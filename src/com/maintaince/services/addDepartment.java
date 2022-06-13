package com.maintaince.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addDepartment
 */
public class addDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDepartment() {
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
		int id=0;
		String demail= request.getParameter("email");
		String dpassword= request.getParameter("password");
		String depname= request.getParameter("depname");
		String dmobile= request.getParameter("mobile");
		String daddress= request.getParameter("address");
		String dtaluka= request.getParameter("taluka");
		String ddistrict= request.getParameter("district");
		String dzip= request.getParameter("zip");
		
		try
		{
			Connection obj = Connect.connect();
			PreparedStatement ps1 = obj.prepareStatement("insert into department_details values(?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1,id);
			ps1.setString(2,demail);
			ps1.setString(3,dpassword);
			ps1.setString(4,depname);
			ps1.setString(5,dtaluka);
			ps1.setString(6,ddistrict);
			ps1.setString(7,daddress);
			ps1.setString(8,dmobile);
			ps1.setString(9,dzip);
			int res = ps1.executeUpdate();
			
					if(res>0)
					{
						
						response.sendRedirect("addDep.html");
						System.out.println("Department added Succesfully");
						
					} 
					else
					{
						response.sendRedirect("404.html");
						System.out.println("Failed!!!!!");
					}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}

}
