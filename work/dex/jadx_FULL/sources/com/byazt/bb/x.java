package com.byazt.bb;

import android.content.Context;
import com.byazt.eia.da;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 71})
public class x implements com.byazt.hl.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.cq.c f28315a;
    public com.byazt.hl.c c;
    public final boolean da;
    public com.byazt.ny.uj.c i;
    public Map<String, Object> n;
    public int sp;
    public Context tt;
    public String uj;
    public boolean ve;
    public final da x;

    public x(da daVar, Context context, boolean z, String str, Map<String, Object> map, com.byazt.cq.c cVar, int i, boolean z2) {
        this.x = daVar;
        this.tt = context;
        this.ve = z;
        this.uj = str;
        this.n = map;
        this.f28315a = cVar;
        this.sp = i;
        this.da = z2;
    }

    public void c(com.byazt.ny.uj.c cVar) {
        this.i = cVar;
    }

    @Override // com.byazt.hl.c
    public boolean c(final Map<String, Object> map) {
        boolean z = false;
        boolean zC = !com.byazt.wdw.n.c() ? new com.byazt.wdw.n(this.x, this.tt, this.da).c(this.uj).c(this.sp).tt(this.ve).c(this.n).c(new com.byazt.wdw.n.c() { // from class: com.byazt.bb.x.1
            @Override // com.byazt.wdw.n.c
            public void c() {
                if (x.this.i != null) {
                    x.this.i.c(true);
                }
            }

            @Override // com.byazt.wdw.n.c
            public void c(com.byazt.cr.c cVar) {
                if (x.this.c != null ? x.this.c.c(map) : false) {
                    return;
                }
                com.byazt.ppf.ve.c((Map<String, Object>) x.this.n, cVar);
                if (x.this.da) {
                    x.this.f28315a.tt(x.this.n, null);
                } else {
                    x.this.f28315a.c(x.this.n, (com.byazt.qb.c) null);
                }
            }
        }) : false;
        com.byazt.wdw.n.c(false);
        if (zC) {
            return true;
        }
        com.byazt.hl.c cVar = this.c;
        if (cVar != null && cVar.c(map)) {
            z = true;
        }
        com.byazt.ny.uj.c cVar2 = this.i;
        if (cVar2 != null) {
            cVar2.c(z);
        }
        return z;
    }
}
