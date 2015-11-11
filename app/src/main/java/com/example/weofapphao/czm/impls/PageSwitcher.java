package com.example.weofapphao.czm.impls;

import android.app.Activity;
import android.content.Intent;

import com.example.weofapphao.czm.ui.CzmHomeActivity;
import com.example.weofapphao.czm.interfaces.IPageSwitcher;

/**
 * Created by caozhimin on 2015/11/10.
 */
public class PageSwitcher implements IPageSwitcher{
    private Activity fromActivity;
    public PageSwitcher(Activity activity) {
        this.fromActivity = activity;
    }
    @Override
    public void toCzmHomePage() {
        Intent intent=new Intent(fromActivity, CzmHomeActivity.class);
        fromActivity.startActivity(intent);
    }

    @Override
    public void toActivityByClass(Class clazz) {
        Intent intent=new Intent(fromActivity, clazz);
        fromActivity.startActivity(intent);
    }
}
