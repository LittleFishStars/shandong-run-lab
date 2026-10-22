package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.ad.splashscreen.monitor.SplashWebMonitorInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class df {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(SplashSkipViewModel.class, new ml());
        hl.LT().put(SplashWebMonitorInfo.class, new mo());
        hl.LT().put(SplashPreloadManager.PreLoadItem.class, new kl());
        hl.LT().put(SplashMonitorInfo.class, new mh());
        hl.LT().put(com.kwad.components.ad.splashscreen.local.a.class, new mg());
    }
}
