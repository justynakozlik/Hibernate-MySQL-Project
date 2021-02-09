package oneToOne.crud;

import oneToOne.entity.Student;
import oneToOne.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Student student = new Student("Marcin", "Kowal", 24);
        StudentIndex studentIndex = new StudentIndex(10458);
        student.setStudentIndex(studentIndex);
        studentIndex.setStudent(student);

        currentSession.persist(student);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
