package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;

@WebServlet("/DelEmpServlet")
public class DelEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelEmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("emailid");
		
		EmpDAO empdaoobj = new EmpDAO();
		boolean status = empdaoobj.deletedRecord(email);
					
		RequestDispatcher rd = request.getRequestDispatcher("/ViewAllEmp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
