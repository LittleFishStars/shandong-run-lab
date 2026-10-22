package com.byazt.ja;

import com.byazt.nr.m;
import com.byazt.omf.d;
import com.byazt.omf.x;
import com.byazt.pct.nu;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1425, 20})
public class c extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<d> c;

    public c(d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(nu nuVar, final d dVar) {
        nuVar.c("interstitial_webview_close", new com.byazt.pct.uj.tt() { // from class: com.byazt.ja.c.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new c(dVar);
            }
        });
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        x.m().hd();
        m.uj("DoInterstitialWebViewCloseMethod", "DoInterstitialWebViewCloseMethod invoke ");
        d dVar = this.c.get();
        if (dVar == null) {
            m.uj("DoInterstitialWebViewCloseMethod", "invoke error");
            ve();
        } else {
            dVar.nu();
        }
    }
}
