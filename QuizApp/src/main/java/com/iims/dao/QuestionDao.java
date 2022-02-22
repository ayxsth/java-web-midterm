package com.iims.dao;

import com.iims.model.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDao {
    List<Question> getRandom10Questions() throws SQLException, ClassNotFoundException;
}
