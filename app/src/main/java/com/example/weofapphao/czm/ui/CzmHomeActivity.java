package com.example.weofapphao.czm.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.weofapphao.R;
import com.example.weofapphao.czm.impls.AdapterSwitcher;
import com.example.weofapphao.czm.module.HomeItemModel;
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
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_czmhome);
        mLv_list = (ListView) findViewById(R.id.lv_list);
        initData();
        mHomeAdapter=new AdapterSwitcher<HomeItemModel>(this,mDatas).getHomeAdapter();
        mLv_list.setAdapter(mHomeAdapter);
    }

    private void initData() {
        mDatas.add(new HomeItemModel("属性动画练习"));
    }
}
