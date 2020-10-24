package com.baizhi.empty;

public class OrderItem {
	
	private Integer shopcar_id; //购物项的ID
    private Integer order_id ;//订单ID
    private Integer product_id;//图书ID
    private double shopcar_totalprice;//原价小计
    private String shopcar_satus;//订单状态；
    private double shopcar_smalltatal;//商品当当小计
    private Integer  shopcar_counts;//商品的数量
    
    private Product product;
    
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Integer shopcar_id, Integer order_id, Integer product_id,
			double shopcar_totalprice, String shopcar_satus,
			double shopcar_smalltatal, Integer shopcar_counts, Product product) {
		super();
		this.shopcar_id = shopcar_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.shopcar_totalprice = shopcar_totalprice;
		this.shopcar_satus = shopcar_satus;
		this.shopcar_smalltatal = shopcar_smalltatal;
		this.shopcar_counts = shopcar_counts;
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [shopcar_id=" + shopcar_id + ", order_id=" + order_id
				+ ", product_id=" + product_id + ", shopcar_totalprice="
				+ shopcar_totalprice + ", shopcar_satus=" + shopcar_satus
				+ ", shopcar_smalltatal=" + shopcar_smalltatal
				+ ", shopcar_counts=" + shopcar_counts + ", product=" + product
				+ "]";
	}

	public Integer getShopcar_id() {
		return shopcar_id;
	}

	public void setShopcar_id(Integer shopcar_id) {
		this.shopcar_id = shopcar_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public double getShopcar_totalprice() {
		return shopcar_totalprice;
	}

	public void setShopcar_totalprice(double shopcar_totalprice) {
		this.shopcar_totalprice = shopcar_totalprice;
	}

	public String getShopcar_satus() {
		return shopcar_satus;
	}

	public void setShopcar_satus(String shopcar_satus) {
		this.shopcar_satus = shopcar_satus;
	}

	public double getShopcar_smalltatal() {
		return shopcar_smalltatal;
	}

	public void setShopcar_smalltatal(double shopcar_smalltatal) {
		this.shopcar_smalltatal = shopcar_smalltatal;
	}

	public Integer getShopcar_counts() {
		return shopcar_counts;
	}

	public void setShopcar_counts(Integer shopcar_counts) {
		this.shopcar_counts = shopcar_counts;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
    
}
