package com.byazt.mg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 130})
public final class m {
    public static Thread c(Runnable runnable, String str) {
        if (runnable == null) {
            return null;
        }
        com.byazt.jtc.ve veVar = str == null ? new com.byazt.jtc.ve(runnable, "hreadExecutor") : new com.byazt.jtc.ve(runnable, str);
        veVar.start();
        return veVar;
    }

    public static Thread c(Runnable runnable) {
        return c(runnable, null);
    }
}
