package com.baizhi.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.baizhi.dao.AdminDAO;
import com.baizhi.dao.CategoryDAO;
import com.baizhi.dao.OrderDAO;
import com.baizhi.dao.OrderItemDAO;
import com.baizhi.dao.ProductDAO;
import com.baizhi.dao.UserDAO;
import com.baizhi.empty.Admin;
import com.baizhi.empty.Category;
import com.baizhi.empty.Order;
import com.baizhi.empty.OrderItem;
import com.baizhi.empty.Page;
import com.baizhi.empty.Product;
import com.baizhi.mybatisutil.MybatisUtil;

public class MybatisTest {
	@Test
	public void test1(){
		AdminDAO ad = (AdminDAO)MybatisUtil.getMapper(AdminDAO.class);
		Admin admin = ad.selectAdminByUsername("hy");
		MybatisUtil.close();
		System.out.println(admin.getAdmin_name());
	}
	@Test
	public void selectAllCategory(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> categorys = cd.selectAllCategory();
		MybatisUtil.close();
		for (Category category : categorys) {
			System.out.println(category);
		}
	}
	@Test
	public void insertCategory(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		cd.insertCategory(new Category(0,null,"风水",null,1));
		MybatisUtil.commit();
	}
	//分页查询商品
	@Test
	public void selectFYProduct(){
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		int totalCount = pd.selectTotalCount();
		
		List<Product> products = pd.selectFYProduct(new Page(2,3));
		for (Product product : products) {
			System.out.println(product);
		}
	}
	//查询所有二级分类
	@Test
	public void selectTwoCategory(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> twoCategory = cd.selectTwoCategory();
		for (Category category : twoCategory) {
			System.out.println(category);
		}
	}
	//模糊查询
	@Test
	public void tjSelectProduct(){
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> products = pd.nameSelectProduct("梦");
		for (Product product : products) {
			System.out.println(product);
		}
	}
	//修改用户状态
	@Test
	public void updateUser(){
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		ud.updateUser(10001, "正常");
		MybatisUtil.commit();
	}
	@Test
	public void selectProductByDate(){
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> list = pd.selectProductByBjtj();
		for (Product product : list) {
			System.out.println(product);
		}
	}
	@Test
	public void selectProductByNewAndXl(){
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		List<Product> list = pd.selectProductByNewAndXl();
		for (Product product : list) {
			System.out.println(product);
		}
	}
	//查询1级类别下的所有商品
	@Test
	public void selectOneCategoryProduct(){
		Page page = new Page(2);
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(1004);
		int count = pd.selectCategoryProductCount(category);
		page.setTotalCount(count);
		List<Product> list = pd.selectCategoryProduct(page,category);
		for (Product product : list) {
			System.out.println(product);
		}
	}
	//查询1级类别下的所有商品的总数
	@Test
	public void selectOneCategoryProductCount(){
		ProductDAO pd = (ProductDAO)MybatisUtil.getMapper(ProductDAO.class);
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(1001);
		int count = pd.selectCategoryProductCount(category);
		MybatisUtil.close();
		System.out.println(count);
	}
	//查询当前1级类别下的所有2级类别  或 当前2级类别的所有兄弟类别
	@Test
	public void selectTwoCategoryByOneId(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(1004);
		List<Category> twoCategoryByOneId = cd.selectTwoCategoryByOneId(category);
		for (Category category2 : twoCategoryByOneId) {
			System.out.println(category2);
		}
	}
	//查询当前类别所属的1级类别通过id
	@Test
	public void selectOneCategoryById(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(1001);
		Category selectOneCategoryById = cd.selectOneCategoryById(category);
		System.out.println(selectOneCategoryById);
	}
	//查询当前2级类别的  所有兄弟类别  下的商品数
	@Test
	public void selectCategoryProductCount(){
		CategoryDAO cd = (CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = cd.selectCategoryById(1001);
		List<Category> productCount = cd.selectCategoryProductCount(category);
		for (Category category2 : productCount) {
			
			System.out.println(category2);
		}

	}
	//添加订单
	@Test
	public void insertOrder(){
		OrderDAO od = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		
		od.insertOrder(new Order(0,10004,1001,"sasad554d",150.0,"黄宇","北京",new Date(),"未付款"));
		MybatisUtil.commit();
	}
	//查询订单
	@Test
	public void selectAllOrder(){
		OrderDAO od = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		
		MybatisUtil.close();
	}
	//查询当前订单下的订单项   订单详细信息  包括商品信息
	@Test
	public void selectOrderItem(){
		OrderItemDAO od = (OrderItemDAO)MybatisUtil.getMapper(OrderItemDAO.class);
		List<OrderItem> orderItems = od.selectOrderItem(4006);
		MybatisUtil.close();
		for (OrderItem orderItem : orderItems) {
			System.out.println(orderItem);
		}
		
	}
	@Test
	public void hehess(){
	
		system.out.println("远程仓库的第一次修改+哈哈哈哈哈哈哈");
		system.out.println("本地仓库的第一次修改+hhh");
	}
}
