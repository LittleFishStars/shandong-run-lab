package com.kwad.sdk.core.adlog.b;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class d extends com.kwad.sdk.commercial.c.a {
    public String aKB;
    public int aKI;
    public int aMd;
    public int retryCount;
    public int status;

    public static d Je() {
        return new d();
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: cE, reason: merged with bridge method [inline-methods] */
    public final d setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final d dQ(int i) {
        this.status = i;
        return this;
    }

    public final d dR(int i) {
        this.aKI = i;
        return this;
    }

    public final d dS(int i) {
        this.aMd = 1;
        return this;
    }

    public final d dT(int i) {
        this.retryCount = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: dU, reason: merged with bridge method [inline-methods] */
    public final d setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    public final d dZ(String str) {
        this.aKB = str;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: ea, reason: merged with bridge method [inline-methods] */
    public final d setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }
}
