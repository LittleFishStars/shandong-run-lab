package com.byazt.zm;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 482, 20})
public class c {
    public int c;
    public String tt;

    public c(int i, String str) {
        this.c = i;
        this.tt = str;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        return "GMCustomAdError{mCode=" + this.c + ", mMessage='" + this.tt + "'}";
    }

    @Nullable
    public String tt() {
        return this.tt;
    }
}
