package js.com.br.servlets;

import java.util.HashMap;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import js.com.br.controllers.Action;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerFilter implements Filter {

	private static HashMap<String, String> routesMapper = new HashMap<String, String>();

	static {
		routesMapper.put("login", "LoginForm");
		routesMapper.put("authenticate", "Authenticate");
		routesMapper.put("logout", "Logout");
		routesMapper.put("list", "Show");
		routesMapper.put("new-form", "NewCompanyForm");
		routesMapper.put("new", "CreateNewCompany");
		routesMapper.put("delete", "DeleteCompany");
		routesMapper.put("update", "UpdateCompany");
		routesMapper.put("update-form", "UpdateCompanyForm");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ControllerFilter");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		try {
			String actionParam = request.getParameter("action");
			if (actionParam == null) {
				actionParam = "login";
			}

			Action action = getRouteAction(actionParam);
			String path = action.call(request, response);
			handleResponse(path, request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	private Action getRouteAction(String action) throws Exception {
		String className = "js.com.br.controllers." + routesMapper.get(action);
		Class classObject = Class.forName(className);
		return (Action) classObject.newInstance();
	}

	private void handleResponse(String path, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String[] typeAndAddress = path.split(":");
		if (typeAndAddress[0].equals("redirect")) {
			response.sendRedirect(typeAndAddress[1]);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + typeAndAddress[1]);
			rd.forward(request, response);
		}
	}

}
