package com.example.weofapphao.liuzhonghu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.activity.AnimatorActivity;
import com.example.weofapphao.liuzhonghu.activity.SlidingMenuActivity;

public class LZHActivity extends Activity implements View.OnClickListener {

    private Button btn_slidingMenu;
    private Button btn_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lzh);

        btn_slidingMenu = (Button) findViewById(R.id.myslidingmenu);
        btn_animation = (Button) findViewById(R.id.myanimation);

        btn_slidingMenu.setOnClickListener(this);
        btn_animation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.myslidingmenu:
                this.startActivity(new Intent(this, SlidingMenuActivity.class));
                break;
            case R.id.myanimation:
                this.startActivity(new Intent(this, AnimatorActivity.class));
                break;
        }
    }
}
