package js.com.br.controllers;

import java.io.IOException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import js.com.br.models.Company;
import js.com.br.models.DB;

public class CreateNewCompany implements Action {
	public String call(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String date = req.getParameter("date");

		Company c = null;

		try {
			c = new Company(name, date);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		DB.addCompany(c);

		return "redirect:entry-point?action=list";
	}
}
