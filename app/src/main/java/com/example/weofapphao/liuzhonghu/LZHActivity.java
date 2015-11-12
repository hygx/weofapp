package com.example.weofapphao.liuzhonghu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.view.SlidingMenu;

public class LZHActivity extends ActionBarActivity {


    private SlidingMenu mMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lzh);

        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
    }
}
