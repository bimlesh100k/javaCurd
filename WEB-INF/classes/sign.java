import javax.servlet.*;
import javax.servlet.http.*;



import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
// import java.sql.ResultSet;

@WebServlet("/sign")

public class sign extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
    String id1= req.getParameter("id");
    String pass1=req.getParameter("password");
	String em1=req.getParameter("email");
    RequestDispatcher dis1=req.getRequestDispatcher("/login.html");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		Statement stat= con.createStatement();
		stat.execute("insert into login values('"+id1+"','"+em1+"','"+pass1+"')");
	   	dis1.forward(req,res);
		
	}
		catch(Exception ex)
		{
			out.println(ex);
			out.println("error.....");
		}
	}
}	
