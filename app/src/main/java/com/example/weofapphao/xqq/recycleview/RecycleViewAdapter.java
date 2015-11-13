package com.example.weofapphao.xqq.recycleview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weofapphao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rrtoyewx on 15/11/12.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.Holder> {
    private static final String TAG = RecycleViewAdapter.class.getSimpleName();
    private static final int CONTENT_TYPE01 = Integer.MIN_VALUE;
    private static final int CONTENT_TYPE02 = Integer.MIN_VALUE + 1;
    private static final int HEADVIEW_TYPE = 0;


    private Activity _activity;
    private List<String> _dataList = new ArrayList<>();
    private List<View> headView = new ArrayList<>();

    public RecycleViewAdapter(Activity activity) {
        Log.e(TAG, "RecycleViewAdapter");
        _activity = activity;
    }

    //create viewholder
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e(TAG, "onCreateViewHolder parent" + parent.toString());//recycleView
        LayoutInflater inflater = LayoutInflater.from(_activity);
        View view = null;
        if (viewType == CONTENT_TYPE01) {
            view = inflater.inflate(R.layout.item_rrtoyewx_recycleview_adapter_type1, null);
        } else if (viewType == CONTENT_TYPE02) {
            view = inflater.inflate(R.layout.item_rrtoyewx_recycleview_adapter_type2, null);
        } else {
            view = headView.get(viewType);
        }
        return new Holder(view, viewType);
    }


    //set listener and  initdata
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.e(TAG, "onBindViewHolder");
        String s = null;
        if (position >= headView.size()) {
            s = _dataList.get(position - headView.size());
        }
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case CONTENT_TYPE01:
                holder.tvType01.setText(s);
                break;
            case CONTENT_TYPE02:
                holder.tvType02.setText(s);
                break;

        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.e(TAG, "getItemViewType");
        int type = 0;
        if (position < headView.size()) {
            type = HEADVIEW_TYPE + position;
        } else {
            type = (position - headView.size()) % 2 == 0 ? CONTENT_TYPE01 : CONTENT_TYPE02;
        }

        return type;
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount" + _dataList.size());
        return headView.size() + _dataList.size();
    }

    public void setList(ArrayList<String> list) {
        _dataList.clear();
        _dataList.addAll(list);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvType01;
        TextView tvType02;


        public Holder(View itemView, int viewType) {

            super(itemView);
            Log.e(TAG, "Holder");
            switch (viewType) {
                case HEADVIEW_TYPE:

                    break;
                case CONTENT_TYPE01:
                    tvType01 = (TextView) itemView.findViewById(R.id.tv_item_rrtoyewx_recycleview_adapter_type1);
                    break;
                case CONTENT_TYPE02:
                    tvType02 = (TextView) itemView.findViewById(R.id.tv_item_rrtoyewx_recycleview_adapter_type2);
                    break;
            }
        }
    }

    public void addHeadView(View view) {
        view.setTag(headView.size());
        headView.add(view);

    }

    public int getHeadViewSize() {
        return headView.size();
    }
}
