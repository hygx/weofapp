package com.example.weofapphao.xqq.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Rrtoyewx on 15/11/10.
 * 数据库操作类
 */
public class LocalDataHelper extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME = "download.db";
    private static final int DB_VERSION = 1;
    private static LocalDataHelper mHelper;


    private RuntimeExceptionDao<DownloadInfo, Integer> DownloadInfoRuntimeDAO = null;

    public LocalDataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static void init(Context context){
        if(mHelper==null){
            synchronized (LocalDataHelper.class){
                if(mHelper==null){
                    mHelper = new LocalDataHelper(context);
                }
            }
        }
    }
    public static synchronized LocalDataHelper getLocalHelper(){
        return mHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource,DownloadInfo.class);

            DownloadInfoRuntimeDAO = getDownloadInfoRuntimeDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }


    public RuntimeExceptionDao<DownloadInfo,Integer> getDownloadInfoRuntimeDAO(){
        if(DownloadInfoRuntimeDAO == null){
            synchronized (LocalDataHelper.this){
                if(DownloadInfoRuntimeDAO == null){
                    DownloadInfoRuntimeDAO = getRuntimeExceptionDao(DownloadInfo.class);
                }
            }
        }
        return DownloadInfoRuntimeDAO;
    }
}
