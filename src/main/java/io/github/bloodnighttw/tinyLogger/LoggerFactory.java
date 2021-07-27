package io.github.bloodnighttw.tinyLogger;

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

    public static Logger getLogger(String groupName,boolean debug){
        return new Logger(groupName,debug);
    }

}
