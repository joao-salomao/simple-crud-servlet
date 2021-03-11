package js.com.br.servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.com.br.Company;
import js.com.br.DB;


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = -5745637161629570891L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id =  Integer.parseInt(paramId);
		Company c = DB.findById(id);
		
		if (c == null) {
			response.sendRedirect("list");
		} else {
			request.setAttribute("company", c);
			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id =  Integer.parseInt(paramId);
		Company c = DB.findById(id);
		
		if (c == null) {
			response.sendError(404);
		} else {
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			
			c.setName(name);
			
			try {
				c.setDate(date);
			} catch (ParseException e) {
				throw new ServletException(e);
			}
			
			response.sendRedirect("list");
		}
	}

}
