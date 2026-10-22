package com.aliyun.aio_stat;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class AioStat {
    public static boolean init(Context context) {
        ContextHolder.setApplicationContext(context);
        return nInit();
    }

    private static native boolean nInit();

    private static native boolean nRelease();

    public static native void nSetApplicationContext(Context context);

    public static boolean release() {
        return nRelease();
    }
}
