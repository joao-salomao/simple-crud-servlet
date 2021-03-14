<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<core:url value="/entry-point?action=update" var="updateCompanyUrl" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<core:import url="logout.jsp" />
	<form action="${updateCompanyUrl}" method="post">
		Name: <input type="text" name="name" value="${company.name}">
		Date: <input type="text" name="date"
			value="<fmt:formatDate value="${company.date}" pattern="dd/MM/yyyy"/>">
		<input type="hidden" name="id" value="${company.id}"> <input
			type="submit">
	</form>
</body>
</html>