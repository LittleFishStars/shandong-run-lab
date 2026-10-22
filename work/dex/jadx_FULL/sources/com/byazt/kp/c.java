package com.byazt.kp;

import com.byazt.omf.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 667, 20})
public final class c {
    public static void c(d dVar, boolean z, boolean z2, boolean z3) {
        if (dVar == null) {
            return;
        }
        String.format("sendMessage: isVisible = %s, isResume = %s, isForemost = %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            jSONObject.put("adResume", z2);
            jSONObject.put("adForemost", z3);
            dVar.tt("notifyPageVisibilityState", jSONObject);
        } catch (Exception unused) {
        }
    }
}
