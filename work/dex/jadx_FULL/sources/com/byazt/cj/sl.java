package com.byazt.cj;

import android.content.Context;
import android.view.View;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 158})
public class sl implements com.byazt.kkb.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.byazt.ls.c(c = "view")
    public View f28358a;

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "live_saas_interaction_type")
    public int n = -1;

    @com.byazt.ls.c(c = "handle_chain_data")
    public Map<String, Object> sp;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @com.byazt.ls.c(c = "dpa_tag")
    public String uj;

    @com.byazt.ls.c(c = "event_tag")
    public String ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        int iVe;
        if (!c()) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        if (this.c.mu() != -1001) {
            iVe = this.c.mu();
        } else {
            iVe = com.byazt.apd.tt.c().ve();
            this.c.iu(iVe);
        }
        map2.put("saas_status_while_click", Integer.valueOf(iVe));
        com.byazt.bb.a aVar = new com.byazt.bb.a(this.c, this.tt, this.ve, this.uj, map2);
        int i = this.n;
        if (i != -1) {
            aVar.tt(i);
        }
        aVar.c(this.f28358a);
        aVar.tt(this.sp);
        if (new com.byazt.bb.tt(new com.byazt.bb.n(aVar, this.c, cVar, map2, this.ve), this.tt, this.c, this.ve, map2, cVar).c(new HashMap())) {
            cVar.c(map2);
            return false;
        }
        cVar.c(map2, (com.byazt.qb.c) null);
        return false;
    }

    private boolean c() {
        return (this.c == null || this.tt == null) ? false : true;
    }
}
