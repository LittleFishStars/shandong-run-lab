package com.byazt.cc;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 54})
public abstract class ve {
    public Context c;
    public ViewGroup tt;
    public i.c uj;
    public ic ve;

    public abstract String c();

    public void c(Context context, ViewGroup viewGroup, ic icVar) {
        this.c = context;
        this.tt = viewGroup;
        this.ve = icVar;
    }

    public abstract void c(com.byazt.hkv.c cVar);

    public void c(boolean z) {
    }

    public void tt() {
        i.c cVar = this.uj;
        if (cVar != null) {
            cVar.tt();
        }
    }

    public void c(com.byazt.un.uj ujVar, i.c cVar) {
        com.byazt.ddx.uj.ve(this.ve, "splash_ad", c());
        this.tt.setVisibility(0);
        this.uj = cVar;
    }
}
