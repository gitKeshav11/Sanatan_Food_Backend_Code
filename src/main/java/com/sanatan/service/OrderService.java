package com.sanatan.service;

import java.util.List;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.sanatan.Exception.CartException;
import com.sanatan.Exception.OrderException;
import com.sanatan.Exception.RestaurantException;
import com.sanatan.Exception.UserException;
import com.sanatan.model.Order;
import com.sanatan.model.PaymentResponse;
import com.sanatan.model.User;
import com.sanatan.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException, RazorpayException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
