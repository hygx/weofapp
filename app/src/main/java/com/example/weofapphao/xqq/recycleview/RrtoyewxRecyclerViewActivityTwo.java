package com.example.weofapphao.xqq.recycleview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.weofapphao.R;

/**
 * Created by Rrtoyewx on 15/11/19.
 */
public class RrtoyewxRecyclerViewActivityTwo extends AppCompatActivity {

    public static void start(Context context) {
        Intent it = new Intent(context, RrtoyewxRecyclerViewActivityTwo.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrtoyewx_recyclerview_two);

    }
}
