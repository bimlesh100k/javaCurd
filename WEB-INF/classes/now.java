import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;


@WebServlet("/now")

public class now extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
	res.setContentType("text/html");		
	PrintWriter out= res.getWriter();
    RequestDispatcher dis=req.getRequestDispatcher("/header.html");
	dis.include(req,res);
	HttpSession hs=req.getSession(true);
	String uid=(String)hs.getAttribute("log");
	out.println("<h5>"+uid+"</h5");
	}
}	
