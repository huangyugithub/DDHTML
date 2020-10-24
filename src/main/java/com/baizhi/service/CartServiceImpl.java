package com.baizhi.service;

import java.util.Map;

import com.baizhi.empty.Product;
import com.baizhi.vo.Cart;
import com.baizhi.vo.CartItem;

public class CartServiceImpl implements CartService{
	private ProductService ps = new ProductServiceImpl();
	@Override
	public Cart addCart(int product_id, Cart cart) {
		//查询商品
		Product product = ps.selectOneProduct(product_id);
		//获取购物项
		Map<Integer, CartItem> cartItems = cart.getCartItems();
		CartItem cartItem = cartItems.get(product_id);
		
		//判断是否第一次添加此商品
		if(cartItem == null){
			//第一次添加此商品,新建购物项
			cartItem = new CartItem();
			//设置购物项中的属性
			cartItem.setProduct(product);//设置商品
			cartItem.setProductCount(1); //设置数量为1
			cartItem.setSubDDTotal(product.getPrduct_ddprice());//设置当当价小计
			cartItem.setSubTotal(product.getPrduct_price());//设置原价的小计
			//将设置好的购物项放入到Map集合中
			cartItems.put(product_id, cartItem);
			//设置购物车原价  总价   原总价+单价
			cart.setTotalPrice(cart.getTotalPrice()+product.getPrduct_price());
			//设置购物车    当当价   总价
			cart.setTotalDDPrice(cart.getTotalDDPrice()+product.getPrduct_ddprice());
		}else{
			//不是第一次添加此商品   购物项cartItem中是此商品
			cartItem.setProductCount(cartItem.getProductCount()+1);
			//当当价  的  小计
			cartItem.setSubDDTotal(cartItem.getSubDDTotal()+product.getPrduct_ddprice());
			//原价  的  小计
			cartItem.setSubTotal(cartItem.getSubTotal()+product.getPrduct_price());
			//设置总价  当当价
			cart.setTotalDDPrice(cart.getTotalDDPrice()+product.getPrduct_ddprice());
			//设置总价  原价
			cart.setTotalPrice(cart.getTotalPrice()+product.getPrduct_price());
		}
		return cart;
	}
	//修改购物车的商品数量
	@Override
	public Cart updateCartProductCount(int product_id, int productCount,Cart cart) {
		//查询商品
		Product product = ps.selectOneProduct(product_id);
		//获取购物项
		Map<Integer, CartItem> cartItems = cart.getCartItems();
		CartItem cartItem = cartItems.get(product_id);
		
		System.out.println(productCount);
		//设置总价  当当价
		cart.setTotalDDPrice(cart.getTotalDDPrice()-cartItem.getSubDDTotal()+product.getPrduct_ddprice()*productCount);
		//设置总价  原价
		cart.setTotalPrice(cart.getTotalPrice()-cartItem.getSubTotal()+product.getPrduct_price()*productCount);
		//修改商品数量
		cartItem.setProductCount(productCount);
		//当当价  的  小计
		cartItem.setSubDDTotal(product.getPrduct_ddprice()*productCount);
		//原价  的  小计
		cartItem.setSubTotal(product.getPrduct_price()*productCount);
		
		
		return cart;
	}
	//删除购物车商品项
	@Override
	public Cart deleteCartItem(int product_id, Cart cart) {
		
		Product product = ps.selectOneProduct(product_id);
		Map<Integer, CartItem> cartItems = cart.getCartItems();
		CartItem cartItem = cartItems.get(product_id);
		
		//设置  原价总价
		cart.setTotalPrice(cart.getTotalPrice()-cartItem.getSubTotal());
		//设置  当当价总价
		cart.setTotalDDPrice(cart.getTotalDDPrice()-cartItem.getSubDDTotal());
		
		//删除此购物项
		CartItem removeCategory = cartItems.remove(product_id);
		
		return cart;
	}

}
