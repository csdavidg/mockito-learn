package com.david.learn.testdoubles.stub;

import java.sql.SQLException;

public interface StudentDAO {

    public String create(String name, String className) throws SQLException;

}
