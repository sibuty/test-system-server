package com.seriouscompany.testsystem.server.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder registryBuilder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SESSION_FACTORY = configuration.buildSessionFactory(registryBuilder.build());
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

}
