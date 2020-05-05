package be.pxl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DemoListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(DemoListener.class);

    public void contextInitialized(ServletContextEvent e) {
        EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("studentdb_pu");
        LOGGER.info("EntityManagerFactory created in WebListener");
        e.getServletContext().setAttribute("entityManagerFactory", entityManagerFactory);
    }

    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("entityManagerFactory");
        if (emf != null) {
            emf.close();
        }
    }
}
