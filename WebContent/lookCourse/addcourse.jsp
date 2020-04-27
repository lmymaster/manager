<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加课程</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="cccfff">

<h3 align="center">请在这里添加</h3>
    <form action="http://localhost:8080/bbumanager1/addCourseServlet?type=add" method="post">
      <table border="1" align="center">
		<tr>
			<td>课程号</td>  <td><input type="text" name="cid"/></td>
		</tr>
		<tr>
			<td>课程名</td>  <td><input type="text" name="cname"/></td>
		</tr>
		<tr>
			<td>选/必修</td>  
			<td>
				<input type="radio" name="type" value="必修" checked>必修
				<input type="radio" name="type" value="选修">选修
			</td>
		</tr>
		<tr>
			<td>学分</td>  <td>
							<select name="credit" size="1">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								</select>
								</td>
		</tr>
		<tr>
			<td align="center">
				<input type="submit" value="确定" size="12">&nbsp;&nbsp;
				<input type="reset" value="清除" size="12">
			</td>
		</tr>
</body>
</html>