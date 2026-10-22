package com.autonavi.base.amap.mapcore;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class LinkInfo {
    private int state = 0;
    private int time = 0;
    private int length = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public String toString() {
        return "状态：" + this.state + "|时间：" + this.time + "|长度：" + this.length;
    }
}
