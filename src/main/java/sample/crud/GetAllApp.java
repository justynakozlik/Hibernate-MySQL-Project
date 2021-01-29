package sample.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sample.entity.Student;

import java.util.List;

public class GetAllApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        List<Student> studentList = currentSession.createQuery("from Student").getResultList();

        for(Student student : studentList){
            System.out.println(student);
        }

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
