<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Patient Page</title>
</head>
<body>

	<form action="home" method="GET">

		<table border="1">
			<tr>
				<td>Id</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Mobile No</td>
				<td>Gender</td>
				<td>Action</td>
			</tr>


			<c:forEach items="${allPatient}" var="patient">
				<tr>
					<td>${patient.id} </td>
					<td>${patient.firstName} </td>
					<td>${patient.lastName} </td>
					<td>${patient.email} </td>
					<td>${patient.mobileNo} </td>
					<td>${patient.gender} </td>
					<td><a href="getEdit?id=${patient.id}" >Edit</a> </td> 
					<td><a href="getDelete?id=${patient.id}" >Delete</a> </td> 
				</tr>
			</c:forEach>
      
			<tr>
				<td><input type="submit"></td>
				<td><a href="./home">Home</a></td>
			</tr>

		
		
		</table>

	</form>


</body>
</html>