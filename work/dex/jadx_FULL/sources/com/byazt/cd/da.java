package com.byazt.cd;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 72})
public class da implements Runnable {
    public WeakReference<Runnable> c;

    public da(Runnable runnable) {
        this.c = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.c.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
