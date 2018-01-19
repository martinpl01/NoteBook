package com.zyj.service.inter;

public interface BaseInterface {
	
	public Object findById(Class clazz, java.io.Serializable id);
	
	public void save(Object obj);

}
