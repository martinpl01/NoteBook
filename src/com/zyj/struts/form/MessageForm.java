/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.zyj.struts.form;

import org.apache.struts.action.ActionForm;

/** 
 * MyEclipse Struts
 * Creation date: 01-17-2018
 * 
 * XDoclet definition:
 * @struts.form name="messageForm"
 */
public class MessageForm extends ActionForm {
	
	private String getter;
	private String content;
	public String getGetter() {
		return getter;
	}
	public void setGetter(String getter) {
		this.getter = getter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}