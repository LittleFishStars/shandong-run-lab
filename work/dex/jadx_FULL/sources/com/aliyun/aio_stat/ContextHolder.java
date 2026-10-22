package com.aliyun.aio_stat;

import android.content.Context;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ContextHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f25549a;

    @Keep
    public static Context getApplicationContext() {
        return f25549a;
    }

    @Keep
    public static void setApplicationContext(Context context) {
        setApplicationContext(context, true);
    }

    @Keep
    public static void setApplicationContext(Context context, boolean z) {
        if (context != null) {
            f25549a = context.getApplicationContext();
            if (z) {
                AioStat.nSetApplicationContext(context);
            }
        }
    }
}
