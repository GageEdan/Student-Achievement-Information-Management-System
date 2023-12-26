<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<head>
<title>学生信息修改</title>
</head>
<body>
<% 
request.setCharacterEncoding("UTF-8");
sql01.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
sql01.setUser("sa");
sql01.setPassword("123456");
sql01.openConnection();
String bh=request.getParameter("class");
String xm=request.getParameter("name");
String xh=request.getParameter("num");
String yw=request.getParameter("yw");
String sx=request.getParameter("sx");
String yy=request.getParameter("yy");
String zf=request.getParameter("zf");
%>
<div align="center">
<h1>请修改学生信息</h1>
<form method="post" action="StuRename">
<table border="1">
<tr><td>姓名</td><td><input name="newxm" type="text" id="newName" value="<%=xm %>"></td></tr>
<tr><td>班号</td><td><input name="newbh" type="text" id="newNum" value="<%=bh %>"></td></tr>
<tr><td>学号</td><td><input name="newxh" type="text" id="newNum" value="<%=xh %>"></td></tr>
<tr><td>语文</td><td><input name="newyw" type="text" id="newNum" value="<%=yw %>"></td></tr>
<tr><td>数学</td><td><input name="newsx" type="text" id="newNum" value="<%=sx %>"></td></tr>
<tr><td>英语</td><td><input name="newyy" type="text" id="newNum" value="<%=yy %>"></td></tr>
<tr><td>政治</td><td><input name="newzf" type="text" id="newNum" value="<%=zf %>"></td></tr>

<tr><td colspan="2" style="text-align: center; vertical-align: middle;">
<input type="hidden" name="xm" value="<%=xm%>">
<input type="hidden" name="bh" value="<%=bh %>">
<input type="hidden" name="xh" value="<%=xh %>">

<input type="submit" value="确认" >
</td></tr>
</table>
</form>
<form method="post" action="stuMove.jsp">
<input type="submit" value="返回" >
</form>
</div>
</body>
</html>