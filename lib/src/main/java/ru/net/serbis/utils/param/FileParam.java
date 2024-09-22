package ru.net.serbis.utils.param;

import android.text.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.dialog.*;
import ru.net.serbis.utils.listener.*;

public class FileParam extends TextViewParam
{
    private boolean onlyFolder;
    private boolean onlyFile;
    private String ext;

    public FileParam(int nameId, String value, boolean onlyFolder, boolean onlyFile, String ext)
    {
        super(nameId, value);
        this.onlyFolder = onlyFolder;
        this.onlyFile = onlyFile;
        this.ext = ext;
    }

    public FileParam(int nameId, String value, boolean onlyFolder, boolean onlyFile)
    {
        this(nameId, value, onlyFolder, onlyFile, null);
    }

    @Override
    public void initViewValue(View parent)
    {
        super.initViewValue(parent);

        TextView view = getViewValue(parent);
        view.setOnClickListener(
            new ViewOnClickListener<TextView>()
            {
                @Override
                public void onClickView(final TextView view)
                {
                    String path = getValue(view);
                    File dir = TextUtils.isEmpty(path) ? null : new File(path);
                    new FileChooser(context, R.string.choose_dir, onlyFolder, onlyFile, dir, ext)
                    {
                        @Override
                        public void onChoose(String path)
                        {
                            FileParam.this.onChoose(view, path);
                        }
                    };
                }
            }
        );
    }

    protected void onChoose(TextView view, String path)
    {
        view.setText(path);
    }
}
