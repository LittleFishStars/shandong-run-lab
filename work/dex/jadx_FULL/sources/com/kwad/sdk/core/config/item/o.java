package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class o extends s {
    private JSONObject aRe;

    public o(String str) {
        this(str, "{}");
    }

    public final int ek(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.aRe) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    private o(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue(str);
        try {
            this.aRe = new JSONObject(getValue());
        } catch (NullPointerException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
        }
    }
}
