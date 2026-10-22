package com.byazt.gqp;

import com.byazt.eg.md;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 323, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28580a;
    public long c;
    public long n;
    public long sp;
    public long tt;
    public long uj;
    public long ve;

    public sl() {
        this.c = System.currentTimeMillis();
    }

    public void c() {
        this.ve = System.currentTimeMillis();
    }

    public void tt() {
        this.uj = System.currentTimeMillis();
    }

    public void uj() {
        this.tt = System.currentTimeMillis();
    }

    public void ve() {
        this.n = System.currentTimeMillis();
    }

    public void c(long j) {
        this.f28580a = j;
    }

    public void tt(long j) {
        this.sp = j;
    }

    public sl(Object obj) {
        this.c = System.currentTimeMillis();
        try {
            if (obj instanceof md) {
                md mdVar = (md) obj;
                this.c = mdVar.uj();
                this.tt = mdVar.da();
                this.ve = mdVar.n();
                this.uj = mdVar.a();
                this.n = mdVar.sp();
                this.f28580a = mdVar.x();
                this.sp = mdVar.i();
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }
}
