package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static String n(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.cY(adInfo)) {
            return ILivePush.ClickType.LIVE;
        }
        if (com.kwad.sdk.core.response.helper.a.bj(adInfo)) {
            return "image";
        }
        return com.kwad.sdk.core.response.helper.a.cm(adInfo) ? "reward_preview" : "video";
    }
}
