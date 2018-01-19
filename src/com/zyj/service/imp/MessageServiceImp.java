package com.zyj.service.imp;

import java.util.List;

import com.zyj.domain.Message;
import com.zyj.domain.Users;
import com.zyj.service.inter.MessageServiceInter;
import com.zyj.util.HibernateUtil;


public class MessageServiceImp extends BaseServiceImp implements MessageServiceInter{

	public List<Message> showMessage(Users user) {
		// TODO Auto-generated method stub
		//mysql
		
		
		String hql = "from Message where getter.userid = ? or getter.userid = 3";
		String [] parameters = {user.getUserid()+""};
		List<Message> messages = HibernateUtil.executeQuery(hql, parameters);
		return messages;
	}

}
