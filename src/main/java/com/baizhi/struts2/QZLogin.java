package com.baizhi.struts2;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class QZLogin implements Interceptor{
	
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String flag = (String)session.getAttribute("flag");
		if("ok".equals(flag)){
			ai.invoke();
			return null;
		}else{
			return "fail";
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	

}
