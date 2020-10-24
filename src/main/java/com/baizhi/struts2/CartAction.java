package com.baizhi.struts2;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.empty.Product;
import com.baizhi.service.CartService;
import com.baizhi.service.CartServiceImpl;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;
import com.baizhi.vo.Cart;
import com.baizhi.vo.CartItem;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	
	private int product_id;
	private int productCount;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	
	public String addCart(){
		
		CartService cs = new CartServiceImpl();
		//判断是否有购物车
		
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//没有购物车，创建
			cart = new Cart();
		}
		Cart newCart = cs.addCart(product_id, cart);
		
		//将新的购物车对象Cart存到session作用域中，覆盖掉之前session中的Cart
		session.setAttribute("cart", newCart);
		
		return "success";
	}
	//修改购物车的商品数量
	public String updateCartProductCount(){
		CartService cs = new CartServiceImpl();

		Cart cart  = (Cart)session.getAttribute("cart");
		Cart newCart = cs.updateCartProductCount(product_id,productCount,cart);
		
		session.setAttribute("cart", newCart);
		
		return "success";
	}
	//删除商品
	public String deleteCartItem(){
		CartService cs = new CartServiceImpl();	
		
		Cart cart = (Cart)session.getAttribute("cart");	
		Cart newCart = cs.deleteCartItem(product_id, cart);
		session.setAttribute("cart", cart);
		
		
		Cart delCart = (Cart)session.getAttribute("delCart");
		if(delCart==null){
			//第一次删除，新建一个  “删除购物车”
			delCart = new Cart();
		}
		
		Cart newDelCart = cs.addCart(product_id, delCart);
		session.setAttribute("delCart", newDelCart);
		
		
		
		return "success";
	}
	//删除 “已删除购物车”
	public String deleteDelCartItem(){
		CartService cs = new CartServiceImpl();	
		
		Cart delCart = (Cart)session.getAttribute("delCart");	
		Cart newCart = cs.deleteCartItem(product_id, delCart);
		session.setAttribute("delCart", newCart);
		
		return "success";
	}
	//
	public String recoverCartItem(){
		CartService cs = new CartServiceImpl();
		
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			//没有购物车，创建
			cart = new Cart();
		}
		Cart newCart = cs.addCart(product_id, cart);
		
		//将新的购物车对象Cart存到session作用域中，覆盖掉之前session中的Cart
		session.setAttribute("cart", newCart);
		
		
		
		Cart delCart = (Cart)session.getAttribute("delCart");	
		Cart newdelCart = cs.deleteCartItem(product_id, delCart);
		session.setAttribute("delCart", newdelCart);
		return "success";
	}

	
	
	
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	
}
