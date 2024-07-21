package ru.net.serbis.utils;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.bean.*;

public class UITool extends Util
{
    private static final UITool instance = new UITool();
    private boolean progress;

    public static UITool get()
    {
        return instance;
    }

    public <T> T findView(View view, int id)
    {
        return (T) view.findViewById(id);
    }

    public <T> T findView(Activity view, int id)
    {
        return (T) view.findViewById(id);
    }
    
    public <T> T findView(AlertDialog view, int id)
    {
        return (T) view.findViewById(id);
    }

    public String getEditText(Activity activity, int id)
    {
        EditText text = findView(activity, id);
        return text.getText().toString();
    }

    public void hide(Activity activity, int id)
    {
        View view = findView(activity, id);
        view.setVisibility(View.GONE);
    }

    public void show(Activity activity, int id)
    {
        View view = findView(activity, id);
        view.setVisibility(View.VISIBLE);
    }

    public void enable(Activity activity, int id)
    {
        View view = findView(activity, id);
        enable(view);
    }

    public void enable(View view)
    {
        view.setEnabled(true);
    }

    public void disable(Activity activity, int id)
    {
        View view = findView(activity, id);
        disable(view);
    }

    public void disable(View view)
    {
        view.setEnabled(false);
    }

    public boolean isEnabled(Activity activity, int id)
    {
        View view = findView(activity, id);
        return isEnabled(view);
    }

    public boolean isEnabled(View view)
    {
        return view.isEnabled();
    }

    public void disableAll(View view)
    {
        setEnableAll(view, false);
    }

    public void enableAll(View view)
    {
        setEnableAll(view, true);
    }

    public void setEnableAll(View view, boolean enable)
    {
        view.setEnabled(enable);
        if (view instanceof ViewGroup)
        {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i ++)
            {
                View child = group.getChildAt(i);
                setEnableAll(child, enable);
            }
        }
    }

    public void toast(final String text)
    {
        new Handler(Looper.getMainLooper()).post(
            new Runnable()
            {
                public void run()
                {
                    Toast.makeText(context, text, Toast.LENGTH_LONG).show();
                }
            }
        );
    }

    public void toast(int textId)
    {
        toast(Strings.get().get(textId));
    }

    public void toast(int code, String text)
    {
        toast(code + ": " + text);
    }

    public void toast(TaskError error)
    {
        toast(error.getCode(), error.getMessage());
    }

    public void notImplementedYet()
    {
        toast("It is not implemented yet");
    }

    public int getPercent(long max, long cur)
    {
        Double percent = 100.0 / max * cur;
        return percent.intValue();
    }

    public void initButtons(Activity context, View.OnClickListener tool, int ... ids)
    {
        for (int id : ids)
        {
            View button = findView(context, id);
            button.setOnClickListener(tool);
        }
    }
    
    public void setProgress(boolean progress)
    {
        this.progress = progress;
    }
    
    public boolean isProgress()
    {
        return progress;
    }

    public <T> T getBundle(Bundle bundle, String key, T defaultValue)
    {
        if (bundle == null)
        {
            return defaultValue;
        }
        T value = (T) bundle.get(key);
        if (value == null)
        {
            return defaultValue;
        }
        return value;
    }
}
