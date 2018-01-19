package com.zyj.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zyj.util.HibernateUtil;

/**
 * Servlet implementation class filter1
 */
public class filter1 extends HttpServlet implements Filter {
	
	
    public void init(FilterConfig arg0) throws javax.servlet.ServletException { 
         // TODO Auto-generated method stub
    }

	
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws java.io.IOException, javax.servlet.ServletException { 
         // TODO Auto-generated method stub
    	
    	
    	Session session = null;
    	Transaction ts = null;
    	
    	
    	try {
    		session = HibernateUtil.getCurrentSession();
    		ts = session.beginTransaction();
    		arg2.doFilter(arg0, arg1);
    		
    		//回来了
    		ts.commit();
    	}catch(Exception e) {
    		if(ts != null) {
    			ts.rollback();
    		}
    		throw new RuntimeException(e.getMessage());
    	}finally {
    		HibernateUtil.closeCurrentSession();
    	}
    	
    	
    }

	
}
