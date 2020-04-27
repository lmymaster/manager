<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理系统--个人信息管理</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body >
<% String username =(String)request.getSession().getAttribute("username") ;
   String sel = (String)request.getSession().getAttribute("sel");
   session.setAttribute("username",username);  
   session.setAttribute("sel",sel);
    //System.out.println(username);
    
%>
<% ArrayList<UserBean> allusers = (ArrayList<UserBean>) request.getAttribute("allusers"); %>
<% session.setAttribute("allusers",allusers);  // 将allusers的值传到updateMessage.jsp中 %>     
<ul> 
		<li>查看个人信息</li>
		<li><a href="./lookMessage/updateMessage.jsp">修改个人信息</a></li>
		<li><a href="./lookMessage/updatePassword.jsp">修改密码</a></li>
		<li><a href="main.jsp">返回主页面</a></li>
		
</ul>
<hr/>
<br><br>
<center>

<table border="1px" cellspacing="0" cellpadding="5">
<%
	for(int i=0;i<allusers.size();i++){
		UserBean user = allusers.get(i);
%>
<tr><td>用户姓名</td><td><%=user.getName() %></td></tr>
<tr><td>用户性别</td><td><%=user.getSex() %></td></tr>
<tr><td>出生日期</td><td><%=user.getBirth() %></td></tr>
<tr><td>用户民族</td><td><%=user.getNation() %></td></tr>
<tr><td>用户学历</td><td><%=user.getEdu() %></td></tr>
<tr><td>用户职称</td><td><%=user.getWork() %></td></tr>
<tr><td>用户电话</td><td><%=user.getPhone() %></td></tr>
<tr><td>家庭住址</td> <td><%=user.getPlace() %></td></tr>
<tr><td>邮箱地址</td><td><%=user.getEmail() %></td></tr>
<%} %>
</table></center>

</body>
</html>