package ru.net.serbis.utils;

public class Log
{
    public static void info(Object o, String message)
    {
        android.util.Log.i(o.getClass().getName(), message);
    }

    public static void error(Object o, String message, Throwable e)
    {
        android.util.Log.e(o.getClass().getName(), message, e);
    }
	
	public static void error(Object o, Throwable e)
    {
        error(o, "Error", e);
    }
}
