package be.pxl.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Addition", value = "/Addition")
public class AdditionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder answer = new StringBuilder();
		try {
			int number1 = Integer.parseInt(req.getParameter("number1"));
			int number2 = Integer.parseInt(req.getParameter("number2"));
			answer.append("Calculation time:").append(LocalDateTime.now()).append("\n");
			answer.append("Result:").append(number1 + number2).append("\n");
		} catch (NumberFormatException e) {
			answer.append("Invalid input!");
		}
		try (PrintWriter out = resp.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>AdditionServlet Response</h1>");
			out.print(answer.toString());
			out.println("</body>");
			out.println("</html>");
		}
	}

}
