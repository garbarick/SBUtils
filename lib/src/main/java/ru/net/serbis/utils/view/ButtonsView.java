package ru.net.serbis.utils.view;

import android.content.*;
import android.content.res.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class ButtonsView extends GridLayout
{
    private GridLayout buttons;
    private int columnCount;
    
    public ButtonsView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        TypedArray values = context.obtainStyledAttributes(attrs, new int[] {
            android.R.attr.layout,
            android.R.attr.columnCount
        });
        int layout = values.getResourceId(0, 0);
        columnCount = values.getInt(1, 0);
        buttons = (GridLayout) inflate(context, layout, this);
        buttons = (GridLayout) buttons.getChildAt(0);
        buttons.setColumnCount(columnCount);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec)
    {
        int width = MeasureSpec.getSize(widthSpec);
        int height = MeasureSpec.getSize(heightSpec);
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1)
        {
            setChildrenSize(width, height);
        }
        super.onMeasure(widthSpec, heightSpec);
    }

    private void setChildrenSize(int width, int height)
    {
        int count = buttons.getChildCount();
        int rowCount = (int) Math.ceil(count / (float) columnCount);
        for (int i = 0; i < count; i++)
        {
            View child = buttons.getChildAt(i);
            ViewGroup.LayoutParams params = child.getLayoutParams();
            params.width = width / columnCount;
            params.height = height / rowCount;
        }
    }
}
