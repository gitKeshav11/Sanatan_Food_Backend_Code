package com.sanatan.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.sanatan.model.Order;
import com.sanatan.model.PaymentResponse;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.sanatan.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class PaymentServiceImplementation implements PaymentService{
	
	
	@Value("${stripe.api.key}")
	 private String stripeSecretKey;

	@Value("${razorpay.api.key}")
	private String apiKey;

	@Value("${razorpay.api.secret}")
	private String apiSecret;

	@Override
	public PaymentResponse generatePaymentLink(Order order) throws StripeException {

	  Stripe.apiKey = stripeSecretKey;

	        SessionCreateParams params = SessionCreateParams.builder()
	                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	                .setMode(SessionCreateParams.Mode.PAYMENT)
	                .setSuccessUrl("http://localhost:3000/payment/success/"+order.getId())
	                .setCancelUrl("https://sanatan-food.vercel.app/cancel")
	                .addLineItem(SessionCreateParams.LineItem.builder()
	                        .setQuantity(1L)
	                        .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
	                                .setCurrency("usd")
	                                .setUnitAmount((long) order.getTotalAmount()*100) // Specify the order amount in cents
	                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
	                                        .setName("pizza burger")
	                                        .build())
	                                .build())
	                        .build())
	                .build();
	        
	        Session session = Session.create(params);
	        
	        System.out.println("session _____ " + session);
	        
	        PaymentResponse res = new PaymentResponse();
	        res.setPayment_url(session.getUrl());
	        
	        return res;
	    
	}

	@Override
	public PaymentResponse createRazorpayPaymentLink(Order order) throws RazorpayException {
		Long amount = order.getTotalAmount() * 100;


		try {
			// Instantiate a Razorpay client with your key ID and secret
			RazorpayClient razorpay = new RazorpayClient(apiKey, apiSecret);

			JSONObject paymentLinkRequest = new JSONObject();
			paymentLinkRequest.put("amount",amount);
			paymentLinkRequest.put("currency","INR");

			// Create a JSON object with the customer details
			JSONObject customer = new JSONObject();
			customer.put("name",order.getCustomer().getFullName());

			customer.put("email",order.getCustomer().getEmail());
			paymentLinkRequest.put("customer",customer);

			// Create a JSON object with the notification settings
			JSONObject notify = new JSONObject();
			notify.put("email",true);
			paymentLinkRequest.put("notify",notify);

			// Set the reminder settings
			paymentLinkRequest.put("reminder_enable",true);

			// Set the callback URL and method
			paymentLinkRequest.put("callback_url","http://localhost:3000/payment/success/"+order
					.getId());
			paymentLinkRequest.put("callback_method","get");

			PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

			String paymentLinkUrl = payment.get("short_url");
			String paymentLinkId = payment.get("id");



			System.out.println("payment ----- "+payment);

//			return payment;

			PaymentResponse res = new PaymentResponse();
			res.setPayment_url(payment.get("short_url"));

			return res;
		} catch (RazorpayException e) {

			System.out.println("Error creating payment link: " + e.getMessage());
			throw new RazorpayException(e.getMessage());
		}
	}

}
