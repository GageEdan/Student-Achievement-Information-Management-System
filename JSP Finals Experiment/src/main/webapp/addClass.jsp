<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:useBean id="sql01" class="org.bean.JavaBean" scope="page"/>
<html>
<head>
<title>班级增加</title>
</head>
<body>
<div align="center">
<h1>请添加班级</h1>
<form method="post" action="AddClass">
<table border="1">
<% request.setCharacterEncoding("UTF-8");%>
<tr><td>班级编号</td><td><input name="bjbh" type="text" id="bjbh"></td></tr>
<tr><td>班级名称</td><td><input name="bjmc" type="text" id="bjmc"></td></tr>
<tr><td colspan="2" style="text-align: center;">
<input type="button" value="返回"  onclick="window.location.href='setting.jsp'"> 
<input type="submit" value="确认" > 
</td></tr>
</table>

</form>
</div>
</body>
</html>