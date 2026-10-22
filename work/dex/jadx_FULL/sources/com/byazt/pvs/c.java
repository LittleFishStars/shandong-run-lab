package com.byazt.pvs;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 705, 20})
public class c {
    public static volatile tt c;

    public static tt c(com.byazt.vb.n nVar) {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new ve(new a(nVar), nVar);
                }
            }
        }
        return c;
    }
}
