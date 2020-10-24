package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.baizhi.empty.Category;
import com.baizhi.empty.Page;
import com.baizhi.empty.Product;

public interface ProductDAO {
	//分页查询图书商品
	public List<Product> selectFYProduct(Page page);
	//查询商品总条数，商品总数
	public int selectTotalCount();
	//添加商品
	public void insertProduct(Product product);
	//删除商品
	public void deleteProduct(int product_id);
	//按书名查询商品
	public List<Product> nameSelectProduct(@Param("prodct_name") String prodct_name);
	//按作者查询商品
	public List<Product> authorSelectProduct(@Param("prduct_author")String prduct_author);
	//查询单个商品
	public Product selectOneProduct(int product_id);
	//修改商品
	public void updateProduct(Product product);
	
	//根据编辑推荐查询前2个商品
	public List<Product> selectProductByBjtj();
	//根据销量查询前8
	public List<Product> selectProductByXl();
	//根据最新上架排序查询前8 （出版时间）
	public List<Product> selectProductByNew();
	//新书热卖，先按上架时间查询，结果再按销量排序，前8
	public List<Product> selectProductByNewAndXl();
	
	//查询1\2级类别下的所有商品
	public List<Product> selectCategoryProduct(@Param("page")Page page,@Param("category")Category category);
	//查询1\2级类别下的所有商品的总数
	public int selectCategoryProductCount(Category category);
	
	//修改商品销量、库存
	public void updateProductXK(@Param("productCount")int productCount,@Param("product_id")int product_id);
}
