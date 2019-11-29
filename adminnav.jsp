<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
  background-color:#33BBFF ;
}

* {
  box-sizing: border-box;
}

.bg-img {
  background-image: url("emp.jpg");
  min-height: 600px;
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
  max-width: 700px;
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
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
  <a class="active" href="#">Admin Profile</a> 
  <a href="Addemp.html">Add Employee</a> 
  <a href="addsup.html">Add Supervisor</a> 
  <a href="addrev.html">Add Reviewor</a>
</div>
<div>
<form class="container" method=post>
<h1>Welcome Admin</h1>
    <label for="AdminName"><b>Admin Name</b></label>
    <input type="text" name="name" value="$admin.name">

    <label for="Contact"><b>Contact</b></label>
    <input type="text" name="contact" value="$admin.contact">
 
   <label for="Email"><b>Email</b></label>
    <input type="text" name="email" value="$admin.email">
    <h1></h1>
  </form>
</div>
</div>
</body>
</html> 



