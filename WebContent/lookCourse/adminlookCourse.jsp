<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台--查看、修改选修课程</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<script type="text/javascript" language="javascript">
function confirmDel(){
	 var msg = "真的要删除吗？";
         if(confirm(msg)==true){
	  return true;
         }else{
          return false;
         }
 }
 </script>
<body bgcolor="#cccfff">

<% ArrayList<CourseBean> allcourse = (ArrayList<CourseBean>) request.getAttribute("allcourse");
   String sel = (String)request.getAttribute("sel");
   session.setAttribute("sel", sel);
   %>
<ul> 	
		<li><a href="./adminmain.jsp">返回主页面</a></li>
</ul>
<hr/>
<br><br>
<center>
<a href="lookCourse/addcourse.jsp">新增课程</a>
<table border="1px" cellspacing="0" cellpadding="5">
<tr><th>课程号</th><th>课程名</th><th>选/必修</th><th>学分</th><th>删除</th></tr>
<%
	for(int i=0;i<allcourse.size();i++){
		CourseBean nn = allcourse.get(i);
%>
<tr><td><%=nn.getCid() %></td>
	<td><%=nn.getCname() %></td>
	<td><%=nn.getType() %></td>
	<td><%=nn.getCredit() %></td>
	<td><a href="http://localhost:8080/bbumanager1/deleteCourseServlet?id=<%=nn.getCid() %>"  onclick="return confirmDel()">删除</a></td>
</tr>
<%} %>
</table></center>

</body>
</html>