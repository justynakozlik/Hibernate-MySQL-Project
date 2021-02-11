package manyToMany.crud;

import manyToMany.entity.Course;
import manyToMany.entity.Student;
import manyToMany.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);
        configuration.addAnnotatedClass(Course.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Course course = currentSession.get(Course.class, 1);

        for (Student student : course.getStudents()){
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
