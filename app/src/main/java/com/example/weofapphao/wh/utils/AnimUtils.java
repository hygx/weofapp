package com.example.weofapphao.wh.utils;

import android.view.View;
import android.view.animation.AlphaAnimation;

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

}
