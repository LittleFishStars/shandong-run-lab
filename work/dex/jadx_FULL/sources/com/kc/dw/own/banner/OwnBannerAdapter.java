package com.kc.dw.own.banner;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.t0;
import com.kc.dw.platform.ad_adapter.banner.OwnBannerSingleListener;
import com.kc.dw.platform.ad_adapter.banner.a;
import com.kc.dw.platform.ad_adapter.banner.c;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnBannerAdapter extends MsCustomBannerAdapter {
    private static final String TAG = "OwnBannerAdapter";
    private a bannerAd;
    public OwnBannerSingleListener ownListener = new AnonymousClass1(this);
    private b qzxAdDelegate;

    /* JADX INFO: renamed from: com.kc.dw.own.banner.OwnBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements OwnBannerSingleListener {
        public final OwnBannerAdapter this$0;

        public AnonymousClass1(OwnBannerAdapter ownBannerAdapter) {
            this.this$0 = ownBannerAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(a aVar, AdError adError, int i) {
            this.this$0.callRenderError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadedError(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(a aVar) {
            this.this$0.bannerAd = aVar;
            aVar.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.own.banner.OwnBannerAdapter.1.1
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
                    c cVar = (c) this.this$1.this$0.qzxAdDelegate;
                    t0.a(((com.kc.dw.ad.banner.a) cVar.f39477a).getPosId(), 3);
                    String[] monitorUrl = ((com.kc.dw.ad.banner.a) cVar.f39477a).getMonitorUrl();
                    g0.a(monitorUrl, cVar.i.getAdView(), (View) null);
                    if (monitorUrl != null) {
                        LogUtil.d("MeishuViewWrapper", "send onAdExposure");
                        for (String str : monitorUrl) {
                            if (!TextUtils.isEmpty(str)) {
                                int act_type = ((com.kc.dw.ad.banner.a) cVar.f39477a).getAct_type();
                                if ((act_type & 2) == 2) {
                                    act_type = (act_type - 2) | 1;
                                }
                                com.kc.dw.ad.interstitial.c.a(cVar.getContext(), g0.a(g0.a(g0.a(str, act_type, AdType.BANNER), cVar.i.getAdView().getWidth(), cVar.i.getAdView().getHeight())));
                            }
                        }
                    }
                    this.this$1.this$0.callAdExposure();
                }
            });
            this.this$0.callLoadedSuccess();
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(a aVar) {
            this.this$0.callRenderSuccess();
        }
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void destory() {
        b bVar = this.qzxAdDelegate;
        if (bVar != null) {
            bVar.destroy();
        }
        com.kc.dw.core.service.logrecord.a.a(10, "call_destroy", this);
    }

    public a getBannerAd() {
        return this.bannerAd;
    }

    public BaseAdSlot getBaseAdSlot() {
        b bVar = this.qzxAdDelegate;
        if (bVar == null || !(bVar instanceof c)) {
            return null;
        }
        return (BaseAdSlot) ((c) bVar).f39477a;
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        com.kc.dw.core.service.logrecord.a.a(5, "e2", this);
        b bVar = this.qzxAdDelegate;
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        bVar.setLocalParams(this.localParams);
        b bVar2 = this.qzxAdDelegate;
        ((c) bVar2).j = this.ownListener;
        bVar2.loadAd();
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void render() {
        b bVar = this.qzxAdDelegate;
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        c cVar = (c) bVar;
        cVar.n = true;
        com.kc.dw.core.service.logrecord.a.a(5, "e5", cVar, new TypeMsg().setData(2));
        com.kc.dw.ad.banner.a aVar = (com.kc.dw.ad.banner.a) cVar.f39477a;
        cVar.a(aVar);
    }

    public void setQzxAdDelegate(c cVar) {
        this.qzxAdDelegate = cVar;
    }

    @Override // com.kc.dw.platform.custom.banner.MsCustomBannerAdapter
    public void showAd(ViewGroup viewGroup) {
        b bVar = this.qzxAdDelegate;
        if (bVar == null || !(bVar instanceof c)) {
            return;
        }
        c cVar = (c) bVar;
        cVar.l = viewGroup;
        if (cVar.m) {
            LogUtil.e("MeishuViewWrapper", "ad has been called show");
            return;
        }
        cVar.m = true;
        if (cVar.k.f39476a == 0) {
            com.kc.dw.ad.banner.a aVar = (com.kc.dw.ad.banner.a) cVar.f39477a;
            cVar.a(aVar);
        }
        cVar.innerShowAd();
    }
}
