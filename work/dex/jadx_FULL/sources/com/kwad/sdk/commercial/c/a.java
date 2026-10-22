package com.kwad.sdk.commercial.c;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public abstract class a extends com.kwad.sdk.core.response.a.a {
    public int adOperationType;
    public int campaignType;
    public long creativeId;
    public int errorCode;
    public String errorMsg;
    public int industryFirstLevelId;
    public long llsid;
    public int ocpcActionType;
    public long posId;
    public String templateId;
    public String templateVersion;
    public int tkPublishType;
    public int webUriSourceType;

    public a setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return this;
        }
        this.creativeId = e.eY(adTemplate);
        this.llsid = e.eL(adTemplate);
        this.posId = e.eH(adTemplate);
        AdInfo adInfoEO = e.eO(adTemplate);
        this.campaignType = com.kwad.sdk.core.response.helper.a.dw(adInfoEO);
        this.ocpcActionType = com.kwad.sdk.core.response.helper.a.dx(adInfoEO);
        this.industryFirstLevelId = com.kwad.sdk.core.response.helper.a.dy(adInfoEO);
        this.adOperationType = com.kwad.sdk.core.response.helper.a.aW(adInfoEO);
        this.webUriSourceType = com.kwad.sdk.core.response.helper.a.dz(adInfoEO);
        AdMatrixInfo.MatrixTemplate matrixTemplateBB = com.kwad.sdk.commercial.e.bB(adTemplate);
        if (matrixTemplateBB != null) {
            this.templateId = matrixTemplateBB.templateId;
            this.templateVersion = String.valueOf(matrixTemplateBB.templateVersionCode);
            this.tkPublishType = matrixTemplateBB.publishType;
        }
        return this;
    }

    public a setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }

    public a setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public a setLlsid(long j) {
        this.llsid = j;
        return this;
    }

    public a setPosId(long j) {
        this.posId = j;
        return this;
    }
}
