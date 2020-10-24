package com.baizhi.empty;

import java.util.Date;

import com.baizhi.vo.Cart;

public class Order {
	private Integer order_id;
	private Integer user_id;
	private Integer address_id;
	private String order_num;
	private Double order_totalprice;
	private String order_user;
	private String order_address;
	private Date order_creationtime;
	private String order_status;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(Integer order_id, Integer user_id, Integer address_id,
			String order_num, Double order_totalprice, String order_user,
			String order_address, Date order_creationtime, String order_status) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.address_id = address_id;
		this.order_num = order_num;
		this.order_totalprice = order_totalprice;
		this.order_user = order_user;
		this.order_address = order_address;
		this.order_creationtime = order_creationtime;
		this.order_status = order_status;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getOrder_num() {
		return order_num;
	}
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}
	public Double getOrder_totalprice() {
		return order_totalprice;
	}
	public void setOrder_totalprice(Double order_totalprice) {
		this.order_totalprice = order_totalprice;
	}
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public String getOrder_address() {
		return order_address;
	}
	public void setOrder_address(String order_address) {
		this.order_address = order_address;
	}
	public Date getOrder_creationtime() {
		return order_creationtime;
	}
	public void setOrder_creationtime(Date order_creationtime) {
		this.order_creationtime = order_creationtime;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id
				+ ", address_id=" + address_id + ", order_num=" + order_num
				+ ", order_totalprice=" + order_totalprice + ", order_user="
				+ order_user + ", order_address=" + order_address
				+ ", order_creationtime=" + order_creationtime
				+ ", order_status=" + order_status + "]";
	}
	
	
}
