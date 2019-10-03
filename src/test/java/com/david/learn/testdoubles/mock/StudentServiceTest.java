package com.david.learn.testdoubles.mock;

import com.david.learn.pojos.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {

    StudentService service = new StudentService();
    StudentServiceMockObject mockObject = new StudentServiceMockObject();

    @Test
    public void enrollsStudents() throws Exception{
        Student bob = new Student("001", "Robert Anthony");
        Student roy = new Student("002", "Roy Noon");

        service.setMock(mockObject);

        service.enrollToCourse("english", bob);
        service.enrollToCourse("history", roy);

        assertEquals(2, mockObject.invocation("enrollToCourse"));
        mockObject.verify("enrollToCourse", 1);
    }

}
