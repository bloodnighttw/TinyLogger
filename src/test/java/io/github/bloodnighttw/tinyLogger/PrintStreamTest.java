package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.Test;

public class PrintStreamTest {

    @Test
    public void file(){
        LoggerFactory.installLogger(true,false);
        Logger logger = LoggerFactory.getLogger("bign");
        logger.info("sss");
    }

}
