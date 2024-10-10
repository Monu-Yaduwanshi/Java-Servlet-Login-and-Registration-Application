//////package com.service12;
//////
//////import java.io.IOException;
//////import java.io.PrintWriter;
//////import java.sql.Connection;
//////import java.sql.DriverManager;
//////import java.sql.PreparedStatement;
//////import java.sql.SQLException;
//////
//////import jakarta.servlet.ServletException;
//////import jakarta.servlet.http.HttpServlet;
//////import jakarta.servlet.http.HttpServletRequest;
//////import jakarta.servlet.http.HttpServletResponse;
//////
//////public class RegistrationDBconnect extends HttpServlet {
//////    private static final long serialVersionUID = 1L;
//////
//////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//////        response.setContentType("text/html");
//////        PrintWriter out = response.getWriter();
//////
//////        String name = request.getParameter("name");
//////        String branch = request.getParameter("branch");
//////        String semester = request.getParameter("semester");
//////        String gender = request.getParameter("gender");
//////        String[] hobbies = request.getParameterValues("hobby");
//////
//////        Connection con = null;
//////        PreparedStatement ps = null;
//////
//////        try {
//////            // Register JDBC driver
//////            Class.forName("com.mysql.cj.jdbc.Driver");
//////
//////            // Open a connection
//////            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rigistrationdata", "root", "root");
//////
//////            // Create SQL statement
//////            String query = "INSERT INTO student (name, branch, semester, gender, hobby) VALUES (?, ?, ?, ?, ?)";
//////            ps = con.prepareStatement(query);
//////            ps.setString(1, name);
//////            ps.setString(2, branch);
//////            ps.setString(3, semester);
//////            ps.setString(4, gender);
//////            StringBuilder hobbyBuilder = new StringBuilder();
//////            for (String hobby : hobbies) {
//////                hobbyBuilder.append(hobby).append(", ");
//////            }
//////            String hobbiesString = hobbyBuilder.toString();
//////            // Remove the trailing comma and space
//////            if (hobbiesString.length() > 0) {
//////                hobbiesString = hobbiesString.substring(0, hobbiesString.length() - 2);
//////            }
//////            ps.setString(5, hobbiesString);
//////
//////            int i = ps.executeUpdate();
//////            if (i > 0) {
//////                // Redirect to success page
//////                response.sendRedirect("success.html");
//////            } else {
//////                out.println("<p>Registration failed.</p>");
//////            }
//////        } catch (ClassNotFoundException | SQLException e) {
//////            // Forward to error page
//////            request.setAttribute("errorMessage", e.getMessage());
//////            request.getRequestDispatcher("/error.jsp").forward(request, response);
//////        } finally {
//////            try {
//////                if (ps != null) {
//////                    ps.close();
//////                }
//////                if (con != null) {
//////                    con.close();
//////                }
//////            } catch (SQLException ex) {
//////                // Forward to error page
//////                request.setAttribute("errorMessage", ex.getMessage());
//////                request.getRequestDispatcher("/error.jsp").forward(request, response);
//////            }
//////            out.close();
//////        }
//////    }
//////}
////package com.service12;
////
////import java.io.IOException;
////import java.io.PrintWriter;
////import java.sql.Connection;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.SQLException;
////
////import jakarta.servlet.ServletException;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////
////public class RegistrationDBconnect extends HttpServlet {
////    private static final long serialVersionUID = 1L;
////
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        response.setContentType("text/html");
////        PrintWriter out = response.getWriter();
////
////        String name = request.getParameter("name");
////        String branch = request.getParameter("branch");
////        String semester = request.getParameter("semester");
////        String gender = request.getParameter("gender");
////        String[] hobbies = request.getParameterValues("hobby");
////
////        Connection con = null;
////        PreparedStatement ps = null;
////
////        try {
////            // Register JDBC driver
////            Class.forName("com.mysql.cj.jdbc.Driver");
////
////            // Open a connection
////            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rigistrationdata", "root", "root");
////
////            // Create SQL statement
////            String query = "INSERT INTO student (name, branch, semester, gender, hobby) VALUES (?, ?, ?, ?, ?)";
////            ps = con.prepareStatement(query);
////            ps.setString(1, name);
////            ps.setString(2, branch);
////            ps.setString(3, semester);
////            ps.setString(4, gender);
////            StringBuilder hobbyBuilder = new StringBuilder();
////            for (String hobby : hobbies) {
////                hobbyBuilder.append(hobby).append(", ");
////            }
////            String hobbiesString = hobbyBuilder.toString();
////            if (hobbiesString.length() > 0) {
////                hobbiesString = hobbiesString.substring(0, hobbiesString.length() - 2);
////            }
////            ps.setString(5, hobbiesString);
////
////            int i = ps.executeUpdate();
////            if (i > 0) {
////                // Redirect to success page
////                response.sendRedirect("success.html");
////            } else {
////                out.println("<p>Registration failed.</p>");
////            }
////        } catch (ClassNotFoundException | SQLException e) {
////            // Forward to error page
////            request.setAttribute("errorMessage", e.getMessage());
////            request.getRequestDispatcher("/error.jsp").forward(request, response);
////        } finally {
////            try {
////                if (ps != null) {
////                    ps.close();
////                }
////                if (con != null) {
////                    con.close();
////                }
////            } catch (SQLException ex) {
////                // Forward to error page
////                request.setAttribute("errorMessage", ex.getMessage());
////                request.getRequestDispatcher("/error.jsp").forward(request, response);
////            }
////            out.close();
////        }
////    }
////}
////
//
//
//package com.service12;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//
//
//@WebServlet("\registration")
//public class RegistrationDBconnect extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String name = request.getParameter("name");
//        String branch = request.getParameter("branch");
//        int semester = Integer.parseInt(request.getParameter("semester"));
//        String gender = request.getParameter("gender");
//        String[] hobbiesArray = request.getParameterValues("hobby");
//        String hobbies = String.join(",", hobbiesArray);
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rigistrationdata", "root", "root");
//
//            PreparedStatement ps = con.prepareStatement("INSERT INTO student (name, branch, semester, gender, hobbies) VALUES (?, ?, ?, ?, ?)");
//            ps.setString(1, name);
//            ps.setString(2, branch);
//            ps.setInt(3, semester);
//            ps.setString(4, gender);
//            ps.setString(5, hobbies);
//
//            int rowsAffected = ps.executeUpdate();
//            if (rowsAffected > 0) {
//                response.sendRedirect("success.html");
//            } else {
//                response.sendRedirect("registrationform.html");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//package com.service12;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class RegistrationDBconnect extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        String name = request.getParameter("name");
//        String branch = request.getParameter("branch");
//        String semester = request.getParameter("semester");
//        String gender = request.getParameter("gender");
//        String[] hobbies = request.getParameterValues("hobby");
//
//        Connection con = null;
//        PreparedStatement ps = null;
//
//        try {
//            // Register JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Open a connection
//            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/rigistrationdata", "root", "root");
//
//            // Create SQL statement
//            String query = "INSERT INTO student (name, branch, semester, gender, hobby) VALUES (?, ?, ?, ?, ?)";
//            ps = con.prepareStatement(query);
//            ps.setString(1, name);
//            ps.setString(2, branch);
//            ps.setString(3, semester);
//            ps.setString(4, gender);
//            StringBuilder hobbyBuilder = new StringBuilder();
//            for (String hobby : hobbies) {
//                hobbyBuilder.append(hobby).append(", ");
//            }
//            ps.setString(4, hobbyBuilder.toString());
//
//            int i = ps.executeUpdate();
//            if (i > 0) {
//                // Redirect to success page
//           // 	request.setAttribute("errorMessag", e.getMessage());
//            	 request.getRequestDispatcher("success.html").forward(request, response);
//            } else {
//                out.println("<p>Registration failed.</p>");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            // Forward to error page
//            request.setAttribute("errorMessage", e.getMessage());
////            request.getRequestDispatcher("error.jsp").forward(request, response);
//        } finally {
//            try {
//                if (ps != null) {
//                    ps.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                // Forward to error page
//                request.setAttribute("errorMessage", ex.getMessage());
////                request.getRequestDispatcher("error.jsp").forward(request, response);
//            }
//            out.close();
//        }
//    }
//}

