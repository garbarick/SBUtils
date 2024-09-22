package ru.net.serbis.testutils.activity;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.dialog.*;
import ru.net.serbis.testutils.param.*;

public class Main extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle state)
    {
        super.onCreate(state);
        setContentView(R.layout.main);
        LinearLayout main = UITool.get().findView(this, R.id.main);
        UITool.get().initAllButtons(main, this);
        new Permissions().initPermissions(this);
    }

    @Override
    public void onClick(View view) 
    {
        Button button = (Button) view;
        switch (view.getId())
        {
            case R.id.hello:
                hello(button);
                break;
                
            case R.id.params:
                new ParamsDialog(this, R.string.params, Params.PARAMS).show();
                break;
                
            case R.id.error:
                error(button);
                break;
        }
    }

    private void hello(Button button)
    {
        String str1 = Strings.get().get(R.string.hello);
        String str2 = Strings.get().get(ru.net.serbis.utils.R.string.hello_lib);
        String cur = button.getText().toString();
        cur = str1.equals(cur) ? str2 : str1;
        button.setText(cur);
    }

    private void error(Button button)
    {
        throw new RuntimeException("Error");
    }
}
