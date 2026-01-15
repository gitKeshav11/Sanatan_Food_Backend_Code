package com.sanatan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanatan.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
