package ru.net.serbis.utils.param;

import android.text.*;
import android.view.*;
import java.text.*;
import java.util.*;

public abstract class DateTimeParam<V extends View> extends Param<Date, V>
{
    public DateTimeParam(int nameId, Date value)
    {
        super(nameId, value);
    }

    public DateTimeParam(String name, Date value, boolean stored)
    {
        super(name, value, stored);
    }

    @Override
    public String typeToString(Date value)
    {
        if (value == null)
        {
            return null;
        }
        return getFormat().format(value);
    }

    @Override
    public Date stringToType(String value)
    {
        if (TextUtils.isEmpty(value))
        {
            return null;
        }
        try
        {
            return getFormat().parse(value);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    protected SimpleDateFormat getFormat()
    {
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    }
}
