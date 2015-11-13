package com.example.weofapphao.xqq.download;

import android.os.Environment;
import android.util.Log;

import com.example.weofapphao.DownloadApplication;
import com.example.weofapphao.xqq.data.DownloadDataHelper;
import com.example.weofapphao.xqq.data.DownloadInfo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Rrtoyewx on 15/11/10.
 * 单个的任务分成多部分来下载
 */
public class DownloadTask {

    private static final String TAG = DownloadTask.class.getSimpleName();
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final ExecutorService _downloadExcutorService = Executors.newFixedThreadPool(CPU_COUNT + 1);
    public static final String LOCAL_PATH = DownloadApplication.getDownloadApplication().getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();

    private static final int DOWNLOAD_STATE_READY = 0;
    private static final int DOWNLOAD_STATE_DOWNLOADING = 1;
    private static final int DOWNLOAD_STATE_PAUSE = 2;
    private static final int DOWNLOAD_STATTE_DELETE = 3;


    //
    private int _theadCount;

    private String _url;

    private int _fileSize;

    private volatile int _totalCompeleteSize = 0;

    private String _fileName;

    private int _downloadState = DOWNLOAD_STATE_READY;

    private List<DownloadInfo> _downloadList;


    public DownloadTask(int threadCount, String url, String fileName) {
        _url = url;
        _theadCount = threadCount;
        _fileName = fileName;
    }

    public void ready() {
        Log.e(TAG, "ready");
        _totalCompeleteSize = 0;
        _downloadList = DownloadDataHelper.getDownloadHelper().getDownloadListByUrl(_url);
        if (_downloadList.size() == 0) {
            initFirst();
        } else {
            File file = new File(LOCAL_PATH + "/" + _fileName);
            if (!file.exists()) {
                initFirst();
            } else {
                _fileSize = _downloadList.get(_downloadList.size() - 1).getEndPosition();
                for (DownloadInfo info : _downloadList) {
                    _totalCompeleteSize += info.getCompeleteSize();
                }
                Log.e(TAG, "local file totalCompeleteSize" + _totalCompeleteSize);
            }

        }
    }

    public void start() throws Exception {
        Log.e(TAG, "start");
        if (_downloadList == null || _downloadList.size() == 0) {
            throw new Exception("_download must not be null");
        }

        if (_downloadList != null) {
            if (_downloadState == DOWNLOAD_STATE_DOWNLOADING) {
                return;
            }
            _downloadState = DOWNLOAD_STATE_DOWNLOADING;
            for (DownloadInfo info : _downloadList) {
                _totalCompeleteSize += info.getCompeleteSize();
                Runnable runnable = new DownloadRunnable(info);
                _downloadExcutorService.execute(runnable);
            }

        }


    }

    private void initFirst() {
        Log.e(TAG, "initFirst");
        URL url = null;
        RandomAccessFile accessFile = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(_url);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                _fileSize = connection.getContentLength();
                if (_fileSize > 0) {
                    Log.e(TAG, "_fileSize" + _fileSize);
                    File parentFile = new File(LOCAL_PATH);
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    File file = new File(parentFile, _fileName);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    accessFile = new RandomAccessFile(file, "rwd");
                    accessFile.setLength(_fileSize);
                    accessFile.seek(0);

                    int range = _fileSize / _theadCount;
                    _downloadList = new ArrayList<>();
                    for (int i = 0; i < _theadCount - 1; i++) {
                        DownloadInfo info = new DownloadInfo(i, i, i * range, (i + 1) * range - 1, 0, _url, _fileName);
                        _downloadList.add(info);
                    }
                    DownloadInfo info = new DownloadInfo(_theadCount - 1, _theadCount - 1, (_theadCount - 1) * range, _fileSize - 1, 0, _url, _fileName);
                    _downloadList.add(info);

                    DownloadDataHelper.getDownloadHelper().addLists(_downloadList);

                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public String getUrl() {
        return _url;
    }

    public int getFileSize() {
        return _fileSize;
    }

    public int getTotalCompeleteSize() {
        return _totalCompeleteSize;
    }

    public String getFileName() {
        return _fileName;
    }


    class DownloadRunnable implements Runnable {
        private DownloadInfo _info;
        private int infoId;
        private String url;
        private int threadId;
        private int startPosition;
        private int endPosition;
        private int compeleteSize;
        private int totalThreadSize;

        public DownloadRunnable(DownloadInfo info) {
            _info = info;
            infoId = info.getId();
            this.url = info.getDownloadUrl();
            threadId = info.getThreadId();
            startPosition = info.getStartPosition();
            endPosition = info.getEndPosition();
            compeleteSize = info.getCompeleteSize();
            totalThreadSize = endPosition - startPosition + 1;
        }

        @Override
        public void run() {
            Log.e(TAG, "run");
            if (compeleteSize >= totalThreadSize) {
                return;
            }
            HttpURLConnection connection = null;
            RandomAccessFile accessFile = null;
            BufferedInputStream bis = null;

            try {
                URL Url = new URL(url);
                connection = (HttpURLConnection) Url.openConnection();
                accessFile = new RandomAccessFile(LOCAL_PATH + File.separator + _fileName, "rwd");
                accessFile.seek(startPosition + compeleteSize);

                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Range", "bytes=" + (startPosition + compeleteSize) + "-" + endPosition);
                String responseCode = String.valueOf(connection.getResponseCode());

                if (connection.getResponseCode() == HttpURLConnection.HTTP_PARTIAL) {
                    bis = new BufferedInputStream(connection.getInputStream());
                    byte[] buffer = new byte[1024 * 8];
                    int length = -1;
                    while (-1 != (length = bis.read(buffer))) {
                        accessFile.write(buffer, 0, length);
                        compeleteSize += length;
                        _totalCompeleteSize += length;
                        Log.e(TAG, "ThreadID :" + threadId + " ,compelete :" + compeleteSize + " , total :" + totalThreadSize);

                        if (_downloadState != DOWNLOAD_STATE_DOWNLOADING) {
                            break;
                        }
                    }
                    if (compeleteSize >= totalThreadSize) {
                        DownloadDataHelper.getDownloadHelper().deleteById(infoId);
                    } else {
                        _info.setCompeleteSize(compeleteSize);
                        DownloadDataHelper.getDownloadHelper().updataInfo(_info);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (accessFile != null) {
                    try {
                        accessFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }
}

