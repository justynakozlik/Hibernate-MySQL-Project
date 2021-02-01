package sample.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.entity.Student;

import java.util.List;

public class HqlFromWhereApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Student.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String from = "from Student";
        String where1 = "from Student where lastName='Nowak'";
        String where2 = "from Student where age<=24";
        String where3 = "from Student where firstName in ('Justyna', 'Katarzyna')";
        
        Query query = currentSession.createQuery(where3);

        List<Student> resultList = query.getResultList();

        currentSession.getTransaction().commit();

        for (Student student : resultList){
            System.out.println(student);
        }

        sessionFactory.close();
    }
}
