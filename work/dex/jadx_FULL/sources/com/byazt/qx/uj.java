package com.byazt.qx;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 15})
public class uj extends com.byazt.pct.n<JSONObject, JSONObject> {
    public AtomicBoolean c = new AtomicBoolean(false);
    public AtomicBoolean tt = new AtomicBoolean(false);
    public com.byazt.omf.d ve;

    public uj(com.byazt.omf.d dVar) {
        this.ve = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("businessStatusNotify", (com.byazt.pct.n<?, ?>) new uj(dVar));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null || this.ve == null) {
            return jSONObject2;
        }
        int iOptInt = jSONObject.optInt("status", 0);
        if (iOptInt == 0) {
            this.ve.a(0);
        } else if (iOptInt == 1) {
            int iOptInt2 = jSONObject.optInt("completed", 0);
            int iOptInt3 = jSONObject.optInt("finished", 0);
            if (iOptInt2 == 1 && this.c.compareAndSet(false, true)) {
                this.ve.a(1);
            }
            if (iOptInt3 == 1 && this.tt.compareAndSet(false, true)) {
                this.ve.a(2);
            }
        }
        return jSONObject2;
    }
}
