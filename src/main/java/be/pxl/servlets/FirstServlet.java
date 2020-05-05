package be.pxl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FirstServlet", value = "/FirstServlet", initParams = @WebInitParam(name = "text", value = "Een ijsje zou mij wel smaken!"))
public class FirstServlet extends HttpServlet {
	private String text;

	@Override
	public void init() throws ServletException {
		super.init();
		text = getInitParameter("text");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>First Servlet Example</h1>");
			out.println("<b>" + text + "</b>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
