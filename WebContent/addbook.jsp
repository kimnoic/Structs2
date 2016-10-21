<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Library management main</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

</head>

<body>
	<h1 class="title">Add Book</h1>
	<div class="dv">
		<h2>add book</h2>
		<s:form action="addbook" class="f">
			<s:textfield name="title" label="title" style="width:100%" />
			<s:textfield name="authorID" label="authorID" style="width:100%" readonly="true" />
			<s:textfield name="publisher" label="publisher" style="width:100%" />
			<s:textfield name="price" label="price(int)" style="width:100%" />
			<s:textfield name="ISBN" label="ISBN" style="width:100%" />
			<s:textfield name="publishdate" label="publishdate(xxxx-xx-xx)" style="width:100%" />
			<s:submit class="btn" value="add book" />
		</s:form>
	</div>
	<a href="index.jsp" class="back"> back to main</a>
</body>
</html>
