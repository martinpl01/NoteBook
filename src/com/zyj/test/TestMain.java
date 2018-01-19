package com.zyj.test;

import java.util.List;

import com.zyj.domain.Users;
import com.zyj.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String hql = "from Users where userid = ? and passwd = ?";
//		String parameters[] = {user.getUserid() +"", MyTools.MD5(user.getPasswd())};
		String parameters[] = {5 +"", "1"};
		List<Users> users = HibernateUtil.executeQuery(hql, parameters);
		
//		List<Users> users = new ArrayList<Users>();
		
	
		if(users.size() == 0) {
			System.out.println("没有");
		}else {
			System.out.println(users.get(0).getName());
		}
		
		
	}

}
