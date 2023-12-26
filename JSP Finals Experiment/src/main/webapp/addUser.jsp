<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<html>
<head>
<title>用户增加</title>
</head>
<body>
<div align="center">
<h1>请添加用户</h1>
<form method="post" action="AddUser">
<table border="1">
<% request.setCharacterEncoding("UTF-8");%>
<tr><td>用户名</td><td><input name="user" type="text" id="user"></td></tr>
<tr><td>密码</td><td><input name="password" type="password" id="password"></td></tr>
<tr><td colspan="2" style="text-align: center;">
<input type="button" value="返回"  onclick="window.location.href='setting.jsp'"> 
<input type="submit" value="确认" > 
</td></tr>
</table>
</form>
</div>
</body>
</html>