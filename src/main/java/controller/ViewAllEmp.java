package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDAO;
import models.EmpInfoModel;

@WebServlet("/ViewAllEmp")
public class ViewAllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewAllEmp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        EmpDAO daoobj = new EmpDAO();
		ArrayList<EmpInfoModel> allemplist = daoobj.viewAllRecord();
		
		request.setAttribute("emplist", allemplist);
		RequestDispatcher rd = request.getRequestDispatcher("viewallemp.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
