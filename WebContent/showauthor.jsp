<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SUCCESS</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">


</head>
<body>
	<h2 class="title">作者信息</h2>
	<div class="dv">
		<table class="tb">
			<tr>
				<th>AuthorID</th>
				<td>${authorinfo.authorID }</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${authorinfo.name }</td>
			</tr>
			<tr>
				<th>Age</th>
				<td>${authorinfo.age }</td>
			</tr>
			<tr>
				<th>Country</th>
				<td>${authorinfo.country }</td>
			</tr>
		</table>
		<a href="toaddbook.action?authorID=${authorinfo.authorID }" class="add"> add book to this author </a>
	</div>
	<a href="index.jsp" class="back"> back to main</a>

</body>
</html>