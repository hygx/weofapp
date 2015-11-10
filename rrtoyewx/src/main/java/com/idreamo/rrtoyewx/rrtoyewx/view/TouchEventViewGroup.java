package com.idreamo.rrtoyewx.rrtoyewx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rrtoyewx on 15/11/8.
 */
public class TouchEventViewGroup extends ViewGroup {

    public TouchEventViewGroup(Context context) {
        super(context);
    }

    public TouchEventViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        getChildAt(0).layout(l, t, r, b);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "TouchEventViewGroup 的onTouchEvent");
        return true;
    }

}
