package oneToManyOneWay.crud;

import oneToManyOneWay.entity.Department;
import oneToManyOneWay.entity.FieldOfStudy;
import oneToManyOneWay.entity.Laboratory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveApp {

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

        Laboratory laboratory1 = new Laboratory("Biotechnology laboratory");
        Laboratory laboratory2 = new Laboratory("Grain technology laboratory");
        Laboratory laboratory3 = new Laboratory("Meat technology laboratory");

        department.addLaboratory(laboratory1);
        department.addLaboratory(laboratory2);
        department.addLaboratory(laboratory3);

        currentSession.persist(department);

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
