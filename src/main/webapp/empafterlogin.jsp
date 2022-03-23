<%@page import="models.EmpInfoModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Emp After Login</title>
</head>
<body>
 <%
    /* EmpInfoModel empobj = null;
     if (request.getAttribute("empinfo") != null)
    	  empobj = (EmpInfoModel)request.getAttribute("empinfo");*/
   
     EmpInfoModel empobj = (EmpInfoModel)session.getAttribute("empinfo");
     if (empobj == null)
     {
    	 response.sendRedirect("emplogin.jsp");
     }	
     else
     {
    	  
   %>
<div align="center">
      <h3>EMP AFTER LOGIN PAGE</h3> 
      
      <h3 style="color: blue;"> WELCOME <%= empobj.getName() %></h3>
  <br/><br/>
  <nav>
         <a href="empafterlogin.jsp">EMP DASHBOARD </a> |
         <a href="empviewprofile.jsp">VIEW OWN PROFILE </a> |
         <a href="empupdateprofile.jsp">UPDATE PROFILE </a> |
         <a href="logoutemp.jsp">LOGOUT </a>
      </nav>
  
      <h3>THIS IS EMP AFTER LOGIN PAGE</h3>
   
  </div>
   <%
     }
   %>
</body>
</html>