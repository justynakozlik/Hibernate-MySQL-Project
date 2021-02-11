package oneToMany.hql;

import oneToMany.entity.Department;
import oneToMany.entity.FieldOfStudy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HqlApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(FieldOfStudy.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String getFieldsOfStudy = "select f.name from FieldOfStudy f join f.department d where d.idDepartment=2 order by f.name asc";

        String getName = "select d.name from Department d where size(d.fieldsOfStudy)=4";

        Query query1 = currentSession.createQuery(getFieldsOfStudy);

        Query query2 = currentSession.createQuery(getName);

        List<String> resultList = query1.getResultList();

        String departmentName = (String) query2.getSingleResult();

        for (String name : resultList){
            System.out.println(name);
        }

        System.out.println();

        System.out.println(departmentName);

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
