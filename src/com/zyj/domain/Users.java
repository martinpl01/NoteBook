package com.zyj.domain;

import java.util.Set;

public class Users implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userid;
	private String passwd;
	private String name;
	
	//一个人有很多接受信息 也有很多发送信息
	private Set<Message> senderMes;
	private Set<Message> getterMes;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Message> getSenderMes() {
		return senderMes;
	}
	public void setSenderMes(Set<Message> senderMes) {
		this.senderMes = senderMes;
	}
	public Set<Message> getGetterMes() {
		return getterMes;
	}
	public void setGetterMes(Set<Message> getterMes) {
		this.getterMes = getterMes;
	}
	

}
