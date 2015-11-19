package com.example.weofapphao.wh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weofapphao.R;
import com.example.weofapphao.czm.android.log.Log;
import com.example.weofapphao.wh.base.HaoBaseActivity;
import com.example.weofapphao.wh.utils.AnimUtils;
import com.example.weofapphao.xqq.explosionfield.ExplosionAnimator;
import com.example.weofapphao.xqq.utils.Utils;

import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * Created by 王浩 on 2015/11/8.
 */
public class HaoMainActivity extends HaoBaseActivity {

    Map<String,SoftReference<ImageView>> mSoftGroup =  new HashMap<>();

    Toolbar toolbar ;
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
       setSupportActionBar (toolbar);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        toolbar  = (Toolbar) findViewById(R.id.toolbar);

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


    public void click4(final View view){

        ObjectAnimator anim  = ObjectAnimator.ofFloat(view,"hgwd",0,1000).setDuration(1000);

        anim.start();

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();


                view.setTranslationX(-animatedValue);
                view.setTranslationY(-animatedValue);

                float v = (animatedValue / 1000) - 1;
                v =  -v <0.7 ? 0 : -v ;
                view.setAlpha(v);
            }
        });

        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ViewParent parent = view.getParent();
                LinearLayout par = (LinearLayout) parent;
                ObjectAnimator.ofFloat(parent, "translationY", par.getTranslationY(), par.getTranslationY() + view.getHeight(), par.getTranslationY(), par.getTranslationY() + view.getHeight()).setDuration(1500).start();
            }


            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }


    public void click5(View v){
        ObjectAnimator animstart =   ObjectAnimator.ofFloat(v.getParent(), "translationX", 0, 1000,1000,0).setDuration(500);
        ObjectAnimator animend =   ObjectAnimator.ofFloat(v.getParent(), "rotationX", 0, 360).setDuration(1000);

        AnimatorSet set  = new AnimatorSet();
        set.play(animend).with(animstart).with( ObjectAnimator.ofFloat(v.getParent(), "translationY", 0, 1000,1000,0).setDuration(500))
                .with(ObjectAnimator.ofFloat(v.getParent(), "rotationY", 0, 360).setDuration(1000))
                .after(ObjectAnimator.ofFloat(v.getParent(), "translationX", 0, 1000, 1000, 0).setDuration(500)).after( ObjectAnimator.ofFloat(v.getParent(), "translationY", 0, 1000,1000,0).setDuration(500))
                .before(ObjectAnimator.ofFloat(v.getParent(), "rotationX", 0, 360).setDuration(1000))
                .before(ObjectAnimator.ofFloat(v.getParent(), "rotationY", 0, 360).setDuration(1000));
        set.start();


    }

    int[] mExpandInset =  new int[2];

    public void click6(final View view){
        Arrays.fill(mExpandInset, Utils.dp2Px(32));

            Rect r = new Rect();
        ( (View) view.getParent()).getGlobalVisibleRect(r);
            int[] loacation = new int[2];
        ( (View) view.getParent()).getLocationInWindow(loacation);
            r.offset(-loacation[0], -loacation[1]);
            r.inset(-mExpandInset[0], -mExpandInset[1]);
            int startDelay = 100;
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f).setDuration(150);
            //震动动画
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                Random random = new Random();

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    ( (View) view.getParent()).setTranslationX((random.nextFloat() - 0.5f) * view.getWidth() * 0.05f);
                    ( (View) view.getParent()).setTranslationY((random.nextFloat() - 0.5f) * view.getHeight() * 0.05f);

                }
            });
            valueAnimator.start();
            //隐藏调
        ( (View) view.getParent()).animate().setDuration(150).setStartDelay(100).scaleX(0f).scaleY(0).alpha(0f).start();
            explode(Utils.createBitmapFromView(view), r, startDelay, ExplosionAnimator.DEFAULT_DURATION, (View) view.getParent());
        }

private List<ExplosionAnimator> mExplosions = new ArrayList<>();

    public void explode(Bitmap bitmap, Rect r, long startDelay, long duration,View view) {
        final ExplosionAnimator explosion = new ExplosionAnimator(view, bitmap, r);
        explosion.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mExplosions.remove(animation);
            }
        });
        explosion.setStartDelay(startDelay);
        explosion.setDuration(duration);
        mExplosions.add(explosion);
        explosion.start();
    }


}
