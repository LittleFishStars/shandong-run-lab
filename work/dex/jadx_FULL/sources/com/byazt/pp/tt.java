package com.byazt.pp;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28953a;
    public String c;
    public int n;
    public String tt;
    public String uj;
    public String ve;

    @Nullable
    public String a() {
        return this.f28953a;
    }

    @Nullable
    public String c() {
        return this.uj;
    }

    public int n() {
        return this.n;
    }

    public String toString() {
        return "{mediationRit='" + this.c + "', adnName='" + this.tt + "', customAdnName='" + this.ve + "', adType='" + this.uj + "', errCode=" + this.n + ", errMsg=" + this.f28953a + '}';
    }

    @Nullable
    public String tt() {
        return this.c;
    }

    @Nullable
    public String uj() {
        return this.ve;
    }

    @Nullable
    public String ve() {
        return this.tt;
    }

    public tt c(String str) {
        this.uj = str;
        return this;
    }

    public tt n(String str) {
        this.f28953a = str;
        return this;
    }

    public tt tt(String str) {
        this.c = str;
        return this;
    }

    public tt uj(String str) {
        this.ve = str;
        return this;
    }

    public tt ve(String str) {
        this.tt = str;
        return this;
    }

    public tt c(int i) {
        this.n = i;
        return this;
    }
}
