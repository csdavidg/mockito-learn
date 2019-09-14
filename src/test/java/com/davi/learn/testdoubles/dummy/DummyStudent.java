package com.davi.learn.testdoubles.dummy;

import com.david.learn.pojos.Student;

public class DummyStudent extends Student {

    public DummyStudent() {
        super(null, null);
    }

    @Override
    public String getRoleNumber() {
        throw new RuntimeException("Dummy Student");
    }

    @Override
    public String getName() {
        throw new RuntimeException("Dummy Student");
    }
}
