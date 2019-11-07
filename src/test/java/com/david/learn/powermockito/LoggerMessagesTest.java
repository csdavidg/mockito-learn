package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class, LoggerMessages.class})
public class LoggerMessagesTest {

    @Test
    public void logTest() {
        mockStatic(LoggerFactory.class);
        Logger logMock = mock(Logger.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(logMock);

        LoggerMessages sut = new LoggerMessages();
        sut.firstMessage();
        verify(logMock, times(1)).info(anyString());
    }

}
