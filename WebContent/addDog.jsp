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
				<a href="">Add</a>
				<a href="updateDog.html">Update</a>
				<a href="">Mark Inactive</a>
			</div>
		</div>
		<div class="dropdownM">
			<button class="dropbtnM">Owners 
			<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdownM-content">
				<a href="addOwner.html">Add</a>
				<a href="UpdateOwner.html">Update</a>
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
  		<form id="addDogForm" action="addDogServlet" method="post"> 
			<h2 align="center">Add Dog</h2>
			</br>
			<div class="form-group row">
				<div class="error-box hidden col-sm-6 col-sm-offset-3 text-center"></div>
			</div>
			<div class="form-group row"> 
				<label for="name" class="col-sm-3 col-form-label text-right">Name</label>
				<div class="col-sm-3">
					<input id="name" type="text" class="form-control" placeholder="Enter Dog's Name">
				</div>
				<label for="age" class="col-sm-1 col-form-label text-right">Age</label>
				<div class="col-sm-1">
					<input id="age" type="text" class="form-control" >
				</div>
			</div>
			<div class="form-group row"> 
				<label for="breed" class="col-sm-3 col-form-label text-right">Breed</label>
				<div class="col-sm-3">
					<input id="breed" type="text" class="form-control" placeholder="Enter Dog's Breed">
				</div>
				<label for="gender" class="col-sm-1 col-form-label text-right">Gender</label>
				<div class="col-sm-2">
					<select id="gender" class="form-control">
						<option value="M" selected>Male</option>
						<option value="F">Female</option>
					</select>
				</div>
				
			</div>
			<div class="form-group row"> 
				<label for="owner" class="col-sm-3 col-form-label text-right">Owner</label>
				<div class="col-sm-4">
				  <select id="owner" class="form-control" name="owner">
  <!--       				<option>me</option> -->
    			<c:forEach items="${requestScope.allOwners}" var="owner">
        				<option value="${owner.ownerId}"><c:out value="${owner.firstName}" /></option>
    			</c:forEach>  	
			      </select>
				</div>
				<a href="viewAllOwnersServlet">get owners</a>
			</div>
			<div class="form-group row">
				<label for="vaccinations" class="col-sm-3 col-form-label text-right">Vaccinated</label>
				<div class="col-sm-2">
					<select id="vaccinations" class="form-control">
						<option value="Y" selected>Yes</option>
						<option value="N">No</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<button id="submit" class="col-sm-2 col-sm-offset-5" type="button">Submit</button>
			</div>
			</br>
		</form>
		</div>
  </body>
  <script type="text/javascript">
$("document").ready(function(){

	//	var url = "viewAllOwnersServlet";
  /*  	var url = "/Doggy-Daycare/Doggy-Daycare-master/doggyDaycare/src/main/java/controller/viewAllOwnersServlet.java";
		$.ajax({
    		type: "GET",
    		url: url,
    		success: function(data){
    			console.log(data);
    			$('#owner').empty();
    			$.each(data, function(i, obj){
					var options = "<option value=" + obj.ownerId + ">" + obj.firstName + ", " + obj.lastName + "</option";
    				alert(options);
					$(options).appendTo("#owner");
    			});
    		}
    	});
*/
  
  $("#submit").click(function(){
	 e.preventDefault();
	 allEdits();
  })
  
  function allEdits(){
	var err = document.getElementsByClassName("error-box")[0];
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var breed = document.getElementById("breed").value;
	var gender = document.getElementById("gender").value;
	var owner = document.getElementById("owner").value;
	var vaccinations = document.getElementById("vaccinations").value;
	
	if (name == "") {		
		err.innerText = "Name is required";
		err.classList.remove("hidden");
		name.focus();
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
	} else if (owner == "") {		
		err.innerText = "Owner is required";
		err.classList.remove("hidden");
		owner.focus();
		return false;	 	
	}  else if (vaccinations == "") {		
		err.innerText = "Vaccinations is required";
		err.classList.remove("hidden");
		vaccinated.focus();
		return false;	 	
	}  else {
		err.classList.add("hidden");
		document.getElementById("addDogForm").submit();
	}  
  }
});	
  	
  </script>
 </html>