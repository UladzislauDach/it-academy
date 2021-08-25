package web.listener;

import storage.AppParam;
import storage.EStorageType;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@WebListener
public class InitAppParam implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String currentStorageTypeAsString = sce.getServletContext().getInitParameter("storage_type");
        AppParam appParam = AppParam.getInstance();
        try {
            appParam.setStorageType(EStorageType.valueOfIgnoreCase(currentStorageTypeAsString));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Отсутствует или не верный способ хранения файлов");
        }
        appParam.setStartTime(LocalDateTime.now());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
