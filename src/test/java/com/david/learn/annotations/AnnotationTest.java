package com.david.learn.annotations;

import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Mock
    private Service service;

    @Test
    public void whenCAptorAnnotationIsUsed() {
        service.call(Arrays.asList("a", "b"));
        verify(service).call(captor.capture());
        assertTrue(captor.getValue().containsAll(Arrays.asList("a", "b")));
    }

}
