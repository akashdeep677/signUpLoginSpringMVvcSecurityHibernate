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




<h1 style="color:green">SubRoot page!</h1>
<h1 style="color:green">Add/delete sub-root</h1>
<br>

<form:form action="saveSubRoot"  modelAttribute="subroot" method="GET">
<form:hidden path="id" />
    <form:input  type="text" path="subrootName"   placeholder="SubRoot Name" name="subrootName"    />
    <form:input  type="hidden" path="rootid"   placeholder="Root Name" name="rootid" value= "${rootid}"   />
	  <input type="submit" value="Add" style="background-color: green;color:white">
</form:form>
<br>


<!--  add our html table here -->
		
			<table >
				<tr>
					<th>SubRoot Name</th>
					<th>Action</th>
					
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempSubRoot" items="${subroots}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/logged/updateSubRoot">
						<c:param name="id" value="${tempSubRoot.id}" />
						<c:param name="subrootName" value="${tempSubRoot.subrootName}" />
						<c:param name="rootid" value="${tempSubRoot.rootid}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/logged/deleteSubroot">
						<c:param name="id" value="${tempSubRoot.id}" />
						<c:param name="rootid" value="${tempSubRoot.rootid}" />
					</c:url>					
					
					<tr>
						
						<td> ${tempSubRoot.subrootName} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
						<%-- <td>
								<form:form action="subRoot"  modelAttribute="subroot" method="GET">
								<form:hidden path="id"/>
								    <form:input  type="hidden" path="rootName"   placeholder="Root Name" name="rootName"
								     value="${tempRoot.rootName}"  />
								     <form:input  type="hidden" path="id"   placeholder="Root Name" name="rootName"
								     value="${tempRoot.id}"  />
								    <form:input  type="hidden" path="userName"   placeholder="First Name" name="userName" 
								    value= "${tempRoot.userName}"   />
									  <input type="submit" value="SubRoot">
								<br><br>
								</form:form>
								
						</td> --%>
					</tr>
				
				</c:forEach>
						
			</table>
				











</body>
</html>
   