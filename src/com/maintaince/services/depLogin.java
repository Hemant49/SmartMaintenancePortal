package com.maintaince.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class depLogin
 */
public class depLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depLogin() {
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
		String demail = request.getParameter("email");
		
		String dpassword = request.getParameter("password");
		
		
		Connection con = Connect.connect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from department_details where email=? and password=?");
			ps.setString(1,demail);
			ps.setString(2,dpassword);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				GetSet.setDname(rs.getString("depname"));
				System.out.println("Login Successfully");
				response.sendRedirect("depWelcome.html");
			}
			else
			{
				System.out.println("Failed");
				response.sendRedirect("404.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}


