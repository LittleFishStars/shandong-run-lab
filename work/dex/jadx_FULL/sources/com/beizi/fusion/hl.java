package com.beizi.fusion;

import android.content.Context;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class hl extends bb {
    public hl(Context context, String str) {
        super(context, str);
    }

    @Override // com.beizi.fusion.bb
    public void a(String str) {
        JSONArray jSONArrayB = mg.b(str);
        if (jSONArrayB != null) {
            for (int i = 0; i < jSONArrayB.length(); i++) {
                nf.b().a(this.b, jSONArrayB.optString(i), ph.TEMPORARY);
            }
        }
    }
}
