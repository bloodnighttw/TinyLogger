package io.github.bloodnighttw.tinyLogger;

import org.junit.jupiter.api.Test;

class LoggerPrintStreamShow {

    @Test
    public void printStreamTest(){
        LoggerFactory.installLogger(true,true);
        System.out.println("hello");
        System.out.print("hello");
        System.out.println(1);
        System.out.print(1);
        System.out.println(true);
    }

}