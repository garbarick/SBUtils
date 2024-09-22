package ru.net.serbis.utils;

import android.content.*;
import java.util.*;

public class Preferences extends Util
{
    private static final Preferences instance = new Preferences();
    private String app;

    public void setApp(String app)
    {
        this.app = app;
    }

    public static Preferences get()
    {
        return instance;
    }

    private SharedPreferences getPreferences()
    {
        return context.getSharedPreferences(app, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getPreferencesEditor()
    {
        return getPreferences().edit();
    }

    public void setString(String name, String value)
    {
        SharedPreferences.Editor editor = getPreferencesEditor();
        editor.putString(name, value);
        editor.commit();
    }

    public void setStringSet(String name, Set<String> value)
    {
        SharedPreferences.Editor editor = getPreferencesEditor();
        editor.putStringSet(name, value);
        editor.commit();
    }

    public String getString(String name, String value)
    {
        return getPreferences().getString(name, value);
    }

    public Set<String> getStringSet(String name)
    {
        return getStringSet(name, new TreeSet<String>());
    }

    public Set<String> getStringSet(String name, Set<String> value)
    {
        return new TreeSet<String>(getPreferences().getStringSet(name, value));
    }

    public String get(String name)
    {
        return getPreferences().getAll().get(name).toString();
    }

    public Collection<String> getNames()
    {
        return getPreferences().getAll().keySet();
    }
}
