package Project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/done")
public class registerServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String name = req.getParameter("name");
		String Mail = req.getParameter("mail");
		String Password = req.getParameter("pass");
		String phno = req.getParameter("phno");
		
		
		
		UserDAO s=new UserDAO();
		try {
			s.saveUser(name,Mail,Password,phno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name =="" || Mail=="")
		{
		
			RequestDispatcher rd = req.getRequestDispatcher("registerPage.html");
			rd.include(req, resp);
			writer.write("<font style='color:red'>enter details</font>");
		}
		else if(name!="" && Mail!="") {
		
		writer.write("<font style='color:green'><h1>Registration Success ...you can login now</h1></font>");
		RequestDispatcher rd = req.getRequestDispatcher("Loginpage.html");
		rd.include(req, resp);
		
		}
		
		
		
		
		
		
	}

}
