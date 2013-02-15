<%@include file="taglib_includes.jsp"%>

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
				<td align="center">
				<form:form action="saveContact.do" method="post" commandname="newContact">
						<table style="border-collapse: collapse;" width="500" border="0"
							bordercolor="#006699" cellpadding="2" cellspacing="2">
							<tbody>
								<tr>
									<td width="100" align="right">Name</td>
									<td width="150">
									<input name="name" type="text">
									
									</td>
									<td align="left"><form:errors path="name"
											cssstyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">DOB</td>
									<td>
									<input name="dob" type="text">
									
									</td>
									<td align="left"><form:errors path="dob"
											cssstyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Gender</td>
									<td>
											<select name="gender">
											  <option value="M">Male</option>
											  <option value="F">Female</option>
											</select> 
									</td>
									<td></td>
								</tr>
								<tr>
									<td width="100" align="right">Address</td>
									<td>
									<input name="address" type="text">
									
									</td>
									<td align="left"><form:errors path="address"
											cssstyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Email</td>
									<td>
									<input name="email" type="text">
									</td>
									<td align="left"><form:errors path="email"
											cssstyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td width="100" align="right">Mobile</td>
									<td>
									<input name="mobile" type="text">
									
									</td>
									<td align="left"><form:errors path="mobile"
											cssstyle="color:red"></form:errors>
									</td>
								</tr>
								<tr>
									<td colspan="3" align="center"><input name="" value="Save"
										type="submit"> <input name="" value="Reset"
										type="reset"> <input value="Back"
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
