package manyToMany.crud;

import manyToMany.entity.Course;
import manyToMany.entity.Student;
import manyToMany.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);
        configuration.addAnnotatedClass(Course.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Course course = new Course("HTML course");

        Student student = new Student("Anna", "Kowal", 23);
        StudentIndex studentIndex = new StudentIndex(10465);
        student.setStudentIndex(studentIndex);

        course.addStudent(student);

        currentSession.persist(course);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
