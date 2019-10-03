package com.david.learn.testdoubles.mock;

import com.david.learn.pojos.Student;
import com.david.learn.testdoubles.spy.MethodInvocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<String, List<Student>> studentCourseMap = new HashMap<>();

    private StudentServiceMockObject mock;

    public void enrollToCourse(String courseName, Student student) {
        MethodInvocation invocation = new MethodInvocation();
        invocation.addParam(student).setMethod("enrollToCourse");
        mock.registerCall(invocation);

        List<Student> list = studentCourseMap.get(courseName);
        if (list == null) {
            list = new ArrayList<>();
        }

        if (!list.contains(student)) {
            list.add(student);
        }

        studentCourseMap.put(courseName, list);
    }

    public void setMock(StudentServiceMockObject mock) {
        this.mock = mock;
    }
}
