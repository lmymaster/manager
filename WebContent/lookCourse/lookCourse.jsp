<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理系统--查看课程</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="cccfff">
<% ArrayList<CourseBean> allcourse = (ArrayList<CourseBean>) request.getAttribute("allcourse"); %>
<ul> 	
		<li><a href="./main.jsp">返回主页面</a></li>
</ul>
<hr/>
<br><br>
<center>

<table border="1px" cellspacing="0" cellpadding="5">
<tr><th>课程号</th><th>课程名</th><th>选/必修</th><th>学分</th></tr>
<%
	for(int i=0;i<allcourse.size();i++){
		CourseBean nn = allcourse.get(i);
%>
<tr><td><%=nn.getCid() %></td>
	<td><%=nn.getCname() %></td>
	<td><%=nn.getType() %></td>
	<td><%=nn.getCredit() %></td></tr>

<%} %>
</table></center>

</body>
</html>