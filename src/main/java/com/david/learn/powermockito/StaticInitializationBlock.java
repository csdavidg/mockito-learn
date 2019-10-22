package com.david.learn.powermockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StaticInitializationBlock {

    public static int value;

    /*static {
        value = 100 / 0;
        System.out.println("In static block");
    }*/

    public static Logger LOG = LoggerFactory.getLogger(StaticInitializationBlock.class);

    public void write() {
        LOG.info("Write");
    }

}
