package js.com.br.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewCompanyForm implements Action {
	public String call(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "forward:new.jsp";
	}
}
