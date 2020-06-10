package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl extends Util implements UserDao {


    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() throws SQLException {


    }

    @Override
    public void dropUsersTable() throws SQLException {


    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {


    }

    @Override
    public void removeUserById(long id) throws SQLException {


    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return null;
    }

    @Override
    public void cleanUsersTable() throws SQLException {


    }
}
