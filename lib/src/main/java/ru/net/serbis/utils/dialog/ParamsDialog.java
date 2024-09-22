package ru.net.serbis.utils.dialog;

import android.app.*;
import android.content.*;
import android.view.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.adapter.*;
import ru.net.serbis.utils.bean.*;
import ru.net.serbis.utils.param.*;

public class ParamsDialog extends AlertDialog.Builder implements DialogInterface.OnClickListener
{
    private Activity context;
    private ParamsAdapter adapter;

    public ParamsDialog(Activity context, int titleId, Param[] params, boolean ok, boolean reset)
    {
        super(context);
        this.context = context;

        setTitle(titleId);

        View view = LayoutInflater.from(context).inflate(R.layout.params, null, false);
		adapter = new ParamsAdapter(context, view, params);
        setView(view);

        if (ok)
        {
            setPositiveButton(android.R.string.ok, this);
        }
        if (reset)
        {
            setNeutralButton(R.string.reset, this);
        }
        setNegativeButton(android.R.string.cancel, this);
    }

    public ParamsDialog(Activity context, int titleId, Param[] params)
    {
        this(context, titleId, params, true, true);
    }

    @Override
    public void onClick(DialogInterface dialog, int id)
    {
        switch(id)
        {
            case Dialog.BUTTON_POSITIVE:
                ok(adapter);
                break;
            case Dialog.BUTTON_NEUTRAL:
                reset(adapter);
                break;
        }
    }

    public void updateValue(Param param, Object value)
    {
        adapter.updateValue(param, value);
    }

    public Holder<Integer, String> getValues()
    {
        return adapter.getValues();
    }
    
    public void setValues(Holder<Integer, String> values)
    {
        adapter.setValues(values);
    }

    public void ok(ParamsAdapter adapter)
    {
        adapter.saveValues();
    }

    public void reset(ParamsAdapter adapter)
    {
        adapter.reset();
    }

    public void deleteParam(String name)
    {
        adapter.deleteParam(name);
    }
}
