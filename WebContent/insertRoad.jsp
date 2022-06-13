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
                	String rname= request.getParameter("roadname");
                	String depname= request.getParameter("department");
                	String rlocation= request.getParameter("location");
                	String date= request.getParameter("date");
                
                PreparedStatement ps = con.prepareStatement("insert into road_maintenance values(?,?,?,?)");
                ps.setString(1,rname);
                ps.setString(2,rlocation);
                ps.setString(3,depname);
                ps.setString(4,date);
                int rs = ps.executeUpdate();
                if(rs>0)
                { 
                	response.sendRedirect("addRoad.jsp");
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