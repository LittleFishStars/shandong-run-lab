package com.acse.ottn.model;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdInfoModel implements Serializable {
    private String adId;
    private String adType;
    private int countdown;
    private String deeplink;
    private String img;
    private String link;
    private String mediaType;
    private String packageName;
    private int r;
    private boolean showPermissionDialog;
    private String showDisLike = "0";
    private String showBigClose = "0";

    public String getAdId() {
        return this.adId;
    }

    public String getAdType() {
        return this.adType;
    }

    public int getCountdown() {
        return this.countdown;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getImg() {
        return this.img;
    }

    public String getLink() {
        return this.link;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getR() {
        return this.r;
    }

    public String getShowBigClose() {
        return this.showBigClose;
    }

    public String getShowDisLike() {
        return this.showDisLike;
    }

    public boolean isShowPermissionDialog() {
        return this.showPermissionDialog;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setCountdown(int i) {
        this.countdown = i;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setMediaType(String str) {
        this.mediaType = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setR(int i) {
        this.r = i;
    }

    public void setShowBigClose(String str) {
        this.showBigClose = str;
    }

    public void setShowDisLike(String str) {
        this.showDisLike = str;
    }

    public void setShowPermissionDialog(boolean z) {
        this.showPermissionDialog = z;
    }

    public String toString() {
        return "AdInfoModel{r=" + this.r + ", adType='" + this.adType + "', adId='" + this.adId + "', mediaType='" + this.mediaType + "', showPermissionDialog=" + this.showPermissionDialog + ", img='" + this.img + "', delink='" + this.deeplink + "', link='" + this.link + "'}";
    }
}
