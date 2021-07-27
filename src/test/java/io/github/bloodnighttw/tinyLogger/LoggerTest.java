package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    // thank to https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut =System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void loggerInfoTest(){
        Logger logger = new Logger("Test",true);
        logger.info("test case #1");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.GREEN_BOLD+"INFO"+TextColor.RESET+"]:test case #1\n"));
    }

    @Test
    public void loggerWarmTest(){
        Logger logger = new Logger("Test",true);
        logger.warm("test case #2");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.YELLOW_BOLD+"WARM"+TextColor.RESET+"]:test case #2\n"));
    }


    @Test
    public void loggerDebugTrue(){

        Logger logger = new Logger("Test",true);
        logger.debug("test case #3");
        assertTrue(outContent.toString().contains("[Test]["+TextColor.CYAN_BOLD+"DEBUG"+TextColor.RESET+"]"));
    }

    @Test
    public void  loggerDebugFalse(){
        Logger logger = new Logger("Test",false);
        logger.debug("test case #4");
        assertEquals("",outContent.toString());

    }

    @Test
    public void loggerError(){
        Logger logger = new Logger("Test",true);
        logger.error("t");
        assertTrue(errContent.toString().contains("[Test]["+TextColor.RED_BOLD+"ERROR"+TextColor.RESET+"]:t\n"));
    }

}