package com.baizhi.empty;

import java.util.Date;

public class Product {
	private Integer product_id;			// 商品id 1
	private Integer category_id;		// 类别id 2
	private String prodct_name;			// 商品名称 3
	private Double prduct_price;		// 商品原价 4
	private Double prduct_ddprice;		// 当当价     5
	private Integer product_counts;		// 库存         6
	private String prduct_author;		// 作者         7
	private String prduct_publisher;	// 出版社     8
	private Date prduct_publishtime;	// 出版时间 9
	private Date prduct_printtime;		// 印刷时间 10
	private Integer prduct_ISBN;		// 编码         11  国际标准书号
	private Integer prduct_salescount;	// 销量         12..................
	private String prduct_format;		// 开本         13
	private String prduct_paper;		// 纸张         14 
	private String prduct_packaging;	// 包装         15
	private Integer prduct_pages;		// 页数         16
	private Long prduct_words;		// 字数         17
	private String prduct_cover;		// 封面图片 18
	private String prduct_bjtj;			// 编辑推荐 19
	private String prduct_nrjs;			// 内容介绍 20
	private String prduct_zzjs;			// 作者介绍 21
	private String prduct_jbml;			// 基本目录 22
	private String prduct_comments;		// 媒体评论 23
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer product_id, Integer category_id, String prodct_name,
			Double prduct_price, Double prduct_ddprice, Integer product_counts,
			String prduct_author, String prduct_publisher,
			Date prduct_publishtime, Date prduct_printtime,
			Integer prduct_ISBN, Integer prduct_salescount,
			String prduct_format, String prduct_paper, String prduct_packaging,
			Integer prduct_pages, Long prduct_words, String prduct_cover,
			String prduct_bjtj, String prduct_nrjs, String prduct_zzjs,
			String prduct_jbml, String prduct_comments) {
		super();
		this.product_id = product_id;
		this.category_id = category_id;
		this.prodct_name = prodct_name;
		this.prduct_price = prduct_price;
		this.prduct_ddprice = prduct_ddprice;
		this.product_counts = product_counts;
		this.prduct_author = prduct_author;
		this.prduct_publisher = prduct_publisher;
		this.prduct_publishtime = prduct_publishtime;
		this.prduct_printtime = prduct_printtime;
		this.prduct_ISBN = prduct_ISBN;
		this.prduct_salescount = prduct_salescount;
		this.prduct_format = prduct_format;
		this.prduct_paper = prduct_paper;
		this.prduct_packaging = prduct_packaging;
		this.prduct_pages = prduct_pages;
		this.prduct_words = prduct_words;
		this.prduct_cover = prduct_cover;
		this.prduct_bjtj = prduct_bjtj;
		this.prduct_nrjs = prduct_nrjs;
		this.prduct_zzjs = prduct_zzjs;
		this.prduct_jbml = prduct_jbml;
		this.prduct_comments = prduct_comments;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", category_id="
				+ category_id + ", prodct_name=" + prodct_name
				+ ", prduct_price=" + prduct_price + ", prduct_ddprice="
				+ prduct_ddprice + ", product_counts=" + product_counts
				+ ", prduct_author=" + prduct_author + ", prduct_publisher="
				+ prduct_publisher + ", prduct_publishtime="
				+ prduct_publishtime + ", prduct_printtime=" + prduct_printtime
				+ ", prduct_ISBN=" + prduct_ISBN + ", prduct_salescount="
				+ prduct_salescount + ", prduct_format=" + prduct_format
				+ ", prduct_paper=" + prduct_paper + ", prduct_packaging="
				+ prduct_packaging + ", prduct_pages=" + prduct_pages
				+ ", prduct_words=" + prduct_words + ", prduct_cover="
				+ prduct_cover + ", prduct_bjtj=" + prduct_bjtj
				+ ", prduct_nrjs=" + prduct_nrjs + ", prduct_zzjs="
				+ prduct_zzjs + ", prduct_jbml=" + prduct_jbml
				+ ", prduct_comments=" + prduct_comments + "]";
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getProdct_name() {
		return prodct_name;
	}
	public void setProdct_name(String prodct_name) {
		this.prodct_name = prodct_name;
	}
	public Double getPrduct_price() {
		return prduct_price;
	}
	public void setPrduct_price(Double prduct_price) {
		this.prduct_price = prduct_price;
	}
	public Double getPrduct_ddprice() {
		return prduct_ddprice;
	}
	public void setPrduct_ddprice(Double prduct_ddprice) {
		this.prduct_ddprice = prduct_ddprice;
	}
	public Integer getProduct_counts() {
		return product_counts;
	}
	public void setProduct_counts(Integer product_counts) {
		this.product_counts = product_counts;
	}
	public String getPrduct_author() {
		return prduct_author;
	}
	public void setPrduct_author(String prduct_author) {
		this.prduct_author = prduct_author;
	}
	public String getPrduct_publisher() {
		return prduct_publisher;
	}
	public void setPrduct_publisher(String prduct_publisher) {
		this.prduct_publisher = prduct_publisher;
	}
	public Date getPrduct_publishtime() {
		return prduct_publishtime;
	}
	public void setPrduct_publishtime(Date prduct_publishtime) {
		this.prduct_publishtime = prduct_publishtime;
	}
	public Date getPrduct_printtime() {
		return prduct_printtime;
	}
	public void setPrduct_printtime(Date prduct_printtime) {
		this.prduct_printtime = prduct_printtime;
	}
	public Integer getPrduct_ISBN() {
		return prduct_ISBN;
	}
	public void setPrduct_ISBN(Integer prduct_ISBN) {
		this.prduct_ISBN = prduct_ISBN;
	}
	public Integer getPrduct_salescount() {
		return prduct_salescount;
	}
	public void setPrduct_salescount(Integer prduct_salescount) {
		this.prduct_salescount = prduct_salescount;
	}
	public String getPrduct_format() {
		return prduct_format;
	}
	public void setPrduct_format(String prduct_format) {
		this.prduct_format = prduct_format;
	}
	public String getPrduct_paper() {
		return prduct_paper;
	}
	public void setPrduct_paper(String prduct_paper) {
		this.prduct_paper = prduct_paper;
	}
	public String getPrduct_packaging() {
		return prduct_packaging;
	}
	public void setPrduct_packaging(String prduct_packaging) {
		this.prduct_packaging = prduct_packaging;
	}
	public Integer getPrduct_pages() {
		return prduct_pages;
	}
	public void setPrduct_pages(Integer prduct_pages) {
		this.prduct_pages = prduct_pages;
	}
	public Long getPrduct_words() {
		return prduct_words;
	}
	public void setPrduct_words(Long prduct_words) {
		this.prduct_words = prduct_words;
	}
	public String getPrduct_cover() {
		return prduct_cover;
	}
	public void setPrduct_cover(String prduct_cover) {
		this.prduct_cover = prduct_cover;
	}
	public String getPrduct_bjtj() {
		return prduct_bjtj;
	}
	public void setPrduct_bjtj(String prduct_bjtj) {
		this.prduct_bjtj = prduct_bjtj;
	}
	public String getPrduct_nrjs() {
		return prduct_nrjs;
	}
	public void setPrduct_nrjs(String prduct_nrjs) {
		this.prduct_nrjs = prduct_nrjs;
	}
	public String getPrduct_zzjs() {
		return prduct_zzjs;
	}
	public void setPrduct_zzjs(String prduct_zzjs) {
		this.prduct_zzjs = prduct_zzjs;
	}
	public String getPrduct_jbml() {
		return prduct_jbml;
	}
	public void setPrduct_jbml(String prduct_jbml) {
		this.prduct_jbml = prduct_jbml;
	}
	public String getPrduct_comments() {
		return prduct_comments;
	}
	public void setPrduct_comments(String prduct_comments) {
		this.prduct_comments = prduct_comments;
	}
	
	
}
