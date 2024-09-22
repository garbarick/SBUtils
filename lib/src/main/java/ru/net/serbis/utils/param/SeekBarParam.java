package ru.net.serbis.utils.param;

import android.view.*;
import android.widget.*;
import ru.net.serbis.utils.*;

public class SeekBarParam extends NumberParam<SeekBar>
{
    private int min;
    private int max;
    private boolean showViewValue;

    public SeekBarParam(int nameId, int min, int max, int value, boolean showViewValue)
    {
        super(nameId, value);
        this.min = min;
        this.max = max;
        this.showViewValue = showViewValue;
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.param_seekbar;
    }

    @Override
    public void initViewValue(View parent)
    {
        SeekBar view = getViewValue(parent);
        view.setMin(min);
        view.setMax(max);
        setValue(view, getValue());

        if (showViewValue)
        {
            initViewValue(parent, view);
            return;
        }
    }

    private void initViewValue(View parent, SeekBar view)
    {
        final TextView viewValue = UITool.get().findView(parent, R.id.view_value);
        viewValue.setVisibility(View.VISIBLE);
        viewValue.setText(getValue().toString());
        view.setOnSeekBarChangeListener(
            new SeekBar.OnSeekBarChangeListener()
            {
                @Override
                public void onProgressChanged(SeekBar seek, int progress, boolean byUser)
                {
                    if (byUser)
                    {
                        viewValue.setText(String.valueOf(progress));
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seek)
                {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seek)
                {
                }
            }
        );
    }

    @Override
    public void setValue(SeekBar view, Integer value)
    {
        view.setProgress(value);
    }

    @Override
    public Integer getValue(SeekBar view)
    {
        return view.getProgress();
    }
}
