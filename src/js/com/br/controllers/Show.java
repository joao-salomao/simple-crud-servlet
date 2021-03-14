package js.com.br.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import js.com.br.models.Company;
import js.com.br.models.DB;

public class Show implements Action {

	public String call(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Company> companies = DB.getCompanies();
		request.setAttribute("companies", companies);
		return "forward:list.jsp";
	}

}
