package com.david.learn.testdoubles.spy;

import com.david.learn.pojos.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<String, List<Student>> studentCourseMap = new HashMap<>();

    private StudentServiceSpy spy;

    public void enrollToCourse(String courseName, Student student) {
        MethodInvocation invocation = new MethodInvocation();
        invocation.addParam(courseName).addParam(student).setMethod("enrollToCourse");
        spy.registerCall(invocation);

        List<Student> list = studentCourseMap.get(courseName);

        if (list == null) {
            list = new ArrayList<>();
        }

        if (!list.contains(student)) {
            list.add(student);
        }

        studentCourseMap.put(courseName, list);

    }

    public void setSpy(StudentServiceSpy spy) {
        this.spy = spy;
    }

}
