package ru.net.serbis.utils.param;

import android.view.*;

public abstract class TextParam<V extends View> extends Param<String, V>
{
    public TextParam(int nameId, String value)
    {
        super(nameId, value);
    }

    public TextParam(String name, String value, boolean stored)
    {
        super(name, value, stored);
    }

    @Override
    public String typeToString(String value)
    {
        return value;
    }

    @Override
    public String stringToType(String value)
    {
        return value;
    }
}
