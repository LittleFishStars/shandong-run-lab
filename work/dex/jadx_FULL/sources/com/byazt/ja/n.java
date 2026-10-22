package com.byazt.ja;

import com.byazt.ete.ic;
import com.byazt.omf.d;
import com.byazt.pct.nu;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1425, 46})
public class n extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<d> c;

    public n(d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(nu nuVar, final d dVar) {
        nuVar.c("openPrivacy", new com.byazt.pct.uj.tt() { // from class: com.byazt.ja.n.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new n(dVar);
            }
        });
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        d dVar;
        ic icVarX;
        WeakReference<d> weakReference = this.c;
        if (weakReference == null || (dVar = weakReference.get()) == null || (icVarX = dVar.x()) == null) {
            return;
        }
        com.byazt.aas.n.c(aVar.getContext(), icVarX);
        dVar.qp();
    }
}
