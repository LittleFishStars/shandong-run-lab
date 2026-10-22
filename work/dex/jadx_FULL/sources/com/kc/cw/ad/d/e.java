package com.kc.cw.ad.d;

import android.os.Handler;
import android.os.Looper;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f38812a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        f38812a.postDelayed(runnable, j);
    }
}
