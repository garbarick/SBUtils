package ru.net.serbis.utils.adapter;

import android.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.bean.*;
import ru.net.serbis.utils.param.*;

public class ParamsAdapter
{
    private Activity context;
    private Map<Integer, Param> params = new HashMap<Integer, Param>();
    private Map<Integer, View> views = new HashMap<Integer, View>();

    public ParamsAdapter(Activity context, View parent, Param[] params)
    {
        this.context = context;
        int position = 0;
        for (Param param : params)
        {
            param.setContext(context);
            this.params.put(position, param);
            views.put(position, getView(param, parent, position));
            position ++;
        }
    }

    private View getView(Param param, View parent, int position)
    {
        LinearLayout layout = UITool.get().findView(parent, R.id.params);
        View view = param.getView(layout);
        layout.addView(view);
        return view;
    }

    public void saveValues()
    {
        for (Map.Entry<Integer, Param> entry : params.entrySet())
        {
            int position = entry.getKey();
            Param param = entry.getValue();
            View view = views.get(position);
            View viewValue = param.getViewValue(view);
            param.saveViewValue(viewValue);
        }
    }

    public View getView(Param param)
    {
        for (Map.Entry<Integer, Param> entry : params.entrySet())
        {
            if (entry.getValue() == param)
            {
                return views.get(entry.getKey());
            }
        }
        return null;
    }

    public void updateValue(Param param, Object value)
    {
        View view = getView(param);
        View viewValue = param.getViewValue(view);
        param.setValue(viewValue, value);
    }

    public void reset()
    {
        for (Param param: params.values())
        {
            param.saveValue(null);
        }
    }

    public Holder<Integer, String> getValues()
    {
        Holder<Integer, String> result = new Holder<Integer, String>();
        for (Map.Entry<Integer, Param> entry : params.entrySet())
        {
            int position = entry.getKey();
            Param param = entry.getValue();
            View view = views.get(position);
            View viewValue = param.getViewValue(view);
            String value = param.typeToString(param.getValue(viewValue));
            result.put(position, value);
        }
        return result;
    }

    public <T> T getValue(Param param)
    {
        View view = getView(param);
        View viewValue = param.getViewValue(view);
        return (T) param.getValue(viewValue);
    }

    public void setValues(Holder<Integer, String> values)
    {
        for (Map.Entry<Integer, String> entry : values.entrySet())
        {
            int position = entry.getKey();
            String value = entry.getValue();
            Param param = params.get(position);
            View view = views.get(position);
            View viewValue = param.getViewValue(view);
            param.setValue(viewValue, param.stringToType(value));
        }
    }

    public void deleteParam(String name)
    {
        for (Map.Entry<Integer, Param> entry : params.entrySet())
        {
            int position = entry.getKey();
            Param param = entry.getValue();
            if (name.equals(param.getName()))
            {
                View view = views.get(position);
                view.setVisibility(View.GONE);
            }
        }
    }
}
