package com.david.learn.argumentcaptor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock
    private Service service;

    @Test
    public void whenCapturesCollections() throws Exception {
        Class<List<String>> listClass = (Class<List<String>>) (Class) List.class;
        ArgumentCaptor<List<String>> captor = ArgumentCaptor.forClass(listClass);

        service.call(Arrays.asList("a", "b", "c"));

        verify(service).call(captor.capture());
        assertTrue(captor.getValue().containsAll(Arrays.asList("a", "b")));

    }


}
