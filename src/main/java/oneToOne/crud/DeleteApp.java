package oneToOne.crud;

import oneToOne.entity.Student;
import oneToOne.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        StudentIndex studentIndex = currentSession.get(StudentIndex.class, 6);

        currentSession.remove(studentIndex);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
