package com.sanatan.service;

import com.sanatan.Exception.CartException;
import com.sanatan.Exception.CartItemException;
import com.sanatan.Exception.FoodException;
import com.sanatan.Exception.UserException;
import com.sanatan.model.Cart;
import com.sanatan.model.CartItem;
import com.sanatan.model.Food;
import com.sanatan.model.User;
import com.sanatan.request.AddCartItemRequest;
import com.sanatan.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
