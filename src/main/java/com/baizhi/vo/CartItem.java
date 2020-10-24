package com.baizhi.vo;

import com.baizhi.empty.Product;

public class CartItem {
	private Product product;  //商品
	private int productCount; //数量
	private double subTotal;  //小计  原价
	private double subDDTotal;//小计  当当价
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getSubDDTotal() {
		return subDDTotal;
	}
	public void setSubDDTotal(double subDDTotal) {
		this.subDDTotal = subDDTotal;
	}
	
}
