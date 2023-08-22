package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "From " + Course.class.getSimpleName() + " Where price > 120000";
        List<Course> courses = session.createQuery(hql).getResultList();
        System.out.println(courses.size());


        /*CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root).where(builder.greaterThan(root.get("price"), 100000))
                .orderBy(builder.desc(root.get("price")));
        List<Course> courses = session.createQuery(query).setMaxResults(5).getResultList();
        for (Course course : courses) {
            System.out.println(course.getName() + " - " + course.getPrice());
        }*/



        transaction.commit();
        sessionFactory.close();


       /* String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "@Potapchik007";


        try {
            Connection connection = DriverManager.getConnection(url, user, pass); // соединяльщик

            Statement statement = connection.createStatement(); // запросник

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses"); // запись результата запроса

            while (resultSet.next()) {
                Course course = new Course();
            }

            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}