<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理--管理员操作界面</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<% String sel =(String)request.getAttribute("sel") ;
   String username =(String)request.getSession().getAttribute("username") ;
   username = java.net.URLEncoder.encode(username,"UTF-8");  //URL中文参数乱码处理，那在将中文作为参数值传递时，首先要把中文字符串进行编码转换，转换成URL格式,使用URLEncoder.encode方法
   //sel = java.net.URLEncoder.encode(sel,"UTF-8"); 
%>
<div id="body">
	 <div id="top">
		<div id="top1"><img src="./images/bbxy.jpg" alt="蚌埠学院" height="100px"></div>
		<div id="top2">欢迎使用学生信息管理系统后台</div>
		</div>
	 <div id="nav">
	 	<ul>
		<li><a href="http://localhost:8080/bbumanager1/lookCourseServlet?sel=<%=sel %>">查看、修改选修课程</a></li>
		<li><a href="http://localhost:8080/bbumanager1/lookMessageServlet?sel=<%=sel %>">查看、修改学生信息</a></li>
		<li><a href="http://localhost:8080/bbumanager1/login.jsp">退出主页面</a></li>
		</ul>
		<div id="wel">欢迎,${username }登陆系统</div>
		
	 </div>
	<div id="article">
		<%  
 String message=(String)request.getAttribute("message");
	if(message==null)
		message="";
%>
<h1><%=message %></h1>
	</div>
	<div id="footer">
		欢迎使用蚌埠学院学生管理系统
	</div>
	
	</div>
</body>
</html>