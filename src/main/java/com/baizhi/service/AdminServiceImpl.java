package com.baizhi.service;

import com.baizhi.dao.AdminDAO;
import com.baizhi.empty.Admin;
import com.baizhi.mybatisutil.MybatisUtil;

public class AdminServiceImpl implements AdminService{

	@Override
	public Admin loginAdminByUsername(String admin_username) {
		AdminDAO ad = (AdminDAO)MybatisUtil.getMapper(AdminDAO.class);
		Admin admin = ad.selectAdminByUsername(admin_username);
		MybatisUtil.close();
		return admin;
	}
	
}
