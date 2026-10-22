package com.kc.dw.platform.ad_adapter.recycler;

import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.ad.recycler.RecyclerAdEventAdapter;
import com.kc.dw.core.ad.recycler.RecyclerAdListener;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends com.kc.dw.platform.ad_adapter.h<com.kc.dw.ad.nativ.i, RecyclerMixCommonAdLoader, RecyclerAdEventAdapter> {
    public c f;
    public SsdRecyclerOwnListener g;
    public List<FeedAd> h;
    public final RecyclerAdListener i;

    @Keep
    public class a implements RecyclerAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39489a;

        public a(e eVar) {
            this.f39489a = eVar;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            SsdRecyclerOwnListener ssdRecyclerOwnListener = this.f39489a.g;
            if (ssdRecyclerOwnListener != null) {
                ssdRecyclerOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.i.intValue(), "load error"));
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdListener, com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
            e eVar = this.f39489a;
            SsdRecyclerOwnListener ssdRecyclerOwnListener = eVar.g;
            if (ssdRecyclerOwnListener != null) {
                ssdRecyclerOwnListener.onRenderSuccess(eVar.h);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public /* bridge */ /* synthetic */ void onAdLoaded(List<FeedAd> list) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdReady(List<FeedAd> list) {
            List<FeedAd> list2 = list;
            e eVar = this.f39489a;
            eVar.h = list2;
            SsdRecyclerOwnListener ssdRecyclerOwnListener = eVar.g;
            if (ssdRecyclerOwnListener != null) {
                ssdRecyclerOwnListener.onLoadSuccess(list2);
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecyclerAdListener, com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            e eVar = this.f39489a;
            SsdRecyclerOwnListener ssdRecyclerOwnListener = eVar.g;
            if (ssdRecyclerOwnListener != null) {
                ssdRecyclerOwnListener.onAdFail(eVar.h, new AdError(i, str), 0);
            }
        }
    }

    public e(RecyclerMixCommonAdLoader recyclerMixCommonAdLoader, com.kc.dw.ad.nativ.i iVar) {
        super(recyclerMixCommonAdLoader, iVar);
        this.i = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        try {
            T t = this.f39477a;
            if (t != 0 && ((com.kc.dw.ad.nativ.i) t).getImageUrls() != null && ((com.kc.dw.ad.nativ.i) this.f39477a).getImageUrls().length != 0) {
                this.f = new c(this, this.i);
                boolean isVideoAutoPlay = ((RecyclerMixCommonAdLoader) getAdLoader()).getAdSlot().getIsVideoAutoPlay();
                if (AdSdk.isTestMode) {
                    isVideoAutoPlay = ((com.kc.dw.ad.nativ.i) this.f39477a).z;
                }
                boolean z = isVideoAutoPlay;
                com.kc.dw.platform.ad_adapter.e eVar = new com.kc.dw.platform.ad_adapter.e(getContext(), this);
                com.kc.dw.ad.nativ.i iVar = (com.kc.dw.ad.nativ.i) this.f39477a;
                c cVar = this.f;
                boolean isShowDetail = ((RecyclerMixCommonAdLoader) getAdLoader()).getAdSlot().getIsShowDetail();
                float fPx2dip = DimensionUtils.px2dip(getContext(), ((RecyclerMixCommonAdLoader) getAdLoader()).getAccept_ad_width().intValue());
                float fPx2dip2 = DimensionUtils.px2dip(getContext(), ((RecyclerMixCommonAdLoader) getAdLoader()).getAccept_ad_height().intValue());
                try {
                    iVar.getErrorUrl();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                eVar.a(iVar, cVar, true, isShowDetail, z, fPx2dip, fPx2dip2);
                return;
            }
            LogUtil.i("MeishuAdNativeWrapper", "资源url为空");
            SsdRecyclerOwnListener ssdRecyclerOwnListener = this.g;
            if (ssdRecyclerOwnListener != null) {
                ssdRecyclerOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
