package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.ad.splash.SplashAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f39552a;

    public f(e eVar) {
        this.f39552a = eVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        try {
            SplashAdListener splashAdListener = this.f39552a.b;
            if (splashAdListener != null) {
                splashAdListener.onAdClosed();
            }
            k kVar = this.f39552a.d;
            if (kVar == null || kVar.getInteractionListener() == null) {
                return;
            }
            this.f39552a.d.getInteractionListener().onAdClosed();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
