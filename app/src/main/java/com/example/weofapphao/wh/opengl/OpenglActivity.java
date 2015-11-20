package com.example.weofapphao.wh.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

/**
 * Created by 浩 on 2015/11/20.
 */
public class OpenglActivity extends Activity {

    GLSurfaceView glSurface ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glSurface = new GLSurfaceView(this);
        setContentView(glSurface);


    }
}
