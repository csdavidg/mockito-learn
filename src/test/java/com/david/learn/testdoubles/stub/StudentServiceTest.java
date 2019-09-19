package com.david.learn.testdoubles.stub;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class StudentServiceTest {

    private StudentService studentService;

    @Test
    public void whenConnectionTimesOutThenTheStudentIsNotSaved() {
        studentService = new StudentServiceImpl(new ConnetionTimedOutStudentDAOStub());
        String classNine = "IX";
        String johnSmith = "john Smith";

        CreateStudentResponse response = studentService.create(johnSmith, classNine);
        assertFalse(response.isSuccess());
    }

}
