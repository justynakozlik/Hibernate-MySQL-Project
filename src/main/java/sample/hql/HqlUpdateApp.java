package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

public class HqlUpdateApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        int id = 4;
        int age = 23;

        String update = "update Student s set s.age=:age where s.idStudent=:id";

        Query query = currentSession.createQuery(update);

        query.setParameter("age", age);
        query.setParameter("id", id);

        query.executeUpdate();

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
