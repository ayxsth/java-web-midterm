package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.QuestionDao;
import com.iims.model.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public List<Question> getRandom10Questions() throws SQLException, ClassNotFoundException {
        final String QUERY = "SELECT * FROM quiz ORDER BY RAND() LIMIT 10";
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(QUERY);

        List<Question> questions = new ArrayList<>();

        while (resultSet.next()){
            Question question = new Question();
            question.setId(resultSet.getInt("id"));
            question.setQuestion(resultSet.getString("question"));
            question.setAnsOne(resultSet.getString("ansOne"));
            question.setAnsTwo(resultSet.getString("ansTwo"));
            question.setAnsThree(resultSet.getString("ansThree"));
            question.setCorrectAns(resultSet.getString("correctAns"));
            questions.add(question);
        }

        return questions;
    }
}
