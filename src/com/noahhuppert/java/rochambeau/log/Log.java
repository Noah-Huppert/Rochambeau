package com.noahhuppert.java.rochambeau.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noah Huppert on 9/22/2014.
 */
public class Log {
    public static final String TAG_PREFIX = "com.noahhuppert.java.rochambeau";
    /* Log Tags */
    public static final String TAG_INFO             = "        Info";
    public static final String TAG_DEBUG            = "        Debug";
    public static final String TAG_ERROR            = "        ERROR";
    public static final String TAG_SOCKET_SERVER    = "Socket Server";
    public static final String TAG_SOCKET_CLIENT    = "Socket Client";
    public static final String TAG_GAME             = "         Game";

    /* Modes */
    public static final String MODE_DEBUG = "MODE_DEBUG";
    public static final String MODE_SOFT_DEBUG = "MODE_SOFT_DEBUG";
    public static final String MODE_PRODUCTION = "MODE_PRODUCTION";
    public static final String MODE_SOFT_PRODUCTION = "MODE_SOFT_PRODUCTION";

    public static List<LogTag> logTags = new ArrayList<LogTag>();

    public static void addDefaultLogTags(){
        Log.addTag(new LogTag(TAG_INFO));

        Log.addTag(new LogTag(TAG_DEBUG));

        Log.addTag(new LogTag(TAG_ERROR));

        Log.addTag(new LogTag(TAG_SOCKET_SERVER));

        Log.addTag(new LogTag(TAG_SOCKET_CLIENT));

        Log.addTag(new LogTag(TAG_GAME));
    }

    public static void log(String message, String logTagName){
        Log.addDefaultLogTags();

        LogTag logTag = Log.findTag(logTagName);

        Log.printLog(message, logTag);
    }

    public static void log(String message){
        Log.addDefaultLogTags();

        LogTag logTag = Log.findTag(Log.TAG_INFO);

        Log.printLog(message, logTag);
    }

    public static void rLog(String message, String logTagName){
        Log.addDefaultLogTags();

        LogTag logTag = Log.findTag(logTagName);

        Log.rewrite(message, logTag);
    }

    public static void rLog(String message){
        Log.addDefaultLogTags();

        LogTag logTag = Log.findTag(Log.TAG_INFO);

        Log.rewrite(message, logTag);
    }

    public static void divider(String title){
        System.out.println("********************  " + title + "  ********************");
    }

    public static void divider(){
        System.out.println("****************************************");
    }

    public static void rewrite(String message, LogTag logTag){
        if(logTag != null && logTag.getEnabled()){
            if(logTag.getName().equals(Log.TAG_GAME)){
                System.out.print("\r" + message);
            } else{
                System.out.print("\r" + TAG_PREFIX + "   " + logTag.getName() + ":       " + message);
            }
        }
    }

    public static void printLog(String message, LogTag logTag){
        if(logTag != null && logTag.getEnabled()){
            if(logTag.getName().equals(Log.TAG_GAME)){
                System.out.println(message);
            } else {
                System.out.println(TAG_PREFIX + "   " + logTag.getName() + ":       " + message);
            }
        }
    }

    public static LogTag findTag(String logTagName){
        LogTag logTag = null;

        for(LogTag tag : logTags){
            if(tag != null && tag.getName().equals(logTagName)){
                logTag = tag;
            }
        }

        return logTag;
    }

    public static void setTag(String logTagName, boolean enabled){
        LogTag logTag = Log.findTag(logTagName);

        if(logTag != null){
            logTag.setEnabled(enabled);
        }
    }

    public static void enable(String logTagName){
        Log.setTag(logTagName, true);
    }

    public static void disable(String logTagName){
        Log.setTag(logTagName, false);
    }

    public static void addTag(LogTag logTag){
        if(Log.findTag(logTag.getName()) == null){
            Log.logTags.add(logTag);
        }
    }

    public static void mode(String mode){
        Log.addDefaultLogTags();

        if(mode.equals(Log.MODE_DEBUG)){
            Log.setTag(Log.TAG_INFO, true);
            Log.setTag(Log.TAG_SOCKET_SERVER, true);
            Log.setTag(Log.TAG_SOCKET_CLIENT, true);
            Log.setTag(Log.TAG_ERROR, true);
            Log.setTag(Log.TAG_DEBUG, true);
            Log.setTag(Log.TAG_GAME, true);
        } else if(mode.equals(Log.MODE_SOFT_DEBUG)){
            Log.setTag(Log.TAG_INFO, true);
            Log.setTag(Log.TAG_SOCKET_SERVER, false);
            Log.setTag(Log.TAG_SOCKET_CLIENT, false);
            Log.setTag(Log.TAG_ERROR, true);
            Log.setTag(Log.TAG_DEBUG, true);
            Log.setTag(Log.TAG_GAME, true);
        } else if(mode.equals(Log.MODE_SOFT_PRODUCTION)){
            Log.setTag(Log.TAG_INFO, true);
            Log.setTag(Log.TAG_SOCKET_SERVER, false);
            Log.setTag(Log.TAG_SOCKET_CLIENT, false);
            Log.setTag(Log.TAG_ERROR, true);
            Log.setTag(Log.TAG_DEBUG, false);
            Log.setTag(Log.TAG_GAME, true);
        } else if(mode.equals(Log.MODE_PRODUCTION)){
            Log.setTag(Log.TAG_INFO, false);
            Log.setTag(Log.TAG_SOCKET_SERVER, false);
            Log.setTag(Log.TAG_SOCKET_CLIENT, false);
            Log.setTag(Log.TAG_ERROR, true);
            Log.setTag(Log.TAG_DEBUG, false);
            Log.setTag(Log.TAG_GAME, true);
        }
    }
}
