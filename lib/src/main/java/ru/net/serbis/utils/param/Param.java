package ru.net.serbis.utils.param;

import android.app.*;
import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public abstract class Param<T, V extends View>
{
    protected String name;
    protected int nameId;
    protected T value;
    protected Activity context;
    protected boolean stored;

    private Param(int nameId, String name, T value, boolean stored)
    {
        this.nameId = nameId;
        this.name = name;
        this.value = value;
        this.stored = stored;
    }

    public Param(int nameId, T value, boolean stored)
    {
        this(nameId, null, value, stored);
    }

    public Param(int nameId, T value)
    {
        this(nameId, value, true);
    }

    public Param(String name, T value, boolean stored)
    {
        this(0, name, value, stored);
    }

    public Param(String name, T value)
    {
        this(name, value, true);
    }

    public String getName()
    {
        if (nameId == 0)
        {
            return name;
        }
        return Strings.get().get(nameId);
    }

    public View getView(ViewGroup parent)
    {
        View view = LayoutInflater.from(context).inflate(getLayoutId(), parent, false);
        initNameView(view);
        initViewValue(view);
        return view;
    }

    public abstract int getLayoutId();

    protected void initNameView(View parent)
    {
        TextView view = UITool.get().findView(parent, R.id.name);
        view.setText(getName());
    }

    protected abstract void initViewValue(View parent);

    public V getViewValue(View parent)
    {
        return UITool.get().findView(parent, R.id.value);
    }

    public void saveValue(T value)
    {
        if (stored)
        {
            String data = value == null ? null : typeToString(value);
            Preferences.get().setString(getName(), data);
        }
    }

    public abstract String typeToString(T value);

    public T getValue()
    {
        if (stored)
        {
            return stringToType(Preferences.get().getString(getName(), typeToString(value)));
        }
        return value;
    }

    public abstract T stringToType(String value);

    public void saveViewValue(V view)
    {
        T value = getValue(view);
        saveValue(value);
    }

    public abstract void setValue(V view, T value);
    public abstract T getValue(V view);

    public void setContext(Activity context)
    {
        this.context = context;
    }
}
