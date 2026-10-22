package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f32629a = Executors.newSingleThreadExecutor();
    private static Handler b = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        f32629a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        b.post(runnable);
    }
}
