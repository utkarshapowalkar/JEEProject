<%@page import="models.EmpInfoModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
     EmpInfoModel empobj = (EmpInfoModel)session.getAttribute("empinfo");
     if (empobj == null)
     {
    	 response.sendRedirect("emplogin.jsp");
     }	
     else
     {
   %>
   
   <div align="center">
      <h3>EMP VIEW PROFILE</h3>
      <h3 style="color: blue;"> WELCOME <%= empobj.getName() %></h3>
  <br/>
    <nav>
         <a href="empafterlogin.jsp">EMP DASHBOARD </a> |
         <a href="empviewprofile.jsp">VIEW OWN PROFILE </a> |
         <a href="empupdateprofile.jsp">UPDATE PROFILE </a> |
         <a href="logoutemp.jsp">LOGOUT </a>
      </nav>
   <br/>
   <table border="1">
           <caption>DETAILS</caption>
           <tr>
             <th>NAME</th>
             <th>EMAIL</th>
             <th>SALARY</th>
             <th>CITY</th>
           </tr>
           
           <tr>
    	   <td><% out.print(empobj.getName()); %></td>
    	   <td><% out.print(empobj.getEmail()); %></td>
           <td><% out.print(""+empobj.getSalary()); %></td>
    	   <td><% out.print(empobj.getCity()); %></td>
    	 </tr>
           
    </table>
   
  </div>
  <%
     }
  %>
</body>
</html>