package com.alibaba.alibclinkpartner.smartlink;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f23567a = new Handler(Looper.getMainLooper());
    private static ExecutorService b = Executors.newCachedThreadPool();

    public static void a(Runnable runnable) {
        if (runnable != null) {
            b.execute(runnable);
        }
    }
}
