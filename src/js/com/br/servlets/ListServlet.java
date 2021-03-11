package js.com.br.servlets;

import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import js.com.br.Company;
import js.com.br.DB;


@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies = DB.getCompanies();
        request.setAttribute("companies", companies);

        RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
        rd.forward(request, response);
	}

}
