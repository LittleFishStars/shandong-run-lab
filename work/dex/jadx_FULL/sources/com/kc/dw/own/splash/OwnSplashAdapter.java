package com.kc.dw.own.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.platform.ad_adapter.splash.SsdSplashOwnListener;
import com.kc.dw.platform.ad_adapter.splash.j;
import com.kc.dw.platform.ad_adapter.splash.k;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnSplashAdapter extends MsCustomSplashAdapter {
    private k ad;
    private final SsdSplashOwnListener ownListener = new AnonymousClass1(this);
    private j qzxAdNativeWrapper;

    /* JADX INFO: renamed from: com.kc.dw.own.splash.OwnSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SsdSplashOwnListener {
        public final OwnSplashAdapter this$0;

        public AnonymousClass1(OwnSplashAdapter ownSplashAdapter) {
            this.this$0 = ownSplashAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(k kVar, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.platform.ad_adapter.splash.SsdSplashOwnListener
        public void onAdSkip(k kVar) {
            this.this$0.callAdSkip();
        }

        @Override // com.kc.dw.platform.ad_adapter.splash.SsdSplashOwnListener
        public void onAdTick(long j) {
            this.this$0.callAdTick(j);
        }

        @Override // com.kc.dw.platform.ad_adapter.splash.SsdSplashOwnListener
        public void onAdTimeOver(k kVar) {
            this.this$0.callAdTimeOver();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(k kVar) {
            this.this$0.ad = kVar;
            kVar.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.own.splash.OwnSplashAdapter.1.1
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
        public void onRenderSuccess(k kVar) {
            this.this$0.callRenderSuccess();
        }
    }

    public BaseAdSlot getBaseAdSlot() {
        j jVar = this.qzxAdNativeWrapper;
        if (jVar != null) {
            return (BaseAdSlot) jVar.f39477a;
        }
        return null;
    }

    public k getSplashAd() {
        return this.ad;
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        a.a(5, "e2", this);
        j jVar = this.qzxAdNativeWrapper;
        if (jVar != null) {
            jVar.setLocalParams(getLocalParams());
            j jVar2 = this.qzxAdNativeWrapper;
            jVar2.h = this.ownListener;
            jVar2.loadAd();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void render() {
        com.kc.dw.ad.k kVar;
        super.render();
        j jVar = this.qzxAdNativeWrapper;
        if (jVar == null || (kVar = jVar.f) == null) {
            return;
        }
        try {
            kVar.g = true;
            if (kVar.t.f39562a == 0) {
                kVar.a((ViewGroup) null);
            } else if (kVar.t.f39562a == 2) {
                kVar.b();
            }
            kVar.b(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSplashAdDelegate(j jVar) {
        this.qzxAdNativeWrapper = jVar;
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        k kVar;
        j jVar = this.qzxAdNativeWrapper;
        if (jVar == null || (kVar = jVar.i) == null) {
            return;
        }
        kVar.showAd(viewGroup);
    }
}
