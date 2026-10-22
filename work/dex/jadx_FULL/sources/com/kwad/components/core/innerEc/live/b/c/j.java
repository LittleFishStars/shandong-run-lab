package com.kwad.components.core.innerEc.live.b.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.EmptyResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j extends com.kwad.components.core.innerEc.live.b.a.a {
    private AdTemplate TQ;

    private void sB() {
        new l<com.kwad.components.core.innerEc.live.h.a, EmptyResultData>() { // from class: com.kwad.components.core.innerEc.live.b.c.j.1
            @NonNull
            private static EmptyResultData aL(String str) {
                JSONObject jSONObject = new JSONObject(str);
                EmptyResultData emptyResultData = new EmptyResultData();
                emptyResultData.parseJson(jSONObject);
                return emptyResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: sC, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.innerEc.live.h.a createRequest() {
                com.kwad.components.core.innerEc.live.base.b bVarAE = com.kwad.components.core.innerEc.live.base.b.rv().aD(com.kwad.components.core.innerEc.live.i.e.aM(j.this.TQ)).aC(com.kwad.components.core.innerEc.live.i.e.aN(j.this.TQ)).aE(com.kwad.components.core.innerEc.live.i.e.getKwaiUserId());
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "liveParam: " + bVarAE.toString());
                Map mapRj = com.kwad.components.core.innerEc.f.rj();
                if (mapRj == null) {
                    mapRj = new HashMap();
                }
                return new com.kwad.components.core.innerEc.live.h.a(bVarAE, mapRj);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aL(str);
            }
        }.request(new o<com.kwad.components.core.innerEc.live.h.a, EmptyResultData>() { // from class: com.kwad.components.core.innerEc.live.b.c.j.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NonNull com.kwad.components.core.innerEc.live.h.a aVar, @NonNull EmptyResultData emptyResultData) {
                super.onSuccess(aVar, emptyResultData);
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "requestStopPlay success");
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.innerEc.live.h.a aVar, int i, String str) {
                super.onError(aVar, i, str);
                com.kwad.sdk.core.d.c.d("LiveStopPlayPresenter", "requestStartPlay error");
            }
        });
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.TQ = this.Ub.mAdTemplate;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        sB();
    }
}
