package io.github.bloodnighttw.tinyLogger;

import sun.rmi.runtime.Log;

public final class LoggerFactory {

    /*  TODO (ESSENTIAL)
     *  1.Logger with different mode
     *  2.Log File
     *  3.Color text
     *  4.Group
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
    private static boolean logfile;

    public static void installLogger(boolean debug,boolean logfile){
        if(hasInstalled){
            logger.error("TinyLogger has been installed");
            return;
        }

        hasInstalled = true;
        System.setOut(new LoggerPrintStream(System.out));
        logger = LoggerFactory.getLogger("TinyLogger",debug);
    }

    public static Logger getLogger(String groupName,boolean debug){

        return new Logger(groupName,debug);
    }

}
