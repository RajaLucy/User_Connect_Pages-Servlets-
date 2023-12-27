package Project;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;


@WebFilter("/done")
public class registerFilter extends HttpFilter implements Filter {
       
 
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 String name = request.getParameter("name");
		 String Mail = request.getParameter("mail");
		 String password = request.getParameter("pass");
		 String phno = request.getParameter("phno");
		 
		 if(name.isEmpty()||Mail.isEmpty()||password.isEmpty()||phno.isEmpty())
		 {
			 response.getWriter().write("Please fill details");
			 RequestDispatcher rd = request.getRequestDispatcher("registerPage.html");
			 rd.include(request, response);
		 }
		 else {
		
			chain.doFilter(request, response);
		 }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
