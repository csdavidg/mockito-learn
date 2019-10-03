package com.david.learn.testdoubles.fake;

import com.david.learn.pojos.Student;

import java.util.List;

public interface StudentDao {

    public void batchUpdate(List<Student> students);
}
