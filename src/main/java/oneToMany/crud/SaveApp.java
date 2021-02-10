package oneToMany.crud;

import oneToMany.entity.Department;
import oneToMany.entity.FieldOfStudy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SaveApp {

    public static void main(String[] args) {

            Configuration configuration = new Configuration();

            configuration.configure("hibernate.cfg.xml");

            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(FieldOfStudy.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session currentSession = sessionFactory.getCurrentSession();

            currentSession.beginTransaction();

            String getDepartment = "select d from Department d where d.idDepartment=1";

            Query query = currentSession.createQuery(getDepartment);

            Department department = (Department) query.getSingleResult();

            FieldOfStudy field1 = new FieldOfStudy("System informatics");
            FieldOfStudy field2 = new FieldOfStudy("ICT");
            FieldOfStudy field3 = new FieldOfStudy("Bioinformatics");

            department.addFieldOfStudy(field1);
            department.addFieldOfStudy(field2);
            department.addFieldOfStudy(field3);

            currentSession.persist(field1);
            currentSession.persist(field2);
            currentSession.persist(field3);

            currentSession.getTransaction().commit();

            sessionFactory.close();

    }
}
