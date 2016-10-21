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
	<h1 class="title">Choose Author</h1>
	<div class="dv">
		<h2>Input the Author ID</h2>
		<s:form action="searchAddAuthorID" class="f">
			<s:textfield name="authorID" style="width:100%" />
			<s:submit class="btn" value="search" />
		</s:form>
	</div>

</body>
</html>
