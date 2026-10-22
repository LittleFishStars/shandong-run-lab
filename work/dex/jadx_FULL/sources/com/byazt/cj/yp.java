package com.byazt.cj;

import android.content.Context;
import com.byazt.ete.ic;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 215})
public class yp implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "material_meta")
    public ic c;

    @com.byazt.ls.c(c = "context")
    public Context tt;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        Context context;
        ic icVar = this.c;
        if (icVar == null || (context = this.tt) == null) {
            cVar.c(map2, (com.byazt.qb.c) null);
            return true;
        }
        com.byazt.aas.n.c(context, icVar);
        cVar.c(map2);
        return true;
    }
}
