package ru.net.serbis.test.utils;

import android.app.Application;
import android.content.Context;
import ru.net.serbis.utils.*;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        Context context = getApplicationContext();
        init(context);
    }

    public void init(Context context)
    {
        Strings.get().set(context);
        UITool.get().set(context);
    }
}
