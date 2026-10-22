package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.ad.splash.SplashAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f39553a;

    public g(e eVar) {
        this.f39553a = eVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            e eVar = this.f39553a;
            SplashAdListener splashAdListener = eVar.b;
            if (splashAdListener != null) {
                splashAdListener.onAdSkip(eVar.d);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
