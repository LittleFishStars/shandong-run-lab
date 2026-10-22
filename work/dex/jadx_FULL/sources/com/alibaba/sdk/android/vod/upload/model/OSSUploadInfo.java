package com.alibaba.sdk.android.vod.upload.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OSSUploadInfo implements Serializable {
    private String bucket;
    private String endpoint;
    private String md5;
    private String object;
    private String videoID;

    public String getBucket() {
        return this.bucket;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getObject() {
        return this.object;
    }

    public String getVideoID() {
        return this.videoID;
    }

    public void setBucket(String str) {
        this.bucket = str;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setObject(String str) {
        this.object = str;
    }

    public void setVideoID(String str) {
        this.videoID = str;
    }
}
