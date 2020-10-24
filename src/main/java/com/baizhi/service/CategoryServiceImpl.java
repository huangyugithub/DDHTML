package com.baizhi.service;

import java.util.List;

import com.baizhi.dao.CategoryDAO;
import com.baizhi.empty.Category;
import com.baizhi.mybatisutil.MybatisUtil;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public List<Category> selectAllCategory() {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> categorys = cd.selectAllCategory();
		MybatisUtil.close();
		return categorys;
	}
	@Override
	public void insertCategory(Category category) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		cd.insertCategory(category);
		MybatisUtil.commit();
		
	}
	@Override
	public void deleteCategory(Integer category_id) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		cd.deleteCategory(category_id);
		MybatisUtil.commit();
	}
	//查询所有二级分类
	@Override
	public List<Category> selectTwoCategory() {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> twoCategory = cd.selectTwoCategory();
		
		MybatisUtil.close();
		return twoCategory;
	}
	//根据类别id查询类别
	@Override
	public Category selectCategoryById(int category_id) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(category_id);
		MybatisUtil.close();
		return category;
	}
	
	//查询当前1级类别下的所有2级类别
	@Override
	public List<Category> selectTwoCategoryByOneId(Category category) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> twoCategory = cd.selectTwoCategoryByOneId(category);
		MybatisUtil.close();
		return twoCategory;
	}
	//查询当前类别所属的1级类别通过id
	@Override
	public Category selectOneCategoryById(Category category) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category selectOneCategoryById = cd.selectOneCategoryById(category);
		MybatisUtil.close();
		return selectOneCategoryById;
	}
	//查询1\2级类别下的所有商品的总数
	@Override
	public List<Category> selectCategoryProductCount(Category category) {
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> productCounts = cd.selectCategoryProductCount(category);
		MybatisUtil.close();
		return productCounts;
	}
}
