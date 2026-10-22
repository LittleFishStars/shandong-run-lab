package com.byazt.ja;

import com.byazt.omf.d;
import com.byazt.pct.nu;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1425, 54})
public class ve extends com.byazt.pct.n<JSONObject, JSONObject> {
    public WeakReference<d> c;

    public ve(d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    public static void c(nu nuVar, d dVar) {
        nuVar.c("rewardPlayAgain", (com.byazt.pct.n<?, ?>) new ve(dVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        d dVar;
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<d> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null || (dVar = this.c.get()) == null) {
            return jSONObject2;
        }
        dVar.gt();
        return jSONObject2;
    }
}
