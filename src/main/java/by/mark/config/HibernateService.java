package by.mark.config;

import by.mark.domain.Message;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

import java.util.Properties;

public class HibernateService {

    private final SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateService() {
        this.sessionFactory = initSessionFactory();
    }

    private SessionFactory initSessionFactory() {
        Configuration configuration = getConfiguration();
        Properties properties = configuration.getProperties();

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);
        StandardServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Message.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/helloworld");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "m0rk42002");
        configuration.setProperty("hibernate.format.sql", "true");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.use_sql_comments", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        return configuration;
    }
}
