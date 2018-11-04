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
<html lang="en">
<head>
  <title>LoggedHomePage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">

table {   
	border-collapse:collapse;
	border-bottom:1px solid gray;
	font-family: Tahoma,Verdana,Segoe,sans-serif;
	width:100%;
}
 
th {
	border-bottom:1px solid gray;
	background:none repeat scroll 0 0 #09c332;
	padding:10px;
	color: #FFFFFF;
}

tr {

	border-top:1px solid gray;
	text-align:left;	
}
td{
	padding:10px;

}
 
tr:nth-child(even) {background: #FFFFFF}
tr:nth-child(odd) {background: #BBBBBB}	
</style>


</head>
<body>

<% 
	User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String uname = user.getUsername();
    System.out.println(uname);

%>



<h1 style="color:green">Update Root page!</h1>
<h1 style="color:green">Rename your root</h1>
<br>
<form:form action="saveRoot"  modelAttribute="root" method="GET">
    <form:input  type="text" path="rootName"   placeholder="${rootName}" name="rootName"  />
    <form:input  type="hidden" path="id"   placeholder="Root Name" name="id" value="${id }" />
    <form:input  type="hidden" path="userName"   placeholder="First Name" name="userName" 
    value= "${userName }"   />
	  <input type="submit" value="saveUpdate" style="background-color: green;color:white">

</form:form>


</body>
</html>
   