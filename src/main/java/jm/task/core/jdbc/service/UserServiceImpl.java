package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaoJDBC;

    public UserServiceImpl(UserDao userDaoJDBC) {
        this.userDaoJDBC = userDaoJDBC;
    }

    @Override
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
        System.out.println("Table has been created");
    }

    @Override
    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
        System.out.println("Table has been deleted");
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
        System.out.println("User " + name + " added in database");
    }

    @Override
    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDaoJDBC.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
        System.out.println("Table has been cleaned");
    }
}
