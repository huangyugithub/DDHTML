package com.baizhi.service;

import java.util.List;

import com.baizhi.dao.UserDAO;
import com.baizhi.empty.User;
import com.baizhi.mybatisutil.MybatisUtil;

public class UserServiceImpl implements UserService{
	//查询所有用户
	@Override
	public List<User> selectAllUser() {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		List<User> users = ud.selectAllUser();
		MybatisUtil.close();
		return users;
	}
	//修改用户状态
	@Override
	public void updateUser(int user_id, String user_status) {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		ud.updateUser(user_id, user_status);
		MybatisUtil.commit();
		
	}
	//根据邮箱查询用户
	@Override
	public User selectUserByEmail(String email) {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		User user = ud.selectUserByEmail(email);
		MybatisUtil.close();
		//String Str1=UUID.randomUUID().toString().replace("-", "");
		return user;
	}
	//添加用户   注册
	@Override
	public void insertUser(User user) {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		ud.insertUser(user);
		MybatisUtil.commit();
		
	}
	//修改用户
	@Override
	public void updateUserById(User user) {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		ud.updateUserById(user);
		MybatisUtil.commit();
	}
	//根据id查询单个用户
	@Override
	public User selectUserById(int user_id) {
		UserDAO ud = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		User user = ud.selectUserById(user_id);
		MybatisUtil.close();
		return user;
	}
}
