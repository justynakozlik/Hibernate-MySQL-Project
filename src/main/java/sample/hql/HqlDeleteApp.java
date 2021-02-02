package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

public class HqlDeleteApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        int id = 6;

        String update = "delete Student s where s.idStudent=:id";

        Query query = currentSession.createQuery(update);

        query.setParameter("id", id);

        int rows = query.executeUpdate();

        System.out.println("The number of removed records is: " + rows);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
