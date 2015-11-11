package com.example.weofapphao.xqq.download;

import java.io.File;
import java.lang.String;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Rrtoyewx on 15/11/10.
 * 里面封装了多个task，统一管理
 */
public class DownloadQueue {
    public static final String TAG = DownloadQueue.class.getSimpleName();

    private static DownloadQueue _instance;

    private final PriorityBlockingQueue<DownloadTask> _downloadQueue =
            new PriorityBlockingQueue<>();

    private DownloadQueue() {

    }

    public static void init() {
        if (_instance == null) {
            synchronized (DownloadQueue.class) {
                if (_instance == null) {
                    _instance = new DownloadQueue();
                }
            }
        }
    }

    public boolean addDownloadTask(DownloadTask task) {
        synchronized (_downloadQueue) {

            boolean exits = checkTaskInQueue(task);


        }


        return false;
    }

    /**
     * check downloadqueue exiting
     * @param task
     * @return
     */
    public boolean checkTaskInQueue(DownloadTask task) {
        if (_downloadQueue.size() > 0) {
            for (DownloadTask downloadTask : _downloadQueue) {
                if (downloadTask.getUrl().equals(task.getUrl())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkTaskInFile(DownloadTask task){
        File file = new File(DownloadTask.LOCAL_PATH,task.getFileName());
        if(file.exists()){

        }

        return true;
    }


}
