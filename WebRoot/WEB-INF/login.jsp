<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <form action="/Note1/login.do?flag=login" method="post">
    <table>
    <tr><td colspan="2">部门内部留言本</td></tr>
    <tr><td>用户ID</td><td><input type="text" style="width: 200px" name="userid"></td></tr>
    <tr><td>密码</td><td><input type="password" style="width: 200px" name="passwd"></td></tr>
    <tr><td><input type="submit" value="提交"></td><td><input type="reset" value="重写"></td></tr>
    </table>
    </form>
  </body>
</html>
