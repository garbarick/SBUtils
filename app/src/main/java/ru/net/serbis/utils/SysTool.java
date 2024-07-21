package ru.net.serbis.utils;

import android.content.*;
import java.io.*;
import java.util.*;

public class SysTool extends Util
{
    private static final SysTool instance = new SysTool();

    public static SysTool get()
    {
        return instance;
    }

    public <T> T getService(String name)
    {
        return (T) context.getSystemService(name);
    }

    public void setClipBoard(int labelId, String text)
    {
        ClipboardManager clipboard = getService(Context.CLIPBOARD_SERVICE);
        String label = Strings.get().get(labelId);
        ClipData clip = ClipData.newPlainText(label, text);
        clipboard.setPrimaryClip(clip);
    }
    
    public String errorToText(Throwable error)
    {
        StringWriter writer = new StringWriter();
        error.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

    public Set<String> getSet(Collection data)
    {
        Set<String> result = new TreeSet<String>();
        for (Object item : data)
        {
            result.add(item.toString());
        }
        return result;
    }
}
