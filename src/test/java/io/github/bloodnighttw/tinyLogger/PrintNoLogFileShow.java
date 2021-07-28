package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.Test;

public class PrintNoLogFileShow {

    @Test
    void print(){
        LoggerFactory.installLogger(false,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.info("test case #1");
        logger.warm("test case #2");
        logger.debug("test case #3");
        logger.error("text case #4");
    }

}
