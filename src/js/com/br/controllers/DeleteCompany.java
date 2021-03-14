package js.com.br.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.com.br.models.DB;


public class DeleteCompany implements Action {

	public String call(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		int id = Integer.parseInt(paramId);
		DB.removeCompany(id);
		return "redirect:entry-point?action=list";
	}

}
