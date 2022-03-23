package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import models.EmpInfoModel;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//STEP 1  Receive Data from Client
		/*String name = request.getParameter("fullname");
		String email = request.getParameter("emailid");
		String password = request.getParameter("pass");
		
		String sal = request.getParameter("salary");
		double salary = Double.parseDouble(sal);
		   
		String city = request.getParameter("city");
		
		//STEP 2 CREATE MODEL CLASS OBJ AND STORE USER INPUT DATA
		EmpInfoModel empobj = new EmpInfoModel();
		empobj.setName(name);
		empobj.setEmail(email);
		empobj.setPassword(password);
		empobj.setSalary(salary);
		empobj.setCity(city);*/
		
		EmpInfoModel empobj = new EmpInfoModel();
		empobj.setName(request.getParameter("fullname"));
		empobj.setEmail(request.getParameter("emailid"));
		empobj.setPassword(request.getParameter("pass"));
		empobj.setSalary(Double.parseDouble(request.getParameter("salary")));
		empobj.setCity(request.getParameter("city"));
				
		//STEP 3 CREATE DAO CLASS OBJECT
		EmpDAO empdaoobj = new EmpDAO();
		
		//STEP 4 CALL DAO METHOD
		//boolean status = empdaoobj.addRecord(empobj);
		int empid = empdaoobj.addRecord(empobj);
		
		//STEP 5 FOR GENERATE VIEW(JSP/HTML)
		
		//if(status)
		if(empid > 0)
		{
			request.setAttribute("msg", "THANKS FOR REGISTRATION");
			request.setAttribute("msg1", "YOUR EMP ID IS "+empid);
		}
		else if (empid == -1)
		{
			request.setAttribute("msg", "TRY AGAIN"); 
		}
		else if (empid == -5)
		{
			request.setAttribute("msg", "ALREADY REGISTER WITH THIS EMAIL, TRY WITH ANOTHER EMAIL"); 
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("reg.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
