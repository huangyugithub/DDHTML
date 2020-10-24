package com.baizhi.empty;

import java.util.Date;
import java.util.List;

public class User {
	private int user_id;
	private String user_eamil;
	private String user_password;
	private String user_status;//状态
	private String user_name;
	private String user_ukey;//激活码
	private Date user_joindate;//注册时间
	private List<Address> addersses;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String user_eamil, String user_password,
			String user_status, String user_name, String user_ukey,
			Date user_joindate) {
		super();
		this.user_id = user_id;
		this.user_eamil = user_eamil;
		this.user_password = user_password;
		this.user_status = user_status;
		this.user_name = user_name;
		this.user_ukey = user_ukey;
		this.user_joindate = user_joindate;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_eamil=" + user_eamil
				+ ", user_password=" + user_password + ", user_status="
				+ user_status + ", user_name=" + user_name + ", user_ukey="
				+ user_ukey + ", user_joindate=" + user_joindate + "]";
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_eamil() {
		return user_eamil;
	}
	public void setUser_eamil(String user_eamil) {
		this.user_eamil = user_eamil;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_ukey() {
		return user_ukey;
	}
	public void setUser_ukey(String user_ukey) {
		this.user_ukey = user_ukey;
	}
	public Date getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(Date user_joindate) {
		this.user_joindate = user_joindate;
	}
	
	
}
