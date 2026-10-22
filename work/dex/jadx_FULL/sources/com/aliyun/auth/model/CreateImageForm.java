package com.aliyun.auth.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CreateImageForm {
    private String ImageId;
    private String ImageURL;
    private String RequestId;
    private String UploadAddress;
    private String UploadAuth;

    public String getImageId() {
        return this.ImageId;
    }

    public String getImageURL() {
        return this.ImageURL;
    }

    public String getRequestId() {
        return this.RequestId;
    }

    public String getUploadAddress() {
        return this.UploadAddress;
    }

    public String getUploadAuth() {
        return this.UploadAuth;
    }

    public void setImageId(String str) {
        this.ImageId = str;
    }

    public void setImageURL(String str) {
        this.ImageURL = str;
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
}
