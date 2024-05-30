package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
   // private final UserDao userDaoJDBC;

   /* public UserServiceImpl(UserDao userDaoJDBC) {
        this.userDaoJDBC = userDaoJDBC;
    }*/

    public void createUsersTable() {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        System.out.println("Table has been created");
    }

    public void dropUsersTable() {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        userDaoJDBC.dropUsersTable();
        System.out.println("Table has been deleted");
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        userDaoJDBC.saveUser(name, lastName, age);
        System.out.println("User " + name + " added in database");

    }

    public void removeUserById(long id) {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        userDaoJDBC.removeUserById(id);

    }

    public List<User> getAllUsers() {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        List<User> users = userDaoJDBC.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public void cleanUsersTable() {
        UserDao userDaoJDBC=new UserDaoJDBCImpl();
        userDaoJDBC.cleanUsersTable();
        System.out.println("Table has been cleaned");
    }
}
