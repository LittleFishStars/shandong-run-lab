package com.byazt.omf;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aas.nb;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 42})
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f28882a;
    public final Context c;
    public com.byazt.ouz.n n;
    public String sp;
    public final ic tt;
    public com.byazt.ouz.a uj;
    public com.byazt.pop.ve ve;

    public i(Context context, ic icVar, View view, String str) {
        this.sp = "rewarded_video";
        this.tt = icVar;
        this.c = context;
        this.f28882a = view;
        if (TextUtils.isEmpty(str)) {
            this.sp = nb.tt(nb.sl(icVar));
        } else {
            this.sp = str;
        }
        if (icVar.i() == 4) {
            this.ve = com.byazt.yih.x.c(context, icVar, this.sp);
        }
        String str2 = this.sp;
        com.byazt.ouz.a aVar = new com.byazt.ouz.a(context, icVar, str2, nb.uj(str2));
        this.uj = aVar;
        aVar.c(this.f28882a);
        ((com.byazt.nat.c) this.uj.c(com.byazt.nat.c.class)).c(this.ve);
        String str3 = this.sp;
        com.byazt.ouz.n nVar = new com.byazt.ouz.n(context, icVar, str3, nb.uj(str3));
        this.n = nVar;
        nVar.c(this.f28882a);
        ((com.byazt.nat.c) this.n.c(com.byazt.nat.c.class)).c(this.ve);
    }

    public void c(int i, com.byazt.ete.gr grVar) {
        com.byazt.ouz.n nVar;
        if (i == -1 || grVar == null) {
            return;
        }
        com.byazt.ete.da daVar = new com.byazt.ete.da();
        daVar.c(grVar.c);
        daVar.tt(grVar.tt);
        daVar.ve(grVar.ve);
        daVar.uj(grVar.uj);
        daVar.tt(grVar.z);
        daVar.c(grVar.nu);
        if (i != 1) {
            if (i == 2 && (nVar = this.n) != null) {
                nVar.c(grVar);
                this.n.c(daVar);
                this.n.c(this.f28882a, daVar);
                return;
            }
            return;
        }
        com.byazt.ouz.a aVar = this.uj;
        if (aVar != null) {
            aVar.c(grVar);
            this.uj.c(daVar);
            this.uj.c(this.f28882a, daVar);
        }
    }
}
