package ru.net.serbis.utils.param;

public class ListParam extends SpinnerParam<String>
{
    public ListParam(int nameId, String value, String[] values)
    {
        super(nameId, value, values);
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
