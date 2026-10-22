package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.ad.splash.SplashAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f39555a;
    public final e b;

    public i(e eVar, long j) {
        this.b = eVar;
        this.f39555a = j;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        SplashAdListener splashAdListener = this.b.b;
        if (splashAdListener != null) {
            splashAdListener.onAdTick(this.f39555a);
        }
    }
}
