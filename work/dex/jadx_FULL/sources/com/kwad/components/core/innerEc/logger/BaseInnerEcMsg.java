package com.kwad.components.core.innerEc.logger;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class BaseInnerEcMsg extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -3013275432545179290L;
    public int adStyle;
    public int materialType;
    public int status;
    public String userId;

    @Override // com.kwad.sdk.commercial.c.a
    public com.kwad.sdk.commercial.c.a setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo adInfoEO = e.eO(adTemplate);
        this.adStyle = e.eI(adTemplate);
        this.materialType = com.kwad.sdk.core.response.helper.a.bk(adInfoEO);
        return this;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        try {
            return toJson().toString();
        } catch (Exception unused) {
            return super.toString();
        }
    }
}
