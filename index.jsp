<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="style.css"/>
  <style> 
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;
  margin-left: auto;
  margin-right: auto;
    
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
  
}


/* Set a style for all buttons */
button {
  background-color:yellow;
  color:black;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 20px;
  
  
  
}
.button{background-color: cyan;
}


/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
   <title>Insert title here</title>
   <script src="https://apis.google.com/js/platform.js" async defer></script>
   <meta name="google-signin-client_id" content="377510639695-fjb43e3am6sltqvrgn7bijj06fpp7md9.apps.googleusercontent.com">
</head>
<body>
<h1 style="font-size:30px">GROCERS </h1>
        
        <nav class="navigation-bar">
            <img class="logo" src="fruits-and-vegetable.png">
            <a href="lab2.html" >SHOP BY CATEGORY</a>
            
            <li style="float:right"><a class="fi" href="about.html">ABOUT</a></li>
            <li style="float:right"><a class="fi" href="index.jsp" >LOGIN</a></li>
            <li style="float:right"><a class="fi" href="log2.html" >REGISTER</a></li>
            <li style="float:right"><a class="fi" href="home.html" >HOME</a></li>
                
        </nav>
        <form action="Login" rstyle="border:1px solid #ccc" method="get" >
  <div class="container">
    <h1>   LOGIN</h1>
    
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

   
   

    <div class="clearfix">
      
      <button  type="submit" class="signupbtn">LOGIN</button>
    </div>
  </div>
</form>
        
   <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
   
      <img id="myImg"><br>
      <p id="name"></p>
      <div id="status">
   </div>
   <script type="text/javascript">
   
      function onSignIn(googleUser) {
    	  <%! int k=1;%>
       window.location.href='success.jsp';
      var profile = googleUser.getBasicProfile();
      var imagurl=profile.getImageUrl();
      var name=profile.getName();
      var email=profile.getEmail();
      document.getElementById("myImg").src = imagurl;
      document.getElementById("name").innerHTML = name;
      document.getElementById("myP").style.visibility = "hidden";
      document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=success.jsp?                  
      email='+email+'&name='+name+'/>Continue with Google login</a></p>'
   }
   </script>
  
		
   <button class="button" onclick="myFunction()">Sign Out</button>
   <script>
   
      function myFunction() {
      gapi.auth2.getAuthInstance().disconnect();
      location.reload();
   }
   </script>
   <% try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","");  
			//here sonoo is database name, root is username and password  
		PreparedStatement pstmt=con.prepareStatement("insert into glogin(gl) values(?)");
			
			pstmt.setInt(1,k);
			
			pstmt.executeUpdate();
			
			
			
			  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			 %>
			
</body>
</html>