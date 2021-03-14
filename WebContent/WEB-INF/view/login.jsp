<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/entry-point?action=authenticate" var="loginUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="${loginUrl}" method="post">
		Login: <input type="text" name="login">
		Password: <input type="text" name="password">
		<input type="submit">
	</form>
</body>
</html>