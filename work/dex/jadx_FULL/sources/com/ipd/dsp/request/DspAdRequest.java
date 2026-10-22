package com.ipd.dsp.request;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class DspAdRequest {
    private String appId;
    private int bidFloor;
    private boolean isDownloadConfirm;
    private final String posId;
    private String userId;

    @Keep
    public DspAdRequest(String str) {
        this.posId = str;
    }

    @Keep
    public String getAppId() {
        return this.appId;
    }

    @Keep
    public int getBidFloor() {
        return this.bidFloor;
    }

    @Keep
    public String getPosId() {
        return this.posId;
    }

    @Keep
    public String getUserId() {
        return this.userId;
    }

    @Keep
    public void isDownloadConfirm(boolean z) {
        this.isDownloadConfirm = z;
    }

    @Keep
    public void setAppId(String str) {
        this.appId = str;
    }

    @Keep
    public void setBidFloor(int i) {
        this.bidFloor = i;
    }

    @Keep
    public void setUserId(String str) {
        this.userId = str;
    }

    @Keep
    public boolean isDownloadConfirm() {
        return this.isDownloadConfirm;
    }
}
