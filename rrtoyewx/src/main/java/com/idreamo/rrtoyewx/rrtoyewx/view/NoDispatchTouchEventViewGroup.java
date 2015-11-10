package com.idreamo.rrtoyewx.rrtoyewx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by Rrtoyewx on 15/11/8.
 */
public class NoDispatchTouchEventViewGroup extends ViewGroup {

    public NoDispatchTouchEventViewGroup(Context context) {
        super(context);
    }

    public NoDispatchTouchEventViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoDispatchTouchEventViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG", "NoDispatchTouchEvent   dispatchTouchEvent ");
        return true;
    }


}
