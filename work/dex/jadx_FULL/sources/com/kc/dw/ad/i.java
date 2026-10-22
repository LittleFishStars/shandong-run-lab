package com.kc.dw.ad;

import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.core.view.SwipeView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i implements SwipeView.OnSwipeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.splash.a f39093a;
    public final com.kc.dw.ad.splash.d b;
    public final com.kc.dw.ad.splash.c c;
    public final SplashSkipView d;
    public final k e;

    public i(k kVar, com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SplashSkipView splashSkipView) {
        this.e = kVar;
        this.f39093a = aVar;
        this.b = dVar;
        this.c = cVar;
        this.d = splashSkipView;
    }

    @Override // com.kc.dw.core.view.SwipeView.OnSwipeListener
    public void onSwipe(int i) {
        com.kc.dw.ad.splash.d dVar;
        com.kc.dw.ad.splash.a aVar = this.f39093a;
        if (aVar == null || !((com.kc.dw.platform.ad_adapter.splash.e) aVar).e) {
            return;
        }
        int i2 = 128;
        if ((this.b.getAct_type() & 128) != 128) {
            dVar = this.c.b;
            i2 = 32;
        } else {
            dVar = this.c.b;
        }
        dVar.setClkActType(i2);
        this.c.b.setClkPower(i);
        if (this.c.getInteractionListener() != null) {
            this.c.getInteractionListener().onAdClicked();
        }
        com.kc.dw.ad.splash.a aVar2 = this.f39093a;
        if (aVar2 != null) {
            ((com.kc.dw.platform.ad_adapter.splash.e) aVar2).h = true;
        }
        com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.c, true);
        k.a(this.e, this.d);
    }
}
