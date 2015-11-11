package com.example.weofapphao;

import android.app.Application;

import com.example.weofapphao.xqq.data.LocalDataHelper;
import com.example.weofapphao.xqq.download.DownloadQueue;


/**
 * Created by Rrtoyewx on 15/11/10.
 */
public class DownloadApplication extends Application {

    private static DownloadApplication _instance;

    @Override
    public void onCreate() {
        super.onCreate();

        _instance = this;
        LocalDataHelper.init(this);
        DownloadQueue.init();
    }

    public static DownloadApplication getDownloadApplication() {
        return _instance;
    }
}
