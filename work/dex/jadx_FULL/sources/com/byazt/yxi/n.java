package com.byazt.yxi;

import android.util.SparseArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1133, 46})
public class n {
    public final SparseArray<Object> c = new SparseArray<>();

    private n() {
    }

    public static n c() {
        return new n();
    }

    public SparseArray<Object> tt() {
        return this.c;
    }

    public n c(int i) {
        this.c.put(-999900, Integer.valueOf(i));
        return this;
    }

    public n c(String str) {
        this.c.put(-999901, str);
        return this;
    }

    public n c(boolean z) {
        this.c.put(-999903, Boolean.valueOf(z));
        return this;
    }

    public n c(SparseArray<Object> sparseArray) {
        this.c.put(-999902, sparseArray);
        return this;
    }
}
