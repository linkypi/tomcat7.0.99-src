package com.lynch.sci;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.EventListener;

public class UserListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("user context listener init...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("user context listener destroyed...");
    }
}
