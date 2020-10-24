package com.baizhi.service;

import java.util.List;

import com.baizhi.empty.OrderItem;

public interface OrderItemService {
	//添加订单项
	public void insertOrderItem(OrderItem orderItem);
	//查询当前订单下的订单项   订单详细信息
	public List<OrderItem> selectOrderItem(int order_id);
}
