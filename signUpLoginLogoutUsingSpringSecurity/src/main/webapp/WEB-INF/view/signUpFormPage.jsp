<%@ include file = "landingHeaderPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
    display: -ms-flexbox; /* IE10 */
    display: flex;
    width: 100%;
    margin-bottom: 15px;
}

.icon {
    padding: 10px;
    background: dodgerblue;
    color: white;
    min-width: 50px;
    text-align: center;
}

.input-field {
    width: 100%;
    padding: 10px;
    outline: none;
}

.input-field:focus {
    border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
    background-color: dodgerblue;
    color: white;
    padding: 15px 20px;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}

.btn:hover {
    opacity: 1;
    background-color: green ;
    color:white;
}
</style>
</head>
<body>

<form:form  style="max-width:500px;margin:auto" action="saveUser"  modelAttribute="customer" method="GET">
  <h1>Create an account</h1>
  
  
    <p style="color: red;font-size:25px ">*all field are required.</p>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <form:input class="input-field" path="firstName"  type="text" placeholder="First Name" name="firstName" />
    <form:errors path="firstName" cssClass="error" />
  </div>
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <form:input class="input-field" path="lastName" type="text" placeholder="Last Name" name="usrnm" />
    <form:errors path="lastName" cssClass="error" />
  </div>
  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <form:input class="input-field" path="email" type="email" placeholder="Email" name="email" />
    <form:errors path="email" cssClass="error" />
  </div>
  <div class="input-container">
    <i class="fa fa-mobile icon"></i>
    <form:input class="input-field" path="phone" type="text" placeholder="Phone " name="phone" />
        <form:errors path="phone" cssClass="error" />
  </div>
  <div class="input-container">
    <i class="fa fa-map-marker icon"></i>
    <form:input class="input-field" path="city" type="text" placeholder="City " name="city" />
        <form:errors path="city" cssClass="error" />
  </div>
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <form:input class="input-field" path="password" type="password" placeholder="Password (min-5 max-15 )" name="password" id="psw1" />
          <form:errors path="password" cssClass="error" />
  </div>
	<div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="Confirm Password" name="psw" id="psw2" />
  </div>
  <p id="passwordChecker"></p><br>
  <button type="submit" class="btn" id="submit" disabled >Sign Up</button>
</form:form>

<script>
var myVar = setInterval(myTimer, 100);
function myTimer() { 
var x = document.getElementById("psw1").value;
var y = document.getElementById("psw2").value;
if(x==y && x!=""){
	 document.getElementById("passwordChecker").innerHTML = "password  matched";
     document.getElementById("passwordChecker").style.color = "green";
     document.getElementById("submit").disabled = false;

}
else{
	 document.getElementById("passwordChecker").innerHTML = "password not matched";
     document.getElementById("passwordChecker").style.color = "red";

}

}
</script>
</body>
</html>
    