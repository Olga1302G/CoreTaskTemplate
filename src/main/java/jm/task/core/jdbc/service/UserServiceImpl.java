package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;



public class UserServiceImpl implements UserService {
   private UserDao implementor = new UserDaoJDBCImpl();

    public void createUsersTable() {
        implementor.createUsersTable();
    }

    public void dropUsersTable() {
        implementor.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        implementor.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        implementor.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return implementor.getAllUsers();
    }

    public void cleanUsersTable() {
        implementor.cleanUsersTable();
    }
}
