package com.baizhi.service;

import java.util.List;

import com.baizhi.empty.Order;

public interface OrderService {
	
	//添加订单
	public void insertOrder(Order order);
	//查询所有订单
	public List<Order> selectAllOrder();
	//根据订单id查询订单
	public Order selectOrderById(int order_id);
}
