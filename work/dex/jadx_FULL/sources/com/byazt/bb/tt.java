package com.byazt.bb;

import android.content.Context;
import com.byazt.eia.i;
import com.byazt.ete.yp;
import com.byazt.xs.da;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 13})
public class tt implements com.byazt.hl.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f28313a;
    public i c;
    public com.byazt.cq.c n;
    public Context tt;
    public com.byazt.hl.c uj;
    public String ve;

    public tt(com.byazt.hl.c cVar, Context context, i iVar, String str, Map<String, Object> map, com.byazt.cq.c cVar2) {
        this.uj = cVar;
        this.tt = context;
        this.c = iVar;
        this.ve = str;
        this.n = cVar2;
        this.f28313a = map;
    }

    @Override // com.byazt.hl.c
    public boolean c(final Map<String, Object> map) {
        yp ypVarMy;
        if (this.c.n() == 9 && Objects.equals(this.f28313a.get("saas_status_while_click"), 2)) {
            ypVarMy = this.c.D_() != null ? this.c.D_().tt() : null;
        } else {
            ypVarMy = this.c.my();
        }
        if (!com.byazt.wdw.ve.c(ypVarMy, false)) {
            com.byazt.hl.c cVar = this.uj;
            return cVar != null && cVar.c(map);
        }
        if (da.n(com.byazt.ppf.ve.c(this.c, this.f28313a))) {
            com.byazt.hl.c cVar2 = this.uj;
            return cVar2 != null && cVar2.c(map);
        }
        if (da.uj(com.byazt.ppf.ve.c(this.c, this.f28313a))) {
            com.byazt.hl.c cVar3 = this.uj;
            return cVar3 != null && cVar3.c(map);
        }
        new com.byazt.wdw.ve(this.c, ypVarMy, this.tt, this.f28313a).c(this.ve).c(new com.byazt.wdw.ve.c() { // from class: com.byazt.bb.tt.1
            @Override // com.byazt.wdw.ve.c
            public void c() {
                if (tt.this.uj.c(map)) {
                    return;
                }
                tt.this.n.c(tt.this.f28313a, (com.byazt.qb.c) null);
            }
        });
        return true;
    }
}
