package com.kwad.components.ad.reward.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.ad.reward.g Ch;
    private AdTemplate mAdTemplate;
    private Context mContext;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean Ci;
    }

    public t(Context context, com.kwad.components.ad.reward.g gVar) {
        this.mContext = context;
        this.mAdTemplate = gVar.mAdTemplate;
        this.Ch = gVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            a(aVar);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showLandingPage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ch = null;
        this.mContext = null;
        this.mAdTemplate = null;
    }

    private void a(a aVar) {
        if (aVar.Ci) {
            com.kwad.components.ad.reward.presenter.f.r(this.Ch);
        } else {
            AdWebViewActivityProxy.launch(this.mContext, this.mAdTemplate);
        }
    }
}
