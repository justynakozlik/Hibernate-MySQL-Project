package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

public class HqlAggregateFunctionsApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String avg = "select avg(s.age) from Student s";
        String sum = "select sum(s.age) from Student s";
        String min = "select min(s.age) from Student s";
        String count = "select count(s) from Student s";

        Query query1 = currentSession.createQuery(avg);
        Query query2 = currentSession.createQuery(sum);
        Query query3 = currentSession.createQuery(min);
        Query query4 = currentSession.createQuery(count);

        Double result1 = (Double) query1.getSingleResult();
        Long result2 = (Long) query2.getSingleResult();
        Integer result3 = (Integer) query3.getSingleResult();
        Long result4 = (Long) query4.getSingleResult();

        System.out.println("The average for all ages is: " + result1);
        System.out.println("The sum for all ages is: " + result2);
        System.out.println("The minimum value of the age is: " + result3);
        System.out.println("The number of all records is: " + result4);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
