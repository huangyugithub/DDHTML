package com.baizhi.service;

import java.util.List;

import com.baizhi.empty.Category;

public interface CategoryService {
	public List<Category> selectAllCategory();
	
	public void insertCategory(Category category);
	
	//删除级别
	public void deleteCategory(Integer category_id);
	//查询所有二级分类
	public List<Category> selectTwoCategory();
	
	//根据类别id查询类别
	public Category selectCategoryById(int category_id);
	
	//查询当前1级类别下的所有2级类别  或 当前2级类别的所有兄弟类别
	public List<Category> selectTwoCategoryByOneId(Category category);
	//查询当前类别所属的1级类别通过id
	public Category selectOneCategoryById(Category category);
	
	//查询1\2级类别下的所有商品的总数
	public List<Category> selectCategoryProductCount(Category category);
}
