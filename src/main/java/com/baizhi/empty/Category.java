package com.baizhi.empty;

import java.util.List;

public class Category {
//	category_id          NUMBER(5)   not null,
//	   dd__category_id      NUMBER(5),
//	   category_name        VARCHAR2(15),
//	   category_byclass     NUMBER(5),
//	   category_class       NUMBER(5),
	private Integer category_id;
	private Integer dd__category_id;
	private String category_name;
	private Integer category_byclass;
	private Integer category_class;
	//private List<Category> categorys;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Integer category_id, Integer dd__category_id,
			String category_name, Integer category_byclass,
			Integer category_class) {
		super();
		this.category_id = category_id;
		this.dd__category_id = dd__category_id;
		this.category_name = category_name;
		this.category_byclass = category_byclass;
		this.category_class = category_class;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", dd__category_id="
				+ dd__category_id + ", category_name=" + category_name
				+ ", category_byclass=" + category_byclass
				+ ", category_class=" + category_class + "]";
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getDd__category_id() {
		return dd__category_id;
	}
	public void setDd__category_id(Integer dd__category_id) {
		this.dd__category_id = dd__category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getCategory_byclass() {
		return category_byclass;
	}
	public void setCategory_byclass(Integer category_byclass) {
		this.category_byclass = category_byclass;
	}
	public Integer getCategory_class() {
		return category_class;
	}
	public void setCategory_class(Integer category_class) {
		this.category_class = category_class;
	}
	
	
}
