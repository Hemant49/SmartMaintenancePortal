<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
      <%@page import="com.maintaince.services.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
             <%
                Connection con = Connect.connect();
                try{
                	int id=0;
                	String utitle= request.getParameter("title");
                	String udescription= request.getParameter("description");
                	String depname= request.getParameter("department");
                
                	String date= request.getParameter("date");
                	String com = request.getParameter("comment");
                	String uemail= GetSet.getEmail();
                	String upassword = GetSet.getPassword();
                
                PreparedStatement ps = con.prepareStatement("insert into complaint values(?,?,?,?,?,?,?,?,?)");
                ps.setInt(1,id);
                ps.setString(2,utitle);
                ps.setString(3,udescription);
                ps.setString(4,depname);
                ps.setString(5,date);
                ps.setString(6,uemail);
                ps.setString(7,upassword);
                ps.setString(8,"pending");
                ps.setString(9,com);
                int rs = ps.executeUpdate();
                if(rs>0)
                { 
                	response.sendRedirect("addComplaint.jsp");
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
         %>
</body>
</html>