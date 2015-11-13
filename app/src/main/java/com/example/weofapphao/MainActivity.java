package com.example.weofapphao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.example.weofapphao.czm.impls.PageSwitcher;
import com.example.weofapphao.liuzhonghu.LZHActivity;
import com.example.weofapphao.wh.HaoMainActivity;
import com.example.weofapphao.xqq.RrtoyewxMainActivity;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {



    private Button wh,xqq,zcm,yb,lzh ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

      wh = (Button) findViewById(R.id.auther1);
        xqq = (Button) findViewById(R.id.auther2);
        zcm = (Button) findViewById(R.id.auther3);
        yb = (Button) findViewById(R.id.auther4);
        lzh = (Button) findViewById(R.id.auther5);

        initViewData();

    }

    private void initViewData() {

        wh.setOnClickListener(this);
        xqq.setOnClickListener(this);
        zcm.setOnClickListener(this);
        yb.setOnClickListener(this);
        lzh.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.auther1://王浩的项目

                startActivity(new Intent(MainActivity.this, HaoMainActivity.class));
                break;

            case R.id.auther2://许强强项目
                RrtoyewxMainActivity.start(MainActivity.this);
                break;

            case R.id.auther3://曹智民项目
                new PageSwitcher(this).toCzmHomePage();
                break;

            case R.id.auther4://杨斌的项目

                break;
            case R.id.auther5://刘忠虎的项目
                this.startActivity(new Intent(this, LZHActivity.class));
                break;
        }
    }
}
