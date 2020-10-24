package com.baizhi.vo;

import java.util.List;

import com.baizhi.empty.Category;
import com.baizhi.empty.Product;

public class MainPage {
	private List<Category> categoryList;	//类别
	private List<Product> recommendList;	//编辑推荐
	private List<Product> hotList;			//热销图书
	private List<Product> newList;			//最新上架
	private List<Product> hotBoardList;		//新书热卖
	
	public MainPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainPage(List<Category> categoryList, List<Product> recommendList,
			List<Product> hotList, List<Product> newList,
			List<Product> hotBoardList) {
		super();
		this.categoryList = categoryList;
		this.recommendList = recommendList;
		this.hotList = hotList;
		this.newList = newList;
		this.hotBoardList = hotBoardList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	public List<Product> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Product> recommendList) {
		this.recommendList = recommendList;
	}
	public List<Product> getHotList() {
		return hotList;
	}
	public void setHotList(List<Product> hotList) {
		this.hotList = hotList;
	}
	public List<Product> getNewList() {
		return newList;
	}
	public void setNewList(List<Product> newList) {
		this.newList = newList;
	}
	public List<Product> getHotBoardList() {
		return hotBoardList;
	}
	public void setHotBoardList(List<Product> hotBoardList) {
		this.hotBoardList = hotBoardList;
	}
	
}
