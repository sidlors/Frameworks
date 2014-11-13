package com.example.web.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

/**
 * Application Lifecycle Listener implementation class JPAListener
 * 
 */
@WebListener
public class JPAListener implements ServletContextListener {

	private static Logger logger = Logger
			.getLogger(JPAListener.class.getName());

	/**
	 * Default constructor.
	 */
	public JPAListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("contextDestroyed - entro");

		// WebApplicationContext ctx =
		// WebApplicationContextUtils.getWebApplicationContext(
		// arg0.getServletContext() );
		// //ApplicationContext ctx = ...;
		// if (ctx instanceof ConfigurableApplicationContext) {
		// //((ConfigurableApplicationContext)ctx).registerShutdownHook();
		// logger.info("((ConfigurableApplicationContext)ctx).close()");
		// ((ConfigurableApplicationContext)ctx).close();
		// }

		// BeanFactory bf = (BeanFactory)
		// ContextLoader.getCurrentWebApplicationContext();
		// if (bf instanceof ConfigurableApplicationContext) {
		// ((ConfigurableApplicationContext)bf).close();
		// }

		// Sleep for a little while to give threads time to stop. Without that,
		// tomcat kept complaining.
		try {
			logger.info("Sleep for a little while to give threads time to stop");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error(e.getMessage(), e);
		}

		// This manually deregisters JDBC driver, which prevents Tomcat 7 from
		// complaining about memory leaks wrto this class
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				logger.info(String.format("Deregistering jdbc driver: %s",
						driver));
			} catch (SQLException e) {
				logger.error(
						String.format("Error deregistering driver %s", driver),
						e);
			}

		}

		// Just for mysql due to orphaned threads in Tomcat: [Abandoned
		// connection cleanup thread]
		try {
			logger.info("Just for mysql due to orphaned threads in Tomcat - AbandonedConnectionCleanupThread.shutdown()");
			AbandonedConnectionCleanupThread.shutdown();
		} catch (InterruptedException e) {
			logger.warn("SEVERE problem cleaning up: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		logger.info("contextInitialized - entro");

	}

}
