package com.filedownload.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Created by kson on 2017/7/3.
 */

public class Logger {
    public static final boolean DEBUG = true;

    public static void debug(String tag,String msg){
        if (DEBUG){
            Log.d(tag,msg);
        }
    }
    public static void debug(String tag,String msg,Object ... args){
        if (DEBUG){
            Log.d(tag,String.format(Locale.getDefault(),msg,args));
        }
    }

    public static void error(String tag,String msg){
        if (DEBUG){
            Log.e(tag,msg);
        }
    }
    public static void info(String tag,String msg){
        if (DEBUG){
            Log.i(tag,msg);
        }
    }
    public static void warn(String tag,String msg){
        if (DEBUG){
            Log.w(tag,msg);
        }
    }

}
