package com.byazt.hkv;

import android.content.Context;
import android.view.View;
import com.byazt.ete.da;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 19, 13})
public class tt extends uj {
    public final ic c;
    public com.byazt.zo.ve n;
    public final String tt;
    public int uj;
    public final int ve;

    public tt(Context context, ic icVar, String str, int i) {
        super(context);
        this.uj = 1;
        this.c = icVar;
        this.tt = str;
        this.ve = i;
        n();
    }

    private void n() {
        com.byazt.zo.ve veVarC = this.x.c(this.c, this.f28610a, this, c());
        this.n = veVarC;
        veVarC.c(this.sp);
        ((com.byazt.vis.c) c(com.byazt.vis.c.class)).c(this.tt);
        ((com.byazt.nat.c) c(com.byazt.nat.c.class)).c(this.tt);
        ((com.byazt.nat.c) c(com.byazt.nat.c.class)).c(this.ve);
        if (c()) {
            ((com.byazt.nat.c) c(com.byazt.nat.c.class)).uj(true);
        }
    }

    public void c(int i) {
        this.uj = i;
        da daVar = this.sp;
        if (daVar != null) {
            daVar.c(i);
        }
    }

    public boolean c() {
        return false;
    }

    public da tt() {
        return this.sp;
    }

    public void uj(int i) {
        this.sp.tt(i);
    }

    public void ve(int i) {
        this.sp.ve(i);
    }

    public void tt(View view) {
        this.sp.c(view);
    }

    public void tt(int i) {
        this.sp.uj(i);
    }

    public void c(da daVar) {
        this.sp = daVar;
    }

    public void c(View view) {
        this.sp.tt(view);
    }

    @Override // com.byazt.hkv.uj
    public void c(View view, da daVar) {
        if (ic.a(this.c)) {
            return;
        }
        ((com.byazt.nat.c) c(com.byazt.nat.c.class)).c(((com.byazt.vis.c) c(com.byazt.vis.c.class)).n());
        this.n.c(view);
        if (daVar == null) {
            daVar = new da();
        }
        this.n.c(daVar);
        this.n.tt();
        ic.sp(this.c);
    }
}
