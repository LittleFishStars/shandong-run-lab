package com.byazt.il;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2411, 20})
public class c {
    public String c;
    public Object[] tt;

    public String c() {
        return this.c;
    }

    public String toString() {
        return "MethodResult{methodName='" + this.c + "', args=" + Arrays.toString(this.tt) + '}';
    }

    public Object[] tt() {
        return this.tt;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(Object[] objArr) {
        this.tt = objArr;
    }
}
