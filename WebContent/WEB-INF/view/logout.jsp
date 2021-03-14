<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:url value="/entry-point?action=logout" var="logoutUrl" />
<div style="float: right; margin-bottom: 10px;">
	<p style="margin-bottom: 0;">User: ${ authUser.login }</p>
	<a href="${logoutUrl}">Logout</a>
</div>