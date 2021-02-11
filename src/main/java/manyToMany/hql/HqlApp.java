package manyToMany.hql;

import manyToMany.entity.Course;
import manyToMany.entity.Student;
import manyToMany.entity.StudentIndex;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentIndex.class);
        configuration.addAnnotatedClass(Course.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String lastName = "Kot";
        int idCourse = 1;
        String course = "Java course";

        String getLastName = "select s.lastName from Student s join s.courses c where c.idCourse=3";
        String getNumber = "select si.number from StudentIndex si join si.student s join s.courses c where s.lastName=:lastName and c.idCourse=:idCourse";
        String count = "select count(s) from Student s join s.courses c where c.name=:course";

        Query query1 = currentSession.createQuery(getLastName);

        Query query2 = currentSession.createQuery(getNumber);

        Query query3 = currentSession.createQuery(count);

        List<String> lastNames = query1.getResultList();

        for (String lastName2 : lastNames){
            System.out.println(lastName2);
        }

        query2.setParameter("lastName", lastName);
        query2.setParameter("idCourse", idCourse);

        Integer number = (Integer) query2.getSingleResult();

        System.out.println(number);

        query3.setParameter("course", course);

        Long countResult = (Long) query3.getSingleResult();

        System.out.println(countResult);

        currentSession.getTransaction().commit();

        sessionFactory.close();
    }
}
