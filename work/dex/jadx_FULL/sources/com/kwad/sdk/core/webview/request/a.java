package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.i;
import com.kwad.sdk.utils.ac;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends d {
    private String bdl;
    private String mUrl;

    public a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.bdl = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            c.printStackTrace(e);
            jSONObject = null;
        }
        c.d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            c.d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        ac.a(this.mBodyParams, jSONObject, true);
        c.d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", p.getUserAgent());
        c.d("WebCardGetDataRequest", "user-agent" + p.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public String getUrl() {
        return i.EI() + this.mUrl;
    }
}
