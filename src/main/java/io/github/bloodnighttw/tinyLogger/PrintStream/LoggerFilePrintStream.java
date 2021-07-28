package io.github.bloodnighttw.tinyLogger.PrintStream;

import java.io.PrintStream;
import java.util.Locale;

public class LoggerFilePrintStream extends LoggerPrintStream{

    private final PrintStream fileOutputStream;

    public LoggerFilePrintStream(PrintStream originalPrintStream1,PrintStream fileOutputStream) {
        super(originalPrintStream1);
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        fileOutputStream.printf(l,format,args);
        return super.printf(l, format, args);
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        fileOutputStream.print(String.format(format,args).replaceAll("\u001B\\[[\\d;]*[^\\d;]",""));
        return super.printf(format, args);
    }
}
