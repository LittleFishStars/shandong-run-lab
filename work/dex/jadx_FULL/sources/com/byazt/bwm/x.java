package com.byazt.bwm;

import com.ali.auth.third.login.LoginConstants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 71})
public class x implements ThreadFactory {
    public final String c;
    public final ThreadGroup tt;
    public final AtomicInteger uj;
    public int ve;

    public x(String str) {
        this(5, str);
    }

    public Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new com.byazt.jtc.ve(threadGroup, runnable, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadC = c(this.tt, runnable, this.c + LoginConstants.UNDER_LINE + this.uj.getAndIncrement());
        if (threadC.isDaemon()) {
            threadC.setDaemon(false);
        }
        int i = this.ve;
        if (i > 10) {
            this.ve = 10;
        } else if (i <= 0) {
            this.ve = 1;
        }
        threadC.setPriority(this.ve);
        return threadC;
    }

    public x(int i, String str) {
        this.uj = new AtomicInteger(1);
        this.ve = i;
        this.tt = new ThreadGroup("csj_g_" + str);
        StringBuilder sb = new StringBuilder("csj_");
        sb.append(i.tt.a() ? "p" : "");
        sb.append(str);
        this.c = sb.toString();
    }
}
