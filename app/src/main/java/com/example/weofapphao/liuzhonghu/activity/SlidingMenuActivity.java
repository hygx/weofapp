package com.example.weofapphao.liuzhonghu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.view.SlidingMenu;

public class SlidingMenuActivity extends AppCompatActivity {

    private SlidingMenu mMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);

        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
    }

    public void toggleMenu(View view){
        mMenu.toggle();
    }


}
