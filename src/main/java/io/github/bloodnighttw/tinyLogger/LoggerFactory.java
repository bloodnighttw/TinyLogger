package io.github.bloodnighttw.tinyLogger;

import io.github.bloodnighttw.tinyLogger.PrintStream.LoggerFilePrintStream;
import io.github.bloodnighttw.tinyLogger.PrintStream.LoggerPrintStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class LoggerFactory {

    /*  TODO (ESSENTIAL)
     *  1.Logger with different mode [DONE]
     *  2.Log File [Done]
     *  3.Color text [DONE]
     *  4.Group [DONE]
     *
     *  Text Field:
     *      [YYYY/MM/DD HH:mm:ss][$GroupName][$Type]:$Content\n
     *
     */

    /*  TODO BUT NOT ESSENTIAL
     *  1.Error to Logger.Error()
     *  2.Custom Text Field
     *  3.Progress bar
     */

    private static boolean hasInstalled = false;
    private static Logger logger ;
    private static boolean debug;

    public static void installLogger(boolean debug2,boolean logfile1){
        if(hasInstalled){
            logger.error("TinyLogger has been installed");
            return;
        }

        debug = debug2;
        hasInstalled = true;


        if(logfile1) {
            File file = new File(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date())+".log");
            try {
                System.setOut(new LoggerFilePrintStream(System.out, new PrintStream(new BufferedOutputStream(new FileOutputStream(file)), true)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        else
            System.setOut(new LoggerPrintStream(System.out));
        logger = LoggerFactory.getLogger("TinyLogger");
    }

    public static Logger getLogger(String groupName){
        //logger.info(String.valueOf(debug));
        return new Logger(groupName,debug);
    }

}
