<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
%>
  <head>
    <title>学生管理</title>
    <link rel="stylesheet" href="./stylesheet.css" type="text/css"></link>
  </head>
<body>
    <div>
    <table style="width:1000px;"align="center">
            <tr>
                <td align="center" height="100px" style="font-size: 50px;" >
                    欢迎使用学生成绩管理系统
                </td>
            </tr>
            <tr>
                 <td align="center">
        <table border="0" width="200px">
            <tr>
                <td align="center" bgcolor="#66CCFF">
                    &nbsp;</td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 30px;">
                    <img alt="" src="./image/LuVred.png">班级管理</td>
            </tr>
            <tr>
                <td >
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="addClass.jsp" target="rightFrame">班级增加</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="classMove.jsp" target="rightFrame">班级维护</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 30px;">
                    <img alt="" src="./image/LuVblue.png">学生管理</td>
            </tr>
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="addStudent.jsp" target="rightFrame">学生增加<br></a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="stuMove.jsp" target="rightFrame">学生成绩维护</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 30px;">
                    <img alt="" src="./image/LuVred.png">用户管理</td>
            </tr>
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif"> 
                    <a href="addUser.jsp" target="rightFrame">用户增加</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif"> 
                    <a href="userMove.jsp" target="rightFrame">用户维护</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td style="font-size: 30px;">
                    <img alt="" src="./image/LuVblue.png"> 当前用户</td>
            </tr>            
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="userRename.jsp?username=<%=username %>&password=<%=password %>" target="rightFrame">密码设置</a></td>
            </tr>            
            <tr>
                <td>
                    &nbsp;<img alt="" src="./image/LuArrow.gif">
                    <a href="main.jsp" target="_top">安全退出</a></td>
            </tr>
            <tr>
                <td>
                    &nbsp;</td>
            </tr>
            <tr>
                <td bgcolor="#66CCFF">
                    &nbsp;</td>
            </tr>
        </table>
        </td>
        </tr>
        </table>
    </div>
</body>
</html>
