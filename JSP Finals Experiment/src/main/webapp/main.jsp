<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生成绩管理</title>
    <link rel="stylesheet" href="./stylesheet.css" type="text/css"></link>
  </head>
<body>

    <div>
    <form action="LoginDB" method="post">
    <img alt="" src="./image/Title.png" style="margin-top: 20px; margin-left: 40px;">
        <table style="width:500px;" align="center">
            <tr>
                <td align="center">
                    <img alt="" src="./image/welcome.png">
                </td>
            </tr>
            <tr>
                 <td align="center">
				<table style="border: thin dashed #008080;" width="350" align="center">
				<tr>
				<td style="width: 30%">&nbsp;</td>
				<td style="width: 70%">&nbsp;</td>
				</tr>
				
				
				<tr>
				<td align="center" colspan="2">
				<b>系统登录</b>
				
				</td>
				</tr>
				<tr>
				<td align="center" colspan="2"><%
if(request.getAttribute("error")==null){
	request.setAttribute("error", "请输入账号密码");
}
out.print(request.getAttribute("error"));
%></td>
				<td>&nbsp;</td>
				</tr>
				<tr>
				<td align="right">
					用户名:
				</td>
				<td>
					<input type="text" name="username" maxlength="10">
				</td>
				</tr>
				<tr>
				<td align="right">
					密码:
				</td>
				<td>
					<input type="password" name="password" maxlength="20">
				</td>
				</tr>
				<tr>
				<td>&nbsp;</td>
				<td><input type="hidden" name="action" value="login"></td>
				</tr>
				<tr>
				<td align="center" colspan="2">
				<input type="submit" name="submit" value="确定">
				</td>
				</tr>
        </table>
        
        <tr> <td height="600px">
        </tr>
        <tr>
                <td align="center">
					<font color="#330033"> 湖北工程学院 022301304132 袁作函 GageEdan&copy;All Rights Reserved.</font></td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>