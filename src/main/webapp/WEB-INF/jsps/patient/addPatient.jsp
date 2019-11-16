<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Patient Page</title>
<!-- <style type="text/css">
.red {
	color: red
}
</style> -->
<link href="static/css/my-style.css" rel="stylesheet">
</head>
<body>

	<form:form action="getSave" method="POST" modelAttribute="editPatient">


		<table border="1">
			<tr>
				<form:errors class="red" path="*"></form:errors>
			</tr>
			<tr>
				<td>Id:</td>
				<td><form:input type="text" path="id" disabled="true" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input type="text" path="firstName" /> <form:errors
						class="red" path="firstName"></form:errors></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input type="text" path="lastName" /> <form:errors
						path="lastName"></form:errors></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input type="text" path="email" /> <form:errors
						path="email"></form:errors></td>
			</tr>
			<tr>
				<td>Mobile No:</td>
				<td><form:input type="text" path="mobileNo" /> <form:errors
						path="mobileNo"></form:errors></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>Male<form:radiobutton path="gender" value="Male" /> Female<form:radiobutton
						path="gender" value="Female" />
				</td>
			</tr>

			<tr>
				<td><input type="submit"></td>
			</tr>

		</table>

	</form:form>


</body>
</html>