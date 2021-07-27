package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerPrintStreamTest {

    @Test
    public void printStreamTest(){
        System.setOut(new LoggerPrintStream(System.out));
        System.out.println("hello");
        System.out.println("si");
        System.out.println(1);
    }

}