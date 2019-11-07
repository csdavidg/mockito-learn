package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivateMethod.class)
public class PrivateMethodTest {

    @Test
    public void stubbingPrivateMethodTest() throws Exception {

        PrivateMethod spyPm = spy(new PrivateMethod());
        when(spyPm, "getSecretValue").thenReturn("123");
        assertEquals("123", spyPm.exposeSecretValue());
    }
}
