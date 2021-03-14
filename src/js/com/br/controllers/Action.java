package js.com.br.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String call(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
