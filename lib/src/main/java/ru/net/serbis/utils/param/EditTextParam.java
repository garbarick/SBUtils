package ru.net.serbis.utils.param;

import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public class EditTextParam extends TextParam<EditText>
{
    public EditTextParam(int nameId, String value)
    {
        super(nameId, value);
    }

    public EditTextParam(String name, String value, boolean stored)
    {
        super(name, value, stored);
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.param_edit;
    }

    @Override
    public void initViewValue(View parent)
    {
        EditText view = getViewValue(parent);
        setValue(view, getValue());
    }

    @Override
    public void setValue(EditText view, String value)
    {
        view.setText(value);
    }

    @Override
    public String getValue(EditText view)
    {
        return view.getText().toString();
    }
}
