package com.kwad.components.ad.e;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static s dv = new s("kwaiLogoUrl", null);
    public static s dw = new s("attentionTips", "去关注TA");
    public static s dx = new s("viewHomeTips", "查看TA的主页");
    public static s dy = new s("buyNowTips", "立即抢购");

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
