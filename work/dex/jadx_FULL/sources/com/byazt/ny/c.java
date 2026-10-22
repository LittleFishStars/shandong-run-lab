package com.byazt.ny;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 188, 20})
public class c implements com.byazt.kkb.ve {
    public final com.byazt.eia.tt c = new com.byazt.eia.tt();

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        com.byazt.ppf.ve.c(this.c, cVar.ve(), map, map2);
        if (!c(map2)) {
            cVar.tt(map2, null);
            return true;
        }
        if (new com.byazt.szt.tt(c(map2, com.byazt.bb.c.uj(map2)), this.c.nu()).c(map2)) {
            com.byazt.ppf.ve.c(map2, com.byazt.cr.tt.ve);
            cVar.tt(map2);
        } else {
            cVar.tt(map2, null);
        }
        return true;
    }

    private com.byazt.bb.c c(Map<String, Object> map, int i) {
        com.byazt.eia.tt ttVar = this.c;
        com.byazt.bb.uj ujVar = new com.byazt.bb.uj(ttVar, ttVar.getContext(), this.c.x(), this.c.da(), this.c.yp(), this.c.gt(), map, true);
        ujVar.tt(this.c.u());
        ujVar.c(this.c.t(), i);
        ujVar.c(this.c.i());
        ujVar.c(this.c.sp());
        ujVar.c(this.c.sl());
        ujVar.c(this.c.m());
        ujVar.c(this.c.u_());
        return ujVar;
    }

    private boolean c(Map<String, Object> map) {
        if (com.byazt.ppf.ve.c(this.c, map) == null || this.c.getContext() == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.c.yp())) {
            com.byazt.ete.n nVarZ = this.c.z();
            if (nVarZ != null) {
                this.c.c(nVarZ.tt());
            }
            if (TextUtils.isEmpty(this.c.yp())) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.c.x()) || this.c.da() == null) ? false : true;
    }
}
