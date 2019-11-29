<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
  background-color:white;
}

* {
  box-sizing: border-box;
}

.bg-img {
  background-image: url("emp1.jpg");
  min-height: 700px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

/* Add styles to the form container */
.container {
  position: absolute;
  right: 0;
  margin: 20px;
  max-width: 500px;
  padding:14px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 8px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit button */
.btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
* {box-sizing: border-box}
body {font-family: Arial, Helvetica, sans-serif;}

.navbar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.navbar a {
  float: left;
  padding: 12px;
  color: white;
  text-decoration: none;
  font-size: 19px;
  width: 25%; /* Four links of equal widths */
  text-align: center;
}

.navbar a:hover {
  background-color: #000;
}

.navbar a.active {
  background-color: #4CAF50;
}

@media screen and (max-width: 500px) {
  .navbar a {
    float: none;
    display: block;
    width: 100%;
    text-align: left;
  }
}
</style>
<body>
<div class="bg-img">
<div class="navbar">
  <a class="active" href="#">Employee Profile</a> 
  <a href="Project.html">Project Information</a> 
</div>
<form class="container">
<h1>Welcome Employee</h1>
    <label for="EmployeeName"><b>Employee Name</b></label>
    <label>${employee.empname}</label>
<br><br><br>
    <label for="EmployeeId"><b>Employee Id</b></label>
    <label>${employee.empid}</label>
 <br><br><br>
   <label for="Email"><b>Email</b></label>
    <label>${employee.email}</label>
 <br><br><br>   
   <label for="Contact"><b>Contact</b></label>
    <label>${employee.contact}</label>
<br><br><br>
    <label for="Address"><b>Address</b></label>
    <label>${employee.address}</label>

   
  </form>
</div>
</div>

</body>
</html> 
