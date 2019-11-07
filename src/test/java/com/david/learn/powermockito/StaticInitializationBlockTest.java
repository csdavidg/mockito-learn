package com.david.learn.powermockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.david.learn.powermockito.StaticInitializationBlock")
public class StaticInitializationBlockTest {

    @Test
    public void supressesStaticInitializationBlocks() {
        assertEquals(0, StaticInitializationBlock.value);
    }


}
