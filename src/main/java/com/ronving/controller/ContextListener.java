package com.ronving.controller;

import com.ronving.dao.UserDAO;
import com.ronving.model.Account;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.ronving.model.roles.ROLE.ADMIN;
import static com.ronving.model.roles.ROLE.USER;

@WebListener
public class ContextListener implements ServletContextListener {
    /**
     * Fake database connector.
     */
    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().addNewUser(new Account(1, "Pavel", "1", ADMIN));
        dao.get().addNewUser(new Account(2, "Egor", "1", USER));

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }


}
