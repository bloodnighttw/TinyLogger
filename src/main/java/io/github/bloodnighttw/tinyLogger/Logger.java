package io.github.bloodnighttw.tinyLogger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private String groupName;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final String format = "[%s][%s][%s]:%s\n";
    private final String INFO = TextColor.GREEN_BOLD+"INFO"+TextColor.RESET;
    private final String WARM = TextColor.YELLOW_BOLD+"WARM"+TextColor.RESET;
    private final String ERROR = "ERROR";
    private final String DEBUG = TextColor.CYAN_BOLD+"DEBUG"+TextColor.RESET;
    private final boolean debug;

    public Logger(String groupName,boolean debug) {
        this.groupName = groupName;
        this.debug = debug;
    }

    public void info(String st){
        System.out.printf(format,simpleDateFormat.format(new Date()),groupName,INFO,st);
    }

    public void debug(String st){
        if(debug)
            System.out.printf(format,simpleDateFormat.format(new Date()),groupName,DEBUG,st);

    }

    public void warm(String st){
        System.out.printf(format,simpleDateFormat.format(new Date()),groupName,WARM,st);
    }

    public void error(String st){
        System.err.printf(format,simpleDateFormat.format(new Date()),groupName,ERROR,st);
    }

}
