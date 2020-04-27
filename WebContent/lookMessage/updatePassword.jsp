<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理系统--修改密码</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="cccfff">
<%  String username = (String )session.getAttribute("username");   //分别从look--.jsp、update--jsp  获取username、sel的值
    String sel = (String )session.getAttribute("sel");
	session.setAttribute("sel", sel);
	//System.out.println(username);  //验证是否传值成功,从lookMessage.jsp跳转此页面验证一次，从updateMessage.jsp跳转此页面验证一次
    username = java.net.URLEncoder.encode(username,"UTF-8");   

    %>  
<ul>
		<li><a href="http://localhost:8080/bbumanager1/lookMessageServlet?username=<%=username%>&&sel=<%=sel%>">查看个人信息</a></li>
		<li><a href="../lookMessage/updateMessage.jsp">修改个人信息</a></li>
		<li>修改密码</li>
		<li><a href="../main.jsp">返回主页面</a></li>
		
</ul>
<form action="../updatePasswordServlet?username=<%=username %>&&sel=<%=sel %>" method="post">
<table border="1" cellspacing="0" cellpadding="5">
<input type="hidden" name="username" value=<%=username %>>
<tr>
			<td>用户密码</td>  <td><input type="password" name="password1"/></td>
		</tr>
		<tr>
			<td>重复密码</td>  <td><input type="password" name="password2"/></td>
		</tr>
		<tr><td align="center"><input type="submit" value="确定" size="12"></td>
			<td align="center"><input type="reset" value="清除" size="12"></td>
		</tr>
</table>
</form>
</body>
</html>