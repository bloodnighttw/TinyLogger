package io.github.bloodnighttw.tinyLogger;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebugFalseTest {



    @Test
    public void loggerDebugFalse(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream org = System.out;
        System.setOut(new PrintStream(outContent));
        LoggerFactory.installLogger(false,false);
        Logger logger = LoggerFactory.getLogger("Test");
        org.println(outContent);
        logger.debug("test case #4");

        assertEquals("", outContent.toString());
    }
}
