package com.sanatan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanatan.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
