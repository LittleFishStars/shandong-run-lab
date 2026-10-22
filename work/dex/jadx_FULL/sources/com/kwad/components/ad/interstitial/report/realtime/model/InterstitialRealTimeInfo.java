package com.kwad.components.ad.interstitial.report.realtime.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.c.a;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class InterstitialRealTimeInfo extends a implements Serializable {
    public String materialUrl;
    public long monitorIndex;
    public long renderType;

    public void setMaterialUrl(String str) {
        this.materialUrl = str;
    }

    public void setRenderType(long j) {
        this.renderType = j;
    }
}
