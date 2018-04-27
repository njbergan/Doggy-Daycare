<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Add Dog</title>  
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
				<a href="">Update</a>
				<a href="">Mark Inactive</a>
			</div>
		</div>
		<div class="dropdownM">
			<button class="dropbtnM">Owners 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="addOwner.jsp">Add</a>
				<a href="updateOwner.jsp">Update</a>
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
		<form id="updateDogForm" action="updateDogServlet" method="post">
			<h2 align="center">Update Dog</h2>
			<br>
			<div class="form-group row">
				<div class="error-box hidden col-sm-6 col-sm-offset-3 text-center"></div>
			</div>
			<div class="form-group row"> 
				<label for="dogList" class="col-sm-3 col-form-label text-right">Choose Dog</label>
				<div class="col-sm-3">
				 <select id="dogList" class="form-control">
					<c:forEach items="${requestScope.allDogs}" var="pickDog">
        				<option value="${pickDog.dogId}!${pickDog.ownerId}!${pickDog.name}!${pickDog.breed}!${pickDog.age}!${pickDog.gender}!${pickDog.vaccinations}"><c:out value="${pickDog.name}"/></option>
    				</c:forEach>
				  </select>
				</div>
				<div class="col-sm-1">
					<a href="viewAllDogsServlet">get dogs</a>
				</div>
				<label for="age" class="col-sm-1 col-form-label text-right">Age</label>
				<div class="col-sm-1">
					<input id="age" type="text" class="form-control" name="age"><c:out value="${pickDog.age}"/>
				</div>
			</div>
			<div class="form-group row"> 
				<label for="breed" class="col-sm-3 col-form-label text-right">Breed</label>
				<div class="col-sm-3">
					<input id="breed" type="text" class="form-control" name="breed"><c:out value="${pickDog.breed}"/>
				</div>
				<label for="gender" class="col-sm-2 col-form-label text-right">Gender M/F</label>
				<div class="col-sm-1">
					<input id="gender" type="text" class="form-control" name="gender"><c:out value="${pickDog.gender}"/>
				</div>
			</div>
			<div class="form-group row"> 
				<label for="ownerId" class="col-sm-3 col-form-label text-right">Owner</label>
				<div class="col-sm-4">
				  <select id="ownerId" class="form-control" name="ownerId">
					<c:forEach items="${requestScope.allOwners}" var="pickOwner" >
        				<option value="${pickOwner.ownerId}"><c:out value="${pickOwner.firstName}, ${pickOwner.lastName}"/></option>
    				</c:forEach>
				  </select>
				</div>
				<a href="viewAllOwnersServlet">get owners</a>
			</div>
			<div class="form-group row">
				<label for="vaccinations" class="col-sm-3 col-form-label text-right">Vaccinated Y/N</label>
				<div class="col-sm-1">
					<input id="vaccinations" type="text" class="form-control" name="vaccinations"><c:out value="${pickDog.vaccinations}"/>
				</div> 
			</div>
			<div class="form-group row">
		<!-- 	<button id="submit" class="col-sm-2 col-sm-offset-5" type="button">Submit</button> -->
				<input class="col-sm-2 col-sm-offset-5" type="submit" value="Submit"> 
			</div>
			<br>
			<input type="hidden" id="dogId" name="dogId">
			<input type="hidden" id="name" name="name">
		</form>
	</div>
  </body>
  <script type="text/javascript">
$("document").ready(function(){ 
  
  $("#dogList").change(function(){
	  fillInFields();
  })
  
  $("#submit").click(function(){
	 e.preventDefault();
	 allEdits();
  })
  
  function fillInFields(){ 
	  var fields = document.getElementById("dogList").value.split("!");
	  $("#dogId").val(fields[0]);
	  $("#ownerId").val(fields[1]);
	  $("#name").val(fields[2]);
	  $("#breed").val(fields[3]);
	  $("#age").val(fields[4]);
	  $("#gender").val(fields[5]);
	  $("#vaccinations").val(fields[5]);
  }
  
  function allEdits(){
	var err = document.getElementsByClassName("error-box")[0];
	var dog = document.getElementById("dogId").value;
	var age = document.getElementById("age").value;
	var breed = document.getElementById("breed").value;
	var gender = document.getElementById("gender").value;
	var owner = document.getElementById("owner").value;
	var vaccinations = document.getElementById("vaccinations").value;
	
	if (dog == "") {		
		err.innerText = "Dog is required";
		err.classList.remove("hidden");
		dogList.focus();
		return false;	 	
	} else if (age == "") {		
		err.innerText = "Age is required";
		err.classList.remove("hidden");
		age.focus();
		return false;	 	
	} else if (breed == "") {		
		err.innerText = "Breed is required";
		err.classList.remove("hidden");
		breed.focus();
		return false;	 	
	} else if (gender == "") {		
		err.innerText = "Gender is required";
		err.classList.remove("hidden");
		gender.focus();
		return false;	 	
	} else if (ownerId == "") {		
		err.innerText = "Owner is required";
		err.classList.remove("hidden");
		ownerId.focus();
		return false;	 	
	}  else if (vaccinations == "") {		
		err.innerText = "Vaccinations is required";
		err.classList.remove("hidden");
		vaccinated.focus();
		return false;	 	
	}  else {
		err.classList.add("hidden");
		document.getElementById("updateDogForm").submit();
	}  
}
});	 	
  </script>
 </html>
