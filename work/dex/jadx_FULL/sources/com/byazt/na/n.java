package com.byazt.na;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 46})
public abstract class n implements Runnable {
    public final String tt;

    public n(String str, Object... objArr) {
        this.tt = da.c(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.tt);
        try {
            tt();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    public abstract void tt();
}
