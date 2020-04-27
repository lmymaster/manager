  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>蚌埠学院学生信息管理系统</title>
<link rel="stylesheet" type="text/css" href="css/login1.css">  <!-- 哥要准备写css了！Rel是relationship的英文缩写，它描述了当前页面与href所指定文档的关系；
                                                                   stylesheet就是样式表的意思；CSS是 Cascading Style Sheet（级联样式表）的缩写 -->
<script type="text/javascript" language="javascript">

//点击图片切换图片
function Imagecheck(){
	 //IE存在缓存,需要new Date()实现更换路径的作用  
//document.getElementById("vcodeimage").src="validateServlet?t="+new Date().getTime();  
	var img = document.getElementById("vcodeimage");
	    //设置时间戳
	   var date = new Date().getTime();
	    img.src="validateServlet?"+date;
	}		
 </script>                                                                  
</head>
<body>

<%  
 String message=(String)request.getAttribute("message");
	if(message==null)
		message="";
%>
<h1><%=message %></h1>
<div id="val">
	<form  action="LoginServlet" method="post">
	&nbsp;&nbsp;&nbsp;用户登录      <span id="tip"><a href="register.jsp">没有账号>>请注册</a></span>
	<table id="val1">
		<tr><td><input type="text" name="username" placeholder="用户名" style="font-size:18pt"></td></tr>
		<tr><td><input type="password" name="password" placeholder="密码" style="font-size:18pt"></td></tr>
		<tr><td><input  type="text" name="vcode" placeholder="验证码" style="font-size:18pt"></td>
				<td><img title="点击图片切换验证码" id="vcodeimage" src="validateServlet" onclick="Imagecheck()"></td></tr>
				<tr><td align="center" ><input type="radio" name="sel" value="student" checked>学生
				                        <input type="radio" name="sel" value="admin">管理员</td></tr>
		                
		</table>
		<button type="submit">登录</button>
	</form>
</div>

</body>
</html>