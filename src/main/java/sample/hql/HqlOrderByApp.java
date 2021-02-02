package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

import java.util.List;

public class HqlOrderByApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String order1 = "from Student s order by s.firstName";
        String order2 = "select s.firstName, s.lastName from Student s order by s.age desc";

        Query query = currentSession.createQuery(order1);

        List<Student> resultList = query.getResultList();

        Query query2 = currentSession.createQuery(order2);

        List<Object[]> resultList2 = query2.getResultList();

        currentSession.getTransaction().commit();

        for (Student student : resultList){
            System.out.println(student);
        }

        System.out.println();

        for (Object[] values : resultList2){
            System.out.println("First name: " + values[0] + ", Last name: " + values[1]);
        }

        sessionFactory.close();
    }
}
