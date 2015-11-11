package com.example.weofapphao.czm.ui.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

import com.example.weofapphao.czm.ui.View.GameView;

/**
 * Created by caozhimin on 2015/11/11.
 */
public class StudSurface extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        DisplayMetrics outMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        GameView.SCREEN_WIDTH = outMetrics.widthPixels;
        GameView.SCREEN_HEIGHT = outMetrics.heightPixels;

        GameView gameView = new GameView(this);
        setContentView(gameView);
    }
}
