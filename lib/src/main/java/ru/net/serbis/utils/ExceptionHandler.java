package ru.net.serbis.utils;

import android.app.*;
import android.content.*;

public class ExceptionHandler extends Util implements Thread.UncaughtExceptionHandler
{
    private static final ExceptionHandler instance = new ExceptionHandler();
    private Class<? extends Activity> errorActivity;

    public static ExceptionHandler get()
    {
        return instance;
    }

    @Override
    public void set(Context context)
    {
        super.set(context);
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void setErrorActivity(Class<? extends Activity> errorActivity)
    {
        this.errorActivity = errorActivity;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable error) 
    {
        try
        {
            showReport(error);
        }
        catch (Exception e)
        {
            Log.error(this, e);
        }
    }

    private void showReport(Throwable error)
    {
        Intent intent = new Intent(context, errorActivity);
        intent.putExtra(UtilsConstants.THROWABLE, error);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        stop();
    }

    private void stop()
    {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(10);
    }
}
