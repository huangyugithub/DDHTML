package com.baizhi.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.dao.ProductDAO;
import com.baizhi.empty.Category;
import com.baizhi.empty.Page;
import com.baizhi.empty.Product;
import com.baizhi.mybatisutil.MybatisUtil;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<Product> selectFYProduct(Page page) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		//查询总条数
		int totalCount = pd.selectTotalCount();
		//设置总条数
		page.setTotalCount(totalCount);
		
		System.out.println("每页起始条数："+page.getFirstCount());
		System.out.println("每页结束条数："+page.getLastCount());
		System.out.println("总页数："+page.getTotalPage());
		
		List<Product> products = pd.selectFYProduct(page);
		MybatisUtil.close();
		return products;
	}
	//添加商品    (包含文件上传--图片)
	@Override
	public void insertProduct(Product product, File uploadProduct,
			String filePath, String uploadProductFileName) throws Exception {
		
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		
		FileUtils.copyFile(uploadProduct, new File(getPath(filePath)+"/"+uploadProductFileName ));
		
		product.setPrduct_cover(filePath+"/"+uploadProductFileName);
		
		System.out.println(product.getPrduct_cover());
		pd.insertProduct(product);
		MybatisUtil.commit();
	}
	public String getPath(String path){
		//String 绝对路径 = getRealPath("相对路径");
		ServletContext sc = ServletActionContext.getRequest().getSession().getServletContext();
		
		return sc.getRealPath(path);
	}
	//删除商品
	@Override
	public void deleteProduct(int product_id) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		pd.deleteProduct(product_id);
		MybatisUtil.commit();
	}
	//按书名查询商品
	@Override
	public List<Product> nameSelectProduct(String prodct_name) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> products = pd.nameSelectProduct(prodct_name);
		MybatisUtil.close();
		return products;
	}
	//按作者查询商品
	@Override
	public List<Product> authorSelectProduct(String prduct_author) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> products = pd.authorSelectProduct(prduct_author);
		MybatisUtil.close();
		return products;
	}
	//查询单个商品
	@Override
	public Product selectOneProduct(int product_id) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		Product product = pd.selectOneProduct(product_id);
		MybatisUtil.close();
		return product;
	}
	//修改商品
	public void updateProduct(Product product) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		pd.updateProduct(product);
		
		System.out.println(product.getPrduct_cover());
		
		MybatisUtil.commit();
		
	}
	
	
	//根据编辑推荐查询前2个商品
	@Override
	public List<Product> selectProductByBjtj() {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> recommendList = pd.selectProductByBjtj();
		MybatisUtil.close();
		return recommendList;
	}
	//根据销量查询前8
	@Override
	public List<Product> selectProductByXl() {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> hotList = pd.selectProductByXl();
		MybatisUtil.close();
		return hotList;
	}
	//根据最新上架排序查询前8 （出版时间）
	@Override
	public List<Product> selectProductByNew() {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> newList = pd.selectProductByNew();
		MybatisUtil.close();
		return newList;
	}
	//新书热卖， 到现在为止一个月内的新书，按销量排行，取前8
	@Override
	public List<Product> selectProductByNewAndXl() {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> hotBoardList = pd.selectProductByNewAndXl();
		MybatisUtil.close();
		return hotBoardList;
	}
	
	//查询1/2级类别下的所有商品
	@Override
	public List<Product> selectCategoryProduct(Page page,Category category) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		//查询1/2级类别下的所有商品的  数量
		int count = pd.selectCategoryProductCount(category);
		page.setTotalCount(count);
		List<Product> oneCategoryProduct = pd.selectCategoryProduct(page,category);
		MybatisUtil.close();
		return oneCategoryProduct;
	}
	//查询1\2级类别下的所有商品的总数
	@Override
	public int selectCategoryProductCount(Category category) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		int productCount = pd.selectCategoryProductCount(category);
		MybatisUtil.close();
		return productCount;
	}
	//修改商品销量、库存
	@Override
	public void updateProductXK(int productCount,int product_id) {
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		
		pd.updateProductXK(productCount, product_id);
		MybatisUtil.commit();
	}
	
}
