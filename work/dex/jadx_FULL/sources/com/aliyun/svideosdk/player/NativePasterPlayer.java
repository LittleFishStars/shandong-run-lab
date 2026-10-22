package com.aliyun.svideosdk.player;

import android.view.Surface;
import com.aliyun.svideosdk.nativeload.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NativePasterPlayer extends a {
    public native void addTimeIndex(long j, long j2, int i);

    public native void draw(long j, long j2);

    public native long initialize();

    public native void release(long j);

    public native void setSource(long j, String str);

    public native void setWindow(long j, Surface surface);
}
