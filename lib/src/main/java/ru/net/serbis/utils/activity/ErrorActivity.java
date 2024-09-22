package ru.net.serbis.utils.activity;

import android.content.*;
import android.os.*;
import ru.net.serbis.utils.*;
import android.app.*;

public abstract class ErrorActivity extends TextActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Throwable error = (Throwable) getIntent().getSerializableExtra(UtilsConstants.THROWABLE);
        edit.setText(SysTool.get().errorToText(error));
    }

    @Override
    protected void onOk()
    {
        Intent intent = new Intent(this, getActivityClass());
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        super.onOk();
    }

    protected abstract Class<? extends Activity> getActivityClass()
}
