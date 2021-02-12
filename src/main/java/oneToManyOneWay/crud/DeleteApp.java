package oneToManyOneWay.crud;

import oneToManyOneWay.entity.Department;
import oneToManyOneWay.entity.FieldOfStudy;
import oneToManyOneWay.entity.Laboratory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Set;

public class DeleteApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(FieldOfStudy.class);
        configuration.addAnnotatedClass(Laboratory.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String queryString = "delete Laboratory l where l.idLaboratory=3";

        Laboratory laboratory = currentSession.get(Laboratory.class, 4);
        currentSession.delete(laboratory);


        Query query = currentSession.createQuery(queryString);
        query.executeUpdate();

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
