<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="classBean" class="org.bean.JavaBean" scope="page"></jsp:useBean>
<head>
<title>班级信息维护</title>
</head>
<body>
<div align="center">
<table border="1">
<tr><td >班级编号</td><td >班级名称</td><td align="center">操作</td> </tr>
<%
classBean.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
classBean.setUser("sa");
classBean.setPassword("123456");
classBean.openConnection();
ResultSet rs = classBean.executeQueryClass();
while(rs.next()){
	String bjbh=rs.getString("bjbh");
	String bjmc=rs.getString("bjmc");
	
%>
<tr><td><%=bjbh %></td><td><%=bjmc %></td>
<td><a href="ClassRename.jsp?bjbh=<%=bjbh%>&bjmc=<%= rs.getString("bjmc") %>">修改</a>
<a href="DelClass?bjbh=<%=bjbh%>&bjmc=<%= rs.getString("bjmc") %>">删除</a></td></tr>
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