package com.example.weofapphao.wh;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weofapphao.R;
import com.example.weofapphao.wh.base.HaoBaseActivity;
import com.example.weofapphao.wh.utils.AnimUtils;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 王浩 on 2015/11/8.
 */
public class HaoMainActivity extends HaoBaseActivity {

    Map<String,SoftReference<ImageView>> mSoftGroup =  new HashMap<>();

    static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            SimpleDateFormat formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日    HH:mm:ss     ");
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

    public void click2(View v){

        ImageView  imgShow =   (ImageView)  ( (View)v.getParent()).findViewById(R.id.softiv);

        imgShow.setImageResource(R.mipmap.ic_launcher);;


        SoftReference<ImageView> img1 = mSoftGroup.get("img1");

        if(img1==null){//软引用 取值 为空 则 重新加载对象
            //开启按钮退出
            AnimUtils.startAlphaAnim(v,1,0);
            //开启图片出现
            AnimUtils.startAlphaAnim(imgShow,0,1);

            //软引用加载
            SoftReference<ImageView> softimg  = new SoftReference<ImageView>(imgShow);
            mSoftGroup.put("img1",softimg);

        }else{
            //按钮出现
            AnimUtils.startAlphaAnim(v,0,1);
            //开启图片消失
            AnimUtils.startAlphaAnim(imgShow,1,0);

            mSoftGroup.remove("img1");
        }



    }


    private int startY;

    private int endY;

    public  void click3(View v){
        if(startY==0){
            startY = 180;
            endY = 0 ;
        }else{
            startY = 0;
            endY = 180 ;
        }

        ObjectAnimator.ofFloat(v.getParent(),"rotationY",startY,endY)
                .setDuration(500)
                .start();
    }
}
