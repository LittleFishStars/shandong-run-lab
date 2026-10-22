package com.kc.dw.platform.ad_adapter.fullscreenvideo;

import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.g;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenAdLoadListener;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoAdListener;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoCommonAdLoader;
import com.kc.dw.core.ad.fullscreenvideo.IFullScreenVideoAd;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.loader.IAdLoadListener;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.x;
import com.kc.dw.platform.ad_adapter.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a extends h<i, FullScreenVideoCommonAdLoader, FullScreenAdLoadListener> {
    public com.kc.dw.platform.ad_adapter.reward.a f;
    public com.kc.dw.platform.ad_adapter.a g;
    public SsdFullScreenOwnListener h;
    public g i;
    public com.kc.dw.platform.ad_adapter.reward.a j;
    public final IAdLoadListener k;
    public final InteractionListener l;

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.fullscreenvideo.a$a, reason: collision with other inner class name */
    @Keep
    public class C1069a extends com.kc.dw.platform.ad_adapter.reward.a {
        public C1069a(a aVar, h hVar, IAdLoadListener iAdLoadListener, i iVar) {
            super(hVar, iAdLoadListener, iVar);
        }
    }

    @Keep
    public class b implements com.kc.dw.ad.nativ.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NormalMediaView f39472a;
        public final a b;

        public b(a aVar, NormalMediaView normalMediaView) {
            this.b = aVar;
            this.f39472a = normalMediaView;
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPrepareError(int i, String str) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.b, new LoadResState().setFail(4));
            a aVar = this.b;
            aVar.a(aVar.j, "video load error", com.kc.dw.core.exception.b.i);
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPreparedStartPlay(int i, int i2, boolean z) {
            this.b.d = System.currentTimeMillis();
            i iVar = (i) this.b.f39477a;
            iVar.setMonitorUrl(g0.b(iVar.getMonitorUrl(), this.b.b()));
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.b, new LoadResState().setSuccess(2, 1, 0));
            this.f39472a.setAdListener(this.b.j);
            this.f39472a.setPlayOnce(true);
            this.f39472a.setFromLogoVisibility(8);
            this.f39472a.setUseTransform(false);
            if (((FullScreenVideoCommonAdLoader) this.b.adLoader).getVideoIsMute()) {
                this.f39472a.f();
            }
            a aVar = this.b;
            IAdLoadListener iAdLoadListener = aVar.k;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdReady(aVar.g);
            }
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onStartDownload() {
        }
    }

    @Keep
    public class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NormalMediaView f39473a;
        public final a b;

        public c(a aVar, NormalMediaView normalMediaView) {
            this.b = aVar;
            this.f39473a = normalMediaView;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.b, new LoadResState().setFail(2));
            a aVar = this.b;
            aVar.a(aVar.j, "image load error", com.kc.dw.core.exception.b.i);
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.b, new LoadResState().setSuccess(1, 1, 0));
            this.f39473a.setAdListener(this.b.j);
            a aVar = this.b;
            IAdLoadListener iAdLoadListener = aVar.k;
            if (iAdLoadListener != null) {
                iAdLoadListener.onAdReady(aVar.g);
            }
        }
    }

    @Keep
    public class d implements FullScreenVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39474a;

        public d(a aVar) {
            this.f39474a = aVar;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            a aVar = this.f39474a;
            SsdFullScreenOwnListener ssdFullScreenOwnListener = aVar.h;
            if (ssdFullScreenOwnListener != null) {
                ssdFullScreenOwnListener.onAdFail(aVar.g, new AdError(200002, "render error"), 0);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdLoaded(IFullScreenVideoAd iFullScreenVideoAd) {
            a aVar = this.f39474a;
            com.kc.dw.platform.ad_adapter.a aVar2 = (com.kc.dw.platform.ad_adapter.a) iFullScreenVideoAd;
            aVar.g = aVar2;
            aVar2.setInteractionListener(aVar.l);
            a aVar3 = this.f39474a;
            SsdFullScreenOwnListener ssdFullScreenOwnListener = aVar3.h;
            if (ssdFullScreenOwnListener != null) {
                ssdFullScreenOwnListener.onLoadSuccess(aVar3.g);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdReady(IFullScreenVideoAd iFullScreenVideoAd) {
            a aVar = this.f39474a;
            SsdFullScreenOwnListener ssdFullScreenOwnListener = aVar.h;
            if (ssdFullScreenOwnListener != null) {
                ssdFullScreenOwnListener.onRenderSuccess(aVar.g);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            a aVar = this.f39474a;
            SsdFullScreenOwnListener ssdFullScreenOwnListener = aVar.h;
            if (ssdFullScreenOwnListener != null) {
                ssdFullScreenOwnListener.onAdFail(aVar.g, new AdError(i, str), 0);
            }
        }
    }

    @Keep
    public class e implements InteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39475a;

        public e(a aVar) {
            this.f39475a = aVar;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
            com.kc.dw.platform.ad_adapter.a aVar = this.f39475a.g;
            if (aVar == null || aVar.getInteractionListener() == null) {
                return;
            }
            this.f39475a.g.getInteractionListener().onAdClicked();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
            com.kc.dw.platform.ad_adapter.a aVar = this.f39475a.g;
            if (aVar == null || aVar.getInteractionListener() == null) {
                return;
            }
            this.f39475a.g.getInteractionListener().onAdClosed();
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
            com.kc.dw.platform.ad_adapter.a aVar = this.f39475a.g;
            if (aVar == null || aVar.getInteractionListener() == null) {
                return;
            }
            this.f39475a.g.getInteractionListener().onAdExposure();
        }
    }

    public a(FullScreenVideoCommonAdLoader fullScreenVideoCommonAdLoader, i iVar) {
        super(fullScreenVideoCommonAdLoader, iVar);
        this.k = new d(this);
        this.l = new e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        T t = this.f39477a;
        if (t == 0 || ((i) t).getImageUrls() == null || ((i) this.f39477a).getImageUrls().length == 0) {
            LogUtil.i("SsdFullScreenVideoAdWrapper", "资源url为空");
            SsdFullScreenOwnListener ssdFullScreenOwnListener = this.h;
            if (ssdFullScreenOwnListener != null) {
                ssdFullScreenOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
                return;
            }
            return;
        }
        IAdLoadListener iAdLoadListener = this.k;
        i iVar = (i) this.f39477a;
        C1069a c1069a = new C1069a(this, this, iAdLoadListener, iVar);
        this.f = c1069a;
        FullScreenVideoCommonAdLoader fullScreenVideoCommonAdLoader = (FullScreenVideoCommonAdLoader) getAdLoader();
        try {
            this.e = iVar.getErrorUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            this.e = iVar.getErrorUrl();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        this.j = c1069a;
        NormalMediaView normalMediaView = new NormalMediaView(this.context);
        ArrayList arrayList = new ArrayList();
        g gVar = new g(iVar);
        gVar.d = iVar.title;
        gVar.e = iVar.desc;
        gVar.f39131a = iVar.getAdPatternType();
        gVar.b = iVar.iconUrl;
        gVar.c = iVar.getImageUrls();
        gVar.g = normalMediaView;
        gVar.j = fullScreenVideoCommonAdLoader.getVideoIsMute();
        iVar.getCid();
        this.i = gVar;
        arrayList.add(gVar);
        c1069a.a((List<com.kc.dw.ad.nativ.d>) arrayList);
        if (isAutoRender()) {
            render();
        }
    }

    public void render() {
        try {
            if (this.b != 0) {
                return;
            }
            this.b = System.currentTimeMillis();
            com.kc.dw.core.service.logrecord.a.a(5, "e5", this, new TypeMsg().setData(isAutoRender() ? 1 : 2));
            com.kc.dw.core.service.logrecord.a.a(5, "e4", this);
            NormalMediaView normalMediaView = (NormalMediaView) this.i.g;
            if (((i) this.f39477a).getAdPatternType() == 2) {
                normalMediaView.setPreparedStartPlayListener(new b(this, normalMediaView));
                normalMediaView.setVideoPath(((i) this.f39477a).g);
            } else {
                c0.a(com.kc.dw.core.utils.a.b((BaseAdSlot) this.f39477a), new c(this, normalMediaView));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a(this.j, "render error", 9000001);
        }
    }
}
