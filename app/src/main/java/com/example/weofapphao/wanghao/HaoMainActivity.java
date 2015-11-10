package com.example.weofapphao.wanghao;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.weofapphao.R;
import com.example.weofapphao.wanghao.base.HaoBaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by 王浩 on 2015/11/8.
 */
public class HaoMainActivity extends HaoBaseActivity {

    static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy��MM��dd��    HH:mm:ss     ");
            Date    curDate    =   new Date(System.currentTimeMillis());//��ȡ��ǰʱ��
            String    str    =    formatter.format(curDate);

            TextView tv = (TextView) msg.obj;

            tv.setText("��̬��ʾʱ��:"+str);

            Message message = handler.obtainMessage();

            message.obj = tv  ;
            handler.sendMessageDelayed(message,2000);
        //    handler.sendMessageAtTime(message, 2000);

        }
    };

    @Override
    protected void initModel() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_haomain;
    }



    public void click1(View v){

        Message message = handler.obtainMessage();

        message.obj = v  ;

        handler.sendMessageAtTime(message, 2000);
    }

}
