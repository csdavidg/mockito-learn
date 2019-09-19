package com.davi.learn.testdoubles.stub;

import com.david.learn.testdoubles.stub.StudentDAO;

import java.sql.SQLException;

public class ConnetionTimedOutStudentDAOStub implements StudentDAO {

    @Override
    public String create(String name, String className) throws SQLException{
        throw new SQLException("DB connection timed out");
    }

}
