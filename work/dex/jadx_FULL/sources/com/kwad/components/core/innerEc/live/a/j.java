package com.kwad.components.core.innerEc.live.a;

import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.components.core.innerEc.live.base.f TF;

    public j(com.kwad.components.core.innerEc.live.base.f fVar) {
        this.TF = fVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            com.kwad.sdk.core.d.c.d("JsHandlerLiveTask", "handleJsCall: " + str);
            LiveDetailReward liveDetailReward = new LiveDetailReward();
            liveDetailReward.parseJson(new JSONObject(str));
            com.kwad.components.core.innerEc.live.base.f fVar = this.TF;
            if (fVar != null) {
                fVar.b(liveDetailReward);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "liveRewardCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
