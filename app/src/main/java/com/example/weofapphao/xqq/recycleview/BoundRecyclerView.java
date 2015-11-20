package com.example.weofapphao.xqq.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

import com.example.weofapphao.xqq.utils.Utils;

/**
 * Created by Rrtoyewx on 15/11/19.
 */

public class BoundRecyclerView extends RecyclerView {
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
    private static final int MAX_X_OVERSCROLL_DISTANCE = 50;

    private int mMaxYOverscrollDistance;
    private int mMaxXOverscrollDistance;

    public BoundRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    public BoundRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public BoundRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {

        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final float density = metrics.density;
        mMaxYOverscrollDistance = (int) (density * MAX_Y_OVERSCROLL_DISTANCE);
        mMaxXOverscrollDistance = (int) (density * MAX_X_OVERSCROLL_DISTANCE);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxYOverscrollDistance, isTouchEvent);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {

        return super.onTouchEvent(e);
    }
}
