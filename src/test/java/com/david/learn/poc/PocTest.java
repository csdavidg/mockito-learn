package com.david.learn.poc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.CombinableMatcher.either;

@RunWith(MockitoJUnitRunner.class)
public class PocTest {


    @Test
    public void verifyMatchers() {
        int age = 28;

        assertThat(age, equalTo(28));
        assertThat(age, is(28));
        assertThat(age, anyOf(equalTo(21), equalTo(22), equalTo(23), equalTo(24), equalTo(25), equalTo(26), equalTo(27), equalTo(28)));
        assertThat(age, not(equalTo(10)));

        assertThat(age, either(is(28)).or(is(30)));
    }

    @Test
    public void usingVerifyExecution(){

    }


}
