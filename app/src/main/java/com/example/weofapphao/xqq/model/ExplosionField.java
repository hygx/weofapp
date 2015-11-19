package com.example.weofapphao.xqq.model;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.weofapphao.xqq.explosionfield.ExplosionAnimator;
import com.example.weofapphao.xqq.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Rrtoyewx on 15/11/14.
 */
public class ExplosionField extends View {
    private List<ExplosionAnimator> mExplosions = new ArrayList<>();
    private int[] mExpandInset = new int[2];

    public ExplosionField(Context context) {
        super(context);
        init();
    }

    public ExplosionField(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExplosionField(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Arrays.fill(mExpandInset, Utils.dp2Px(32));
    }


    public static ExplosionField attach2Window(Activity activity) {
        ExplosionField explosionField = new ExplosionField(activity);
        ViewGroup rootView = (ViewGroup) activity.findViewById(android.R.id.content);
        rootView.addView(explosionField, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return explosionField;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (ExplosionAnimator explosion : mExplosions) {
            explosion.draw(canvas);
        }
    }

    public void explode(final View view) {
        Rect r = new Rect();
        view.getGlobalVisibleRect(r);
        int[] loacation = new int[2];
        getLocationInWindow(loacation);
        r.offset(-loacation[0], -loacation[1]);
        r.inset(-mExpandInset[0], -mExpandInset[1]);
        int startDelay = 100;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration(150);
        //震动动画
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            Random random = new Random();

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                view.setTranslationX((random.nextFloat() - 0.5f) * view.getWidth() * 0.05f);
                view.setTranslationY((random.nextFloat() - 0.5f) * view.getHeight() * 0.05f);

            }
        });
        valueAnimator.start();
        //隐藏调
        view.animate().setDuration(150).setStartDelay(100).scaleX(0f).scaleY(0).alpha(0f).start();
        explode(Utils.createBitmapFromView(view), r, startDelay, ExplosionAnimator.DEFAULT_DURATION);
    }

    public void explode(Bitmap bitmap, Rect r, long startDelay, long duration) {
        final ExplosionAnimator explosion = new ExplosionAnimator(this, bitmap, r);
        explosion.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mExplosions.remove(animation);
            }
        });
        explosion.setStartDelay(startDelay);
        explosion.setDuration(duration);
        mExplosions.add(explosion);
        explosion.start();
    }

    public void expandExplosingBound(int dx, int dy) {
//        mExplosio[0] = dx;
//        mExplosion
        mExpandInset[0] = dx;
        mExpandInset[1] = dy;
    }

    public void clear() {
        mExplosions.clear();
        invalidate();
    }

}
