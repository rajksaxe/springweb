<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page session="false"%>
<html>
<head>
<title>Student Saved Successfully</title>
</head>
<body>
	<h3>Student Saved Successfully.</h3>

	<strong>Student Name:${student.name}</strong>
	<br>
	<strong>Student Email:${student.email}</strong>
	<br>
	<strong>Student Age:${student.age}</strong>
	<br>
	<strong>Student Gender:${student.gender}</strong>
	<br>
	<strong>Student Birthday:<fmt:formatDate value="${student.birthday}" type="date" /></strong>
	<br>

</body>
</html>