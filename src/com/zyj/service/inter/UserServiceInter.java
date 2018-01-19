package com.zyj.service.inter;

import com.zyj.domain.Users;

public interface UserServiceInter extends BaseInterface{
	
	public Users checkUsers(Users user);
	
	public Users findUsersByName(String name);

}
