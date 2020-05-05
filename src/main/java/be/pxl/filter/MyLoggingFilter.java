package be.pxl.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/SearchCountry/*")
public class MyLoggingFilter implements Filter {

    private static final Logger LOGGER = LogManager.getLogger(MyLoggingFilter.class);

  @Override
  public void doFilter (ServletRequest request,
                        ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      String url = request instanceof HttpServletRequest ?
                ((HttpServletRequest) request).getRequestURL().toString() : "N/A";
      LOGGER.warn("from filter, processing url: "+url);
      String capital = request.getParameter("capital");
      if (capital == null) {
          LOGGER.fatal("No capital given...");
      }
      chain.doFilter(request, response);
  }

}
