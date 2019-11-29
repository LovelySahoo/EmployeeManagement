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
  background-image: url("sup.jpg");
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
label {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

label {
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
  <a class="active" href="#">Supervisor Profile</a> 
  <a href="task.html">Assign Task</a> 
  <a href="attendence.html">Attendance</a> 
</div>

<form class="container">
<h1>Welcome Supervisor</h1>
    <label for="Supervisor Name"><b>Supervisor Name</b></label>
    <label>${supervisor.name}</label>
<br><br><br>
    <label for="Contact"><b>Contact</b></label>
    <label>${supervisor.contact}</label>
 <br><br><br>
   <label for="Email"><b>Email</b></label>
    <label>${supervisor.email}</label>
    <h1></h1>
  </form>

</div>

</body>
</html> 
