package ru.net.serbis.utils;

import android.app.*;
import android.content.*;

public class Util
{
    protected Context context;
    protected Application app;

    public void set(Context context)
    {
        this.context = context;
        app = (Application) context.getApplicationContext();
    }

    public <T> T getApp()
    {
        return (T) app;
    }
}
