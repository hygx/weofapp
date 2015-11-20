package com.example.weofapphao.wh.views;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by 浩 on 2015/11/20.
 */
public class MyGLSurfaceView extends GLSurfaceView {
    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
