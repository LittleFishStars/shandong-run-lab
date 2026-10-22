package com.alibaba.sdk.android.vod.upload.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FilePartInfo {
    private int mPartNumber;
    private long mSeek;
    private long mSize;

    public int getPartNumber() {
        return this.mPartNumber;
    }

    public long getSeek() {
        return this.mSeek;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setPartNumber(int i) {
        this.mPartNumber = i;
    }

    public void setSeek(long j) {
        this.mSeek = j;
    }

    public void setSize(long j) {
        this.mSize = j;
    }
}
