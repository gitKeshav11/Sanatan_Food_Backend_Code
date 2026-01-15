package com.sanatan.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.sanatan.model.Order;
import com.sanatan.model.PaymentResponse;
import com.sanatan.model.User;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;
	PaymentResponse createRazorpayPaymentLink(Order order) throws RazorpayException;
}