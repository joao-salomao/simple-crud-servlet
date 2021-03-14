package js.com.br.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entry-point")
public class RequestSpeedMonitorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("RequestSpeedMonitorFilter");
		
		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();

		System.out.println("Action: " + request.getParameter("action"));
		System.out.println("Execution time: " + (after - before) + "ms");

	}

}
