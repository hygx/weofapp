package com.example.weofapphao.wh.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 浩 on 2015/11/8.
 */
public abstract class HaoBaseActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        initView();
        initData();
        initModel();
    }

    protected abstract void initModel();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int   getLayout ();

}
