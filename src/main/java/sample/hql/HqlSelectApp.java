package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

import java.util.List;

public class HqlSelectApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String select = "select s.age from Student s";
        String select2 = "select s.firstName, s.lastName from Student s";
        String select3 = "select s.lastName from Student s where idStudent=2";

        Query query = currentSession.createQuery(select);

        List<Integer> resultList = query.getResultList();

        Query query2 = currentSession.createQuery(select2);

        List<Object[]> resultList2 = query2.getResultList();

        Query query3 = currentSession.createQuery(select3);

        Object singleResult = query3.getSingleResult();

        currentSession.getTransaction().commit();

        for (Integer age : resultList){
            System.out.println(age);
        }

        System.out.println();

        for (Object[] values : resultList2){
            System.out.println("First name: " + values[0] + ", Last name: " + values[1]);
        }

        System.out.println();

        System.out.println(singleResult);

        sessionFactory.close();
    }
}
