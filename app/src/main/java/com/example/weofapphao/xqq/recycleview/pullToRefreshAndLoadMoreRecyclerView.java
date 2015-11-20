package com.example.weofapphao.xqq.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Rrtoyewx on 15/11/19.
 */
public class pullToRefreshAndLoadMoreRecyclerView extends RecyclerView {

    private LoadDataListener mLoadDataListener;


    private OnScrollListener mSuperScrolListener = new OnScrollListener() {
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Log.e("TAG", "onScrollStateChanged");
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Log.e("TAG", "onScrolled");
        }
    };


    public pullToRefreshAndLoadMoreRecyclerView(Context context) {
        super(context);

    }

    public pullToRefreshAndLoadMoreRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        super.addOnScrollListener(mSuperScrolListener);

    }


    public void setLoadDataListener(LoadDataListener listener) {
        mLoadDataListener = listener;
    }

    interface LoadDataListener {
        void onRefresh();

        void onLoadMore();
    }

}
