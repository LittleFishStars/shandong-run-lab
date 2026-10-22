package com.kc.dw.own.intertitial;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.ad_adapter.interstitial.SsdInterstitialAdAdapter;
import com.kc.dw.platform.ad_adapter.interstitial.SsdInterstitialOwnListener;
import com.kc.dw.platform.ad_adapter.interstitial.b;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnIntertitialAdapter extends MsCustomInterstitialAdapter {
    private InterstitialAd ad;
    private final SsdInterstitialOwnListener ownListener = new AnonymousClass1(this);
    private b qzxAdNativeWrapper;

    /* JADX INFO: renamed from: com.kc.dw.own.intertitial.OwnIntertitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SsdInterstitialOwnListener {
        public final OwnIntertitialAdapter this$0;

        public AnonymousClass1(OwnIntertitialAdapter ownIntertitialAdapter) {
            this.this$0 = ownIntertitialAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(InterstitialAd interstitialAd, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(InterstitialAd interstitialAd) {
            this.this$0.ad = interstitialAd;
            interstitialAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.own.intertitial.OwnIntertitialAdapter.1.1
                public final AnonymousClass1 this$1;

                {
                    this.this$1 = this;
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClicked() {
                    this.this$1.this$0.callAdClicked();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdClosed() {
                    this.this$1.this$0.callAdClosed();
                }

                @Override // com.kc.dw.core.loader.InteractionListener
                public void onAdExposure() {
                    this.this$1.this$0.callAdExposure();
                }
            });
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(InterstitialAd interstitialAd) {
            this.this$0.callRenderSuccess();
        }
    }

    public BaseAdSlot getBaseAdSlot() {
        b bVar = this.qzxAdNativeWrapper;
        if (bVar != null) {
            return (BaseAdSlot) bVar.f39477a;
        }
        return null;
    }

    public InterstitialAd getInterstitialAd() {
        return this.ad;
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        a.a(5, "e2", this);
        b bVar = this.qzxAdNativeWrapper;
        if (bVar != null) {
            bVar.setLocalParams(this.localParams);
            b bVar2 = this.qzxAdNativeWrapper;
            bVar2.g = this.ownListener;
            bVar2.loadAd();
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void render() {
        SsdInterstitialAdAdapter ssdInterstitialAdAdapter;
        b bVar = this.qzxAdNativeWrapper;
        if (bVar == null || (ssdInterstitialAdAdapter = bVar.f) == null) {
            return;
        }
        ssdInterstitialAdAdapter.render();
    }

    public void setOwnAdDelegate(b bVar) {
        this.qzxAdNativeWrapper = bVar;
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        SsdInterstitialAdAdapter ssdInterstitialAdAdapter;
        b bVar = this.qzxAdNativeWrapper;
        if (bVar == null || (ssdInterstitialAdAdapter = bVar.f) == null) {
            return;
        }
        ssdInterstitialAdAdapter.showAd(activity);
    }
}
