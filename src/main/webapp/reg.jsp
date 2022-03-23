<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
     <br/>
   
   <h3 >Registration</h3>
   
   <div style="color: red;font-size: large; font-weight: bold;">
   <%
      if (request.getAttribute("msg") != null)
      {
    	  out.print(request.getAttribute("msg"));
      }
    %>
      <br/>
    <%
    if (request.getAttribute("msg1") != null)
     {
    	  out.print(request.getAttribute("msg1"));
     }
   %>
   </div>
   <br/>
   <form action="RegServlet" method="post">
     <table>
       <tr>
         <td><label >Name</label></td>
         <td><input type="text" name="fullname" placeholder="Enter Name" required ></td>
       </tr>
 
       <tr>
         <td><label >Email</label></td>
         <td><input type="email" name="emailid" placeholder="Enter Email" required ></td>
       </tr>            

       <tr>
         <td><label >Password</label></td>
         <td><input type="password" name="pass" placeholder="Enter Password" required></td>
       </tr>
            
       <tr>
         <td><label >Salary</label></td>
         <td><input type="text" name="salary" placeholder="Enter Salary" required ></td>
       </tr>
            
       <tr>
          <td><label >City</label></td>
          <td>
            <select name="city">
               <option>PUNE</option>
               <option>HYD</option>
               <option>Kol</option>
               <option>Mumbai</option>
            </select>
          </td>
        </tr>
        <tr>
           <td>&nbsp;</td>
           <td> <input type="submit" value="REGISTRATION"> </td>
        </tr>
       </table>
     </form>
     </div>  
</body>
</html>