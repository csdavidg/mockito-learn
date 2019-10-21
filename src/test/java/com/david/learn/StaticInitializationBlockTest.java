package com.david.learn;

import com.david.learn.powermockito.StaticInitializationBlock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StaticInitializationBlock.class, LoggerFactory.class })
//@SuppressStaticInitializationFor("com.david.learn.powermockito.StaticInitializationBlock")
public class StaticInitializationBlockTest {

    @Test
    public void supressesStaticInitializationBlocks() {
        assertEquals(0, StaticInitializationBlock.value);
    }

    @Test
    public void logTest() {
        mockStatic(LoggerFactory.class);
        Logger logMock = mock(Logger.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(logMock);

        StaticInitializationBlock sut = new StaticInitializationBlock();
        sut.write();
        verify(logMock, times(1)).info(anyString());
    }

}
