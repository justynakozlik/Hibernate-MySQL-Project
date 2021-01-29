package sample.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.entity.Student;

public class SaveApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Student student = new Student();

        student.setFirstName("Tomasz");
        student.setLastName("Nowak");
        student.setAge(21);

        currentSession.save(student);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
