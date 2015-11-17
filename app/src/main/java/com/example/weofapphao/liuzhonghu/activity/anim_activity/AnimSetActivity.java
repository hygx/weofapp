package com.example.weofapphao.liuzhonghu.activity.anim_activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.example.weofapphao.R;

public class AnimSetActivity extends AppCompatActivity {

    private ImageView mBall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_set);

        mBall = (ImageView) findViewById(R.id.img_ball);
    }

    public void togetherRun(View view){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBall, "scaleX", 1.0f, 2.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBall, "scaleY", 1.0f, 2.0f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000);
        set.setInterpolator(new LinearInterpolator());
        set.playTogether(anim1, anim2);
        set.start();
    }

    public void orderRun(View view){
        float cx = mBall.getX();
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mBall, "scaleX", 1.0f, 2.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mBall, "scaleY", 1.0f, 2.0f);

        ObjectAnimator anim3 = ObjectAnimator.ofFloat(mBall, "x", cx, 0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(mBall, "x", cx);

        /**
         * anim1.anim2,anim3同时进行
         * anim4接着进行
         */
        AnimatorSet set = new AnimatorSet();
        set.play(anim1).with(anim2);
        set.play(anim2).with(anim3);
        set.play(anim4).after(anim3);
        set.setDuration(1000).start();
    }
}
