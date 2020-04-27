<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.bbu.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息管理系统--修改个人信息</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="cccfff">
<% ArrayList<UserBean> allusers = (ArrayList<UserBean>) session.getAttribute("allusers"); %>
<%  String username = (String )session.getAttribute("username");
    String sel = (String )session.getAttribute("sel");
    session.setAttribute("username",username);
    session.setAttribute("sel",sel);
    username = java.net.URLEncoder.encode(username,"UTF-8");
//	System.out.println(username);  //验证是否传值成功%>
<ul>
		<li><a href="http://localhost:8080/bbumanager1/lookMessageServlet?username=<%=username%>&&sel=<%=sel %>">查看个人信息</a></li>
		<li>修改个人信息</li>
		<li><a href="../lookMessage/updatePassword.jsp">修改密码</a></li>
		<li><a href="../main.jsp">返回主页面</a></li>
		
<hr/>
<br>
<pre>
			注意事项：
			1、所有需本人录入的信息必须实事求是，详尽细致，认真填写。
			2、不可录入信息由学院维护并修改。
</pre>
<center>
<form action="../updateMessageServlet?username=<%=username%>&&sel=<%=sel %>" method="post">
	<table border="1" cellspacing="0" cellpadding="5">
	<%
		for(int i=0;i<allusers.size();i++){
		UserBean user = allusers.get(i);
	%>
<input type="hidden" name="username" value="<%=user.getUsername()%>">
<tr><td>用户姓名</td><td><%=user.getName() %></td></tr>
<tr><td>用户性别</td><td><%=user.getSex() %></td></tr>
<tr><td>出生日期</td><td><%=user.getBirth() %></td></tr>
<tr><td>用户民族</td><td><%=user.getNation() %></td></tr>
<tr><td>用户学历</td>
	<td><select name="edu" size="1">
						<%if(user.getEdu().equals("博士")){ %>
						<option value="博士">博士</option>
						<%}else{ %>
						<option value="博士">博士</option>
						<%} %>
						<%if(user.getEdu().equals("硕士")){ %>
						<option value="硕士">硕士</option>
						<%}else{ %>
						<option value="硕士">硕士</option>
						<%} %>
						<%if(user.getEdu().equals("本科")){ %>
						<option value="本科">本科</option>
						<%}else{ %>
						<option value="本科">本科</option>
						<%} %>
						<%if(user.getEdu().equals("专科")){ %>
						<option value="专科">专科</option>
						<%}else{ %>
						<option value="专科">专科</option>
						<%} %>
						<%if(user.getEdu().equals("其他")){ %>
						<option value="其他">其他</option>
						<%}else{ %>
						<option value="其他">其他</option>
						<%} %>
						</select></td></tr>
<tr><td>用户职称</td>
	<td><select name="work" size="1">
						<%if(user.getWork().equals("学生")){ %>
						<option value="学生">学生</option>
						<%}else{ %>
						<option value="学生">学生</option>
						<%} %>
						<%if(user.getWork().equals("对口学生")){ %>
						<option value="对口学生">对口学生</option>
						<%}else{ %>
						<option value="对口学生">对口学生</option>
						<%} %>
						<%if(user.getWork().equals("其他")){ %>
						<option value="其他">其他</option>
						<%}else{ %>
						<option value="其他">其他</option>
						<%} %>
	                    </select></td></tr>
<tr><td>用户电话</td><td><input type="text" name="phone" value="<%=user.getPhone() %>"></td></tr>
<tr><td>家庭住址</td> <td><input type="text" name="place" value="<%=user.getPlace() %>"></td></tr>
<tr><td>邮箱地址</td><td><input type="text" name="email" value="<%=user.getEmail() %>"></td></tr>
<tr><td align="center"><input type="submit" value="确定" size="12"></td>&nbsp;&nbsp;
				   	 <td align="center">  <input type="reset" value="清除" size="12"></td></tr>
<%}%>
</table>
</form>
</center>
</body>
</html>