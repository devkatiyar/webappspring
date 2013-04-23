<%@include file="/WEB-INF/jsp/taglib_includes.jsp"%>

<html>
<head>

<title><spring:message code="App.Title"></spring:message></title>
<script>
	function go(url) {
		window.location = url;
	}
</script>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table style="border-collapse: collapse;" width="750" align="center"
		bgcolor="lightblue" border="1" bordercolor="#006699" height="500">
		<tbody>
			<tr>
				<td align="center"><h3>Edit Contact Form</h3>
				</td>
			</tr>
			<tr valign="top" align="center">
				<td align="center"><form:form action="updateContact.do"
						method="post" modelAttribute="editContact" commandname="editContact">
						<table style="border-collapse: collapse;" width="500" border="0"
							bordercolor="#006699" cellpadding="2" cellspacing="2">
							<tbody>
								<tr>
									<td width="100" align="right">Id</td>
									<td width="150"><form:input path="id" readonly="true"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Name</td>
									<td><form:input path="name"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr>
									<td width="100" align="right">DOB</td>
									<td><form:input path="dob"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Gender</td>
									<td><form:select path="gender">
											<form:option value="M" label="Male">
												<form:option value="F" label="Female"></form:option>
											</form:option>
										</form:select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td width="100" align="right">Address</td>
									<td><form:input path="address"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Email</td>
									<td><form:input path="email"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Mobile</td>
									<td><form:input path="mobile"></form:input>
									</td>
									<td align="left">
									</td>
								</tr>
								<tr valign="bottom">
									<td colspan="3" align="center"><input value="Delete"
										onclick="javascript:deleteContact('deleteContact.do?id=${editContact.id}');"
										type="button"> <input name="" value="Save"
										type="submit"> <input value="Back"
										onclick="javascript:go('viewAllContacts.do');" type="button">

									</td>
								</tr>
							</tbody>
						</table>
					</form:form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
