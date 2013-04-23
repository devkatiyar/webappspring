<%@include file="/WEB-INF/jsp/taglib_includes.jsp"%>

<html>

<h3>Welcome : ${username}</h3>
<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
<head>

<title><spring:message code="App.Title"></spring:message></title>



<script>
	function go(url) {
		window.location = url;
	}

	function deleteContact(url) {
		var isOK = confirm("Are you sure to delete?");
		if (isOK) {
			go(url);
		}
	}

	function updateContact(url) {
		go(url);
	}
</script>
</head>
<body style="font-family: Arial; font-size: smaller;">
	<center>
		<form action="searchContacts.do" method="post">
			<table style="border-collapse: collapse;" width="500" border="0"
				bordercolor="#006699">
				<tbody>
					<tr>
						<td>Enter Contact Name</td>
						<td><input name="name" type="text"> <input
							value="Search" type="submit"> <input value="New Contact"
							onclick="javascript:go('saveContact.do');" type="button">

						</td>
					</tr>
				</tbody>
			</table>


		</form>
		<c:if test="${empty SEARCH_CONTACTS_RESULTS_KEY}">
			<tr>
				<td colspan="4">No Results found</td>
			</tr>
		</c:if>

		<table style="border-collapse: collapse;" width="500" border="1"
			bordercolor="#006699">
			<tbody>
				<tr bgcolor="lightblue">
					<th>Name</th>
					<th>Address</th>
					<th>Mobile</th>
					<th></th>
				</tr>

				<c:if test="${! empty SEARCH_CONTACTS_RESULTS_KEY}">
					<c:forEach var="contact" items="${SEARCH_CONTACTS_RESULTS_KEY}">

					

						<tr>

							<td><c:out value="${contact.name}"></c:out>
							</td>
							<td><c:out value="${contact.address}"></c:out></td>
							<td><c:out value="${contact.mobile}"></c:out>
							</td>
							<td><a
								href="javascript:updateContact('updateContact.do?id=${contact.id}');">
									Edit</a> <a
								href="javascript:deleteContact('deleteContact.do?id=${contact.id}');">Delete</a>

							</td>
						</tr>

					</c:forEach>
				</c:if>

			</tbody>
		</table>

	</center>
</body>
</html>
