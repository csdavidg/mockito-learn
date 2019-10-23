package com.david.learn.powermockito;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

import static junit.framework.TestCase.assertNotNull;

public class SuppressConstructor {

    @Test
    public void suppressOwnConstructorTest() throws Exception {

        SuppressConstructor nasty = Whitebox.newInstance(SuppressConstructor.class);
        assertNotNull(nasty);
    }

}
