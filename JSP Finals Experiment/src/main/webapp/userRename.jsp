<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<head>
<title>用户修改</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
sql01.setUser("sa");
sql01.setPassword("123456");
sql01.openConnection();
String username=request.getParameter("username");
String password=request.getParameter("password");
%>
<div align="center">
<h1>请修改用户信息</h1>
<form method="post" action="UserRename">
<table border="1">
<tr><td>用户名</td><td><input name="newusername" type="text" id="newusername" value="<%=username %>"></td></tr>
<tr><td>密码</td><td><input name="newpassword" type="password" id="newpassword" value="<%=password %>"></td></tr>
<tr><td colspan="2" style="text-align: center; vertical-align: middle;">
<input type="hidden" name="username" value="<%=username %>">
<input type="hidden" name="password" value="<%=password %>">
<input type="submit" value="确认" >
</td></tr>
</table>
</form>
<form method="post" action="userMove.jsp">
<input type="submit" value="返回" >
</form>
</div>
</body>
</html>