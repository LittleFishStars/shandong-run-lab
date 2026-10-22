package com.huachenjie.run.bean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class SubDistanceRecord {
    private int calTimes;
    private long lastCalDistance;
    private long lastCalPaceTime;
    private long lastUploadDistance;

    public int getCalTimes() {
        return this.calTimes;
    }

    public long getLastCalDistance() {
        return this.lastCalDistance;
    }

    public long getLastCalPaceTime() {
        return this.lastCalPaceTime;
    }

    public long getLastUploadDistance() {
        return this.lastUploadDistance;
    }

    public void setCalTimes(int calTimes) {
        this.calTimes = calTimes;
    }

    public void setLastCalDistance(long lastCalDistance) {
        this.lastCalDistance = lastCalDistance;
    }

    public void setLastCalPaceTime(long lastCalPaceTime) {
        this.lastCalPaceTime = lastCalPaceTime;
    }

    public void setLastUploadDistance(long lastUploadDistance) {
        this.lastUploadDistance = lastUploadDistance;
    }
}
