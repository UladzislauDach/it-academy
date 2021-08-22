package web.listener;

import storage.CurrentStorageType;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitStorageType implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String currentStorageTypeAsString = sce.getServletContext().getInitParameter("storage_type");
        CurrentStorageType.getInstance().setStorageType(currentStorageTypeAsString);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
