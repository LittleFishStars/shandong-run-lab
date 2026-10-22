package com.byazt.im;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 91})
public class sp extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28656a;
    public long da;
    public com.byazt.nc.tt i;
    public String n;
    public int sl;
    public int sp;
    public int uj;
    public boolean x;

    public sp() {
        this.uj = -1;
        this.n = "unknown";
        this.f28656a = false;
        this.x = false;
        this.sl = -1;
    }

    public boolean a() {
        return this.f28656a;
    }

    public void c(String str) {
        this.n = str;
    }

    public com.byazt.nc.tt i() {
        return this.i;
    }

    public String n() {
        return TextUtils.isEmpty(this.n) ? "unknown" : this.n;
    }

    public int sp() {
        return this.sp;
    }

    public void tt(int i) {
        this.uj = i;
    }

    public int uj() {
        return this.uj;
    }

    public void ve(int i) {
        this.sl = i;
    }

    public boolean x() {
        return this.x;
    }

    public void c(boolean z) {
        this.f28656a = z;
    }

    public void tt(boolean z) {
        this.x = z;
    }

    public void uj(int i) {
        this.sp = i;
    }

    @Override // com.byazt.im.c
    public long ve() {
        return this.da;
    }

    public void c(com.byazt.nc.tt ttVar) {
        this.i = ttVar;
    }

    @Override // com.byazt.im.c
    public void c(long j) {
        this.da = j;
    }

    public sp(int i, String str, boolean z) {
        this.f28656a = false;
        this.sl = -1;
        this.uj = i;
        this.n = str;
        this.x = z;
    }
}
