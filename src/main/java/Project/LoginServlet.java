package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		RequestDispatcher rd1=null;
		
	   String mail = req.getParameter("MAIL");
	   String pass = req.getParameter("pass");
	   
	   
	   UserDAO dao=new UserDAO();
	   try {
		boolean validate = dao.login(mail,pass);
		if(validate)
		{
		   
			RequestDispatcher rd = req.getRequestDispatcher("Dash.html");
		   rd.forward(req, resp);
		   String name = (String)req.getAttribute("name");
		   writer.print("hello..."+name);
		   
		}
		else
		{
			
			resp.getWriter().write("<font style='color:red'><h3>Invalid credintials..</h3></font>");
			RequestDispatcher rd = req.getRequestDispatcher("Loginpage.html");
			rd.include(req, resp);
			
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   
		
		
		
	}

}
