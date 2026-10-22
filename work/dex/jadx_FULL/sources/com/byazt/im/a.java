package com.byazt.im;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, 34})
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28654a;
    public long i;
    public boolean n;
    public long sp;
    public com.byazt.ete.c uj;
    public long x;

    public a(com.byazt.ete.c cVar, boolean z) {
        this.uj = cVar;
        if (cVar != null && cVar.tt() != null && !this.uj.tt().isEmpty()) {
            this.tt = this.uj.tt().get(0);
        }
        this.n = z;
    }

    public long a() {
        return this.f28654a;
    }

    public long i() {
        return this.i;
    }

    public boolean n() {
        return this.n;
    }

    public long sp() {
        return this.sp;
    }

    public void tt(long j) {
        this.f28654a = j;
    }

    public com.byazt.ete.c uj() {
        return this.uj;
    }

    public void ve(long j) {
        this.sp = j;
    }

    public long x() {
        return this.x;
    }

    public void n(long j) {
        this.i = j;
    }

    public void uj(long j) {
        this.x = j;
    }
}
