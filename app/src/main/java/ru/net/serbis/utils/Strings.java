package ru.net.serbis.utils;

public class Strings extends Util
{
    private static final Strings instance = new Strings();

    public static Strings get()
    {
        return instance;
    }

    public String get(int id)
    {
        return context.getResources().getString(id);
    }
}
