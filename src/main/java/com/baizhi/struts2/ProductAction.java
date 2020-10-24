package com.baizhi.struts2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.empty.Category;
import com.baizhi.empty.Page;
import com.baizhi.empty.Product;
import com.baizhi.service.CategoryService;
import com.baizhi.service.CategoryServiceImpl;
import com.baizhi.service.ProductService;
import com.baizhi.service.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	
	private Page page;
	private List<Product> products;
	private Product product;
	
	
	//文件上传（图片）
	//接收数据
	private File uploadProduct;
	//接收上传文件的名字     接收上传文件的成员变量名+FileName  文件名+后缀
	private String uploadProductFileName;
	//接收上传文件的MIMA类型   （格式） 接受上传文件的成员变量名+ContentType  大类型/小类型
	private String uploadProductContentType;
	//存储上传文件的目录   /back/img 文件夹 相对路径
	private String filePath;
	
	private int product_id;
	
	private String key;
	private String content;
	
	//private int category_id;
	private Category category;
	private List<Category> twoCategory;
	private Category oneCategory;
	
	int oneProductCount;

	List<Category> productCounts;
	
	public String selectFYProduct(){
		ProductService ps = new ProductServiceImpl();
		products = ps.selectFYProduct(page);
		return "success";
	}
	
	public String insertProduct() throws Exception{
		ProductService ps = new ProductServiceImpl();
		String name1 = uploadProduct.getName();
		
		uploadProductFileName = new Date().getTime()+uploadProductFileName;
		
		System.out.println(uploadProductFileName);
		
		ps.insertProduct(product,uploadProduct,filePath,uploadProductFileName);
		return "success";
	}
	//删除商品
	public String deleteProduct(){
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct(product_id);
		return "success";
	}
	//按条件查询商品
	public String tjSelectProduct(){
		ProductService ps = new ProductServiceImpl();
		
		if(key.equals("prodct_name")){
			
			products = ps.nameSelectProduct(content);
			return "success";
		}else{
			products = ps.authorSelectProduct(content);
			return "success";
		}
	}
	//查询单个商品并修改
	public String selectOneProduct(){
		ProductService ps = new ProductServiceImpl();
		System.out.println("------------");
		System.out.println(category.getCategory_id());//1004
		System.out.println(product_id);				//2
		product = ps.selectOneProduct(product_id);
		CategoryService cs = new CategoryServiceImpl();
		category = cs.selectCategoryById(category.getCategory_id());
		twoCategory = cs.selectTwoCategory();
		System.out.println("--------------22222222222222------------");
		return "success";
	}
	//修改商品
	public String updateProduct() throws Exception{
		ProductService ps = new ProductServiceImpl();
		if(uploadProduct!=null){
			
			FileUtils.copyFile(uploadProduct, new File(getPath(filePath)+"/"+uploadProductFileName ));
		
			product.setPrduct_cover(filePath+"/"+uploadProductFileName);
		
			ps.updateProduct(product);
			return "success";
		}else{
			ps.updateProduct(product);
			System.out.println(product.getPrduct_cover());
		return "success";
		}
	}
	public String getPath(String path){
		//String 绝对路径 = getRealPath("相对路径");
		ServletContext sc = ServletActionContext.getRequest().getSession().getServletContext();
		
		return sc.getRealPath(path);
	}
	//查询   当前1、2级类别下的所有商品   和   二级类别
	public String selectProductByCategory(){
		
		ProductService ps = new ProductServiceImpl();
		CategoryService cs = new CategoryServiceImpl();
		
		//查询1、2级类别下的所有   商品
		products = ps.selectCategoryProduct(page,category);
		products.size();
		//查询1级类别下的所有   二级类别  或 当前2级类别的所有兄弟类别
		twoCategory = cs.selectTwoCategoryByOneId(category);
		//当前类别
		category = cs.selectCategoryById(category.getCategory_id());
		
		//当前1\2级类别的1级类别
		oneCategory = cs.selectOneCategoryById(category);
		oneProductCount = ps.selectCategoryProductCount(oneCategory);
		//根据当前的1级类别  获取下面的2级类别中商品的数量集合
		productCounts = cs.selectCategoryProductCount(oneCategory);
		return "success";
	}
	//查询单个商品
	public String queryOneProduct(){
		ProductService ps = new ProductServiceImpl();
		product = ps.selectOneProduct(product_id);
		return "success";
	}

	
	
	
	
	
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public File getUploadProduct() {
		return uploadProduct;
	}

	public void setUploadProduct(File uploadProduct) {
		this.uploadProduct = uploadProduct;
	}

	public String getUploadProductFileName() {
		return uploadProductFileName;
	}

	public void setUploadProductFileName(String uploadProductFileName) {
		this.uploadProductFileName = uploadProductFileName;
	}

	public String getUploadProductContentType() {
		return uploadProductContentType;
	}

	public void setUploadProductContentType(String uploadProductContentType) {
		this.uploadProductContentType = uploadProductContentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getTwoCategory() {
		return twoCategory;
	}

	public void setTwoCategory(List<Category> twoCategory) {
		this.twoCategory = twoCategory;
	}

	public Category getOneCategory() {
		return oneCategory;
	}

	public void setOneCategory(Category oneCategory) {
		this.oneCategory = oneCategory;
	}

	public int getOneProductCount() {
		return oneProductCount;
	}

	public void setOneProductCount(int oneProductCount) {
		this.oneProductCount = oneProductCount;
	}

	public List<Category> getProductCounts() {
		return productCounts;
	}

	public void setProductCounts(List<Category> productCounts) {
		this.productCounts = productCounts;
	}
	
	
}
