package com.zyj.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	
	private static ThreadLocal<Session> threadLocal = new ThreadLocal();
	private HibernateUtil(){}
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	
	
	public static void closeSessionFactory() {
		sessionFactory.close();
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		
		Session session = threadLocal.get();
		if(session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
		
	}
	
	
	
	public static void closeCurrentSession() {
		Session session = getCurrentSession();
		
		if(session != null && session.isOpen()) {
			session.close();
			threadLocal.set(null);
		}
	}
	public static Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction ts = null;
		Object obj = null;
		try {
			session = openSession();
			ts = session.beginTransaction();
			obj = session.load(clazz, id);	
			
			ts.commit();
		}catch(Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return obj;
	}
	
	public static void executeUpdate(String hql, String [] parameters) {
		
		Session session = null;
		Transaction ts = null;
		try {
			session = openSession();
			ts = session.beginTransaction();
			Query query = session.createQuery(hql);
			
			if(parameters != null && parameters.length > 0) {
				for(int i = 0; i< parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			query.executeUpdate();
			ts.commit();
		}catch(Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}

	} 
	
	public static List executeQuery(String hql, String [] parameters) {
		
		Session session = null;
		List list = null;
		try {
			session = openSession();
			Query query = session.createQuery(hql);
			
			if(parameters != null && parameters.length > 0) {
				for(int i = 0; i< parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			list = query.list();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	} 
	
public static Object uniqueQuery(String hql, String [] parameters) {
		
		Session session = null;
		Object obj = null;
		try {
			session = openSession();
			Query query = session.createQuery(hql);
			
			if(parameters != null && parameters.length > 0) {
				for(int i = 0; i< parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			obj = query.uniqueResult();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return obj;
	} 
	
	
	public static void save(Object obj) {
		Session session = null;
		Transaction ts = null;
		
		try {
			session = openSession();
			ts = session.beginTransaction();
			session.save(obj);
			ts.commit(); 
		}catch(Exception e) {
			if(ts != null) {
				ts.rollback();
			}
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		
	}
	
	public static List executeQueryByPage(String hql, String [] parameters, int pageNow, int pageSize) {
		
		Session session = null;
		List list = null;
		try {
			session = openSession();
			Query query = session.createQuery(hql);
			
			if(parameters != null && parameters.length > 0) {
				for(int i = 0; i< parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult((pageNow - 1)*pageSize).setMaxResults(pageSize);
			list = query.list();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}
	
	
}
