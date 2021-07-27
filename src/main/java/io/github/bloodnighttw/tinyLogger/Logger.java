package io.github.bloodnighttw.tinyLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private final String groupName;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final String format = "[%s][%s][%s]:%s\n";
    private final boolean debug;

    protected Logger(String groupName,boolean debug) {
        this.groupName = groupName;
        this.debug = debug;
    }

    public void info(String st){
        String INFO = TextColor.GREEN_BOLD + "INFO" + TextColor.RESET;
        System.out.printf(format,simpleDateFormat.format(new Date()),groupName, INFO,st);
    }

    public void debug(String st){
        String DEBUG = TextColor.CYAN_BOLD + "DEBUG" + TextColor.RESET;
        if(debug)
            System.out.printf(format,simpleDateFormat.format(new Date()),groupName, DEBUG,st);

    }

    public void warm(String st){
        String WARM = TextColor.YELLOW_BOLD + "WARM" + TextColor.RESET;
        System.out.printf(format,simpleDateFormat.format(new Date()),groupName, WARM,st);
    }

    public void error(String st){
        String ERROR = TextColor.RED_BOLD + "ERROR" + TextColor.RESET;
        System.err.printf(format,simpleDateFormat.format(new Date()),groupName, ERROR,st);
    }

}
