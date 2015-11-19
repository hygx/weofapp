package com.example.weofapphao.liuzhonghu.activity.anim_activity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
     * @param view
     */
    public void verticalRun(View view){
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, ScreenUtils.getScreenHeight(this) - mBall.getHeight());
        valueAnimator.setTarget(mBall);
        valueAnimator.setDuration(1000).start();

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mBall.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }

    /**
     * 抛物线
     * @param view
     */
    public void horizontalRun(View view){

    }
}
