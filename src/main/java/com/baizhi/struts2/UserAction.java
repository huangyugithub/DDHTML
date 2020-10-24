package com.baizhi.struts2;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.empty.User;
import com.baizhi.service.UserService;
import com.baizhi.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	private List<User> users;
	
	private int user_id;
	private String user_status;
	
	private User user;
	private String code;
	private String hint;//提示
	private String key;
	
	private String email;
	private String password;
	
	//查询所有用户
	public String selectAllUser(){
		UserService us = new UserServiceImpl();
		users = us.selectAllUser();
		
		return "success";
	}
	//修改用户（只修改状态）
	public String updateUser(){
		UserService us = new UserServiceImpl();
		if("正常".equals(user_status)){
			user_status = "冻结";
		}else{
			user_status = "正常";
		}
		us.updateUser(user_id,user_status);
		return "success";
	}
	//注册
	public String insertUser(){
		System.out.println("11111111111111111111111");
		UserService us = new UserServiceImpl();

		String validationCode = (String)session.getAttribute("validationCode");
		if(validationCode.equals(code)){
			System.out.println("2222222222222222222222222");
			//根据邮箱查找用户
			User user2 = us.selectUserByEmail(user.getUser_eamil());
			if(user2==null){
				System.out.println("33333333333333333333333333333");
				user.setUser_status("正常");
				user.setUser_joindate(new Date());
				us.insertUser(user);
				key = UUID.randomUUID().toString().replace("-", "");
				session.setAttribute("key", key);
				System.out.println("44444444444444444444444444444");
				return "success";
			}else{
				System.out.println("555555555555555555555555555555");
				hint="该邮箱已被注册";
				return "fail";
			}
			
		}else{
			System.out.println("66666666666666666666666666666666");
			hint="验证码错误";
			return "fail";
		}
	}
	//激活码
	public String keyCode(){
		UserService us = new UserServiceImpl();
		String key = (String)session.getAttribute("key");
		
		User user2 = us.selectUserById(user.getUser_id());
		
		if(key.equals(user.getUser_ukey())){
			
			us.updateUserById(user);
			session.setAttribute("user", user2);
			return "success";
		}
		
		return "fail";
	}
	//登陆
	public String userLogin(){
		UserService us = new UserServiceImpl();
		//根据email查询用户
		user = us.selectUserByEmail(email);
		if(user!=null){
			//判断密码是否正确
			if(user.getUser_password().equals(password)){
				if(user.getUser_status().equals("正常")){
					
					session.setAttribute("flag", "ok");
					session.setAttribute("user", user);
					return "success";
				}else{
					hint = "您的帐户已被冻结";
					return "fail";
				}		
			}else{
				hint = "密码不正确";
				return "fail";
			}
		}else{
			hint = "账号错误";
			return "fail";
		}
	}
	//登出
	public String logOut(){
		//删除所有session
		session.invalidate();
		
		return "success";
	}
	//强制登陆
	public String QZLogin(){
		
		user = (User)session.getAttribute("user");
		if(user==null){
			return "fail";
		}else{
			System.out.println("-----------------------5555--");
			return "success";
		}	
	}
	
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
