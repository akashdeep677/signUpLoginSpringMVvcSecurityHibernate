<%@ include file = "landingHeaderPage.jsp" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="color: red ;text-align: center; ">
<div><h3>User already exist with this email id :<%= request.getParameter("email") %>  </h3>
</div>

<div>
		<h3>Please sign up with different email id</h3>
</div>
</div>
</body>
</html>
<%@ include file = "signUpForm.jsp" %>
