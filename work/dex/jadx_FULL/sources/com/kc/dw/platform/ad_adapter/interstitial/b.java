package com.kc.dw.platform.ad_adapter.interstitial;

import android.util.Log;
import com.kc.dw.ad.interstitial.g;
import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.ad.interstitial.InterstitialAdLoadListener;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.platform.ad_adapter.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends h<com.kc.dw.ad.interstitial.b, InterstitialCommonAdLoader, InterstitialAdLoadListener> {
    public SsdInterstitialAdAdapter f;
    public SsdInterstitialOwnListener g;

    @Keep
    public class a implements InterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39479a;

        public a(b bVar) {
            this.f39479a = bVar;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            b bVar = this.f39479a;
            SsdInterstitialOwnListener ssdInterstitialOwnListener = bVar.g;
            if (ssdInterstitialOwnListener != null) {
                ssdInterstitialOwnListener.onAdFail(bVar.f, new AdError(9000001, "load error"), 0);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdLoaded(SsdInterstitialAdAdapter ssdInterstitialAdAdapter) {
            SsdInterstitialAdAdapter ssdInterstitialAdAdapter2;
            SsdInterstitialAdAdapter ssdInterstitialAdAdapter3 = ssdInterstitialAdAdapter;
            b bVar = this.f39479a;
            bVar.f = ssdInterstitialAdAdapter3;
            SsdInterstitialOwnListener ssdInterstitialOwnListener = bVar.g;
            if (ssdInterstitialOwnListener != null) {
                ssdInterstitialOwnListener.onLoadSuccess(ssdInterstitialAdAdapter3);
            }
            if (!this.f39479a.isAutoRender() || (ssdInterstitialAdAdapter2 = this.f39479a.f) == null) {
                return;
            }
            ssdInterstitialAdAdapter2.render();
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdReady(SsdInterstitialAdAdapter ssdInterstitialAdAdapter) {
            b bVar = this.f39479a;
            SsdInterstitialOwnListener ssdInterstitialOwnListener = bVar.g;
            if (ssdInterstitialOwnListener != null) {
                ssdInterstitialOwnListener.onRenderSuccess(bVar.f);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            b bVar = this.f39479a;
            SsdInterstitialOwnListener ssdInterstitialOwnListener = bVar.g;
            if (ssdInterstitialOwnListener != null) {
                ssdInterstitialOwnListener.onAdFail(bVar.f, new AdError(i, str), 0);
            }
        }
    }

    public b(InterstitialCommonAdLoader interstitialCommonAdLoader, com.kc.dw.ad.interstitial.b bVar) {
        super(interstitialCommonAdLoader, bVar);
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        Log.e("MeishuAdNativeWrapper", "loadAd: ");
        T t = this.f39477a;
        if (t == 0 || ((com.kc.dw.ad.interstitial.b) t).getImageUrls() == null || ((com.kc.dw.ad.interstitial.b) this.f39477a).getImageUrls().length == 0) {
            LogUtil.i("MeishuAdNativeWrapper", "资源url为空");
            SsdInterstitialOwnListener ssdInterstitialOwnListener = this.g;
            if (ssdInterstitialOwnListener != null) {
                ssdInterstitialOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
                return;
            }
            return;
        }
        com.kc.dw.platform.ad_adapter.interstitial.a aVar = new com.kc.dw.platform.ad_adapter.interstitial.a(this, new a(this));
        try {
            this.e = ((com.kc.dw.ad.interstitial.b) this.f39477a).getErrorUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SdkHandler.getInstance().runOnUiThread(new c(this, aVar, new g(this, aVar)));
    }
}
