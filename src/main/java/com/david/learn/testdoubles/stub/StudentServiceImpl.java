package com.david.learn.testdoubles.stub;

import com.david.learn.pojos.Student;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public CreateStudentResponse create(String name, String studentOfClass) {
        CreateStudentResponse response = null;
        try{
           String roleNum = studentDAO.create(name, studentOfClass);
           response = new CreateStudentResponse(null, new Student(roleNum, name));
        }catch (SQLException e){
            response = new CreateStudentResponse("SQL Exception" + e.getMessage(), null);
        }
        return response;
    }
}
