package com.kc.dw.ad;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SplashSkipView f39160a;
    public final com.kc.dw.ad.splash.c b;
    public final com.kc.dw.ad.splash.a c;
    public final View d;
    public final SsdSplashRootView e;
    public final k f;

    @Keep
    public class a implements SplashSkipView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f39161a;

        public a(s sVar) {
            this.f39161a = sVar;
        }

        @Override // com.kc.dw.ad.splash.SplashSkipView.b
        public void onSkip() {
            LogUtil.d("AdNative", "onSkip: ");
            Handler handler = k.E;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            k.c(this.f39161a.f);
            com.kc.dw.ad.splash.a aVar = this.f39161a.c;
            if (aVar != null) {
                SdkHandler.getInstance().runOnUiThread(new com.kc.dw.platform.ad_adapter.splash.g((com.kc.dw.platform.ad_adapter.splash.e) aVar));
                com.kc.dw.platform.ad_adapter.splash.e eVar = (com.kc.dw.platform.ad_adapter.splash.e) this.f39161a.c;
                eVar.getClass();
                ShakeUtil.getInstance().a();
                SdkHandler.getInstance().runOnUiThread(new com.kc.dw.platform.ad_adapter.splash.f(eVar));
            }
        }

        @Override // com.kc.dw.ad.splash.SplashSkipView.b
        public void onTick(long j) {
            View view;
            com.kc.dw.ad.splash.a aVar = this.f39161a.c;
            if (aVar != null) {
                SdkHandler.getInstance().runOnUiThread(new com.kc.dw.platform.ad_adapter.splash.i((com.kc.dw.platform.ad_adapter.splash.e) aVar, j));
            }
            if (((long) this.f39161a.f39160a.getTotalTime()) - j <= this.f39161a.f39160a.getShowTime() || (view = this.f39161a.d) == null) {
                return;
            }
            view.setVisibility(0);
        }

        @Override // com.kc.dw.ad.splash.SplashSkipView.b
        public void onTimeOver() {
            LogUtil.d("AdNative", "onTimeOver: ");
            Handler handler = k.E;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            k.c(this.f39161a.f);
            com.kc.dw.ad.splash.a aVar = this.f39161a.c;
            if (aVar != null) {
                SdkHandler.getInstance().runOnUiThread(new com.kc.dw.platform.ad_adapter.splash.h((com.kc.dw.platform.ad_adapter.splash.e) aVar));
                com.kc.dw.platform.ad_adapter.splash.e eVar = (com.kc.dw.platform.ad_adapter.splash.e) this.f39161a.c;
                eVar.getClass();
                ShakeUtil.getInstance().a();
                SdkHandler.getInstance().runOnUiThread(new com.kc.dw.platform.ad_adapter.splash.f(eVar));
            }
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SplashSkipView.b f39162a;

        public b(s sVar, SplashSkipView.b bVar) {
            this.f39162a = bVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            this.f39162a.onSkip();
        }
    }

    @Keep
    public class c extends com.kc.dw.core.safe.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f39163a;

        public c(s sVar) {
            this.f39163a = sVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            s sVar = this.f39163a;
            com.kc.dw.ad.splash.a aVar = sVar.c;
            if (aVar == null || !((com.kc.dw.platform.ad_adapter.splash.e) aVar).e) {
                return;
            }
            sVar.b.b.setClkActType(1);
            if (this.f39163a.b.getInteractionListener() != null && this.f39163a.b.b.getCbc() == 0) {
                this.f39163a.b.getInteractionListener().onAdClicked();
            }
            s sVar2 = this.f39163a;
            com.kc.dw.ad.splash.a aVar2 = sVar2.c;
            if (aVar2 != null) {
                ((com.kc.dw.platform.ad_adapter.splash.e) aVar2).h = true;
            }
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) sVar2.b, false);
            s sVar3 = this.f39163a;
            k.a(sVar3.f, sVar3.f39160a);
        }
    }

    @Keep
    public class d extends com.kc.dw.core.safe.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f39164a;

        public d(s sVar) {
            this.f39164a = sVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            s sVar = this.f39164a;
            com.kc.dw.ad.splash.a aVar = sVar.c;
            if (aVar == null || !((com.kc.dw.platform.ad_adapter.splash.e) aVar).e) {
                return;
            }
            sVar.b.b.setClkActType(2);
            if (this.f39164a.b.getInteractionListener() != null && this.f39164a.b.b.getCbc() == 0) {
                this.f39164a.b.getInteractionListener().onAdClicked();
            }
            s sVar2 = this.f39164a;
            com.kc.dw.ad.splash.a aVar2 = sVar2.c;
            if (aVar2 != null) {
                ((com.kc.dw.platform.ad_adapter.splash.e) aVar2).h = true;
            }
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) sVar2.b, true);
            s sVar3 = this.f39164a;
            k.a(sVar3.f, sVar3.f39160a);
        }
    }

    @Keep
    public class e implements ShakeUtil.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f39165a;
        public final com.kc.dw.ad.splash.c b;
        public final com.kc.dw.ad.splash.a c;
        public final SplashSkipView d;
        public final s e;

        public e(s sVar, long j, com.kc.dw.ad.splash.c cVar, com.kc.dw.ad.splash.a aVar, SplashSkipView splashSkipView) {
            this.e = sVar;
            this.f39165a = j;
            this.b = cVar;
            this.c = aVar;
            this.d = splashSkipView;
        }

        @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
        public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
            ShakeUtil.getInstance().a(this.e.f.b);
            if (shakeResult != null) {
                shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f39165a);
            }
            com.kc.dw.ad.splash.d dVar = this.b.b;
            dVar.setClkActType(i);
            dVar.setDynamic(z);
            dVar.setClkPower(i2);
            dVar.setShakeResult(shakeResult);
            if (this.b.getInteractionListener() != null && this.b.b.getCbc() == 0) {
                this.b.getInteractionListener().onAdClicked();
            }
            com.kc.dw.ad.splash.a aVar = this.c;
            if (aVar != null) {
                ((com.kc.dw.platform.ad_adapter.splash.e) aVar).h = true;
            }
            com.kc.dw.core.utils.f.a(this.b, i2 >= 50);
            k.a(this.e.f, this.d);
        }
    }

    public s(k kVar, SplashSkipView splashSkipView, com.kc.dw.ad.splash.c cVar, com.kc.dw.ad.splash.a aVar, View view, SsdSplashRootView ssdSplashRootView) {
        this.f = kVar;
        this.f39160a = splashSkipView;
        this.b = cVar;
        this.c = aVar;
        this.d = view;
        this.e = ssdSplashRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kc.dw.ad.splash.c cVar, com.kc.dw.ad.splash.a aVar, SplashSkipView splashSkipView) {
        boolean[] zArr = this.f.D;
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        if (com.kc.dw.core.utils.h.e(cVar.b.getAct_type()) || com.kc.dw.core.utils.h.d(cVar.b.getAct_type())) {
            com.kc.dw.ad.splash.d dVar = cVar.b;
            int i = dVar.G;
            int power_index2 = dVar.getPower_index2();
            cVar.b.getClass();
            if (ShakeUtil.getInstance().indexLocal != 0 && com.kc.dw.base.a.adConfig().isTest()) {
                i = ShakeUtil.getInstance().indexLocal;
            }
            int i2 = i;
            k kVar = this.f;
            if (kVar.b == 0) {
                kVar.b = ShakeUtil.getInstance().b();
            }
            int iB = com.kc.dw.core.utils.h.b(cVar.b.getAct_type());
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(cVar.b.getPosId(), cVar.b.getLoadedTime(), cVar.b.getDclk());
            ShakeUtil.getInstance().a(power_index2, i2, iB, cVar.b.getPower_delay(), cVar.b.getPower_count(), this.f.b, cVar.b.getEcpm(), new e(this, jCurrentTimeMillis, cVar, aVar, splashSkipView));
            if (com.kc.dw.core.utils.h.c(cVar.b.getAct_type())) {
                ShakeUtil.getInstance().a(true);
                ShakeUtil.getInstance().f();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        com.kc.dw.platform.ad_adapter.splash.e.c cVar;
        TextView textView;
        try {
            this.f39160a.setTotalTime((int) ((SplashCommonAdLoader) this.f.w.getAdLoader()).getAdSlot().getSplashShowTime());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f39160a.setShow(!((SplashCommonAdLoader) this.b.f39168a.getAdLoader()).getIsHideSkipBtn());
        a aVar = new a(this);
        this.f39160a.setOnSkipListener(aVar);
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(new b(this, aVar));
            this.f39160a.setShow(false);
        }
        if ((this.b.b.getAct_type() & 1) == 1) {
            this.e.setOnClickListener(new c(this));
        }
        if ((this.b.b.getAct_type() & 2) == 2 && (textView = (TextView) this.e.findViewById(R.id.ssd_jump_btn)) != null) {
            textView.setOnClickListener(new d(this));
        }
        final com.kc.dw.ad.splash.a aVar2 = this.c;
        if (aVar2 instanceof com.kc.dw.platform.ad_adapter.splash.e) {
            final com.kc.dw.ad.splash.c cVar2 = this.b;
            final SplashSkipView splashSkipView = this.f39160a;
            ((com.kc.dw.platform.ad_adapter.splash.e) aVar2).j = new com.kc.dw.platform.ad_adapter.splash.e.c(this, cVar2, aVar2, splashSkipView) { // from class: com.kc.dw.ad.s$$ExternalSyntheticLambda0
                public final s f$0;
                public final com.kc.dw.ad.splash.c f$1;
                public final com.kc.dw.ad.splash.a f$2;
                public final SplashSkipView f$3;

                {
                    this.f$0 = this;
                    this.f$1 = cVar2;
                    this.f$2 = aVar2;
                    this.f$3 = splashSkipView;
                }

                @Override // com.kc.dw.platform.ad_adapter.splash.e.c
                public final void onExposure() {
                    this.f$0.a(this.f$1, this.f$2, this.f$3);
                }
            };
            com.kc.dw.platform.ad_adapter.splash.e eVar = (com.kc.dw.platform.ad_adapter.splash.e) this.c;
            if (!eVar.e || (cVar = eVar.j) == null) {
                return;
            }
            cVar.onExposure();
        }
    }
}
