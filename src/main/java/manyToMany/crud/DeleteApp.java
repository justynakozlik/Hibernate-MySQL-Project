package manyToMany.crud;

import manyToMany.entity.Course;
import manyToMany.entity.Student;
import manyToMany.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);
        configuration.addAnnotatedClass(Course.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

//        Student student = currentSession.get(Student.class, 10);
//
//        currentSession.delete(student);

        Course course = currentSession.get(Course.class, 2);

        currentSession.delete(course);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
