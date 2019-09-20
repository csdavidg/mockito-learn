package com.david.learn.testdoubles.spy;

import com.david.learn.pojos.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentServiceTest {

    StudentService service = new StudentService();
    StudentServiceSpy spy = new StudentServiceSpy();

    @Test
    public void enrollsStudents() throws Exception {
        Student bob = new Student("001", "Bob Jungles");
        Student roy = new Student("002", "Roy Noon");

        service.setSpy(spy);

        service.enrollToCourse("English", bob);
        service.enrollToCourse("History", roy);

        assertEquals(2, spy.invocation("enrollToCourse"));

        List<Object> methodArguments = spy.arguments("enrollToCourse", 1)
                .getParams();

        List<Object> methodArguments2 = spy.arguments("enrollToCourse", 2)
                .getParams();

        assertEquals("English", methodArguments.get(0));
        assertEquals(bob, methodArguments.get(1));

        assertEquals("History", methodArguments2.get(0));
        assertEquals(roy, methodArguments2.get(1));

    }
}
