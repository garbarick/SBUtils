package ru.net.serbis.utils.param;

import android.app.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;
import ru.net.serbis.utils.listener.*;

public class EditDateParam extends DateTimeViewParam implements DatePickerDialog.OnDateSetListener
{
    private TextView textView;

    public EditDateParam(int nameId, Date value)
    {
        super(nameId, value);
    }

    public EditDateParam(String name, Date value, boolean stored)
    {
        super(name, value, stored);
    }

    @Override
    protected SimpleDateFormat getFormat()
    {
        return new SimpleDateFormat("yyyy.MM.dd");
    }

    @Override
    public void initViewValue(View parent)
    {
        super.initViewValue(parent);

        textView = getViewValue(parent);
        textView.setOnClickListener(
            new ViewOnClickListener<TextView>()
            {
                @Override
                public void onClickView(TextView view)
                {
                    Date date = getValue(view);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(date);
                    new DatePickerDialog(
                        context,
                        EditDateParam.this,
                        cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
                }
            }
        );
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        setValue(textView, cal.getTime());
    }
}
