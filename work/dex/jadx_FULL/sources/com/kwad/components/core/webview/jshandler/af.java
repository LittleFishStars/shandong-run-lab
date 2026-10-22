package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class af implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b apJ;
    private final boolean aqq = false;
    private com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> aqr;

    public static final class a implements com.kwad.sdk.core.b {
        AdResultData mAdResultData;

        public a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    jSONArray.put(adTemplate.toJson());
                } else {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                }
            }
            com.kwad.sdk.utils.ac.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public af(com.kwad.sdk.core.webview.b bVar) {
        this.apJ = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.aqr;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!this.aqq) {
            if (this.apJ.Pv()) {
                cVar.onError(-1, "native adTemplate is null");
                return;
            } else {
                cVar.b(new a(this.apJ.iH()));
                return;
            }
        }
        AdTemplate adTemplate = this.apJ.getAdTemplate();
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        SceneImpl sceneImpl = adTemplate.mAdScene;
        if (sceneImpl != null) {
            impInfo.pageScene = sceneImpl.getPageScene();
        }
        impInfo.subPageScene = 106L;
        impInfo.adScene.setAdNum(12);
        impInfo.sdkExtraData = com.kwad.sdk.core.response.helper.e.eX(adTemplate);
        a(impInfo, cVar);
    }

    private void a(final ImpInfo impInfo, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar = this.aqr;
        if (lVar != null) {
            lVar.cancel();
        }
        com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: aj, reason: merged with bridge method [inline-methods] */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: pe, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.a createRequest() {
                return new com.kwad.components.core.request.a(impInfo);
            }
        };
        this.aqr = lVar2;
        lVar2.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.af.2
            private void n(@NonNull final AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.af.2.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            cVar.b(adResultData);
                        }
                    });
                    return;
                }
                StringBuilder sb = new StringBuilder("onError:");
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(com.kwad.sdk.core.network.e.aTe.errorCode);
                objArr[1] = TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg;
                sb.append(String.format("code:%s__msg:%s", objArr));
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", sb.toString());
                by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.af.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        cVar.b(adResultData);
                    }
                });
            }

            private void o(int i, String str) {
                com.kwad.sdk.core.d.c.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                af.this.a(cVar);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.f fVar, int i, String str) {
                o(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar) {
        by.runOnUiThread(new com.kwad.sdk.utils.bi() { // from class: com.kwad.components.core.webview.jshandler.af.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                cVar.b(adResultData);
            }
        });
    }
}
