package be.pxl.servlets;

import be.pxl.dao.BrewerDao;
import be.pxl.domain.Brewer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "SearchBrewers", value = "/SearchBrewers")
public class SearchBrewersServlet extends HttpServlet {
	private BrewerDao brewerDao;
	private EntityManager entityManager;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) getServletContext().getAttribute("entityManagerFactory");
		entityManager = entityManagerFactory.createEntityManager();
		brewerDao = new BrewerDao(entityManager);
	}

	@Override
	public void destroy() {
		super.destroy();
		if (entityManager != null) {
			entityManager.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String city = req.getParameter("city");
		List<Brewer> brewers = brewerDao.findByCity(city);
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Brewers in " + city + "</h1>");
			out.println("<table>");
			for (Brewer brewer : brewers) {
				out.println("<tr><td>" + brewer.getName() + "</td></tr>");
			}

			out.println("</table");
			out.println("</body>");
			out.println("</html>");
		} 
	}
}
