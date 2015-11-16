package com.example.weofapphao.xqq.explosionfield;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.R;
import com.example.weofapphao.xqq.model.ExplosionField;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rrtoyewx on 15/11/14.
 */
public class RrtoyewxExplosionActivity extends AppCompatActivity {

    @InjectView(R.id.btn_rrtoyewx_main_download)
    Button btnRrtoyewxMainDownload;
    @InjectView(R.id.btn_rrtoyewx_main_recycleview)
    Button btnRrtoyewxMainRecycleview;
    @InjectView(R.id.btn_rrtoyewx_main_explosion)
    Button btnRrtoyewxMainExplosion;
    private ExplosionField mExplosionField;

    public static void start(Context context) {
        Intent it = new Intent(context, RrtoyewxExplosionActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrtoyewx_main);
        ButterKnife.inject(this);
        mExplosionField = ExplosionField.attach2Window(this);
        bind();
    }

    private void bind() {
        btnRrtoyewxMainExplosion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExplosionField.explode(btnRrtoyewxMainExplosion);
            }
        });
        btnRrtoyewxMainRecycleview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExplosionField.explode(btnRrtoyewxMainRecycleview);
            }
        });
        btnRrtoyewxMainDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExplosionField.explode(btnRrtoyewxMainDownload);
            }
        });
    }
}
