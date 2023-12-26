<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="classBean" class="org.bean.JavaBean" scope="page"></jsp:useBean>
<head>
<title>用户信息维护</title>
</head>
<body>
<div align="center">
<table border="1">
<tr><td >用户名</td><td >密码</td><td align="center">操作</td> </tr>
<%
classBean.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
classBean.setUser("sa");
classBean.setPassword("123456");
classBean.openConnection();
ResultSet rs = classBean.executeQueryUser();
while(rs.next()){
	String username=rs.getString("username");
	String password=rs.getString("password");
	
%>
<tr><td><%=username %></td><td><%=password %></td>
<td><a href="userRename.jsp?username=<%=username%>&password=<%= rs.getString("password") %>">修改</a>
<a href="DelUser?username=<%=username%>&password=<%= rs.getString("password") %>">删除</a></td></tr>
<%} 
classBean.closeConnection();
%>
</table>
<form method="post" action="setting.jsp">
<input type="submit" value="返回" >
</form>
</div>
</body>
</html>