package com.byazt.msj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1898, 54})
public class ve extends com.byazt.mc.ve implements Runnable {
    public final Runnable uj;

    public ve(Runnable runnable) {
        super(runnable);
        this.uj = runnable;
        tt(false);
        c(false);
    }

    @Override // com.byazt.mc.ve, java.lang.Runnable
    public void run() {
        this.uj.run();
    }
}
