package com.kwad.components.ad.reward.retryReward;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class c extends com.kwad.sdk.commercial.c.a {
    public String BA;
    public String Bz;
    public int convertType;
    public int errorCode;
    public String errorMsg;
    public String productName;
    public int status;
    public String tT;

    public static c kE() {
        return new c();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public final c setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public final c ae(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        super.setAdTemplate(adTemplate);
        this.productName = com.kwad.sdk.core.response.helper.a.aD(adInfoEO);
        this.convertType = com.kwad.sdk.core.response.helper.a.dx(adInfoEO);
        return this;
    }

    public final c aq(int i) {
        this.status = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: ar, reason: merged with bridge method [inline-methods] */
    public final c setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public final c c(f fVar) {
        if (fVar == null) {
            return this;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(fVar.mAdTemplate);
        super.setAdTemplate(fVar.mAdTemplate);
        this.productName = com.kwad.sdk.core.response.helper.a.aD(adInfoEO);
        this.convertType = com.kwad.sdk.core.response.helper.a.dx(adInfoEO);
        return this;
    }
}
