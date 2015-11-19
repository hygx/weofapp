package com.example.weofapphao.liuzhonghu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.activity.anim_activity.ObjectAnimActivity;
import com.example.weofapphao.liuzhonghu.activity.anim_activity.ValueAnimActivity;

public class AnimatorActivity extends Activity implements View.OnClickListener {

    private Button btn_objectanimator;
    private Button btn_valueanimator;
    private Button btn_animatorset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        btn_objectanimator = (Button) findViewById(R.id.btn_objectanimator);
        btn_valueanimator = (Button) findViewById(R.id.btn_valueanimator);
        btn_animatorset = (Button) findViewById(R.id.btn_animatorset);

        btn_objectanimator.setOnClickListener(this);
        btn_valueanimator.setOnClickListener(this);
        btn_animatorset.setOnClickListener(this);
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
                break;
        }
    }
}
