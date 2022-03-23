package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmpDAO;
import models.EmpInfoModel;

@WebServlet("/UserLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpLogin() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empid = request.getParameter("empemail");
		String emppass = request.getParameter("emppass");
		
		EmpDAO daoobj = new EmpDAO();
		EmpInfoModel empobj = daoobj.empLoginCheck(empid, emppass);
			
		String redirectfilename="";
		
		if (empobj != null)
		{
			redirectfilename = "empafterlogin.jsp";
			HttpSession session = request.getSession(true);
			session.setAttribute("empinfo", empobj);
			//request.setAttribute("empinfo", empobj);
		}
		else
		{
			redirectfilename = "emplogin.jsp";
			request.setAttribute("errormsg", "INVALID UID OR PASSWORD");
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectfilename);
		rd.forward(request, response);	
	
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
