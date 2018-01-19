<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <font size="5"><b><a href="${pageContext.request.contextPath}/goPublishMessageUi.do?flag=goPublishMessage">发布信息</a></b></font>   
    <font size="5"><b><a href="/Note1/login.do?flag=logout">安全退出</a></b></font>
    欢迎 ${userInfo.name }留言信息  
    <table>
    <tr><td>发送人</td><td>发送时间</td><td>接收人</td><td>信息内容</td></tr>
    <c:forEach items="${messageInfo }" var="message">
     <tr><td>${message.sender.name }</td>
     <td>${message.mesTime }</td>
     <td>${message.getter.name }</td>
     <td>${message.content }</td></tr>
    </c:forEach>
   
    </table>
  </body>
</html>
