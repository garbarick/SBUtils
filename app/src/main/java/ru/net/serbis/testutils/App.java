package ru.net.serbis.testutils;

import android.app.*;
import android.content.*;
import ru.net.serbis.testutils.param.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.testutils.activity.*;

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
        Preferences.get().set(context);
        Preferences.get().setApp(Params.APP);
        ExceptionHandler.get().set(context);
        ExceptionHandler.get().setErrorActivity(ErrorReport.class);
    }
}
