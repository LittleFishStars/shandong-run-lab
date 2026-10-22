package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class b extends com.kwad.sdk.commercial.c.a {
    public String aJY;
    public String aJZ;
    public String aKa;
    public long aKb;
    public long aKc;
    public int aKd;
    public int aKe;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b Io() {
        return new b();
    }

    public final b ax(long j) {
        this.downloadTime = j;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bJ, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo adInfoEO = e.eO(adTemplate);
        this.url = e.eR(adTemplate);
        try {
            this.aJY = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = adInfoEO.downloadId;
        AdInfo.AdBaseInfo adBaseInfo = adInfoEO.adBaseInfo;
        this.aJZ = adBaseInfo.appPackageName;
        this.aKa = adBaseInfo.appName;
        this.aKb = adInfoEO.totalBytes;
        this.aKc = adInfoEO.soFarBytes;
        return this;
    }

    public final b du(int i) {
        this.status = i;
        return this;
    }

    public final b dv(int i) {
        this.aKd = i;
        return this;
    }

    public final b dw(int i) {
        this.aKe = i;
        return this;
    }
}
