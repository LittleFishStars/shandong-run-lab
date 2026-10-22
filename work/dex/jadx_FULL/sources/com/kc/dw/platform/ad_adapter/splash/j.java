package com.kc.dw.platform.ad_adapter.splash;

import android.view.View;
import com.google.gson.Gson;
import com.kc.dw.core.ad.splash.ISplashAd;
import com.kc.dw.core.ad.splash.SplashAdListener;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j extends com.kc.dw.platform.ad_adapter.h<com.kc.dw.ad.splash.d, SplashCommonAdLoader, SplashAdLoadListener> {
    public com.kc.dw.ad.k f;
    public e g;
    public SsdSplashOwnListener h;
    public k i;
    public com.kc.dw.platform.ad_adapter.state.a j;
    public SplashAdListener k;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f39556a;

        public a(j jVar) {
            this.f39556a = jVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            View view;
            try {
                T t = this.f39556a.f39477a;
                if (t != 0 && ((com.kc.dw.ad.splash.d) t).getImageUrls() != null && ((com.kc.dw.ad.splash.d) this.f39556a.f39477a).getImageUrls().length != 0) {
                    this.f39556a.f = new com.kc.dw.ad.k(((SplashCommonAdLoader) this.f39556a.adLoader).getContext(), this.f39556a.j);
                    boolean zBooleanValue = ((Boolean) this.f39556a.localParams.get(SplashCommonAdLoader.KEY_AUTO_SHOW)).booleanValue();
                    j jVar = this.f39556a;
                    jVar.g = new e(jVar, jVar.k, zBooleanValue, jVar.f);
                    Object obj = this.f39556a.localParams.get(SplashCommonAdLoader.KEY_SKIP_BUTTON);
                    if (obj == null || !(obj instanceof View)) {
                        view = null;
                    } else {
                        view = (View) obj;
                        view.setVisibility(4);
                    }
                    j jVar2 = this.f39556a;
                    jVar2.f.a((com.kc.dw.ad.splash.d) jVar2.f39477a, jVar2.g, jVar2, view, zBooleanValue, jVar2.isAutoRender());
                    return;
                }
                LogUtil.i("MeishuAdNativeWrapper", "资源url为空");
                SsdSplashOwnListener ssdSplashOwnListener = this.f39556a.h;
                if (ssdSplashOwnListener != null) {
                    ssdSplashOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Keep
    public class b implements SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final j f39557a;

        public b(j jVar) {
            this.f39557a = jVar;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            try {
                j jVar = this.f39557a;
                if (jVar.h != null) {
                    if (jVar.j.b == 5) {
                        j jVar2 = this.f39557a;
                        jVar2.h.onAdFail(jVar2.i, new AdError(200003, "load error"), 1);
                    } else {
                        j jVar3 = this.f39557a;
                        jVar3.h.onAdFail(jVar3.i, new AdError(200002, "load error"), 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdLoaded(ISplashAd iSplashAd) {
            j jVar = this.f39557a;
            k kVar = (k) iSplashAd;
            jVar.i = kVar;
            SsdSplashOwnListener ssdSplashOwnListener = jVar.h;
            if (ssdSplashOwnListener != null) {
                ssdSplashOwnListener.onLoadSuccess(kVar);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.ad.splash.SplashAdListener
        public void onAdPresent(ISplashAd iSplashAd) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdReady(ISplashAd iSplashAd) {
            this.f39557a.j.a(5);
            j jVar = this.f39557a;
            SsdSplashOwnListener ssdSplashOwnListener = jVar.h;
            if (ssdSplashOwnListener != null) {
                ssdSplashOwnListener.onRenderSuccess(jVar.i);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            try {
                j jVar = this.f39557a;
                if (jVar.h != null) {
                    if (jVar.j.b == 5) {
                        j jVar2 = this.f39557a;
                        jVar2.h.onAdFail(jVar2.i, new AdError(i, str), 1);
                    } else {
                        j jVar3 = this.f39557a;
                        jVar3.h.onAdFail(jVar3.i, new AdError(i, str), 0);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.ad.splash.SplashAdListener
        public void onAdSkip(ISplashAd iSplashAd) {
            j jVar = this.f39557a;
            SsdSplashOwnListener ssdSplashOwnListener = jVar.h;
            if (ssdSplashOwnListener != null) {
                ssdSplashOwnListener.onAdSkip(jVar.i);
            }
        }

        @Override // com.kc.dw.core.ad.splash.SplashAdListener
        public void onAdTick(long j) {
            SsdSplashOwnListener ssdSplashOwnListener = this.f39557a.h;
            if (ssdSplashOwnListener != null) {
                ssdSplashOwnListener.onAdTick(j);
            }
        }

        @Override // com.kc.dw.core.ad.splash.SplashAdListener
        public void onAdTimeOver(ISplashAd iSplashAd) {
            j jVar = this.f39557a;
            SsdSplashOwnListener ssdSplashOwnListener = jVar.h;
            if (ssdSplashOwnListener != null) {
                ssdSplashOwnListener.onAdTimeOver(jVar.i);
            }
        }
    }

    public j(SplashCommonAdLoader splashCommonAdLoader, com.kc.dw.ad.splash.d dVar) {
        super(splashCommonAdLoader, dVar);
        this.j = new com.kc.dw.platform.ad_adapter.state.a();
        this.k = new b(this);
    }

    @Override // com.kc.dw.platform.ad_adapter.h, com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
        this.f = null;
        e eVar = this.g;
        if (eVar != null) {
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", -1);
                map.put("msg", "destroy invoke");
                Integer numA = eVar.a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                s1.a(eVar.f39548a, gson.toJson(map));
            } catch (Exception e) {
                e.printStackTrace();
            }
            eVar.c = null;
            eVar.i = null;
            eVar.b = null;
            this.g = null;
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        SdkHandler.runOnMainThread(new a(this));
    }
}
