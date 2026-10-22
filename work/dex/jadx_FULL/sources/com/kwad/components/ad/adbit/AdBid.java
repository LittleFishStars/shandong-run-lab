package com.kwad.components.ad.adbit;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class AdBid extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -3937320872050889919L;
    public int bidEcpm;
    public long creativeId;
    public long ecpm;
    public String materialId;
    public String winNoticeUrl;
}
