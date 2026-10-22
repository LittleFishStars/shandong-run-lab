package com.aliyun.auth.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateVideoForm {
    private String RequestId;
    private String UploadAddress;
    private String UploadAuth;
    private String VideoId;

    public String getRequestId() {
        return this.RequestId;
    }

    public String getUploadAddress() {
        return this.UploadAddress;
    }

    public String getUploadAuth() {
        return this.UploadAuth;
    }

    public String getVideoId() {
        return this.VideoId;
    }

    public void setRequestId(String str) {
        this.RequestId = str;
    }

    public void setUploadAddress(String str) {
        this.UploadAddress = str;
    }

    public void setUploadAuth(String str) {
        this.UploadAuth = str;
    }

    public void setVideoId(String str) {
        this.VideoId = str;
    }
}
