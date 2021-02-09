package oneToOne.hql;

import oneToOne.entity.Student;
import oneToOne.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlOneToOneApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String select = "select s from Student s where s.lastName like 'K%'";
        String where = "select s.lastName from Student s join s.studentIndex si where si.number=11355";
        String avg = "select avg(s.age) from StudentIndex si join si.student s where si.number in (10559, 10437, 12235)";
        String numbers = "select si.number from StudentIndex si join si.student s where s.firstName like 'J%'";
//
//        Query query1 = currentSession.createQuery(select);
//
//        Query query2 = currentSession.createQuery(where);
//
//        Query query3 = currentSession.createQuery(avg);

        Query query4 = currentSession.createQuery(numbers);


//        List<Student> resultList = query1.getResultList();
//
//        String singleResult = (String) query2.getSingleResult();
//
//        Double avgResult = (Double) query3.getSingleResult();

        List<Integer> numberList = query4.getResultList();

//
//        for(Student student : resultList){
//            System.out.println(student.getFirstName() + " " + student.getLastName());
//        }

//        System.out.println(singleResult);
//        System.out.println();
//        System.out.println(avgResult);

        for(Integer number : numberList){
            System.out.println(number);
        }

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
