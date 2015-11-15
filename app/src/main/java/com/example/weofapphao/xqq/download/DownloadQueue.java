package com.example.weofapphao.xqq.download;

import java.io.File;
import java.lang.String;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Rrtoyewx on 15/11/10.
 * 里面封装了多个task，统一管理
 */
public class DownloadQueue {
    public static final String TAG = DownloadQueue.class.getSimpleName();

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    private static final ExecutorService _downloadExcutorService = Executors.newFixedThreadPool(CPU_COUNT + 1);


    private static DownloadQueue _instance;

    private final static PriorityBlockingQueue<DownloadTask> _downloadQueue =
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

    /**
     * add task  to  queue
     *
     * @param task
     * @return
     * @throws Exception
     */

    public boolean addDownloadTask(DownloadTask task) throws Exception {
        synchronized (_downloadQueue) {
            boolean existInQueue = checkTaskInQueue(task);
            boolean existInFile = checkTaskInFile(task);
            if (!existInFile && !existInQueue) {
                return _downloadQueue.add(task);
            }
        }
        return false;
    }

    public void startDownloadTask() throws InterruptedException {
        synchronized (_downloadQueue) {
            while (true) {
                DownloadTask task = _downloadQueue.take();
                _downloadExcutorService.execute(new DownloadTaskRunnable(task));
            }
        }
    }

    public void stop() {
        _downloadExcutorService.shutdownNow();
    }

    public static void restoreQueue() {
        _downloadExcutorService.shutdownNow();
        _downloadQueue.clear();
    }

    /**
     * check downloadqueue exiting
     *
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

    public boolean checkTaskInFile(DownloadTask task) {
        File file = new File(DownloadTask.LOCAL_PATH, task.getFileName());
        if (file.exists()) {
            return true;
        }
        return false;
    }


    class DownloadTaskRunnable implements Runnable {
        private final DownloadTask _task;

        public DownloadTaskRunnable(DownloadTask task) {
            _task = task;
        }

        @Override
        public void run() {
            _task.ready();
            try {
                _task.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
