package org.continent.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration()
                        .addAnnotatedClass(org.continent.bean.Continent.class)
                        .addAnnotatedClass(org.continent.bean.Country.class)
                        .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                        .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/test")
                        .setProperty("hibernate.connection.username", "root")
                        .setProperty("hibernate.connection.password", "root")
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                        .setProperty("hibernate.show_sql", "false")
                        .setProperty("hibernate.c3p0.min_size", "10")
                        .setProperty("hibernate.c3p0.max_size", "20")
                        .setProperty("hibernate.c3p0.timeout", "2000")
                        .setProperty("hibernate.hbm2ddl.auto", "create");

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }
}
