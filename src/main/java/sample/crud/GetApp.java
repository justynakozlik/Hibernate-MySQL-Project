package sample.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.entity.Student;

public class GetApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        Integer id = 1;

        currentSession.beginTransaction();

        Student student = currentSession.get(Student.class, id);

        currentSession.getTransaction().commit();

        System.out.println(student);

        sessionFactory.close();
    }
}

