package ru.net.serbis.utils.param;

import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public class TextViewParam extends TextParam<TextView>
{
    public TextViewParam(int nameId, String value)
    {
        super(nameId, value);
    }

    public TextViewParam(String name, String value, boolean stored)
    {
        super(name, value, stored);
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.param_text;
    }

    @Override
    public void initViewValue(View parent)
    {
        TextView view = getViewValue(parent);
        setValue(view, getValue());
    }

    @Override
    public void setValue(TextView view, String value)
    {
        view.setText(value);
    }

    @Override
    public String getValue(TextView view)
    {
        return view.getText().toString();
    }
}
