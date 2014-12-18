package com.seriouscompany.testsystem.server;

import com.seriouscompany.testsystem.server.controller.entity.GenericDao;
import com.seriouscompany.testsystem.server.controller.entity.UserDaoImpl;
import com.seriouscompany.testsystem.server.entities.User;

public class Main {

    public static void main(String[] args) {
        GenericDao<User> entityDAO = new UserDaoImpl();
        User user = new User();
        user.setUserName("username");
        user.setPassword("password");

        entityDAO.save(user);
    }
}
