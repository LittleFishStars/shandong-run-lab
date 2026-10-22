package com.aliyun.svideosdk.common;

import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunObject {
    protected long mNativeHandle = 0;

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public boolean isNativeRelease() {
        return this.mNativeHandle == 0;
    }

    public void releaseNativeHandle() {
        this.mNativeHandle = 0L;
    }

    public void setNativeHandle(long j) {
        this.mNativeHandle = j;
    }
}
