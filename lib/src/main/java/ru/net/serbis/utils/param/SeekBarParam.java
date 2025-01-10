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
        view.setMax(100);
        setValue(view, getValue());
        if (showViewValue)
        {
            initShowViewValue(parent, view);
        }
    }

    private void initShowViewValue(View parent, SeekBar view)
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
                        viewValue.setText(fromProgress(progress).toString());
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
        view.setProgress(toProgress(value));
    }

    @Override
    public Integer getValue(SeekBar view)
    {
        return fromProgress(view.getProgress());
    }

    public Integer toProgress(Integer value)
    {
        return (value - min) * 100 / (max - min);
    }

    public Integer fromProgress(Integer value)
    {
        return value * (max - min) / 100 + min;
    }
}
