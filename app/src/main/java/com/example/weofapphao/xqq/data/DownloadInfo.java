package com.example.weofapphao.xqq.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;import java.lang.Override;import java.lang.String;

/**
 * Created by Rrtoyewx on 15/11/10.
 * DownloadInfo 下载信息类
 */
@DatabaseTable(tableName = "DownloadInfo")
public class DownloadInfo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int threadId;

    @DatabaseField
    private int startPosition;

    @DatabaseField
    private int endPosition;

    @DatabaseField
    private int compeleteSize;

    @DatabaseField
    private String downloadUrl;

    @DatabaseField
    private String name;

    public DownloadInfo() {
    }

    public DownloadInfo(int id, int threadId, int startPosition, int endPosition, int compeleteSize, String downloadUrl, String name) {
        this.id = id;
        this.threadId = threadId;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.compeleteSize = compeleteSize;
        this.downloadUrl = downloadUrl;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public int getCompeleteSize() {
        return compeleteSize;
    }

    public void setCompeleteSize(int compeleteSize) {
        this.compeleteSize = compeleteSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DownloadInfo{" +
                "id=" + id +
                ", threadId=" + threadId +
                ", startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                ", compeleteSize=" + compeleteSize +
                ", downloadUrl='" + downloadUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
