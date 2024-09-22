package ru.net.serbis.utils.param;

import android.view.*;
import android.widget.*;
import java.util.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.dialog.*;
import ru.net.serbis.utils.listener.*;

public class StringsParam extends Param<Set<String>, Button>
{
    protected Set<String> values;

    public StringsParam(int nameId)
    {
        super(nameId, new TreeSet<String>());
    }

    public StringsParam(String name)
    {
        super(name, new TreeSet<String>());
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.param_button;
    }

    @Override
    public void initViewValue(View parent)
    {
        Button view = getViewValue(parent);
        setValue(view, getValue());
        initClick(view);
    }

    @Override
    public Set<String> getValue()
    {
        if (stored)
        {
            return Preferences.get().getStringSet(getName());
        }
        return value;
    }

    @Override
    public void saveValue(Set<String> value)
    {
        if (stored)
        {
            Preferences.get().setStringSet(getName(), value);
        }
    }

    @Override
    public String typeToString(Set<String> value)
    {
        return JsonTool.get().toJsonString(value);
    }

    @Override
    public Set<String> stringToType(String value)
    {
        return JsonTool.get().toSet(value);
    }

    @Override
    public void setValue(Button button, Set<String> values)
    {
        this.values = values;
        button.setText(Strings.get().get(R.string.edit_values_, values.size()));
    }

    @Override
    public Set<String> getValue(Button view)
    {
        return values;
    }

    protected void initClick(Button view)
    {
        view.setOnClickListener(
            new ViewOnClickListener<Button>()
            {
                @Override
                public void onClickView(final Button view)
                {
                    new StringsDialog(context, getValue(view))
                    {
                        @Override
                        public void updateValues(Set<String> values)
                        {
                            setValue(view, values);
                        }
                    };
                }
            }
        );
    }
}
