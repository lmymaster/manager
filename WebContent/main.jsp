<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理系统--主页面</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

  <%// ArrayList<UserBean> allusers=(ArrayList<UserBean>) request.getAttribute("allusers"); %>
 <!--   <center>
<h1>welcome ${username }登录</h1>
	<hr/>
	<a href="register.jsp">新增用户</a>&nbsp;&nbsp; <a href="#">注销</a>
	<hr/>
<table border="1px" cellspacing="0" cellpadding="5">
<tr><th>登录名</th><th>登陆密码</th><th>真实姓名</th><th>性别</th><th>出生日期</th><th>民族</th>
<th>学历</th><th>职称</th><th>用户电话</th><th>住址</th><th>用户邮箱</th><th>编辑</th><th>删除</th></tr>   -->
<%
	// for(int i=0;i<allusers.size();i++){
		//UserBean user = allusers.get(i);
%>
 
<tr>
<td><%//=user.getUsername() %></td>
<td><%//=user.getPassword() %></td>
<td><%//=user.getName() %></td>
<td><%//=user.getSex() %></td>
<td><%//=user.getBirth() %></td>
<td><%//=user.getNation() %></td>
<td><%//=user.getEdu() %></td>
<td><%//=user.getWork() %></td>
<td><%//=user.getPhone() %></td>
<td><%//=user.getPlace() %></td>
<td><%//=user.getEmail() %></td>
<!-- <td><a href="#">编辑</a></td>
<td><a href="#">删除</a></td>
</tr>
<%//} %>
</table></center> -->




<%	String sel =(String)session.getAttribute("sel") ;
	String username =(String)request.getSession().getAttribute("username") ;
    username = java.net.URLEncoder.encode(username,"UTF-8");  //URL中文参数乱码处理，那在将中文作为参数值传递时，首先要把中文字符串进行编码转换，转换成URL格式,使用URLEncoder.encode方法
    //sel = java.net.URLEncoder.encode(sel,"UTF-8"); 
%>

<div id="body">

	 <div id="top">
		<div id="top1"><img src="./images/bbxy.jpg" alt="蚌埠学院" height="100px"></div>
		<div id="top2">欢迎使用学生信息管理系统</div>
		</div>
	 <div id="nav">
	 	<ul>
		<li><a href="http://localhost:8080/bbumanager1/lookMessageServlet?username=<%=username%>&&sel=<%=sel %>">个人信息管理（查询、修改信息、修改密码）</a></li>   
		<li><a href="http://localhost:8080/bbumanager1/lookCourseServlet?sel=<%=sel %>">选修课程</a></li>
		<li><a href="UpandDown.jsp">上传下载图片</a></li>
		<li><a href="buy.jsp">支付宝沙箱简单支付</a></li>
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
		<!--<dl>
		  <dt><img src="./images/bbxy.jpg" height="100px"></dt>
		<dd>蚌埠学院</dd>
		<dd>123</dd>
		</dl>
		<hr>-->
	</div>
	<div id="footer">
		欢迎使用蚌埠学院学生管理系统
	</div>
	
	</div>
</body>
</html>