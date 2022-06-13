package com.maintaince.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maintaince.services.*;

/**
 * Servlet implementation class registerUser
 */
public class registerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerUser() {
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
		String uname = request.getParameter("name");
		String umobile = request.getParameter("mobile");
		String uemail = request.getParameter("email");	
		String upassword =request.getParameter("password");
		String uaddress = request.getParameter("address");
		
		Connection obj = Connect.connect();
		try 
		{
			PreparedStatement ps = obj.prepareStatement("insert into userdetails values(?,?,?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,umobile);
			ps.setString(3,uemail);
			ps.setString(4,upassword);
			ps.setString(5,uaddress);
			int rs = ps.executeUpdate();
			if(rs>0)
			{
				response.sendRedirect("userLogin.html");
				System.out.println("Registeration successfully");
			}
			else
			{
				response.sendRedirect("UserRegister.html");
				System.out.println("Registeration Failed");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
