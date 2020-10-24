package com.baizhi.struts2;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.empty.Address;
import com.baizhi.empty.Order;
import com.baizhi.empty.OrderItem;
import com.baizhi.empty.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.AddressServiceImpl;
import com.baizhi.service.OrderItemService;
import com.baizhi.service.OrderItemServiceImpl;
import com.baizhi.service.OrderService;
import com.baizhi.service.OrderServiceImpl;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;
import com.baizhi.vo.Cart;
import com.baizhi.vo.CartItem;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	private Address address;
	private int address_id;
	private String username;
	
	private Order order;
	List<Order> orders;
	List<OrderItem> orderItems;
	
	//选择地址
	public String addressForm(){
		System.out.println("11111111111111111111111");
		
		User user = (User)session.getAttribute("user");
		int user_id = user.getUser_id();
		System.out.println("333333333333333333333333");
		AddressService ad = new AddressServiceImpl();
		List<Address> addresses = ad.selectAddressByUser(user_id);
		session.setAttribute("addresses", addresses);
		System.out.println("2222222222222222222222222");
		return "success";
	}
	//根据id查询地址
	public String selectAddressById(){
		AddressService ad = new AddressServiceImpl();
		address = ad.selectAddressById(address_id);
		
		return "success";
	}
	
	//修改地址
	public String updateAddress(){
		AddressService as = new AddressServiceImpl();
		//先判断是否为新地址
		if(address.getAddress_id()==null){
			//新建地址
			as.insertAddress(address);
		}else{
			//旧地址
			Address address1 = as.selectAddressById(address.getAddress_id());
			//判断旧地址是否改变
			if(!address1.equals(address)){
				as.updateAddress(address);
			}
		}
		//创建订单
		order = new Order();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		String str = UUID.randomUUID().toString().replace("-", "");
		//填充信息
		order.setAddress_id(address.getAddress_id());
		order.setOrder_address(address.getAddress_name());
		order.setOrder_user(username);
		order.setUser_id(user.getUser_id());
		order.setOrder_totalprice(cart.getTotalDDPrice());
		order.setOrder_creationtime(new Date());
		order.setOrder_num(str);
		order.setOrder_status("未支付");
		//将order存储到数据库中
		OrderService os = new OrderServiceImpl();
		os.insertOrder(order);
		
		//处理订单项
		OrderItemService ois = new OrderItemServiceImpl();
		ProductService ps = new ProductServiceImpl();
		Map<Integer, CartItem> orderItems = cart.getCartItems();
		for ( Entry<Integer, CartItem> orders : orderItems.entrySet()) {
			
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct_id(orders.getValue().getProduct().getProduct_id());
			orderItem.setOrder_id(order.getOrder_id());
			orderItem.setShopcar_counts(orders.getValue().getProductCount());
			orderItem.setShopcar_satus(order.getOrder_status());
			orderItem.setShopcar_smalltatal(orders.getValue().getSubDDTotal());
			orderItem.setShopcar_totalprice(orders.getValue().getSubTotal());
			ois.insertOrderItem(orderItem);
			//处理销量、库存
			int productCount = orderItem.getShopcar_counts();
			int product_id = orderItem.getProduct_id();
			ps.updateProductXK(productCount,product_id);
		}
		//清空购物车
		session.removeAttribute("cart");
		
		return "success";
	}
	//后台查询所有订单
	public String selectAllOrder(){
		OrderService os = new OrderServiceImpl();
		orders = os.selectAllOrder();
		
		return "success";
	}
	//查询当前订单下的订单项   订单详细信息
	public String selectOrderItem(){
		OrderItemService ois = new OrderItemServiceImpl();
		OrderService os = new OrderServiceImpl();
		order = os.selectOrderById(order.getOrder_id());
		orderItems = ois.selectOrderItem(order.getOrder_id());
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
}
