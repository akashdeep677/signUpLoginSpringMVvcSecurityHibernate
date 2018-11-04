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



<h1 style="color:green">Root page!</h1>
<h1 style="color:green">Add/delete root and view sub-root</h1>
<br>
<form:form action="saveRoot"  modelAttribute="root" method="GET">
<form:hidden path="id"/>
    <form:input  type="text" path="rootName"   placeholder="Root Name" name="rootName"  />
    <form:input  type="hidden" path="userName"   placeholder="First Name" name="userName" 
    value= "<%=uname %>"   />
	  <input type="submit" value="Add" style="background-color: green;color:white">

</form:form>
<br>


<!--  add our html table here -->
		
			<table >
				<tr>
					<th>Root Name</th>
					<th>Action</th>
					<th>View</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempRoot" items="${roots}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/logged/updateRoot">
						<c:param name="id" value="${tempRoot.id}" />
						<c:param name="userName" value="${tempRoot.userName}" />
						<c:param name="rootName" value="${tempRoot.rootName}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/logged/deleteRoot">
						<c:param name="id" value="${tempRoot.id}" />
					</c:url>					
					
					<tr>
						
						<td> ${tempRoot.rootName} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						<td>
								<form:form action="subRoot"  modelAttribute="subroot"  method="GET">
								     <form:input  type="hidden" path="rootid"  placeholder="Root Name" name="rootid"
								     value="${tempRoot.id}"  />
								    
									  <input type="submit" value="SubRoot">
								<br><br>
								</form:form>
								
						</td>
					</tr>
				
				</c:forEach>
						
			</table>
				











</body>
</html>
   