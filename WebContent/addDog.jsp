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
  		<form id="addDogForm" action="addDogServlet" method="post"> 
			<h2 align="center">Add Dog</h2>
			<br>
			<div class="form-group row">
				<div class="error-box hidden col-sm-6 col-sm-offset-3 text-center"></div>
			</div>
			<div class="form-group row"> 
				<label for="name" class="col-sm-3 col-form-label text-right">Name</label>
				<div class="col-sm-3">
					<input id="name" type="text" class="form-control" name="name">
				</div>
				<label for="age" class="col-sm-2 col-form-label text-right">Age</label>
				<div class="col-sm-1">
					<input id="age" type="text" class="form-control" name="age">
				</div>
			</div>
			<div class="form-group row"> 
				<label for="breed" class="col-sm-3 col-form-label text-right">Breed</label>
				<div class="col-sm-3">
					<input id="breed" type="text" class="form-control" name="breed">
				</div>
				<label for="gender" class="col-sm-2 col-form-label text-right">Gender M/F</label>
				<div class="col-sm-1">
					<input id="gender" type="text" class="form-control" name="gender">
				</div>
				
			</div>
			<div class="form-group row"> 
				<label for="ownerId" class="col-sm-3 col-form-label text-right">Owner</label>
				<div class="col-sm-4">
				  <select id="ownerId" class="form-control" name="owner">
    				<c:forEach items="${requestScope.allOwners}" var="owner">
        				<option value="${owner.ownerId}"><c:out value="${owner.firstName} ${owner.lastName}" /></option>
    				</c:forEach>  	
			      </select>
				</div>
				<a href="viewAllOwnersServlet?fromJsp=addDog.jsp">get owners</a>
			</div>
			<div class="form-group row">
				<label for="vaccinations" class="col-sm-3 col-form-label text-right">Vaccinated Y/N</label>
				<div class="col-sm-1">
					<input id="vaccinations" type="text" class="form-control" name="vaccinations">
				</div>
			</div>
			<input type="hidden" name="fromJsp" value="/addDog.jsp">
			<input type="hidden" name="playgroundId" value="1">
			<input type="hidden" name="activeFlag" value="1">
			<input type="hidden" name="registrationDate" value="25-4-2018">
			<input type="hidden" name="lastVisit" value="25-4-2018">
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

	//	var url = "viewAllOwnersServlet";
  /*  	var url = "/Doggy-Daycare/Doggy-Daycare-master/doggyDaycare/src/main/java/controller/viewAllOwnersServlet";
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
 
  $("#submit").click(function(e){
	 e.preventDefault();
	 allEdits();
	document.getElementById("addDogForm").submit();
  })
  
  function allEdits(){
	var err = document.getElementsByClassName("error-box")[0];
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var breed = document.getElementById("breed").value;
	var gender = document.getElementById("gender").value;
	var owner = document.getElementById("ownerId").value;
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
		ownerId.focus();
		return false;	 	
	}  else if (vaccinations == "") {		
		err.innerText = "Vaccinations is required";
		err.classList.remove("hidden");
		vaccinated.focus();
		return false;	 	
	}  else {
		err.classList.add("hidden");
	}  
  }
});	
  	
  </script>
 </html>
