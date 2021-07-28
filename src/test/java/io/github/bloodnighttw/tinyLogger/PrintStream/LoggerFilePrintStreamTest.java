package io.github.bloodnighttw.tinyLogger.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class LoggerFilePrintStreamTest {

    File file = new File("test.txt");
    PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)),true);

    LoggerFilePrintStreamTest() throws FileNotFoundException {
    }

    @Test
    void FileCreateTest() {

        file.deleteOnExit();
        System.setOut(new LoggerFilePrintStream(System.out,ps));
        System.out.println(123);

    }

    @AfterEach
    void deleateTestFile(){
        ps.close();
    }

}