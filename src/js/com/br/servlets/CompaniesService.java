package js.com.br.servlets;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import com.thoughtworks.xstream.XStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import js.com.br.models.Company;
import js.com.br.models.DB;

@WebServlet("/companies")
public class CompaniesService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("contentType");
		if (type == null) {
			type = "json";
		}

		List<Company> companies = DB.getCompanies();
		if (type.equals("xml")) {
			XStream xstream = new XStream();
			xstream.alias("company", Company.class);
			String xml = xstream.toXML(companies);
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		} else {
			Gson gson = new Gson();
			String json = gson.toJson(companies);
			response.setContentType("application/json");
			response.getWriter().print(json);
		}

	}

}
