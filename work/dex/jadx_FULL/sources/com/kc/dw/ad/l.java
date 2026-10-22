package com.kc.dw.ad;

import android.view.View;
import com.kc.dw.ad.splash.SplashSkipView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l extends com.kc.dw.core.safe.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.splash.a f39119a;
    public final com.kc.dw.ad.splash.c b;
    public final SplashSkipView c;
    public final k d;

    public l(k kVar, com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.c cVar, SplashSkipView splashSkipView) {
        this.d = kVar;
        this.f39119a = aVar;
        this.b = cVar;
        this.c = splashSkipView;
    }

    @Override // com.kc.dw.core.safe.m
    public void safeOnClick(View view) {
        com.kc.dw.ad.splash.a aVar = this.f39119a;
        if (aVar == null || !((com.kc.dw.platform.ad_adapter.splash.e) aVar).e) {
            return;
        }
        this.b.b.setClkActType(2);
        if (this.b.getInteractionListener() != null && this.b.b.getCbc() == 0) {
            this.b.getInteractionListener().onAdClicked();
        }
        com.kc.dw.ad.splash.a aVar2 = this.f39119a;
        if (aVar2 != null) {
            ((com.kc.dw.platform.ad_adapter.splash.e) aVar2).h = true;
        }
        com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.b, true);
        k.a(this.d, this.c);
    }
}
