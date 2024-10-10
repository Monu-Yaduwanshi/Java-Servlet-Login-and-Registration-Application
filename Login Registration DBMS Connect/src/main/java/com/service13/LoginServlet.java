//package com.service13;
//
//import java.io.*;
//import java.sql.*;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class LoginServlet extends HttpServlet {
//	
//	
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    String username = request.getParameter("username");
//	    String password = request.getParameter("password");
//
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginregistrationdata", "root", "root");
//	        
//	        String sql = "SELECT * FROM loginsignupregistration WHERE username=? AND password=?";
////	        String sql = "SELECT * FROM loginsignupregistration WHERE column10=? AND column9=?";
//	        PreparedStatement statement = conn.prepareStatement(sql);
//	        statement.setString(1, username);
//	        statement.setString(2, password);
//	        ResultSet result = statement.executeQuery();
//
//	        if (result.next()) {
////	        	 response.sendRedirect(("<html><body><b>"));
////	        	  response.sendRedirect(("Welcome: " + username));   
////	        	 response.sendRedirect(("</b></body></html>"));
//	            response.sendRedirect("Loginsuccess.html");
//	        } 
//	       
//	        	else {
//	            response.sendRedirect("Login&Signup.html");
//	        }
//	        conn.close();
//	    } catch (SQLException e) {
//	        // Database access error
//	        request.setAttribute("error", "Database access error: " + e.getMessage());
//	        request.getRequestDispatcher("error.jsp").forward(request, response);
//	    } catch (ClassNotFoundException e) {
//	        // MySQL JDBC driver not found
//	        request.setAttribute("error", "MySQL JDBC driver not found: " + e.getMessage());
//	        request.getRequestDispatcher("error.jsp").forward(request, response);
//	    } catch (Exception e) {
//	        // Other unexpected errors
//	        request.setAttribute("error", "Unexpected error: " + e.getMessage());
//	        request.getRequestDispatcher("error.jsp").forward(request, response);
//	    }
//	}}

//package com.service13;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.Objects;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class LoginServlet extends HttpServlet{
//	public void doGet(HttpServletRequest req, HttpServletResponse res)  
//            throws ServletException, IOException {
//  
//res.setContentType("text/html");  
//PrintWriter out = res.getWriter();  
//          
//String name=req.getParameter("username");  
//String password=req.getParameter("password");  
//  
//try{  
//Class.forName("com.mysql.jdbc.Driver");  
//Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginregistrationdata","root","rooot");  
// PreparedStatement ps=con.prepareStatement( "Select username,password from loginsignupregistration where username=? and password=?");  
//  
//ps.setString(1,name);  
//ps.setString(2, password);  
//          
//ResultSet i=ps.executeQuery();  
//if(i.next())  
//{
//	out.print("<html><body><b>");
//	out.print("Welcome: "+name);
//	out.print("</b></body></html>");
////	RequestDispatcher re=req.getRequestDispatcher("Success.html");
////     re.forward(req, res);
//          
//}
//}catch (Exception e2)
//{
//	out.print(e2);}
//}  }
//package com.service13;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class LoginServlet extends HttpServlet {
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginregistrationdata", "root", "root");
//            ps = con.prepareStatement("SELECT username,password FROM loginsignupregistration WHERE username=? AND password=?");
//
//            ps.setString(1, username);
//            ps.setString(2, password);
//
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                out.print("<html><body><b>");
//                out.print("Welcome: " + username);
//                out.print("</b></body></html>");
//                // RequestDispatcher re=req.getRequestDispatcher("Success.html");
//                // re.forward(req, res);
//
//            } else {
//                out.print("<html><body><b>");
//                out.print("Login Failed!");
//                out.print("</b></body></html>");
//            }
//        } catch (Exception e) {
//            // Handle exception properly, don't print to client
//            out.print("<html><body><b>");
//            out.print("An error occurred: " + e.getMessage());
//            out.print("</b></body></html>");
//        } finally {
//            // Close resources in finally block
//            try {
//                if (rs != null) rs.close();
//                if (ps != null) ps.close();
//                if (con != null) con.close();
//            } catch (Exception ex) {
//                // Log or handle this exception
//                ex.printStackTrace();
//            }
//        }
//    }
//}
package com.service13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "jdbc:mysql://127.0.0.1:3306/loginregistrationdata";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT * FROM loginsignupregistration WHERE username=? AND password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
             
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body><b>Welcome: " + username + "</b></body></html>");
                response.sendRedirect("Loginsuccess.html");
            } else {
               
                response.sendRedirect("Loginfailed.html");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html"); // Redirect to an error page
        }
    }
}


