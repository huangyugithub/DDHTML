package com.baizhi.struts2;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;





import com.baizhi.empty.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLoginAction extends ActionSupport{
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	private Admin admin;
	private String username;
	private String password;
	private String code;
	
	public String adminLogin() throws Exception {
		AdminService as = new AdminServiceImpl();
		
		
		String validationCode = (String)session.getAttribute("validationCode");
		//验证码判断
		if(validationCode.equals(code)){
			//验证码正确
			admin = as.loginAdminByUsername(username);
			if(admin!=null){
				if(admin.getAdmin_password().equals(password) ){
					session.setAttribute("Admin", admin);
					session.setAttribute("flog", "ok");
					
					return "success";
				}else{
					session.setAttribute("hint", "密码错误");
					return "usernamefail";
				}
			}else{
				session.setAttribute("hint", "账号错误");
				return "passwordfail";
			}
			
		}else{
			session.setAttribute("hint", "验证码错误");
			return "codefail";
		}

	}
	//管理员退出
	public String AdminLogout(){
		session.removeAttribute("Admin");
		return "success";
	}
	
	
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
