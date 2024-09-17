package ru.net.serbis.test.utils;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public class Main extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle state)
    {
        super.onCreate(state);
        setContentView(R.layout.main);
        TextView textView = UITool.get().findView(this, R.id.hello);
        textView.setOnClickListener(this);
    }
    
    @Override
    public void onClick(View view) 
    {
        if (R.id.hello == view.getId())
        {
            TextView textView = (TextView) view;
            String str1 = Strings.get().get(R.string.hello_app);
            String str2 = Strings.get().get(ru.net.serbis.utils.R.string.hello_lib);
            String cur = textView.getText().toString();
            cur = str1.equals(cur) ? str2 : str1;
            textView.setText(cur);
        }
    }
}
