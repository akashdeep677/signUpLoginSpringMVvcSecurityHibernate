<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "loggedHeader.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<%@ page import= "org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import ="org.springframework.security.core.userdetails.User" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="saveSubRoot"  modelAttribute="subroot" method="GET">
<form:hidden path="id"/>
    <form:input  type="text" path="subrootName"   placeholder="SubRoot Name" name="subrootName"    />
    <form:input  type="hidden" path="rootName"   placeholder="Root Name" name="rootName" value= "${rootName}"   />
    <form:input  type="hidden" path="rootid"   placeholder="Root Name" name="rootid" value= "${rootid}"   />
    <form:input  type="hidden" path="userName"   placeholder="User Name" name="userName"  value= "${userName}"   />
	  <input type="submit" value="Add">
<br><br>
</form:form>

</body>
</html>