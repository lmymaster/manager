<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台--查看修改学生信息</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
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
</head>
<body >
<% //ArrayList<UserBean> allusers=(ArrayList<UserBean>) request.getAttribute("allusers");
    ArrayList<UserBean> allusers = new ArrayList<UserBean>();
    PageBean pageBean = new PageBean();
   if(request.getAttribute("pageBean")!=null){
	pageBean = (PageBean)request.getAttribute("pageBean");
	allusers = (ArrayList<UserBean>)pageBean.getRecordList();
	}

   String sel = (String)request.getAttribute("sel");
   session.setAttribute("sel", sel);
%>
<ul> 	
		<li><a href="./adminmain.jsp">返回主页面</a></li>
</ul>
   <center>

	<a href="lookMessage/addUser.jsp">新增用户</a>
	<hr/>
<table border="1px" cellspacing="0" cellpadding="5">
<tr><th>登录名</th><th>登陆密码</th><th>真实姓名</th><th>性别</th><th>出生日期</th><th>民族</th>
<th>学历</th><th>职称</th><th>用户电话</th><th>住址</th><th>用户邮箱</th><th>编辑</th><th>删除</th></tr>   
	<%  for(int i=0;i<allusers.size();i++){
		UserBean user = allusers.get(i);
%>
 
<tr>
<td><%=user.getUsername() %></td>
<td><%=user.getPassword() %></td>
<td><%=user.getName() %></td>
<td><%=user.getSex() %></td>
<td><%=user.getBirth() %></td>
<td><%=user.getNation() %></td>
<td><%=user.getEdu() %></td>
<td><%=user.getWork() %></td>
<td><%=user.getPhone() %></td>
<td><%=user.getPlace() %></td>
<td><%=user.getEmail() %></td> <td><a href="#">编辑</a></td>
<td><a href="http://localhost:8080/bbumanager1/deleteUserServlet?id=<%=user.getUsername() %>"  onclick="return confirmDel()">删除</a></td>
</tr>
<% } %>
</table></center> 
<% for(int i = pageBean.getBeginPageIndex();i <pageBean.getEndPageIndex();i++){
	%>
	<a href = "http://localhost:8080/bbumanager1/PageServlet?currentPage=<%=i%>">[<%=i %>]</a>
	<%}
	%>


</body>
</html>