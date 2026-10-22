package com.kwad.components.ad.reward.check;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static void a(@NonNull AdTemplate adTemplate, int i, long j, int i2, String str) {
        c.f(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i).setEnviType(0).setDataLoadInterval(j).setCode(i2).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.helper.a.L(e.eO(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void d(@NonNull AdTemplate adTemplate, int i) {
        c.f(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.helper.a.L(e.eO(adTemplate))).setAdTemplate(adTemplate));
    }
}
