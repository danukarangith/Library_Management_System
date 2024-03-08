package lk.ijse.util;

import lk.ijse.Entity.Admin;
import lk.ijse.Entity.Books;
import lk.ijse.Entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){
        sessionFactory = new  Configuration()
                .configure()
                .addAnnotatedClass(Member.class)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Books.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance(){
        return (null == sessionFactoryConfiguration) ? sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