package com.service13;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RigistrationServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)  
            throws ServletException, IOException {  
  
res.setContentType("text/html");  
PrintWriter out = res.getWriter();  
          
String name=req.getParameter("name");  
String branch=req.getParameter("branch");  
String semester=req.getParameter("semester");  
String gender=req.getParameter("gender");  
String  hobby1=Stream.of(req.getParameter("hobby1")).filter(Objects::nonNull).collect(Collectors.joining(","));  
String  hobby2=Stream.of(req.getParameter("hobby2")).filter(Objects::nonNull).collect(Collectors.joining(","));   
String  hobby3=Stream.of(req.getParameter("hhobby3")).filter(Objects::nonNull).collect(Collectors.joining(",")); 
String  hobby4=Stream.of(req.getParameter("hobby4")).filter(Objects::nonNull).collect(Collectors.joining(","));  

String userName=req.getParameter("username");  
String password=req.getParameter("password"); 
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/loginregistrationdata","root","root");  
 PreparedStatement ps=con.prepareStatement( "insert into loginsignupregistration values(?,?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,name);  
ps.setString(2,branch);  
ps.setString(3,semester);  
ps.setString(4,gender);  
ps.setString(5,hobby1); 
ps.setString(6,hobby2); 
ps.setString(7,hobby3);
ps.setString(8,hobby4);

ps.setString(9,userName); 
ps.setString(10,password);
          
int i=ps.executeUpdate();  
if(i>0)  
{
	RequestDispatcher re=req.getRequestDispatcher("Registrationsuccess.html");
     re.forward(req, res);
          
}
else  {
  out.println("<p>Registration failed.</p>");
}
// else if {
//	  out.println("error.html");
//}

}catch (Exception e2)
{
	out.print(e2);}   
}  
}
//<td colspan="3"><button><span style='font-size:100px;'>&#128100;</span></button></td>
