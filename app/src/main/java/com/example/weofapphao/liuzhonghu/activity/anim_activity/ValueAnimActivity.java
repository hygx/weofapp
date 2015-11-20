package com.example.weofapphao.liuzhonghu.activity.anim_activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.utils.ScreenUtils;

public class ValueAnimActivity extends AppCompatActivity {

    private ImageView mBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        mBall = (ImageView) findViewById(R.id.blue_ball);
    }

    /**
     * 垂直线
     *
     * @param view
     */
    public void verticalRun(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, ScreenUtils.getScreenHeight(this) - mBall.getHeight());
        valueAnimator.setTarget(mBall);
        valueAnimator.setDuration(1000).start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBall.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mBall.setX(0);
                mBall.setY(0);
            }
        });
    }

    /**
     * 抛物线
     *
     * @param view
     */
    public void parabolaRun(View view) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF point = new PointF();
                point.x = 100 * fraction * 3;
                point.y = 0.5f * 100 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                mBall.setX(point.x);
                mBall.setY(point.y);
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mBall.setX(0);
                mBall.setY(0);
            }
        });
    }
}
