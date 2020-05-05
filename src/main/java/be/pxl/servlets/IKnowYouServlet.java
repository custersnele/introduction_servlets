package be.pxl.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "IKnowYou", value = "/IKnowYou")
public class IKnowYouServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("name") != null && req.getParameter("name").equals("Error")) {
			throw new ServletException("Illegal name used");
		}
		try (PrintWriter out = resp.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>I know you</h1>");
			out.println("<form method=\"GET\" action=\"IKnowYou\">");
			HttpSession session = req.getSession();
			if (session.getAttribute("name") == null) {
				if (req.getParameter("name") != null) {
					session.setAttribute("name", req.getParameter("name"));
				} else {
					out.println("I don't know you yet! Give me your name!");
					out.println("<input type=\"text\" name=\"name\" id=\"name\" />");
					out.println("<input type=\"submit\" value=\"Submit\" />");
				}
			}
			if (session.getAttribute("name") != null) {
				out.println("You are " + session.getAttribute("name"));
				out.println("<input type=\"submit\" value=\"Try again\" />");
			}
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}

}
