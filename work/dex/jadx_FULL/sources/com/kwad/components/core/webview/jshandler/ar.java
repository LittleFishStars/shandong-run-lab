package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.smallApp.JumpFrom;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class ar implements com.kwad.sdk.core.webview.c.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public ar(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.a.c cVar2 = new com.kwad.components.core.webview.a.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
            return;
        }
        AdTemplate adTemplate = null;
        try {
            cVar2.parseJson(new JSONObject(str));
            AdTemplate adTemplateA = this.mAdTemplate;
            try {
                int i = cVar2.apo;
                if (i > 0) {
                    adTemplateA = com.kwad.sdk.core.response.helper.c.a(com.kwad.components.core.offline.a.f.a.a.bp(i), cVar2.PC);
                }
                if (adTemplateA == null) {
                    com.kwad.sdk.core.adlog.c.n(this.mAdTemplate, 2);
                    cVar.onError(-1, "adTemplate为空：" + cVar2.apo);
                    return;
                }
                if (com.kwad.components.core.e.d.f.a(this.mContext, cVar2.bB(com.kwad.sdk.core.response.helper.a.du(com.kwad.sdk.core.response.helper.e.eO(adTemplateA))), JumpFrom.H5, adTemplateA) == 1) {
                    cVar.b(null);
                } else {
                    cVar.onError(-1, "跳转失败");
                }
            } catch (Exception e) {
                e = e;
                adTemplate = adTemplateA;
                com.kwad.sdk.core.adlog.c.n(adTemplate, 2);
                cVar.onError(-1, "解析失败");
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
