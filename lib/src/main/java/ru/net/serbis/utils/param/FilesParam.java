package ru.net.serbis.utils.param;

import android.view.*;
import android.widget.*;
import java.util.*;
import ru.net.serbis.utils.*;
import ru.net.serbis.utils.dialog.*;
import ru.net.serbis.utils.listener.*;

public class FilesParam extends StringsParam
{
    private boolean onlyFolder;
    private boolean onlyFile;

    public FilesParam(String name, boolean onlyFolder, boolean onlyFile)
    {
        super(name);
        this.onlyFolder = onlyFolder;
        this.onlyFile = onlyFile;
    }

    public FilesParam(int nameId, boolean onlyFolder, boolean onlyFile)
    {
        super(nameId);
        this.onlyFolder = onlyFolder;
        this.onlyFile = onlyFile;
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.param_files;
    }

    @Override
    protected void initClick(Button view)
    {
        view.setOnClickListener(
            new ViewOnClickListener<Button>()
            {
                @Override
                public void onClickView(final Button view)
                {
                    new FilesDialog(context, nameId, getValue(view), onlyFolder, onlyFile)
                    {
                        @Override
                        protected void onResult(Set<String> result)
                        {
                            setValue(view, result);
                        }
                    }.show();
                }
            }
        );
    }

    @Override
    public void setValue(Button button, Set<String> values)
    {
        this.values = values;
        if (values.isEmpty())
        {
            button.setText(R.string.choose_files);
        }
        else
        {
            String text = Strings.get().get(R.string.chosen_files, values.size());
            button.setText(text);
        }
    }
}
