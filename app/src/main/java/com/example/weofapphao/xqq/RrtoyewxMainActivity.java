package com.example.weofapphao.xqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.R;
import com.example.weofapphao.xqq.explosionfield.RrtoyewxExplosionActivity;
import com.example.weofapphao.xqq.recycleview.RrtoyewxRecycleViewActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rrtoyewx on 15/11/8.
 */
public class RrtoyewxMainActivity extends AppCompatActivity {
    private static final String TAG = RrtoyewxMainActivity.class.getSimpleName();

    @InjectView(R.id.btn_rrtoyewx_main_download)
    Button _btnDownload;
    @InjectView(R.id.btn_rrtoyewx_main_recycleview)
    Button _btnRecycleview;
    @InjectView(R.id.btn_rrtoyewx_main_explosion)
    Button _btnExplosion;

    private Activity mActivity;


    public static void start(Context conext) {
        Intent it = new Intent(conext, RrtoyewxMainActivity.class);
        conext.startActivity(it);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrtoyewx_main);
        ButterKnife.inject(this);
        mActivity = this;

        setListener();
    }

    private void setListener() {
        _btnRecycleview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RrtoyewxRecycleViewActivity.start(mActivity);
            }
        });
        _btnExplosion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RrtoyewxExplosionActivity.start(mActivity);
            }
        });

    }


}
