<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/new" var="newCompanyUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<form action="${ newCompanyUrl }" method="post">
		Nome: <input type="text" name="name"> 
		Data: <input type="text" name="date">
		<input type="submit">
	</form>
</body>
</html>