<%@page import="models.EmpInfoModel"%>
<%@page import="java.util.ArrayList"%>
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
    
     String utype = (String)session.getAttribute("usertype");
     if (utype == null)
     {
    	 response.sendRedirect("adminlogin.jsp");
     }	
     else
     {
    	  
   %>
    <br/>
  <div align="center">
     <nav>
         <a href="adminafterlogin.jsp">ADMIN DASHBOARD </a> |
         <a href="searchemp.jsp">SEARCH EMP </a> |
         <a href="ViewAllEmp">VIEW ALL EMP </a> |
         <a href=#>DEL EMP </a> |
         <a href="adminlogout.jsp">LOGOUT </a>
      </nav>
     <br/>
     <%
       ArrayList<EmpInfoModel> emplist =(ArrayList<EmpInfoModel>) request.getAttribute("emplist");
    	
       if (emplist != null)
       {
      %> 
         <table border="1">
           <caption>ALL EMP DETAILS</caption>
           <tr>
             <th>EMP ID</th>
             <th>NAME</th>
             <th>EMAIL</th>
             <th>SALARY</th>
             <th>CITY</th>
           </tr>
        
     <%
       for(EmpInfoModel empobj:emplist)
       {
     %>
    	 <tr>
    	   <td><% out.print(""+empobj.getEmpid()); %></td>
    	   <td><% out.print(empobj.getName()); %></td>
    	   <td><% out.print(empobj.getEmail()); %></td>
           <td><% out.print(""+empobj.getSalary()); %></td>
    	   <td><% out.print(empobj.getCity()); %></td>
    	   <td> <form action="DelEmpServlet" method="post">
    	            <input type="hidden" name="emailid" value="<%=empobj.getEmail()%>">
    	            <input type="submit" value="Delete">
    	        </form> </td>
    	 </tr>
      <% 
       } //END FOR LOOP
       %>
          </table>
     
     <%
     } //END IF TRUE PART
     else
     {
    %>
     <h3> NO RECORD FOUND </h3>
     <%
     }
       
    }
     %>
     
     
     
  </div>
</body>
</html>