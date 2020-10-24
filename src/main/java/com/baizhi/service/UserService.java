package com.baizhi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.empty.User;

public interface UserService {
	//查询所有用户
	public List<User> selectAllUser();
	//修改用户状态
	public void updateUser(int user_id,String user_status);
	//根据邮箱查询用户
	public User selectUserByEmail(String email);
	//添加用户   注册
	public void insertUser(User user);
	//修改用户
	public void updateUserById(User user);
	//根据id查询单个用户
	public User selectUserById(int user_id);
}
