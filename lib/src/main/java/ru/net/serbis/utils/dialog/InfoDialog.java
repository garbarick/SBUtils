package ru.net.serbis.utils.dialog;

import android.app.*;
import android.content.*;
import android.widget.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.adapter.*;

public class InfoDialog extends AlertDialog.Builder implements DialogInterface.OnClickListener
{
    public InfoDialog(Context context, int layoutId)
    {
        super(context);
        setTitle(R.string.info);
        ListView list = new ListView(context);
        InfoAdapter adapter = new InfoAdapter(context, layoutId);
        list.setAdapter(adapter);
        setView(list);
        setNegativeButton(android.R.string.cancel, this);
        show();
    }

    @Override
    public void onClick(DialogInterface dialog, int id)
    {
    }
}
