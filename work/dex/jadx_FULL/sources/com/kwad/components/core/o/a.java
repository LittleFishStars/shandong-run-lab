package com.kwad.components.core.o;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    private ImpInfo abn;

    public a(ImpInfo impInfo) {
        this.abn = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        p(adResultData);
    }

    private static void p(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo adInfoEO = e.eO(adTemplate);
            if (com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
                if (com.kwad.sdk.core.response.helper.a.bg(adInfoEO).size() == 0) {
                    com.kwad.components.core.p.a.vL().j(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.helper.a.bo(adInfoEO) && TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(adInfoEO))) {
                com.kwad.components.core.p.a.vL().j(adTemplate, 21006);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.l
    @NonNull
    /* JADX INFO: renamed from: aj */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.abn.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    @Override // com.kwad.sdk.core.network.a
    public ExecutorService getExecutor() {
        return GlobalThreadPools.Oe();
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* JADX INFO: renamed from: pe */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.abn);
    }
}
