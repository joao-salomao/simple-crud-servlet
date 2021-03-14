package js.com.br.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

import js.com.br.controllers.Action;
import js.com.br.controllers.CreateNewCompany;
import js.com.br.controllers.DeleteCompany;
import js.com.br.controllers.Show;
import js.com.br.controllers.UpdateCompany;

@WebServlet("/entry-point")
public class EntryPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String actionParam = request.getParameter("action");
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
