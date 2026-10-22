package com.byazt.u;

import com.zj.adlib.c49;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 67, 20})
public class c implements ThreadFactory {
    public final String c;
    public final AtomicInteger tt;
    public final boolean ve;

    public c(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        com.byazt.jtc.ve veVar = new com.byazt.jtc.ve(runnable, this.c + c49.f40900a + this.tt.incrementAndGet());
        if (!this.ve) {
            if (veVar.isDaemon()) {
                veVar.setDaemon(false);
            }
            if (veVar.getPriority() != 5) {
                veVar.setPriority(5);
            }
        }
        return veVar;
    }

    public c(String str, boolean z) {
        this.tt = new AtomicInteger();
        this.c = str;
        this.ve = z;
    }
}
