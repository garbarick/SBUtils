package ru.net.serbis.testutils.activity;

import ru.net.serbis.utils.activity.*;
import android.app.*;

public class ErrorReport extends ErrorActivity
{
    @Override
    protected Class<? extends Activity> getActivityClass()
    {
        return Main.class;
    }
}
