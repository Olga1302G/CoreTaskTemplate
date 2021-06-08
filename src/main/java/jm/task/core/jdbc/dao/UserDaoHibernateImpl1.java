package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.util.UtilHibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl1 implements UserDao {

    private SessionFactory sessionFactory = UtilHibernate.getSessionFactory();


    public UserDaoHibernateImpl1() {

    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS userTable (" + ("id BIGINT PRIMARY KEY AUTO_INCREMENT," +
                " name varchar (30) not null, " +
                "lastname varchar (30) not null," +
                "age TINYINT not null)");
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            session.createSQLQuery(sql).executeUpdate();
            transaction.commit();
            session.close();

            System.out.println("Таблица готова");
        } catch (Exception e) {

        }


    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE  IF EXISTS userTable").executeUpdate();;
            transaction.commit();
            session.close();

            System.out.println("Table delete");
        } catch (Exception e) {
            System.out.println("Error");
        }


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(new User(name, lastName, age));
            transaction.commit();
        }
        System.out.println("User " + name + " created");

    }

    @Override
    public void removeUserById(long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :userId");
            query.setParameter("userId", id);
            query.executeUpdate();
            transaction.commit();
            System.out.println("User ID= " + id + " delete");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            userList = (List<User>) session.createQuery("From User").list();

            System.out.println("List created");

        }
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i));
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = sessionFactory.openSession()){

            Transaction transaction = session.beginTransaction();
            String HQL = "DELETE User";
            session.createQuery(HQL).executeUpdate();


        } catch (Exception e) {

        }


    }
}
