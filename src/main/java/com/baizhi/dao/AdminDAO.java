package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import com.baizhi.empty.Admin;

public interface AdminDAO {
	//根据用户名查询admin，返回
	public Admin selectAdminByUsername(@Param("username")String admin_username);

}
