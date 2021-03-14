package js.com.br.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import js.com.br.models.DB;
import js.com.br.models.User;

public class Authenticate implements Action {

	public String call(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String password = req.getParameter("password");

		User user = DB.getUser(login, password);
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("authUser", user);
			return "redirect:entry-point?action=list";
		} else {
			return "redirect:entry-point?action=login";
		}
	}

}
