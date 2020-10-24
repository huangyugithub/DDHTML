package com.baizhi.dao;

import java.util.List;

import com.baizhi.empty.Address;
import com.baizhi.empty.Order;
import com.baizhi.vo.Cart;

public interface OrderDAO {
	//添加订单
	public void insertOrder(Order order);
	//查询所有订单
	public List<Order> selectAllOrder();
	//根据订单id查询订单
	public Order selectOrderById(int order_id);
}
