package com.kwad.components.ad.splashscreen.b;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.config.item.d;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static l Hj = new l("splashTimeOutMilliSecond", 5000);
    public static s Hk = new s("splashTimerTips", "");
    public static s Hl = new s("splashBtnText", "点击跳转详情页或第三方应用");
    public static d Hm = new d("splashCropNewSwitch", true);
    public static d Hn = new d("splashAdLoadProcessChange", false);
    public static l Ho = new l("splashMaterialDownloadTimeMs", 500);

    @InvokeBy(invokerClass = e.class, methodId = "initConfigList")
    public static void init() {
    }
}
