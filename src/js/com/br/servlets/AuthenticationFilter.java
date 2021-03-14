package js.com.br.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/entry-point")
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String actionParam = request.getParameter("action");
		boolean userIsNotAuthenticated = request.getSession().getAttribute("authUser") == null;
		boolean actionIsProtected = !actionParam.equals("authenticate") && !actionParam.equals("login");

		if (userIsNotAuthenticated && actionIsProtected) {
			response.sendRedirect("entry-point?action=login");
		} else {
			chain.doFilter(request, response);			
		}

	}
}
