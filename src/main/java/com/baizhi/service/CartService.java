package com.baizhi.service;

import com.baizhi.vo.Cart;
import com.baizhi.vo.CartItem;

public interface CartService {
	//购物车中添加商品
	public Cart addCart(int product_id,Cart cart);
	//修改购物车商品数量
	public Cart updateCartProductCount(int product_id,int productCount,Cart cart);
	//删除购物车商品项
	public Cart deleteCartItem(int product_id,Cart cart);
}
