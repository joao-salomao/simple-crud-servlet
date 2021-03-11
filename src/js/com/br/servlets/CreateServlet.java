package js.com.br.servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.com.br.Company;
import js.com.br.DB;

@WebServlet("/new")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = -5651641200471189260L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("new.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String name = req.getParameter("name");
		String date = req.getParameter("date");

		Company c = null;

		try {
			c= new Company(name, date);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB.addCompany(c);
		
		resp.sendRedirect("list");
		
	}
}
