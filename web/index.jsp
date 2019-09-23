<%--
  Created by IntelliJ IDEA.
  User: rael0
  Date: 23/09/2019
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<%@include file="WEB-INF/head.jsp" %>
	<title>Index</title>
</head>
<body>
<section class="login">
	<form action="./index" method="post">
		<input type="text" name="login" value="${param.login}">
		<input type="text" name="password" value="${param.password}">
		<input type="submit" value="Valider">
	</form>
</section>
</body>
</html>
