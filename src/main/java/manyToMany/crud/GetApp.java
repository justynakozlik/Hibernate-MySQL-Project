package manyToMany.crud;

import manyToMany.entity.Course;
import manyToMany.entity.Student;
import manyToMany.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

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

        Course course1 = currentSession.get(Course.class, 1);

        for (Student student : course1.getStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }

        Student student = currentSession.get(Student.class, 7);

        for (Course course2 : student.getCourses()) {
            System.out.println(course2.getName());
        }

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
