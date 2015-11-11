package com.example.weofapphao.xqq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.weofapphao.R;

/**
 * Created by Rrtoyewx on 15/11/8.
 */
public class RrtoyewxMainActivity extends Activity {
    private static final String TAG = RrtoyewxMainActivity.class.getSimpleName();

    public static void start(Context conext) {
        Intent it = new Intent(conext, RrtoyewxMainActivity.class);
        conext.startActivity(it);

    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_rrtoyewx_main);
    }


}
