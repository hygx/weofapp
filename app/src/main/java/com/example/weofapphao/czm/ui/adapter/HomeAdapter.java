package com.example.weofapphao.czm.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weofapphao.R;
import com.example.weofapphao.czm.module.HomeItemModel;

import java.util.List;

/**
 * Created by caozhimin on 2015/11/10.
 */
public class HomeAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<HomeItemModel> datas;
    public HomeAdapter(Context context,List<HomeItemModel> itemModels){
        this.mContext=context;
        this.datas=itemModels;
        this.mLayoutInflater=LayoutInflater.from(context);
    };
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position).Text;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=mLayoutInflater.inflate(R.layout.item_czmhome,parent,false);
            vh.tv_item= (TextView) convertView.findViewById(R.id.tv_item);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv_item.setText((CharSequence)getItem(position));
        return convertView;
    }
    public static class ViewHolder {
        TextView tv_item;
    }
}
