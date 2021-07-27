package io.github.bloodnighttw.tinyLogger;

public final class LoggerFactory {

    /*  TODO (ESSENTIAL)
     *  1.Logger with different mode [DONE]
     *  2.Log File
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
    private static boolean logfile;

    public static void installLogger(boolean debug2,boolean logfile1){
        if(hasInstalled){
            logger.error("TinyLogger has been installed");
            return;
        }

        debug = debug2;
        logfile = logfile1;
        hasInstalled = true;
        System.setOut(new LoggerPrintStream(System.out));
        logger = LoggerFactory.getLogger("TinyLogger");
    }

    public static Logger getLogger(String groupName){
        return new Logger(groupName,debug);
    }

}
