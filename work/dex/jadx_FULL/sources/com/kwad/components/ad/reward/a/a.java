package com.kwad.components.ad.reward.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.h;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static l uo = new l("rewardSkipType", 0);
    public static l up = new l("rewardActiveAppTaskMinSecond", 15);
    public static l uq = new l("rewardContentDetainType", 0);
    public static d ur = new d("forceGetAudioFocus", false);
    public static s us = new s("rewardSkipTips", "");
    public static s ut = new s("fullscreenSkipTips", "");
    public static l uu = new l("ecRewardAdOrderSwitch", 0);
    public static l uv = new l("ecRewardAdFanSwitch", 0);
    public static l uw = new l("ecRewardAdKwaishopStyle", 0);
    public static l ux = new l("xdtCouponShowDuration", 3000);
    public static l uy = new l("jinniuCloseDialogStyle", 1);
    public static h uz = new h("interactionTimeInRewardedVideo", 0.0f);
    public static d uA = new d("autoJumpInRewardedVideo", false);
    public static l uB = new l("advanceJumpDirectDeliveryMaxCount", 0);
    public static d uC = new d("advanceJumpDirectDeliverySwitch", false);
    public static l uD = new l("shortVideoFollowRewardPlayStyle", 0);
    public static d uE = new d("enableRewardLayoutOptimise", false);
    public static d uF = new d("enableFullscreenLayoutOptimise", false);

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
