package com.baizhi.struts2;

import java.util.List;

import com.baizhi.empty.Category;
import com.baizhi.empty.Product;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;
import com.baizhi.vo.MainPage;
import com.opensymphony.xwork2.ActionSupport;

public class HomePageAction extends ActionSupport{
	
	private MainPage mainPage;
	
	
	public String page(){
		mainPage = new MainPage();
		//类别
		CategoryService cs = new CategoryServiceImpl();
		List<Category> categorys = cs.selectAllCategory();
		mainPage.setCategoryList(categorys);
		//编辑推荐
		ProductService ps = new ProductServiceImpl();
		List<Product> recommendList = ps.selectProductByBjtj();
		List<Product> hotList = ps.selectProductByXl();
		List<Product> newList = ps.selectProductByNew();
		List<Product> hotBoardList = ps.selectProductByNewAndXl();
		mainPage.setRecommendList(recommendList);
		mainPage.setHotList(hotList);
		mainPage.setNewList(newList);
		mainPage.setHotBoardList(hotBoardList);
		
		return "success";
	}


	
	
	
	
	
	public MainPage getMainPage() {
		return mainPage;
	}
	public void setMainPage(MainPage mainPage) {
		this.mainPage = mainPage;
	}
	
}
