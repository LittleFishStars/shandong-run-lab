package com.igexin.push.core;

import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a extends Thread {
    public abstract void a();

    public abstract String b();

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Thread.currentThread().setName(b());
        if (Looper.myLooper() == null) {
            Looper.prepare();
            Looper.loop();
        }
    }
}
