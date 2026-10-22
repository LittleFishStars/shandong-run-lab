package com.aliyun.player.nativeclass;

import android.content.Context;
import com.aliyun.utils.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JniUrlListPlayer extends JniListPlayerBase {
    private static final String TAG = "JniUrlListPlayer";

    static {
        f.b();
    }

    public JniUrlListPlayer(Context context, long j, long j2) {
        super(context, j, j2);
    }

    public static void loadClass() {
    }

    public void addUrl(String str, String str2) {
        nAddUrl(str, str2);
    }

    public void addUrl(String str, String str2, PreloadConfig preloadConfig) {
        nAddUrl(str, str2, preloadConfig);
    }

    public long getCurrentPlayerIndex() {
        return nGetCurrentPlayerIndex();
    }

    public long getPreRenderPlayerIndex() {
        return nGetPreRenderPlayerIndex();
    }

    public boolean moveTo(String str) {
        return nMoveTo(str);
    }

    public boolean moveToNext(boolean z) {
        return nMoveToNext(z);
    }

    public boolean moveToPrev() {
        return nMoveToPrev();
    }

    public native void nAddUrl(String str, String str2);

    public native void nAddUrl(String str, String str2, Object obj);

    public native long nGetCurrentPlayerIndex();

    public native long nGetPreRenderPlayerIndex();

    public native boolean nMoveTo(String str);

    public native boolean nMoveToNext(boolean z);

    public native boolean nMoveToPrev();
}
