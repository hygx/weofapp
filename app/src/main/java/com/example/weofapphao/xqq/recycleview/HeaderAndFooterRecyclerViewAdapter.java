package com.example.weofapphao.xqq.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rrtoyewx on 15/11/15.
 */
public class HeaderAndFooterRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_VIEW_TYPE = Integer.MIN_VALUE;
    private static final int FOOTER_VIEW_TYPE = Integer.MAX_VALUE;

    private List<View> mHeaderView = new ArrayList<>();
    private List<View> mFooterView = new ArrayList<>();


    private RecyclerView.Adapter<? extends RecyclerView.ViewHolder> mRecyclerAdapter;

    private HeaderAndFooterRecyclerViewAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        mRecyclerAdapter = adapter;
        mHeaderView.clear();
        mFooterView.clear();
    }

    public static HeaderAndFooterRecyclerViewAdapter createHeaderAndFooterAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> adapter) {
        return new HeaderAndFooterRecyclerViewAdapter(adapter);
    }


    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position < mHeaderView.size()) {
            type = HEADER_VIEW_TYPE + position;
        } else if (position < mHeaderView.size() + mRecyclerAdapter.getItemCount()) {
            type = mRecyclerAdapter.getItemViewType(position - mHeaderView.size());
        } else {
            type = FOOTER_VIEW_TYPE - (mRecyclerAdapter.getItemCount() + mHeaderView.size());
        }

        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType < HEADER_VIEW_TYPE + mHeaderView.size() && viewType > HEADER_VIEW_TYPE) {
            int position = viewType - HEADER_VIEW_TYPE;
            return new HeaderAndFoorterViewHolder(mHeaderView.get(position));
        }
        if (viewType > FOOTER_VIEW_TYPE + mFooterView.size() && viewType < FOOTER_VIEW_TYPE) {
            int position = FOOTER_VIEW_TYPE - viewType;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mHeaderView.size() + mRecyclerAdapter.getItemCount() + mFooterView.size();
    }

    public class HeaderAndFoorterViewHolder extends RecyclerView.ViewHolder {

        public HeaderAndFoorterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
