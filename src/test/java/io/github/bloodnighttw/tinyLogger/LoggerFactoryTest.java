package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerFactoryTest {

    // thank to https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void loggerInfoTest(){
        Logger logger = LoggerFactory.getLogger("Test",true);
        logger.info("test case #1");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.GREEN_BOLD+"INFO"+TextColor.RESET+"]:test case #1\n"));
    }

    @Test
    public void loggerWarmTest(){
        Logger logger = LoggerFactory.getLogger("Test",true);
        logger.warm("test case #2");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.YELLOW_BOLD+"WARM"+TextColor.RESET+"]:test case #2\n"));
    }

    @Test
    public void loggerDebugTrue(){
        Logger logger = LoggerFactory.getLogger("Test",true);
        logger.debug("test case #3");

        assertTrue(outContent.toString().contains("[Test]["+TextColor.CYAN_BOLD+"DEBUG"+TextColor.RESET+"]:test case #3\n"));
    }

    @Test
    public void loggerDebugFalse(){
        Logger logger = LoggerFactory.getLogger("Test",false);
        logger.debug("test case #4");
        assertTrue(outContent.toString().equals(""));
    }

    @Test
    public void loggerError(){
        Logger logger = LoggerFactory.getLogger("Test",false);
        logger.debug("test case #5");

        assertTrue(errContent.toString().equals("[Test][ERROR]:test case #5\n"));
    }



    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}