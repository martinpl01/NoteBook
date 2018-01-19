package com.zyj.service.imp;

import java.io.Serializable;

import com.zyj.service.inter.BaseInterface;
import com.zyj.util.HibernateUtil;

public abstract class BaseServiceImp implements BaseInterface {

	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return HibernateUtil.findById(clazz, id);
	}
	
	public void save(Object obj) {
		try {
			HibernateUtil.save(obj);
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
