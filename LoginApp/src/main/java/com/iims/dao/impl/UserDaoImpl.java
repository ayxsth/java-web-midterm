package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.UserDao;
import com.iims.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findOne(String username, String password) throws SQLException, ClassNotFoundException {
        final String QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            return new User(firstName, lastName, username);
        }

        return null;
    }
}
