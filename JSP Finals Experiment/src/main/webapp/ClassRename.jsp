<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<head>
<title>班级修改</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
sql01.setUser("sa");
sql01.setPassword("123456");
sql01.openConnection();
String bjbh=request.getParameter("bjbh");
String bjmc=request.getParameter("bjmc");
%>
<div align="center">
<h1>请修改班级信息</h1>
<form method="post" action="ClassRename">
<table border="1">
<tr><td>班级编号</td><td><input name="newbjbh" type="text" id="newName" value="<%=bjbh %>"></td></tr>
<tr><td>班级名称</td><td><input name="newbjmc" type="text" id="newNum" value="<%=bjmc %>"></td></tr>
<tr><td colspan="2" style="text-align: center; vertical-align: middle;">
<input type="hidden" name="bjbh" value="<%=bjbh %>">
<input type="hidden" name="bjmc" value="<%=bjmc %>">
<input type="submit" value="确认" >
</td></tr>
</table>
</form>
<form method="post" action="classMove.jsp">
<input type="submit" value="返回" >
</form>
</div>
</body>
</html>