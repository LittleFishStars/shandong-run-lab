package com.byazt.di;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 345, 91})
public class sp {
    public static volatile sp c;
    public com.byazt.ou.a tt = null;

    private sp() {
    }

    public static sp c() {
        if (c == null) {
            synchronized (sp.class) {
                if (c == null) {
                    c = new sp();
                }
            }
        }
        return c;
    }

    public com.byazt.ou.a tt() {
        return this.tt;
    }
}
