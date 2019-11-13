package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalMethod.class)
public class FinalMethodTest {

    @Test
    public void stubbingPrivateFinalMethod() throws Exception {

        FinalMethod spyFinal = spy(new FinalMethod());
        when(spyFinal, "getPrivateFinalValue").thenReturn("value");
        assertEquals("Accessedvalue", spyFinal.getAccessToFinalMethod());
    }

    @Test
    public void stubbingFinalMethod() {
        FinalMethod mockFinal = mock(FinalMethod.class);
        when(mockFinal.getPublicFinalValue()).thenReturn("value");
        assertEquals("value", mockFinal.getPublicFinalValue());
    }

    @Test
    public void pruebas(){
        char[] prueba = {'h','e','l','l','o'};
        int n = 0;
        boolean condi = true;
        while(prueba[n] != '\0' && condi){
            n++;
            if(n == 10){
                condi = false;
            }
        }
    }
}
