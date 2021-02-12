package oneToManyOneWay.crud;

import oneToManyOneWay.entity.Department;
import oneToManyOneWay.entity.FieldOfStudy;
import oneToManyOneWay.entity.Laboratory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(FieldOfStudy.class);
        configuration.addAnnotatedClass(Laboratory.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Department department = currentSession.get(Department.class, 2);

        for(Laboratory laboratory : department.getLaboratories()){
            System.out.println(laboratory.getName());
        }

        Laboratory lab = currentSession.get(Laboratory.class, 1);
        System.out.println(lab);

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
