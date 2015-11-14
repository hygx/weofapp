package com.example.weofapphao.liuzhonghu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.activity.SlidingMenuActivity;

public class LZHActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mSlidingMenu;
    private Button mQQSlidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lzh);

        mSlidingMenu = (Button) findViewById(R.id.myslidingmenu);
        mQQSlidingMenu = (Button) findViewById(R.id.myqqslidingmenu);

        mSlidingMenu.setOnClickListener(this);
        mQQSlidingMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.myslidingmenu:
                this.startActivity(new Intent(this, SlidingMenuActivity.class));
                break;
            case R.id.myqqslidingmenu:

                break;
        }
    }
}
