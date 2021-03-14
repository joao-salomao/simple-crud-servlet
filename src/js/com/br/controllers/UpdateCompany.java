package js.com.br.controllers;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import js.com.br.models.Company;
import js.com.br.models.DB;

public class UpdateCompany implements Action {

	public String call(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
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
		}

		return "redirect:entry-point?action=list";
	}

}
