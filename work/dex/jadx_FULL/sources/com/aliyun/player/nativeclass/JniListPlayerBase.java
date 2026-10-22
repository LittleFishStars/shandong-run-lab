package com.aliyun.player.nativeclass;

import android.content.Context;
import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JniListPlayerBase {
    private long mNativeContext = 0;

    static {
        f.b();
    }

    public JniListPlayerBase(Context context, long j, long j2) {
        nConstruct(j, j2);
    }

    public static void loadClass() {
    }

    public void clear() {
        nClear();
    }

    public void enablePreloadStrategy(int i, boolean z) {
        nEnablePreloadStrategy(i, z);
    }

    public String getCurrentUid() {
        return nGetCurrentUid();
    }

    public int getMaxPreloadMemorySizeMB() {
        return nGetMaxPreloadMemorySizeMB();
    }

    public long getNativeListContext() {
        return this.mNativeContext;
    }

    public native void nClear();

    public native void nConstruct(long j, long j2);

    public native void nEnablePreloadStrategy(int i, boolean z);

    public native String nGetCurrentUid();

    public native int nGetMaxPreloadMemorySizeMB();

    public native void nRelease();

    public native void nRemoveSource(String str);

    public native void nSetMaxPreloadMemorySizeMB(int i);

    public native void nSetPreloadCount(int i);

    public native void nSetPreloadCount(int i, int i2);

    public native void nSetPreloadScene(int i);

    public native void nSetPreloadStrategyParam(int i, String str);

    public native void nStop();

    public native void nUpdatePreloadConfig(Object obj);

    public native void nUpdatePreloadConfig(String str, Object obj);

    public void release() {
        nRelease();
    }

    public void removeSource(String str) {
        nRemoveSource(str);
    }

    public void setMaxPreloadMemorySizeMB(int i) {
        nSetMaxPreloadMemorySizeMB(i);
    }

    public void setNativeListContext(long j) {
        this.mNativeContext = j;
    }

    public void setPreloadCount(int i) {
        nSetPreloadCount(i);
    }

    public void setPreloadCount(int i, int i2) {
        nSetPreloadCount(i, i2);
    }

    public void setPreloadScene(int i) {
        nSetPreloadScene(i);
    }

    public void setPreloadStrategyParam(int i, String str) {
        nSetPreloadStrategyParam(i, str);
    }

    public void stop() {
        nStop();
    }

    public void updatePreloadConfig(PreloadConfig preloadConfig) {
        nUpdatePreloadConfig(preloadConfig);
    }

    public void updatePreloadConfig(String str, PreloadConfig preloadConfig) {
        nUpdatePreloadConfig(str, preloadConfig);
    }
}
