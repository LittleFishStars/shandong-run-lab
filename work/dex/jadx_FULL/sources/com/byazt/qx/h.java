package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 518})
public class h extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.omf.d c;
    public WeakReference<com.byazt.ux.tt> tt;

    public h(com.byazt.omf.d dVar, WeakReference<com.byazt.ux.tt> weakReference) {
        this.c = dVar;
        this.tt = weakReference;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar, WeakReference<com.byazt.ux.tt> weakReference) {
        nuVar.c("pauseRewardCountDown", (com.byazt.pct.n<?, ?>) new h(dVar, weakReference));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<com.byazt.ux.tt> weakReference = this.tt;
        if (weakReference != null && weakReference.get() != null) {
            this.tt.get().c();
            jSONObject2.put("success", true);
        } else {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
