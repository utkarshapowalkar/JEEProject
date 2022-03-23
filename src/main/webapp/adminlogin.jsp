<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN</title>
</head>
<body>
<br/>
  <div align="center">
     <nav>
         <a href="index.jsp">HOME </a> |
         <a href="reg.jsp">REG </a> |
         <a href="emplogin.jsp">LOGIN </a> |
         <a href=#>CONTACT US </a> |
         <a href="adminlogin.jsp">ADMIN </a> 
     </nav>
     <br/><br/>
        <h3> ADMIN LOGIN </h3>
        <%
      if (request.getAttribute("errormsg") != null)
      {
    	%>
    <b style="color: red;"> <%= request.getAttribute("errormsg") %></b>
      <%
      }
      %>
        
        
     <form action="AdminLogin" method="post">
       <input type="text" name="adminid" placeholder="ENTER UID" required="required">
       <br/><br/>
       <input type="password" name="adminpass" placeholder="ENTER PASS" required="required">
       <br/><br/>
       <input type="submit" value="ADMIN LOGIN">
     </form>
  </div>

</body>
</html>