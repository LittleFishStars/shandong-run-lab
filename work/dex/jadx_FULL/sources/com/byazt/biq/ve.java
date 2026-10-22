package com.byazt.biq;

import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.kcl.a;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f28320a;
    public int n;
    public final com.byazt.fcd.c sp;
    public final int uj;
    public int c = 0;
    public int tt = 0;
    public int ve = 1000;

    public ve(boolean z, ic icVar, a aVar, com.byazt.fcd.c cVar) {
        this.f28320a = aVar;
        this.sp = cVar;
        this.uj = z ? gt.tt().uj(nb.t(icVar)) : gt.tt().n(nb.t(icVar));
    }

    public int a() {
        return this.tt;
    }

    public long c() {
        return this.f28320a.h();
    }

    public int i() {
        return this.ve;
    }

    public int n() {
        return this.c;
    }

    public void sp() {
        this.c++;
    }

    public int tt() {
        return this.n;
    }

    public int uj() {
        return this.sp.pf();
    }

    public int ve() {
        return this.uj;
    }

    public void x() {
        this.tt++;
    }

    public void c(int i) {
        this.n += i;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public void ve(int i) {
        this.ve = i;
    }
}
