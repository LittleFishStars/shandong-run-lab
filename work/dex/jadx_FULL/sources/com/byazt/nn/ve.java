package com.byazt.nn;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 54})
public class ve {
    public static int c = 0;
    public static int tt = 1;
    public static int ve = 2;
    public int uj = c;
    public long n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f28840a = null;
    public int sp = 0;
    public String x = "";
    public String i = "";

    public boolean c() {
        return this.uj == tt;
    }

    public int tt() {
        return this.sp;
    }

    public ve c(int i) {
        this.uj = i;
        return this;
    }

    public ve tt(int i) {
        this.sp = i;
        return this;
    }
}
