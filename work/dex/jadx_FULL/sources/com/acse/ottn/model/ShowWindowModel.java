package com.acse.ottn.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShowWindowModel {
    private String appName = "";
    private String showBigWindowData = "";
    private int showSmailWindowSize = 0;
    private long shawWindowTime = 0;

    public String getAppName() {
        return this.appName;
    }

    public long getShawWindowTime() {
        return this.shawWindowTime;
    }

    public String getShowBigWindowData() {
        return this.showBigWindowData;
    }

    public int getShowSmailWindowSize() {
        return this.showSmailWindowSize;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setShawWindowTime(long j) {
        this.shawWindowTime = j;
    }

    public void setShowBigWindowData(String str) {
        this.showBigWindowData = str;
    }

    public void setShowSmailWindowSize(int i) {
        this.showSmailWindowSize = i;
    }

    public String toString() {
        return "ShowWindowModel{appName='" + this.appName + "', showBigWindowData='" + this.showBigWindowData + "', showSmailWindowSize=" + this.showSmailWindowSize + ", shawWindowTime=" + this.shawWindowTime + '}';
    }
}
