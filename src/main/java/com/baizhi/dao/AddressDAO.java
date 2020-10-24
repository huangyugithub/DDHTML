package com.baizhi.dao;

import java.util.List;

import com.baizhi.empty.Address;


public interface AddressDAO {
	//查询用户下的所有地址
	public List<Address> selectAddresByUser(int dd__user_id);
	//根据id查询地址
	public Address selectAddressById(int address_id);
	//新建地址
	public void insertAddress(Address address);
	//修改地址
	public void updateAddress(Address address);
}
