package com.baizhi.service;

import java.util.List;

import com.baizhi.dao.AddressDAO;
import com.baizhi.empty.Address;
import com.baizhi.mybatisutil.MybatisUtil;

public class AddressServiceImpl implements AddressService{
	//查询用户下的所有地址
	@Override
	public List<Address> selectAddressByUser(int dd__user_id) {
		AddressDAO ad = (AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		List<Address> addresses = ad.selectAddresByUser(dd__user_id);
		MybatisUtil.close();
		return addresses;
	}
	//根据id查询地址
	@Override
	public Address selectAddressById(int address_id) {
		AddressDAO ad = (AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		Address address = ad.selectAddressById(address_id);
		MybatisUtil.close();
		return address;
	}
	//新建地址
	@Override
	public void insertAddress(Address address) {
		AddressDAO ad = (AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		ad.insertAddress(address);
		MybatisUtil.commit();
	}
	//修改地址
	@Override
	public void updateAddress(Address address) {
		AddressDAO ad = (AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		ad.updateAddress(address);
		MybatisUtil.commit();
	}
}
