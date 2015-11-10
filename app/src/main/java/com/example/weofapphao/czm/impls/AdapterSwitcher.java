package com.example.weofapphao.czm.impls;

import android.content.Context;

import com.example.weofapphao.czm.interfaces.IAdapterSwitcher;
import com.example.weofapphao.czm.module.HomeItemModel;
import com.example.weofapphao.czm.ui.CzmHomeActivity;
import com.example.weofapphao.czm.ui.adapter.HomeAdapter;

import java.util.List;

/**
 * Created by caozhimin on 2015/11/10.
 */
public class AdapterSwitcher<T> implements IAdapterSwitcher {
    private final List<T> mDatas;
    Context mContext;
    public AdapterSwitcher(Context context, List<T> mDatas){
        this.mContext=context;
        this.mDatas=mDatas;
    }
    @Override
    public HomeAdapter getHomeAdapter() {
        return new HomeAdapter(mContext, (List<HomeItemModel>) mDatas);
    }
}
