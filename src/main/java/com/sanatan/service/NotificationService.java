package com.sanatan.service;

import java.util.List;

import com.sanatan.model.Notification;
import com.sanatan.model.Order;
import com.sanatan.model.Restaurant;
import com.sanatan.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
