package com.baizhi.vo;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> cartItems = new HashMap<Integer, CartItem>();  //购物项
	private double totalPrice;      //总价    原
	private double totalDDPrice;    //总价   当当价
	
	
	public Map<Integer, CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(Map<Integer, CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalDDPrice() {
		return totalDDPrice;
	}
	public void setTotalDDPrice(double totalDDPrice) {
		this.totalDDPrice = totalDDPrice;
	}
	
}
