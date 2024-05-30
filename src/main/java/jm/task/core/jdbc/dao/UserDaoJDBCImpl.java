package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Util util;

    public UserDaoJDBCImpl(Util util) {

        this.util = util;
    }

    public void createUsersTable() {
        String sql = """
                CREATE TABLE users(
                     id bigint primary key,
                     name varchar(40),
                     lastname varchar(40),
                     age int
                 );
                """;
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = """
                DROP TABLE users;
                 """;
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table was deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = """
                INSERT INTO users 
                (name, lastname, age)
                VALUES (?, ?, ?);
                """;
        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User " + name + " added in database");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = """
                DELETE  FROM users
                WHERE users.id=?;
                """;

        try (
                Connection connection = util.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = """
                SELECT
                users.name AS name,
                users.lastname AS lastname,
                users.age AS age
                FROM users
                      """;
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<User> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getByte("age")
                ));
            }
            for (User user : result) {
                System.out.println(user);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void cleanUsersTable() {
        String sql = """
                TRUNCATE TABLE users;
                """;
        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table was cleaned");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
