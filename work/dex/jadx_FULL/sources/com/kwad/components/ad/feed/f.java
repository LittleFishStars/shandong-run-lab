package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    public static String p(@NonNull AdTemplate adTemplate) {
        String strAA = com.kwad.sdk.core.response.helper.a.aA(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        if (!com.kwad.components.core.c.b.oL()) {
            return strAA;
        }
        return (adTemplate.fromCache ? "【cache】" : "") + strAA;
    }
}
