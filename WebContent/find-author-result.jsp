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
	<h2 class="title">Author name : ${name }</h2>
	<a href="index.jsp" class="back"> back to main</a>
	<s:iterator value="namelist" var="li">

		<div class="booklist">
			<table class="tb">
				<tr class="name">
					<td><a
						href="findisbn.action?ISBN=<s:property value="#li.ISBN" />"
						class="lk"> <s:property value="#li.name" />
					</a></td>
				</tr>
				<tr class="del">
					<td><a
						href="delisbn.action?ISBN=<s:property value="#li.ISBN" />"
						class="lk"> delete this book </a></td>
				</tr>
			</table>
		</div>
	</s:iterator>
	<a href="index.jsp" class="back"> back to main</a>
</body>
</html>