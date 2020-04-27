<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body bgcolor="#cccfff">
		<li><a href="./main.jsp">返回主页面</a></li>
<form action="UploadServlet" method="post" enctype="multipart/form-data">
			学号：<input type="text" name="sno"><br/>
			姓名：<input type="text" name="sname"><br/>
			上传文件：<input type="file" name="spicture"><br/>
			      <input type="submit" value="上传">
		</form>
		<a href="DownloadServlet?filename=图片.png">图片下载</a>
</body>
</html>