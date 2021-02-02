package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

import java.util.List;

public class HqlNamedParameters {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String studentLastName = "Nowak";

        String namedParamString = "select s.firstName, s.age from Student s where s.lastName=:lastName";

        Query query = currentSession.createQuery(namedParamString);

        query.setParameter("lastName", studentLastName);

        List<Object[]> resultList = query.getResultList();

        currentSession.getTransaction().commit();

        for (Object[] values : resultList){
            System.out.println("First name: " + values[0] + ", Age: " + values[1]);
        }

        sessionFactory.close();
    }
}
