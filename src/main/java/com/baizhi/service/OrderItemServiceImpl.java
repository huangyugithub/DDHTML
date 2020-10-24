package com.baizhi.service;

import java.util.List;

import com.baizhi.dao.OrderItemDAO;
import com.baizhi.empty.OrderItem;
import com.baizhi.mybatisutil.MybatisUtil;

public class OrderItemServiceImpl implements OrderItemService{
	//添加订单项
	public void insertOrderItem(OrderItem orderItem){
		OrderItemDAO od = (OrderItemDAO)MybatisUtil.getMapper(OrderItemDAO.class);
		od.insertOrderItem(orderItem);
		MybatisUtil.commit();
	}
	//查询当前订单下的订单项   订单详细信息
	@Override
	public List<OrderItem> selectOrderItem(int order_id) {
		OrderItemDAO od = (OrderItemDAO)MybatisUtil.getMapper(OrderItemDAO.class);
		List<OrderItem> orderItems = od.selectOrderItem(order_id);
		MybatisUtil.close();
		return orderItems;
	}
}
