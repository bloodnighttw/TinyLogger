package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;

public class PrintTest {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final String format = "[%s][%s][%s]:%s\n";

    @Test
    void print(){
        Logger logger = LoggerFactory.getLogger("Test",true);
        logger.info("test case #1");
        logger.warm("test case #2");
        logger.debug("test case #3");
        logger.error("text case #4");
    }

}
