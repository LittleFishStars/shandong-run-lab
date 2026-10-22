package com.alibaba.sdk.android.vod.upload.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SVideoConfig {
    private String accessKeyId;
    private String accessKeySecret;
    private String appId;
    private String expriedTime;
    private String imagePath;
    private boolean isTranscode;
    private long partSize;
    private String requestId;
    private String secrityToken;
    private String storageLocation;
    private String templateGroupId;
    private String userData;
    private String videoId;
    private String videoPath;
    private VodInfo vodInfo;
    private String workFlowId;

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getExpriedTime() {
        return this.expriedTime;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSecrityToken() {
        return this.secrityToken;
    }

    public String getStorageLocation() {
        return this.storageLocation;
    }

    public String getTemplateGroupId() {
        return this.templateGroupId;
    }

    public String getUserData() {
        return this.userData;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public VodInfo getVodInfo() {
        return this.vodInfo;
    }

    public String getWorkFlowId() {
        return this.workFlowId;
    }

    public boolean isTranscode() {
        return this.isTranscode;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setAccessKeySecret(String str) {
        this.accessKeySecret = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setExpriedTime(String str) {
        this.expriedTime = str;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSecrityToken(String str) {
        this.secrityToken = str;
    }

    public void setStorageLocation(String str) {
        this.storageLocation = str;
    }

    public void setTemplateGroupId(String str) {
        this.templateGroupId = str;
    }

    public void setTranscode(boolean z) {
        this.isTranscode = z;
    }

    public void setUserData(String str) {
        this.userData = str;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVodInfo(VodInfo vodInfo) {
        this.vodInfo = vodInfo;
    }

    public void setWorkFlowId(String str) {
        this.workFlowId = str;
    }
}
