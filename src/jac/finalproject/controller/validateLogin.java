package jac.finalproject.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import jac.finalproject.model.SocialSECBean;

@WebServlet("/searchmysocial")
public class validateLogin extends HttpServlet {

//	private DBUtil ssnDao;
//
//	public void init() {
//		ssnDao = new DBUtil();
//	}
	
	
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String SSN = request.getParameter("SSN");
		SocialLookupRule serviceUtil = new  DB_BuisnessLogicMiddleware();
		SocialSECBean studentJspVal = serviceUtil.FindSocial(SSN);
//		request.setAttribute("student", student);
		
		 HttpSession session = request.getSession(); // using session
		 session.setAttribute("studentJspRef", studentJspVal);
		 
		 
		String address;
		if (studentJspVal.getSSN().trim() != "") {
//			address = "/WEB-INF/Results/StudentFound.jsp";
			address = "/WEB-INF/View/Results/StudentFound.jsp";


		} else {
			request.setAttribute("badSSN", SSN);
//			address = "/WEB-INF/Results/StudentNotFound.jsp";
			address = "/WEB-INF/View/Results/StudentNotFound.jsp";

		}

		RequestDispatcher dispatcher = 
				request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	// public void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// doPost(request, response);
		doGet(request, response);

	}
}
