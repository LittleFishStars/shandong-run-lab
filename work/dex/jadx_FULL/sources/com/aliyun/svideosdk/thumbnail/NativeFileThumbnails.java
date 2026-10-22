package com.aliyun.svideosdk.thumbnail;

import com.aliyun.svideosdk.nativeload.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeFileThumbnails extends a {
    public static native long alivcNativeCreate();

    public static native int alivcNativeInit(long j, String str, long j2, long j3);

    public static native int alivcNativeRelease(long j);

    public static native int alivcNativeRequest(long j, long j2, int i, int i2, int i3, int i4, int i5, Object obj);

    public static native synchronized void nativeAddPicTime(long[] jArr, int i, long j);

    public static native synchronized void nativeCancel(long j);

    public static native synchronized long nativeInit();

    public static native synchronized long nativePrepare(String str, FileThumbnailsCallback fileThumbnailsCallback, long j);

    public static native synchronized void nativeRelease(long j, long j2);

    public static native synchronized void nativeSetCutSize(int i, int i2, int i3, int i4, int i5, long j);

    public static native synchronized int nativeSetDstSize(int i, int i2, long j);

    public static native synchronized int nativeSetFastMode(boolean z, long j);

    public static native synchronized void nativeStart(long j);
}
