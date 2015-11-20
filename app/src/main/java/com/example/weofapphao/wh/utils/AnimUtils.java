package com.example.weofapphao.wh.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;

import com.example.weofapphao.czm.android.log.Log;

import java.util.Random;

/**
 * Created by 浩 on 2015/11/11.
 */
public class AnimUtils {



    public static void startAlphaAnim( View view,int startAlpha , int endAlpha ){

        AlphaAnimation aAnim = new AlphaAnimation(startAlpha,endAlpha);

        aAnim.setDuration(500);

        aAnim.setFillAfter(true);

        view.startAnimation(aAnim);

    }


    /**
     * 颤抖动画
     * @param v
     * @param duration
     */
    public static AnimatorSet tremBle(final View v,int duration){


        ObjectAnimator anim1   = ObjectAnimator.ofFloat(v,"scaleX",1,0).setDuration(duration);
        ObjectAnimator anim2   = ObjectAnimator.ofFloat(v,"scaleY",1,0).setDuration(duration);
        ObjectAnimator anim3   = ObjectAnimator.ofFloat(v,"xxx",((View)v.getParent()).getWidth(),0).setDuration(duration);

        final Random random=new Random(1000);
        anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("11111:", "-------------" + random.nextInt(500) * 0.05f);
                random.nextFloat();
                ((View) v.getParent()).setTranslationX(random.nextInt(500) * 0.05f);
                ((View) v.getParent()).setTranslationY(random.nextInt(500) * 0.05f);
                v.setTranslationX(random.nextInt(800) * 0.05f);
                v.setTranslationY(random.nextInt(800) * 0.05f);
            }
        });

        AnimatorSet anim  = new AnimatorSet();

        anim.play(anim1).with(anim2).with(anim3);
        anim.start();

        return anim;
    }


}
