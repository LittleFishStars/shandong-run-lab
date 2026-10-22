package com.byazt.nn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 91})
public class sp {
    public int c;
    public int tt;
    public String ve;

    public sp(int i) {
        this(i, 0, null);
    }

    public int c() {
        return this.tt;
    }

    public int getType() {
        return this.c;
    }

    public String tt() {
        return this.ve;
    }

    public sp(int i, int i2) {
        this(i, i2, null);
    }

    public sp(int i, String str) {
        this(i, 0, str);
    }

    public sp(int i, int i2, String str) {
        this.c = i;
        this.tt = i2;
        this.ve = str;
    }
}
