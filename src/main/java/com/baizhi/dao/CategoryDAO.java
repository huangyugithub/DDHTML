package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.empty.Category;

public interface CategoryDAO {
	//查询所有分类
	public List<Category> selectAllCategory();
	
	//添加一级分类
	public void insertCategory(Category category);
	
	//查询所有二级分类
	public List<Category> selectTwoCategory();
	
	//删除分类
	public void deleteCategory(Integer category_id);
	
	//根据类别id查询类别
	public Category selectCategoryById(int category_id);
	
	//查询当前1级类别下的所有2级类别  或 当前2级类别的所有兄弟类别
	public List<Category> selectTwoCategoryByOneId(Category category);
	
	//查询当前类别所属的1级类别通过id
	public Category selectOneCategoryById(Category category);
	
	//查询当前2级类别的  所有兄弟类别  下的商品数
	public List<Category> selectCategoryProductCount(Category oneCategory);
}
