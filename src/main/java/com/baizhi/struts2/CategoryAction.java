package com.baizhi.struts2;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.empty.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	
	private String category_name;
	private Integer oneCategoryId;
	private Integer category_id;
	private Integer category_class;
	private String deleteFail;
	private List<Category> twoCategory;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();
	public String selectAllCategory(){
		CategoryService cs = new CategoryServiceImpl();
		List<Category> categorys = cs.selectAllCategory();
		
		session.setAttribute("Categorys", categorys);
		
		return "success";
	}
	public String insertOneCategory(){
		CategoryService cs = new CategoryServiceImpl();
		cs.insertCategory(new Category(0,null,category_name,null,1));
		return "success";
	}
	
	public String insertTwoCategory(){
		CategoryService cs = new CategoryServiceImpl();
		cs.insertCategory(new Category(0,oneCategoryId,category_name,1,2));
		
		return "success";
	}
	
	public String deleteCategory(){
		CategoryService cs = new CategoryServiceImpl();
		boolean b=false;
		if(category_class==2){
			cs.deleteCategory(category_id);
			return "success";
		}else{
			
			List<Category> categorys = cs.selectAllCategory();
			for (Category category : categorys) {
				
				if(category_id.equals(category.getDd__category_id())){
					System.out.println("----------------------------");
					b=true;
				}
			}
			if(b){
				System.out.println("555555555555555555555555");
				deleteFail= "当前一级类别下有二级类别，无法删除";
				System.out.println(deleteFail);
				return "fail";
			}else{	
				System.out.println("6666666666666666666666");
				cs.deleteCategory(category_id);
				return "success";
			}
		}
	}
	//查询二级类别
	public String selectTwoCategory(){
		CategoryService cs = new CategoryServiceImpl();
		twoCategory = cs.selectTwoCategory();
		
		return "success";
	}
	
	
	
	
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getOneCategoryId() {
		return oneCategoryId;
	}
	public void setOneCategoryId(Integer oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getCategory_class() {
		return category_class;
	}
	public void setCategory_class(Integer category_class) {
		this.category_class = category_class;
	}
	public String getDeleteFail() {
		return deleteFail;
	}
	public void setDeleteFail(String deleteFail) {
		this.deleteFail = deleteFail;
	}
	public List<Category> getTwoCategory() {
		return twoCategory;
	}
	public void setTwoCategory(List<Category> twoCategory) {
		this.twoCategory = twoCategory;
	}
	
	
}
