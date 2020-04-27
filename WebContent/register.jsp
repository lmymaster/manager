<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统注册页面</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="cceddff">
<%  
 String message1=(String)request.getAttribute("message1");
	if(message1==null)
		message1="";
%>
<h1><%=message1 %></h1>
    <h3 align="center">请在这里注册</h3>
    <form action="RegisterServlet?type=add" method="post">
      <table border="1" align="center">
		<tr>
			<td>登录名字</td>  <td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>用户密码</td>  <td><input type="password" name="password1"/></td>
		</tr>
		<tr>
			<td>重复密码</td>  <td><input type="password" name="password2"/></td>
		</tr>
		<tr>
			<td>用户姓名</td>  <td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>用户性别</td>  
			<td>
				<input type="radio" name="sex" value="男">男
				<input type="radio" name="sex" value="男">女
			</td>
		</tr>
		<tr>
			<td>出生日期</td> 
			           <td>
							<select name="year" size="1">
								<option value="1978">1978</option>
								<option value="1979">1979</option>
								<option value="1980">1980</option>
								<option value="1981">1981</option>
								<option value="1982">1982</option>
								<option value="1983">1983</option>
								<option value="1984">1984</option>
								<option value="1985">1985</option>
								<option value="1986">1986</option>
								<option value="1987">1987</option>
								<option value="1988">1988</option>
								<option value="1989">1989</option>
								<option value="1990">1990</option>
								<option value="1991">1991</option>
							</select>年
							<select name="month" size="1">
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="05">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>月
							<select name="day" size="1">
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
							</select>日
			</td>
		</tr>
		<tr>
			<td>用户民族</td>  
			<td>
				<input type="radio" name="nation" value="汉族">汉族
				<input type="radio" name="nation" value="壮族">壮族
				<input type="radio" name="nation" value="回族">回族
				<input type="radio" name="nation" value="其他">其他
			</td>
		</tr>
		<tr>
			<td>用户学历</td>
			<td>
				<select name="edu" size="1">
					<option value="博士">博士</option>
					<option value="硕士">硕士</option>
					<option value="本科">本科</option>
					<option value="专科">专科</option>
					<option value="其他">其他</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>用户职称</td>
			<td>
				<select name="work" size="1">
					<option value="对口学生">对口学生</option>
					<option value="学生">学生</option>
					<option value="其他">其他</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>用户电话</td><td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td>家庭地址</td><td><input type="text" name="place" size="10"></td>
		</tr>
		<tr>
			<td>邮箱地址</td><td><input type="text" name="email" size="20"></td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定" size="12">&nbsp;&nbsp;
				<input type="reset" value="清除" size="12">
			</td>
		</tr>
      </table>
    </form>
 </body>
</html>