package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 20})
public abstract class c extends tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28981a;
    public int c;
    public boolean n;
    public int tt;
    public boolean uj;
    public boolean ve;

    public c(Activity activity, ic icVar) {
        super(activity, icVar);
    }

    public void c(int i) {
        this.c = i;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public void uj(boolean z) {
        this.n = z;
    }

    public void ve(boolean z) {
        this.f28981a = z;
    }

    public c(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public void tt(boolean z) {
        this.uj = z;
    }

    @Override // com.byazt.qq.tt
    public tt.c tt(da daVar) {
        u uVar = new u(this.x, this.sp);
        uVar.tt(this.uj);
        uVar.c(this.ve);
        uVar.c(this.c);
        uVar.tt(this.tt);
        uVar.uj(this.sl);
        uVar.ve(this.t);
        uVar.c(this.m);
        uVar.tt(this.z);
        uVar.ve(this.f28981a);
        uVar.uj(this.n);
        return uVar.tt(daVar);
    }
}
