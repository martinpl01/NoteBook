package com.zyj.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.zyj.domain.Users;
import com.zyj.service.inter.UserServiceInter;
import com.zyj.util.HibernateUtil;
import com.zyj.util.MyTools;

public class UserServiceImp extends BaseServiceImp implements UserServiceInter{
	
	public Users checkUsers(Users user) {
		
		String hql = "from Users where userid = ? and passwd = ?";
		String parameters[] = {user.getUserid() +"", MyTools.MD5(user.getPasswd())};
//		String parameters[] = {user.getUserid() +"", user.getPasswd()};
		List<Users> users = HibernateUtil.executeQuery(hql, parameters);
		
//		List<Users> users = new ArrayList<Users>();
		
		if(users.size() == 0) {
			return null;
		}else {
			return users.get(0);
		}
		
	}

	public Users findUsersByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Users where name = ?";
		String parameters[] = {name};
		
		Users user = null;
		
		try {
			user = (Users) HibernateUtil.uniqueQuery(hql, parameters);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return user;
	}

}
