package js.com.br.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.com.br.models.Company;
import js.com.br.models.DB;

public class UpdateCompanyForm implements Action {
	public String call(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		Company c = DB.findById(id);

		if (c == null) {
			response.sendRedirect("list");
			return "redirect:entry-point?action=list";
		} else {
			request.setAttribute("company", c);
			return "forward:edit.jsp";
		}
	}

}
