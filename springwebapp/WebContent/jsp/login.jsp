<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<font color="blue">Please Enter User Name and Password </font><br><br>
<head>
<title>Login Page</title>

<link rel="stylesheet" href="../css/style.css" type="text/css"></link>

</head>
<body onload='document.f.j_username.focus();'>
	

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
	
	
		<table border = "0">
	<tr align="left" valign="top">
		<td>User Name:</td>
		<td><input type="text" name ="j_username" class="inputbox"/></td>
	</tr>
	<tr align="left" valign="top">
		<td>Password:</td>
		<td><input type="password" name ="j_password" class="inputbox"/></td>
	</tr>
	<tr align="left" valign="top">
		<td></td>
		<td><input type="submit" name="submit" value="submit" class="submitButton"/></td>
	</tr>
</table>
	

	</form>
</body>
</html>