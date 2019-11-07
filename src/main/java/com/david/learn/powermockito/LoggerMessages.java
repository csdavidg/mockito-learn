package com.david.learn.powermockito;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMessages {

    private final static Logger LOG = LoggerFactory.getLogger(LoggerMessages.class);

    public void firstMessage() {
        LOG.info("This is the first message");
    }
}
