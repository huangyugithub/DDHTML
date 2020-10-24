package com.baizhi.service;

import java.util.Date;
import java.util.List;

import com.baizhi.dao.OrderDAO;
import com.baizhi.empty.Order;
import com.baizhi.mybatisutil.MybatisUtil;

public class OrderServiceImpl implements OrderService{
	
	//添加订单
	@Override
	public void insertOrder(Order order) {
		OrderDAO od = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		od.insertOrder(order);
		MybatisUtil.commit();
		
	}
	//查询所有订单
	@Override
	public List<Order> selectAllOrder() {
		OrderDAO od = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		List<Order> orders = od.selectAllOrder();
		MybatisUtil.close();
		return orders;
	}
	//根据订单id查询订单
	@Override
	public Order selectOrderById(int order_id) {
		OrderDAO od = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		Order order = od.selectOrderById(order_id);
		MybatisUtil.close();
		return order;
	}
}
