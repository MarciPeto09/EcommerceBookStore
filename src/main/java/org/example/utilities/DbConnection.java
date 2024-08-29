package org.example.utilities;

import org.example.author.AuthorEntity;
import org.example.book.BookEntity;
import org.example.category.CategoryEntity;
import org.example.order.OrderEntity;
import org.example.user.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    private static SessionFactory FACTORY = null;

    public DbConnection() {
    }

    public static SessionFactory getFactory() {
        if (FACTORY == null) {
            Class var0 = SessionFactory.class;
            synchronized(SessionFactory.class) {
                if (FACTORY == null) {
                    try {
                        Properties prop = new Properties();
                        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
                        prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ecommercebookstore");
                        prop.setProperty("hibernate.hbm2ddl.auto", "update");
                        prop.setProperty("hibernate.show_sql", "false");
                        prop.setProperty("hibernate.format_sql", "false");
                        prop.setProperty("hibernate.connection.username", "root");
                        prop.setProperty("hibernate.connection.password", "ubt.2000");
                        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                        prop.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                        prop.setProperty("hibernate.current_session_context_class", "thread");
                        Configuration config = new Configuration();
                        config.setProperties(prop);
                        config.addPackage("entities");
                        config.addAnnotatedClass(AuthorEntity.class);
                        config.addAnnotatedClass(OrderEntity.class);
                        config.addAnnotatedClass(BookEntity.class);
                        config.addAnnotatedClass(CategoryEntity.class);
                        config.addAnnotatedClass(UserEntity.class);
                        ServiceRegistry serviceRegistry = (new StandardServiceRegistryBuilder()).applySettings(config.getProperties()).build();
                        FACTORY = config.buildSessionFactory(serviceRegistry);
                    } catch (Exception var5) {
                        Exception ex = var5;
                        ex.printStackTrace();
                    }
                }
            }
        }

        return FACTORY;
    }
}
