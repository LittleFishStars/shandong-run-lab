package com.beizi.fusion;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f27097a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable, long j) {
        f27097a.postDelayed(runnable, j);
    }
}
