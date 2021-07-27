package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerFactoryTest {

    // thank to https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void loggerInfoTest(){
        LoggerFactory.installLogger(true,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.info("test case #1");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.GREEN_BOLD+"INFO"+TextColor.RESET+"]:test case #1\n"));
    }

    @Test
    public void loggerWarmTest(){
        LoggerFactory.installLogger(true,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.warm("test case #2");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.YELLOW_BOLD+"WARM"+TextColor.RESET+"]:test case #2\n"));
    }

    @Test
    public void loggerDebugTrue(){
        LoggerFactory.installLogger(true,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.debug("test case #3");

        //originalOut.println(outContent.toString());
        assertTrue(outContent.toString().contains("[Test]["+TextColor.CYAN_BOLD+"DEBUG"+TextColor.RESET+"]"));
    }

    @Test
    public void loggerDebugFalse(){
        LoggerFactory.installLogger(false,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.debug("test case #4");
        assertEquals("", outContent.toString());
    }

    @Test
    public void loggerError(){
        LoggerFactory.installLogger(true,false);
        Logger logger = LoggerFactory.getLogger("Test");
        logger.error("t");
        assertTrue(errContent.toString().contains("[Test]["+TextColor.RED_BOLD+"ERROR"+TextColor.RESET+"]:t\n"));
    }



    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}