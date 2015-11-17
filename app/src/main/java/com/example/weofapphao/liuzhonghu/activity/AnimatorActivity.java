package com.example.weofapphao.liuzhonghu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.activity.anim_activity.AnimSetActivity;
import com.example.weofapphao.liuzhonghu.activity.anim_activity.ObjectAnimActivity;
import com.example.weofapphao.liuzhonghu.activity.anim_activity.ValueAnimActivity;

public class AnimatorActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        findViewById(R.id.btn_objectanimator).setOnClickListener(this);
        findViewById(R.id.btn_valueanimator).setOnClickListener(this);
        findViewById(R.id.btn_animatorset).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_objectanimator:
                this.startActivity(new Intent(this, ObjectAnimActivity.class));
                break;
            case R.id.btn_valueanimator:
                this.startActivity(new Intent(this, ValueAnimActivity.class));
                break;
            case R.id.btn_animatorset:
                this.startActivity(new Intent(this, AnimSetActivity.class));
                break;
        }
    }
}
