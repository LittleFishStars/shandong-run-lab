package com.aliyun.svideosdk.transcode;

import android.util.Log;
import com.aliyun.svideosdk.nativeload.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NativeTranscode2 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f25859a = nativeCreate();

    public interface TranscodeCallback {
        void onError(int i);

        void onExit();

        void onProgress(int i);
    }

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private static native long nativeGetDuration(long j);

    private static native int nativeInit(long j, Object obj);

    private native void nativeSetExtraParam(long j, int i, int i2);

    private static native int nativeStart(long j);

    private static native void nativeStop(long j);

    private native void nativeUninit(long j);

    public void cancel() {
        long j = this.f25859a;
        if (j != 0) {
            nativeStop(j);
            return;
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
    }

    public void dispose() {
        long j = this.f25859a;
        if (j != 0) {
            nativeDispose(j);
        } else {
            Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
        }
        this.f25859a = 0L;
    }

    public long getDuration() {
        long j = this.f25859a;
        if (j != 0) {
            return nativeGetDuration(j);
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
        return 0L;
    }

    public int init(NativeTranscode2InitStruct nativeTranscode2InitStruct) {
        long j = this.f25859a;
        if (j != 0) {
            return nativeInit(j, nativeTranscode2InitStruct);
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
        return -4;
    }

    public void setExtraParam(int i, int i2) {
        long j = this.f25859a;
        if (j != 0) {
            nativeSetExtraParam(j, i, i2);
            return;
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
    }

    public int start() {
        long j = this.f25859a;
        if (j != 0) {
            return nativeStart(j);
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
        return -4;
    }

    public void uninit() {
        long j = this.f25859a;
        if (j != 0) {
            nativeUninit(j);
            return;
        }
        Log.e("AliYunLog", "Invalid Jni Handle " + this.f25859a);
    }
}
