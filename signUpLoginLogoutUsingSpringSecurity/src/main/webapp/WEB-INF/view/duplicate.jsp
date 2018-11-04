<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>LoggedHomePage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/logged/a" style="color: red">Amtica
      </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/logged/a">
      <sec:authentication property="name"/> 
      </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Messages <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/logged/profile">Orders</a></li>
      <li><a href="${pageContext.request.contextPath}/logged/root">Root</a></li>
    </ul>
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/logged/profile"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
      <li><a href="Logout">
      <span class="glyphicon glyphicon-log-in"></span> 
      <label  for="submit-form"  style="color:red">Logout</label>
      </a></li>
        </ul>
   </div>
</nav>
  
<!-- <div class="container">
  <h3>Right Aligned Navbar</h3>
  <p>The .navbar-right class is used to right-align navigation bar buttons.</p>
</div> -->


<form:form action="${pageContext.request.contextPath}/logout"
			method="Post">
			<!--  <input type="submit" value="Logout" /> -->
		
<input type="submit" id="submit-form" style="display: none;"  />
		

</form:form>
<br>
<h3 style="color:red">Duplicate not allowed!!!!!!</h3>

<h3 style="color:red">Please go back and try with different value.</h3>
</body>
</html>
   