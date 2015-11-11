package com.example.weofapphao.wanghao.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.weofapphao.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by �� on 2015/11/10.
 *
 */
public class ShowFunctionInfo extends ImageView implements View.OnClickListener {

    /**
     * ��Ϣ���
     */
    private int tag ;

    public ShowFunctionInfo(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
        TypedArray  type =  context.obtainStyledAttributes(attrs, R.styleable.showfuctionattrs_tag);

         tag =  Integer.parseInt( type.getString(R.styleable.showfuctionattrs_tag_infotag));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                String textInfo = getTextInfo();

                String[] split = textInfo.split(" ");

                new AlertDialog.Builder(getContext())
                        .setMessage(split[tag])
                        .setPositiveButton("ȷ��", null)
                        .show();

                break ;
        }

        return super.onTouchEvent(event);

    }

    private String getTextInfo() {

        InputStream inputStream = getContext().getResources().openRawResource(R.raw.dayplan);

        InputStreamReader reader  = new InputStreamReader(inputStream);
        BufferedReader bfr = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer("");
        String line = null;
        try {
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
        }

        return  sb.toString() ;
    }

    @Override
    public void onClick(View v) {

        Log.e("tag","click");

    }
}
