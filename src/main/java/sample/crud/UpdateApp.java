package sample.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.entity.Student;

public class UpdateApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        Integer id = 4;

        currentSession.beginTransaction();

        Student student = currentSession.get(Student.class, id);

        student.setLastName("Zasada");

        currentSession.getTransaction().commit();

        System.out.println("Updated data of the selected student: " + student);

        sessionFactory.close();
    }
}
