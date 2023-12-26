<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<html>
<head>
<title>学生成绩增加</title>
</head>
<body>
<div align="center">
<h1>请添加学生成绩</h1>
<form method="post" action="CjZjServlet">
<table border="1">
<% request.setCharacterEncoding("UTF-8");%>
<tr><td>姓名</td><td><input name="name" type="text" id="name"></td></tr>
<tr><td>班号</td><td><input name="bh" type="text" id="bh"></td></tr>
<tr><td>学号</td><td><input name="num" type="text" id="num"></td></tr>
<tr><td>语文</td><td><input name="yw" type="text" id="yw"></td></tr>
<tr><td>数学</td><td><input name="sx" type="text" id="sx"></td></tr>
<tr><td>英语</td><td><input name="yy" type="text" id="yy"></td></tr>
<tr><td>政治</td><td><input name="zf" type="text" id="zf"></td></tr>
<tr><td colspan="2" style="text-align: center;">
<input type="button" value="返回"  onclick="window.location.href='setting.jsp'"> 
<input type="submit" value="确认" > 
</td></tr>
</table>
</form>
</div>
</body>
</html>