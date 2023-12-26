<%@ page import="java.sql.*"%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<html>
<jsp:useBean id="classBean" class="org.bean.JavaBean" scope="page"></jsp:useBean>
<head>
<title>学生信息维护</title>
</head>
<body>
<%
//String bj=request.getParameter("bj");
String bj=request.getParameter("class");
try{
	classBean.setUrl("jdbc:sqlserver://localhost:1433;DatabaseName=student01");
	classBean.setUser("sa");
	classBean.setPassword("123456");
	classBean.openConnection();
	ResultSet rs = classBean.executeQueryStu();
%> 
<input type="hidden" name="class" value="<%=bj%>">
<div align="center">
<table border="1">
<tr><td>姓名</td> <td>班号</td> <td>学号</td>
<td>语文</td><td>数学</td><td>英语</td><td>政治</td><td>操作</td></tr>
<%

while(rs.next()){
	String xm=rs.getString("xm");
	String num=rs.getString("xh");
	String bh=rs.getString("bh");
	String yw=rs.getString("yw");
	String sx=rs.getString("sx");
	String yy=rs.getString("yy");
	String zf=rs.getString("zf");
%>
<tr> <td><%=xm %></td> <td><%=num %></td> <td><%=bh %></td>
<td><%=yw %></td><td><%=sx %></td><td><%=yy %></td><td><%=zf %></td>
<td><a href="stuRename.jsp?class=<%=rs.getString("bh")%>&name=<%= rs.getString("xm") %>&num=<%= rs.getString("xh") %>&yw=<%= rs.getString("yw") %>&sx=<%= rs.getString("sx") %>&yy=<%= rs.getString("yy") %>&zf=<%= rs.getString("zf") %>">修改</a>
<a href="DelStu?class=<%=rs.getString("bh")%>&name=<%= rs.getString("xm") %>&num=<%= rs.getString("xh") %>">删除</a></td></tr>
<%
} 
classBean.closeConnection();
}
catch(ClassNotFoundException e){
	out.println("!"+e.getMessage());
}
catch(SQLException e){
	out.println(e.getMessage());
}
%>
</table>
<form method="post" action="setting.jsp">
<input type="submit" value="返回" >
</form>
</div>
</body>
</html>