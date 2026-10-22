package com.byazt.bb;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.aas.nb;
import com.byazt.aas.zb;
import com.byazt.ete.ic;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 147, 15})
public class uj extends c {
    public final boolean t;

    public uj(com.byazt.eia.sp spVar, Context context, String str, com.byazt.yzg.ve veVar, String str2, boolean z, Map<String, Object> map, boolean z2) {
        this.c = spVar;
        this.ve = context;
        this.uj = str;
        this.n = veVar;
        this.f28312a = str2;
        this.sl = z;
        this.tt = map;
        this.t = z2;
    }

    @Override // com.byazt.bb.c
    public com.byazt.wrq.c n(final Map<String, Object> map) {
        final int iUj = c.uj(map);
        String str = this.uj;
        com.byazt.qt.ve.c(str, str, this.c.q_(), iUj);
        map.put("action_type_button", 2);
        com.byazt.eia.sp spVar = this.c;
        if (spVar != null && !TextUtils.isEmpty(spVar.uj())) {
            map.put("id", Long.valueOf(Double.valueOf(this.c.uj()).longValue()));
        }
        if (!ve(iUj)) {
            ve(map);
            return null;
        }
        com.byazt.wrq.c cVar = new com.byazt.wrq.c() { // from class: com.byazt.bb.uj.1
            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.byazt.ou.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.byazt.qt.ve.c(0, iUj);
                uj ujVar = uj.this;
                ujVar.n.c(ujVar.tt(iUj));
                map.remove("downloadButtonClickListener");
                if (uj.this.c((com.byazt.ete.uj) null, (com.byazt.wrq.c) null, map)) {
                    return;
                }
                uj.this.ve(map);
            }
        };
        com.byazt.qt.ve.c(map, cVar);
        return cVar;
    }

    @Override // com.byazt.bb.c
    public boolean ve(int i) {
        Function<SparseArray<Object>, Object> function = this.da;
        return function != null && com.byazt.qt.ve.c(function, i) == 2;
    }

    @Override // com.byazt.bb.c
    public com.byazt.wrq.uj c(Map<String, Object> map, final zb<String, Object> zbVar) {
        final int iUj = c.uj(zbVar);
        return new com.byazt.wrq.uj() { // from class: com.byazt.bb.uj.2
            @Override // com.byazt.wrq.uj
            public void onItemClick() {
                if (uj.this.x || uj.this.c.x_()) {
                    com.byazt.qt.ve.tt(1, iUj);
                    zbVar.remove("itemClickListener");
                    uj.this.da.apply(com.byazt.yxi.uj.c().c(17).c(Void.class).c(0, zbVar).tt());
                } else {
                    if (uj.this.t) {
                        ic icVarTt = uj.this.tt();
                        uj ujVar = uj.this;
                        com.byazt.ppf.ve.c(icVarTt, ujVar.ve, ujVar.uj, (Map<String, Object>) null, (com.byazt.nd.n) null);
                        return;
                    }
                    uj ujVar2 = uj.this;
                    com.byazt.eia.sp spVar = ujVar2.c;
                    if (spVar instanceof ic) {
                        Context context = ujVar2.ve;
                        String str = ujVar2.uj;
                        new com.byazt.szt.c((ic) spVar, context, str, nb.uj(str), new HashMap(), null, null).c(new HashMap());
                    }
                }
            }
        };
    }
}
