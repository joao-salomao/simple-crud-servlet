<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<core:url value="/new" var="newCompanyUrl" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Companies</title>
<style>
table, th, td {
	border: 1px solid black;
}

td {
  text-align: center;
}
</style>
</head>
<body>
	<div>
		<h2 style="margin-bottom: 0">List</h2>
		<a style="margin-bottom: 10px; float: right;" href="${newCompanyUrl}">Create</a>
	</div>
	<table style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Date</th>
			<th>Actions</th>
		</tr>
		<core:forEach items="${companies}" var="company">
			<tr>
				<td>${company.name}</td>
				<td><fmt:formatDate value="${company.date}"
						pattern="dd/MM/yyyy" /></td>
				<td>
					<a href="<core:url value="/update?id=${company.id}" />">Update</a>
					<a href="<core:url value="/delete?id=${company.id}" />">Delete</a>
				</td>
			</tr>
		</core:forEach>
	</table>

</body>
</html>