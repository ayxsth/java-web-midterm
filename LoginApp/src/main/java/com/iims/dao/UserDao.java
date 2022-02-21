package com.iims.dao;

import com.iims.models.User;

import java.sql.SQLException;

public interface UserDao {
    User findOne(String username, String password) throws SQLException, ClassNotFoundException;
}
