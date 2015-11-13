package com.example.weofapphao.xqq.data;


import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.lang.Integer;import java.lang.Object;import java.lang.String;import java.util.HashMap;
import java.util.List;

/**
 * Created by Rrtoyewx on 15/11/10.
 */
public class DownloadDataHelper {
    private final LocalDataHelper _localHelper;
    private final RuntimeExceptionDao<DownloadInfo, Integer> _dao;

    private static DownloadDataHelper _instance = new DownloadDataHelper();

    private DownloadDataHelper() {
        _localHelper = LocalDataHelper.getLocalHelper();
        _dao = _localHelper.getDownloadInfoRuntimeDAO();
    }

    public static DownloadDataHelper getDownloadHelper(){
        return _instance;
    }


    public void addLists(List<DownloadInfo> infos) {
        for (DownloadInfo info : infos) {
            _dao.createOrUpdate(info);
        }
    }

    public List<DownloadInfo> getDownloadListByUrl(String url) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("downloadUrl", url);
        return _dao.queryForFieldValues(query);
    }


    public void updataInfo(DownloadInfo info){
        _dao.update(info);
    }


    public void deleteByUrl(String url) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("downloadUrl", url);

        _dao.delete(getDownloadListByUrl(url));
    }

    public void deleteById(int id){
        _dao.deleteById(id);
    }

}
