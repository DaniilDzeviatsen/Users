package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        UserDao userDao = new UserDaoJDBCImpl();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Petya", "Petrov", (byte) 19);
        userService.saveUser("Vasya", "Metrov", (byte) 22);
        userService.saveUser("Kostya", "Uetrov", (byte) 29);
        userService.saveUser("Zhenya", "Putov", (byte) 39);
        userService.removeUserById(3);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();// реализуйте алгоритм здесь
    }
}
