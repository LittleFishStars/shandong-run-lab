package com.byazt.mta;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1959, 20})
public class c {
    public static volatile c c;
    public int tt;

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public int tt() {
        return this.tt;
    }

    public void c(int i) {
        if (i <= 0) {
            return;
        }
        this.tt = i;
    }
}
