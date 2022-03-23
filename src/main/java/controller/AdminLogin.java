package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String adminid = request.getParameter("adminid");
		String adminpass = request.getParameter("adminpass");
		
		String redirectfilename="";
		
		HttpSession session = request.getSession(true);
		
		if (adminid.equals("admin") && adminpass.equals("pass"))
		{
			session.setAttribute("usertype", "ADMIN");
			redirectfilename = "adminafterlogin.jsp";
		}
		else
		{
			redirectfilename = "adminlogin.jsp";
			request.setAttribute("errormsg", "INVALID UID OR PASSWORD");
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirectfilename);
		rd.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
