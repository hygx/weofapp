package com.example.weofapphao.liuzhonghu.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weofapphao.R;
import com.example.weofapphao.liuzhonghu.view.SlidingMenu;

import java.util.ArrayList;
import java.util.List;

public class SlidingMenuActivity extends AppCompatActivity {

    private SlidingMenu mMenu;
    private RecyclerView mRecyclerView;
    private List<MenuData> menuDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_menu);

        initData();

        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        mRecyclerView = (RecyclerView) findViewById(R.id.menu_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MenuAdapter());
    }

    public void toggleMenu(View view) {
        mMenu.toggle();
    }

    private void initData() {
        menuDatas = new ArrayList<>();
        int[] icons = {R.mipmap.img_1, R.mipmap.img_2, R.mipmap.img_3, R.mipmap.img_4, R.mipmap.img_5,
                R.mipmap.img_1, R.mipmap.img_2, R.mipmap.img_3, R.mipmap.img_4, R.mipmap.img_5};
        for (int i = 0; i < 10; i++) {
            menuDatas.add(new MenuData(icons[i], "第" + i + "个item"));
        }
    }


    class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(SlidingMenuActivity.this).inflate(R.layout.item_slidingmenu, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.icon.setImageResource(menuDatas.get(position).icon);
            holder.title.setText(menuDatas.get(position).title);
        }

        @Override
        public int getItemCount() {
            return menuDatas.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView icon;
            TextView title;

            public MyViewHolder(View itemView) {
                super(itemView);
                icon = (ImageView) findViewById(R.id.img_icon);
                title = (TextView) findViewById(R.id.tv_item);
            }
        }
    }

    class MenuData {
        public int icon;
        public String title;

        MenuData(int icon, String title) {
            this.icon = icon;
            this.title = title;
        }
    }
}
