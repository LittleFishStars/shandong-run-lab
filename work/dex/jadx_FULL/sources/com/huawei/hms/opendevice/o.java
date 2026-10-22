package com.huawei.hms.opendevice;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f37604a;

    public o(Runnable runnable) {
        this.f37604a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.f37604a;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable unused) {
                Log.e("HmsPushThreads", "exception in task run");
            }
        }
    }
}
