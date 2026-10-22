package com.kwad.components.core.innerEc.live.i;

import com.ali.auth.third.login.LoginConstants;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    public static String aM(AdTemplate adTemplate) {
        return adTemplate.liveInfo.liveStreamId;
    }

    public static String aN(AdTemplate adTemplate) {
        return String.valueOf(adTemplate.liveInfo.authorId);
    }

    public static void e(AdTemplate adTemplate, String str) {
        adTemplate.liveInfo.liveStreamId = str;
    }

    public static String g(AdTemplate adTemplate, int i) {
        LiveInfo liveInfo = adTemplate.liveInfo;
        String str = liveInfo.liveStreamId + LoginConstants.UNDER_LINE + i;
        liveInfo.pageDataKey = str;
        liveInfo.livePageType = 0;
        return str;
    }

    public static String getKwaiUserId() {
        StringBuilder sb = new StringBuilder();
        sb.append(com.kwad.components.core.innerEc.e.rf().getUserId());
        return sb.toString();
    }
}
