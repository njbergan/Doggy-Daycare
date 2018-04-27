<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Add Owner</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/daycarestyles.css" type="text/css" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<style  type="text/css">
	.container {
		width: 80%;
		background-color: yellow;
		border-radius: 25px;
		margin-top: 20pt;
	}	
	</style>
  </head>
  
  <body>
  	<header>
	<p><img src="images/pawprint.png" alt="paw" />
	<span id="title">Doggy Daycare</span></p>
	</header>
	
	<div class="navbarN">
		<a href="doggyDaycareIndex.html">Home</a>
		<div class="dropdownM">
			<button class="dropbtnM">Check In/Out
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="">Check In</a>
				<a href="">Check Out</a>
			</div>
		</div>
		<div class="dropdownM">
			<button class="dropbtnM">Dogs 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="addDog.jsp">Add</a>
				<a href="updateDog.jsp">Update</a>
				<a href="">Mark Inactive</a>
			</div>
		</div>
		<div class="dropdownM">
			<button class="dropbtnM">Owners 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="addOwner.jsp">Add</a>
				<a href="">Update</a>
			</div>
		</div> 
		<div class="dropdownM">
			<button class="dropbtnM">Incidents 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="">Add</a>
				<a href="">Update</a>
			</div>
		</div> 
		<div class="dropdownM">
			<button class="dropbtnM">Classes 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="">Basic Manners</a>
				<a href="">Advanced Manners 2</a>
				<a href="">Agility Training</a>
				<a href="">Private Training</a>
			</div>
		</div> 
		<div class="dropdownM">
			<button class="dropbtnM">Reports 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="">Today's Playground</a>
				<a href="">Aggression</a>
				<a href="">Current Facility Count</a>
				<a href="">All Dogs</a>
				<a href="">All Owners</a>
			</div>
		</div> 
	</div>
	
	
	<div class="container">
		<form id="updateOwnerForm" action="UpdateOwnerServlet" method="post">
			<h2 align="center">Update Owner</h2>
			<br>
			<div class="form-group row">
				<div class="error-box hidden col-sm-6 col-sm-offset-3 text-center"></div>
			</div>
			<div class="form-group row">
				<label for="ownerList" class="col-sm-2 col-form-label text-right">Choose Owner</label>
				<div class="col-sm-4">
				  <select id="ownerList" class="form-control">
					<c:forEach items="${requestScope.allOwners}" var="pickOwner">
						<option></option>
        				<option value="${pickOwner.ownerId}!${pickOwner.firstName}!${pickOwner.lastName}!${pickOwner.street}!${pickOwner.city}!${pickOwner.state}!${pickOwner.zip}!${pickOwner.phone}"><c:out value="${pickOwner.firstName} ${pickOwner.lastName}"/></option>
    				</c:forEach>  
				  </select>
				</div>
				<a href="viewAllOwnersServlet">get owners</a> 
			</div>
			<div class="form-group row"> 
				<label for="firstName" class="col-sm-2 col-form-label text-right">First Name</label>
				<div class="col-sm-3">
					<input id="firstName" type="text" class="form-control" name="firstName"><c:out value="${pickOwner.firstName}"/>
				</div>
				<label for="lastName" class="col-sm-2 col-form-label text-right">Last Name</label>
				<div class="col-sm-3">
					<input id="lastName" type="text" class="form-control" name="lastName"><c:out value="${pickOwner.lastName}"/>
				</div>
			</div>
			<div class="form-group row"> 
				<label for="street" class="col-sm-2 col-form-label text-right">Street</label>
				<div class="col-sm-4">
					<input id="street" type="text" class="form-control" name="street"><c:out value="${pickOwner.street}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="city" class="col-sm-2 col-form-label text-right">City</label>
				<div class="col-sm-3">
					<input id="city" type="text" class="form-control" name="city"><c:out value="${pickOwner.city}"/>
				</div>
				<label for="state" class="col-sm-1 col-form-label text-right">2 digit State</label>
				<div class="col-sm-1">
					<input id="state" type="text" class="form-control" name="state"><c:out value="${pickOwner.state}"/>					
				</div>
				<label for="zip" class="col-sm-1 col-form-label text-right">Zip</label>
				<div class="col-sm-2">
					<input id="zip" type="text" class="form-control" name="zip"><c:out value="${pickOwner.zip}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="phone" class="col-sm-2 col-form-label text-right">Phone</label>
				<div class="col-sm-2">
					<input id="phone" type="text" class="form-control" name="phone"><c:out value="${pickOwner.phone}"/>
				</div>
			</div>
			<input type="hidden" id="ownerId" name="ownerId">
			<div class="form-group row">
	<!-- 			<button id="submit" class="col-sm-2 col-sm-offset-5" type="button">Submit</button> -->
				<input class="col-sm-2 col-sm-offset-5" type="submit" value="Submit">
			</div>
		<br>
		</form>
	</div>
  </body>
<script type="text/javascript">
$("document").ready(function(){ 
	
  	$("#ownerList").change(function(){
		  fillInFields();
	})
 
	$("#getOwners")[0].click(function(){ //fires repeatedly when id attached to anchor
		  fillInFields();
	})	  
  	
	$("#submit").click(function(){
	     e.preventDefault();
		 allEdits();
	})
	  
	  function fillInFields(){ 
	  	var fields = document.getElementById("ownerList").value.split("!");
	  	$("#ownerId").val(fields[0]);
	  	$("#firstName").val(fields[1]);
	  	$("#lastName").val(fields[2]);
	  	$("#street").val(fields[3]);
	  	$("#city").val(fields[4]);
	  	$("#state").val(fields[5]);
	  	$("#zip").val(fields[6]);
	  	$("#phone").val(fields[7]);
  }
   
	  function allEdits(){
		var err = document.getElementsByClassName("error-box")[0];
		var owner = document.getElementById("ownerId").value;
		var street = document.getElementById("street").value;
		var city = document.getElementById("city").value;
		var state = document.getElementById("state").value;
		var zip = document.getElementById("zip").value;
		
		if (onwerId == "") {		
			err.innerText = "Owner is required";
			err.classList.remove("hidden");
			ownerId.focus();
			return false;
		} else if (street == "") {		
			err.innerText = "Street is required";
			err.classList.remove("hidden");
			street.focus();
			return false;	 	
		} else if (city == "") {		
			err.innerText = "City is required";
			err.classList.remove("hidden");
			city.focus();
			return false;	 	
		} else if (state == "") {		
			err.innerText = "State is required";
			err.classList.remove("hidden");
			state.focus();
			return false;	 	
		} else if (zip == "") {		
			err.innerText = "Zip is required";
			err.classList.remove("hidden");
			zip.focus();
			return false;	 	
		} else {
			err.classList.add("hidden");
			document.getElementById("updateOwnerForm").submit();
		}  
	}
});	
  </script>
 </html>
