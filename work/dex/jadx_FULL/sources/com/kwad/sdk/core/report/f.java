package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.utils.ac;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends com.kwad.sdk.core.network.d {
    protected String aVj;

    public f(List<n> list) {
        this.aVj = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            ac.a(jSONArray, it.next().buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean enablePrivateInfoObtain() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.aVj)) {
            putBody("actionListString", this.aVj);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.aVj)) {
                return bodyParamsString;
            }
            StringBuilder sb = new StringBuilder(bodyParamsString);
            sb.insert(sb.length() - 1, this.aVj);
            return sb.toString();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.i.EQ();
    }

    public f(String str) {
        this.aVj = str;
    }
}
