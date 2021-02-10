package oneToMany.crud;

import oneToMany.entity.Department;
import oneToMany.entity.FieldOfStudy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(FieldOfStudy.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        String getDepartment = "select d from Department d where d.idDepartment=2";

        Query query = currentSession.createQuery(getDepartment);

        Department department = (Department) query.getSingleResult();

//        for(FieldOfStudy field : department.getFieldsOfStudy()){
//            if(field.getName().contains("informatics") || field.getName().equals("ICT")){
//                currentSession.delete(field);
//            }
//        }

        int idToDelete = 8;

        FieldOfStudy fieldOfStudy = currentSession.get(FieldOfStudy.class, idToDelete);

        currentSession.delete(fieldOfStudy);

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
