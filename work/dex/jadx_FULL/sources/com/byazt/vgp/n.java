package com.byazt.vgp;

import com.byazt.omf.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1713, 46})
public class n implements com.byazt.zb.ve {
    public d c;

    public n(d dVar) {
        this.c = dVar;
    }

    @Override // com.byazt.zb.ve
    public void c(String str, JSONObject jSONObject) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.tt(str, jSONObject);
        }
    }
}
