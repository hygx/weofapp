package com.example.weofapphao.xqq.recycleview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weofapphao.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rrtoyewx on 15/11/12.
 */
public class RrtoyewxRecycleViewActivity extends AppCompatActivity {


    @InjectView(R.id.btn_rrtoyewx_recycleview_linearLayoutManager)
    Button _btnLinearLayoutManager;
    @InjectView(R.id.btn_rrtoyewx_recycleview_gridlayoutmanager)
    Button _btnGridlayoutmanager;
    @InjectView(R.id.btn_rrtoyewx_recycleview_staggeredgridlayoutmanager)
    Button _btnStaggeredgridlayoutmanager;
    @InjectView(R.id.rv_rrtoyewx_recycleview_content)
    RecyclerView rvContent;
    @InjectView(R.id.btn_rrtoyewx_recycleview_addheaderview)
    Button btnAddheaderview;


    private Activity mActivity;
    private int count = 0;
    private LinearLayoutManager _linearLayoutManager;
    private GridLayoutManager _gridlayoutmanage;


    private ArrayList<String> dataList;
    private RecycleViewAdapter _adapter;


    public static void start(Context context) {
        Intent it = new Intent(context, RrtoyewxRecycleViewActivity.class);
        context.startActivity(it);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rrtoyewx_recycleview);
        ButterKnife.inject(this);
        mActivity = this;
        initData();
        setListener();
        rvContent.setAdapter(_adapter);

    }

    private void initData() {
        dataList = new ArrayList<>();
        rvContent.setHasFixedSize(true);

        _linearLayoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        _gridlayoutmanage = new GridLayoutManager(mActivity, 3, LinearLayoutManager.VERTICAL, false);

        for (int i = 0; i < 40; i++) {
            dataList.add("content :" + i);
        }
        _adapter = new RecycleViewAdapter(mActivity);

        loadLinearLayout();
    }

    private void setListener() {
        _btnLinearLayoutManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLinearLayout();
            }
        });
        btnAddheaderview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHeaderView();
            }
        });
        _btnGridlayoutmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadGirdLayout();
            }
        });
    }


    private void loadLinearLayout() {
        //context orientation reverseLayout
        rvContent.setLayoutManager(_linearLayoutManager);

        _adapter.setList(dataList);

    }

    private void addHeaderView() {
        TextView tv = new TextView(mActivity);
        tv.setText("我是头文件" + count++);
        tv.setTextColor(Color.GREEN);
        _adapter.addHeadView(tv);
        setGridManager();


        _adapter.notifyDataSetChanged();
    }

    private void setGridManager() {
        RecyclerView.LayoutManager layoutManager = rvContent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final int spanCount = _gridlayoutmanage.getSpanCount();
            final int headviewSize = _adapter.getHeadViewSize();
            _gridlayoutmanage.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {

                    return position < headviewSize ? spanCount : 1;
                }
            });
            rvContent.setLayoutManager(_gridlayoutmanage);
        }
    }

    private void loadGirdLayout() {

        rvContent.setLayoutManager(_gridlayoutmanage);
        setGridManager();
        _adapter.setList(dataList);
    }


}
