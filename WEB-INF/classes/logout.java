import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;

@WebServlet("/logout")

public class logout extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
    RequestDispatcher dis1=req.getRequestDispatcher("/signup.html");
	HttpSession hs=req.getSession(true);
		hs.invalidate();
		dis1.forward(req,res);
	
	}
}	