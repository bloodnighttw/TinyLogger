package io.github.bloodnighttw.tinyLogger;

import java.io.PrintStream;
import java.util.Locale;

public class LoggerPrintStream extends PrintStream {

    private final PrintStream originalPrintStream;
    private final Logger logger;


    public LoggerPrintStream(PrintStream originalPrintStream1) {
        super(originalPrintStream1);
        this.originalPrintStream = originalPrintStream1;
        logger = LoggerFactory.getLogger("STDOUT");
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        return originalPrintStream.printf(format, args);
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return originalPrintStream.printf(l, format, args);
    }

    @Override
    public void print(Object obj) {
        logger.info(String.valueOf(obj));
    }

    @Override
    public void print(String s) {
        logger.info(s);
    }

    @Override
    public void print(double d) {
        logger.info(String.valueOf(d));
    }

    @Override
    public void print(char[] s) {
        logger.info(new String(s));
    }

    @Override
    public void print(float f) {
        logger.info(String.valueOf(f));
    }

    @Override
    public void print(long l) {
        logger.info(String.valueOf(l));
    }

    @Override
    public void print(char c) {
        logger.info(String.valueOf(c));
    }

    @Override
    public void print(int i) {
        logger.info(String.valueOf(i));
    }

    @Override
    public void print(boolean b) {
        logger.info(String.valueOf(b));
    }

    @Override
    public void println(String x) {
        logger.info(x);
    }

    @Override
    public void println(boolean x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(Object x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(double x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(char[] x) {
        logger.info(new String(x));
    }

    @Override
    public void println(float x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(char x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(int x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println(long x) {
        logger.info(String.valueOf(x));
    }

    @Override
    public void println() {
        logger.info("");
    }
}
