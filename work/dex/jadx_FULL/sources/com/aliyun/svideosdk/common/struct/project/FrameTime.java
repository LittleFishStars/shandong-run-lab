package com.aliyun.svideosdk.common.struct.project;

import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FrameTime implements Serializable {
    public double beginTime;
    public double endTime;
    public double maxTime;
    public double minTime;
    public int shrink;

    public double getBeginTime() {
        return this.beginTime;
    }

    public double getEndTime() {
        return this.endTime;
    }

    public double getMaxTime() {
        return this.maxTime;
    }

    public double getMinTime() {
        return this.minTime;
    }

    public int getShrink() {
        return this.shrink;
    }

    public void setBeginTime(double d) {
        this.beginTime = d;
    }

    public void setEndTime(double d) {
        this.endTime = d;
    }

    public void setMaxTime(double d) {
        this.maxTime = d;
    }

    public void setMinTime(double d) {
        this.minTime = d;
    }

    public void setShrink(int i) {
        this.shrink = i;
    }
}
