package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.util.UtilHibernate;

import java.awt.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
            userService.createUsersTable();
            userService.saveUser("Santa", "Klaus", (byte)98);
        userService.saveUser("SantaOne", "Barbara", (byte)120);
        userService.saveUser("Anna", "Red", (byte)38);
        userService.saveUser("Serje", "Golon", (byte)24);

        userService.removeUserById(2);
        List <User> usersList = userService.getAllUsers();
         userService.cleanUsersTable();
            userService.dropUsersTable();
        UtilHibernate.getSessionFactory().close();

        // реализуйте алгоритм здесь
    }
}
