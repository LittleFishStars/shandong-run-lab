package com.byazt.sb;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1065, 20})
public class c implements ThreadFactory {
    public final ThreadGroup c;
    public final AtomicInteger tt = new AtomicInteger(1);

    public c(String str) {
        this.c = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(this.c, runnable, "tt_img_" + this.tt.getAndIncrement());
        if (veVar.isDaemon()) {
            veVar.setDaemon(false);
        }
        return veVar;
    }
}
