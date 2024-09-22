package ru.net.serbis.utils.activity;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public class TextActivity extends Activity implements View.OnClickListener
{
    protected EditText edit;
    
    @Override
    protected void onCreate(Bundle state)
    {
        super.onCreate(state);
        setContentView(R.layout.text);

        edit = UITool.get().findView(this, R.id.text);
        edit.setKeyListener(null);
        edit.setTextIsSelectable(true);

        initTitle();
        UITool.get().initButtons(this, this, R.id.ok, R.id.cancel);
    }

    protected void initTitle()
    {
        Intent intent = getIntent();
        if (intent.hasExtra(UtilsConstants.TITLE))
        {
            String title = intent.getStringExtra(UtilsConstants.TITLE);
            setTitle(title);
        }
    }

    @Override
    public void onClick(View view)
    {
        if (R.id.ok == view.getId())
        {
            onOk();
        }
        else if (R.id.cancel == view.getId())
        {
            onCancel();
        }
    }

    protected void onOk()
    {
        finish();
    }

    protected void onCancel()
    {
        finish();
    }
}
