package by.mark.helloworld;

import by.mark.config.HibernateService;
import by.mark.domain.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jpa.internal.*;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HelloWorldJPA {
    private final HibernateService hibernateService = new HibernateService();

    @Test
    public void testSaveMessage() {
        SessionFactory sessionFactory = hibernateService.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Message message = new Message();
        message.setText("Hello, JPA!");

        session.persist(message);

        transaction.commit();
        // INSERT INTO MESSAGE (ID, TEXT) ...
        session.close();
        // opened it manually - closed it manually
    }

    @Test
    public void testGetMessages() {
        SessionFactory sessionFactory = hibernateService.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Message message = new Message();
        message.setText("test");

        session.persist(message);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Message> query = criteriaBuilder.createQuery(Message.class);

        Root<Message> from = query.from(Message.class);
        query.select(from);

        Query<Message> sessionQuery = session.createQuery(query);
        List<Message> messages = sessionQuery.getResultList();

        Assert.assertEquals(1, messages.size());

        transaction.commit();
        session.close();
    }
}
