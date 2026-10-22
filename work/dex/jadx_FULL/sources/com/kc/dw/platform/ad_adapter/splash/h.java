package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.ad.splash.ISplashFinishingTouchListener;
import com.kc.dw.core.ad.splash.SplashAdListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f39554a;

    public h(e eVar) {
        this.f39554a = eVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        ISplashFinishingTouchListener splashFinishingTouchListener;
        try {
            e eVar = this.f39554a;
            SplashAdListener splashAdListener = eVar.b;
            if (splashAdListener != null) {
                splashAdListener.onAdTimeOver(eVar.d);
            }
            if (this.f39554a.d.getSplashFinishingTouchListener() != null) {
                e eVar2 = this.f39554a;
                boolean z = false;
                if (eVar2.h) {
                    splashFinishingTouchListener = eVar2.d.getSplashFinishingTouchListener();
                } else {
                    if (eVar2.c == null) {
                        return;
                    }
                    splashFinishingTouchListener = eVar2.d.getSplashFinishingTouchListener();
                    if (((com.kc.dw.ad.splash.d) this.f39554a.c.f39477a).I == 1) {
                        z = true;
                    }
                }
                splashFinishingTouchListener.isSupportSplashClickEye(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
