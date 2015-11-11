package com.example.weofapphao.czm.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.weofapphao.R;
import com.example.weofapphao.czm.impls.AdapterSwitcher;
import com.example.weofapphao.czm.impls.PageSwitcher;
import com.example.weofapphao.czm.interfaces.IPageSwitcher;
import com.example.weofapphao.czm.module.HomeItemModel;
import com.example.weofapphao.czm.ui.Activity.StudObjectAnimator;
import com.example.weofapphao.czm.ui.Activity.StudSurface;
import com.example.weofapphao.czm.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caozhimin on 2015/11/10.
 */
public class CzmHomeActivity extends Activity {

    private ListView mLv_list;
    private HomeAdapter mHomeAdapter;
    private List<HomeItemModel> mDatas=new ArrayList<HomeItemModel>();
    private IPageSwitcher pageSwitcher;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_czmhome);
        pageSwitcher = new PageSwitcher(this);
        initViewAndData();
        initListener();
    }

    private void initListener() {
        mLv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pageSwitcher.toActivityByClass(mDatas.get(position).clazz);
            }
        });
    }

    private void initViewAndData() {
        mLv_list = (ListView) findViewById(R.id.lv_list);
        initData();
        mHomeAdapter=new AdapterSwitcher<HomeItemModel>(this,mDatas).getHomeAdapter();
        mLv_list.setAdapter(mHomeAdapter);
    }

    private void initData() {
        mDatas.add(new HomeItemModel("属性动画", StudObjectAnimator.class));
        mDatas.add(new HomeItemModel("SurfaceView使用", StudSurface.class));
    }
}
