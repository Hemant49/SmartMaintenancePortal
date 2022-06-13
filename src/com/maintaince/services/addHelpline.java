package com.maintaince.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addHelpline
 */
public class addHelpline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addHelpline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 Connection con = Connect.connect();
         try{
         	String hname= request.getParameter("name");
         	String hmobile= request.getParameter("mobile");
         
         PreparedStatement ps = con.prepareStatement("insert into helpline_number values(?,?)");
         ps.setString(1,hname);
         ps.setString(2,hmobile);
         int rs = ps.executeUpdate();
         if(rs>0)
         { 
         	response.sendRedirect("addHelpline.html");
         }
         else
         {
         	response.sendRedirect("404.html");
         }
         }
         catch(Exception e)
         {
         	e.printStackTrace();
         }
	}

}
