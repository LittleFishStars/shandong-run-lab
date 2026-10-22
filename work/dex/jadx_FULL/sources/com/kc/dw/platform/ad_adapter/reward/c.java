package com.kc.dw.platform.ad_adapter.reward;

import android.content.ContextWrapper;
import android.text.TextUtils;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.g;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.ad.reward.RewardVideoAdListener;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.loader.IAdLoadListener;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.webview.l;
import com.kc.dw.core.webview.n;
import com.kc.dw.platform.ad_adapter.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends h<i, RewardVideoCommonLoader, RewardAdLoadListener> {
    public com.kc.dw.platform.ad_adapter.reward.a f;
    public SsdRewardOwnListener g;
    public RewardVideoAd h;
    public final ArrayList<com.kc.dw.ad.nativ.d> i;
    public g j;
    public boolean k;
    public RewardVideoAdListener l;

    @Keep
    public class a extends com.kc.dw.platform.ad_adapter.reward.a {
        public a(c cVar, h hVar, IAdLoadListener iAdLoadListener, i iVar) {
            super(hVar, iAdLoadListener, iVar);
        }
    }

    @Keep
    public class b implements com.kc.dw.platform.ad_adapter.reward.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n[] f39535a;
        public final g b;
        public final com.kc.dw.platform.ad_adapter.reward.a c;
        public final c d;

        public b(c cVar, n[] nVarArr, g gVar, com.kc.dw.platform.ad_adapter.reward.a aVar) {
            this.d = cVar;
            this.f39535a = nVarArr;
            this.b = gVar;
            this.c = aVar;
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.reward.c$c, reason: collision with other inner class name */
    @Keep
    public class C1074c extends com.kc.dw.core.webview.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.platform.ad_adapter.reward.b f39536a;

        public C1074c(c cVar, com.kc.dw.platform.ad_adapter.reward.b bVar) {
            this.f39536a = bVar;
        }

        @Override // com.kc.dw.core.webview.listener.c
        public boolean onPageFinished(String str, boolean z, boolean z2, int i) {
            LogUtil.dev("MeishuRewardVideoAdWrap", "final h5 res:" + z2);
            this.f39536a.d(z2);
            return false;
        }
    }

    @Keep
    public class d implements com.kc.dw.ad.nativ.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39537a;
        public final NormalMediaView b;
        public final com.kc.dw.platform.ad_adapter.reward.a c;
        public final com.kc.dw.platform.ad_adapter.reward.b d;
        public final c e;

        public d(c cVar, i iVar, NormalMediaView normalMediaView, com.kc.dw.platform.ad_adapter.reward.a aVar, com.kc.dw.platform.ad_adapter.reward.b bVar) {
            this.e = cVar;
            this.f39537a = iVar;
            this.b = normalMediaView;
            this.c = aVar;
            this.d = bVar;
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPrepareError(int i, String str) {
            this.d.b(false);
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.e, new LoadResState().setFail(2));
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPreparedStartPlay(int i, int i2, boolean z) {
            this.e.d = System.currentTimeMillis();
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.e, new LoadResState().setSuccess(2, 1, 0));
            i iVar = this.f39537a;
            iVar.setMonitorUrl(g0.b(iVar.getMonitorUrl(), this.e.b()));
            this.b.setAdListener(this.c);
            c cVar = this.e;
            cVar.l.onVideoCached(cVar.h);
            this.d.b(true);
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onStartDownload() {
        }
    }

    @Keep
    public class e implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.platform.ad_adapter.reward.b f39538a;
        public final NormalMediaView b;
        public final com.kc.dw.platform.ad_adapter.reward.a c;
        public final c d;

        public e(c cVar, com.kc.dw.platform.ad_adapter.reward.b bVar, NormalMediaView normalMediaView, com.kc.dw.platform.ad_adapter.reward.a aVar) {
            this.d = cVar;
            this.f39538a = bVar;
            this.b = normalMediaView;
            this.c = aVar;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.d, new LoadResState().setFail(2));
            this.f39538a.b(false);
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.d, new LoadResState().setSuccess(2, 1, 0));
            this.b.setAdListener(this.c);
            this.f39538a.b(true);
        }
    }

    @Keep
    public class f implements RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39539a;

        public f(c cVar) {
            this.f39539a = cVar;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            AdError adError;
            int i;
            c cVar = this.f39539a;
            SsdRewardOwnListener ssdRewardOwnListener = cVar.g;
            if (ssdRewardOwnListener != null) {
                boolean z = cVar.k;
                RewardVideoAd rewardVideoAd = cVar.h;
                if (z) {
                    adError = new AdError(200002, "render error");
                    i = 1;
                } else {
                    adError = new AdError(200002, "render error");
                    i = 0;
                }
                ssdRewardOwnListener.onAdFail(rewardVideoAd, adError, i);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdLoaded(RewardVideoAd rewardVideoAd) {
            RewardVideoAd rewardVideoAd2 = rewardVideoAd;
            c cVar = this.f39539a;
            cVar.h = rewardVideoAd2;
            SsdRewardOwnListener ssdRewardOwnListener = cVar.g;
            if (ssdRewardOwnListener != null) {
                ssdRewardOwnListener.onLoadSuccess(rewardVideoAd2);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdReady(RewardVideoAd rewardVideoAd) {
            this.f39539a.k = true;
            c cVar = this.f39539a;
            SsdRewardOwnListener ssdRewardOwnListener = cVar.g;
            if (ssdRewardOwnListener != null) {
                ssdRewardOwnListener.onRenderSuccess(cVar.h);
            }
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            AdError adError;
            int i2;
            c cVar = this.f39539a;
            SsdRewardOwnListener ssdRewardOwnListener = cVar.g;
            if (ssdRewardOwnListener != null) {
                boolean z = cVar.k;
                RewardVideoAd rewardVideoAd = cVar.h;
                if (z) {
                    if (TextUtils.isEmpty(str)) {
                        str = "render error";
                    }
                    adError = new AdError(200002, str);
                    i2 = 1;
                } else {
                    if (TextUtils.isEmpty(str)) {
                        str = "render error";
                    }
                    adError = new AdError(200002, str);
                    i2 = 0;
                }
                ssdRewardOwnListener.onAdFail(rewardVideoAd, adError, i2);
            }
        }

        @Override // com.kc.dw.core.ad.reward.RewardVideoAdListener
        public void onReward(Map<String, Object> map) {
        }

        @Override // com.kc.dw.core.ad.reward.RewardVideoAdListener
        public void onVideoCached(RewardVideoAd rewardVideoAd) {
            c cVar = this.f39539a;
            SsdRewardOwnListener ssdRewardOwnListener = cVar.g;
            if (ssdRewardOwnListener != null) {
                ssdRewardOwnListener.onVideoLoaded(cVar.h);
            }
        }
    }

    public c(RewardVideoCommonLoader rewardVideoCommonLoader, i iVar) {
        super(rewardVideoCommonLoader, iVar);
        this.i = new ArrayList<>();
        this.l = new f(this);
    }

    public void a(i iVar, com.kc.dw.platform.ad_adapter.reward.a aVar, com.kc.dw.core.ad.b bVar) {
        try {
            this.e = iVar.getErrorUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        NormalMediaView normalMediaView = new NormalMediaView(new ContextWrapper(this.context));
        g gVar = new g(iVar);
        gVar.d = iVar.title;
        gVar.e = iVar.desc;
        gVar.f39131a = iVar.getAdPatternType();
        gVar.b = iVar.iconUrl;
        gVar.c = iVar.getImageUrls();
        gVar.g = normalMediaView;
        gVar.j = bVar.getVideoIsMute();
        iVar.getCid();
        this.j = gVar;
        this.i.add(gVar);
        aVar.a((List<com.kc.dw.ad.nativ.d>) this.i);
        bVar.addRewardMediaViewLocalId(iVar.hashCode() + "");
        if (isAutoRender()) {
            a(iVar, aVar, bVar, this.j, normalMediaView);
        }
    }

    public final void a(i iVar, com.kc.dw.platform.ad_adapter.reward.a aVar, com.kc.dw.core.ad.b bVar, g gVar, NormalMediaView normalMediaView) {
        this.b = System.currentTimeMillis();
        com.kc.dw.core.service.logrecord.a.a(5, "e5", this, new TypeMsg().setData(isAutoRender() ? 1 : 2));
        n[] nVarArr = new n[1];
        com.kc.dw.platform.ad_adapter.reward.b bVar2 = new com.kc.dw.platform.ad_adapter.reward.b(new b(this, nVarArr, gVar, aVar));
        String h5Url = iVar.getH5Url();
        if (TextUtils.isEmpty(h5Url)) {
            bVar2.d(false);
        } else {
            nVarArr[0] = new l().a(this.context, h5Url, gVar, false, new C1074c(this, bVar2));
        }
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this);
        if (iVar.getAdPatternType() != 2) {
            String strB = com.kc.dw.core.utils.a.b((BaseAdSlot) iVar);
            if (!TextUtils.isEmpty(strB)) {
                c0.a(strB, new e(this, bVar2, normalMediaView, aVar));
                return;
            } else {
                bVar2.b(false);
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this, new LoadResState().setFail(9));
                return;
            }
        }
        normalMediaView.setPreparedStartPlayListener(new d(this, iVar, normalMediaView, aVar, bVar2));
        normalMediaView.setVideoPath(iVar.g);
        normalMediaView.setPlayOnce(true);
        normalMediaView.setFromLogoVisibility(8);
        normalMediaView.setUseTransform(false);
        if (bVar.getVideoIsMute()) {
            normalMediaView.f();
        }
    }

    @Override // com.kc.dw.platform.ad_adapter.h, com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
        try {
            if (this.i != null) {
                for (int i = 0; i < this.i.size(); i++) {
                    this.i.get(i).b();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        try {
            T t = this.f39477a;
            if (t != 0 && ((i) t).getImageUrls() != null && ((i) this.f39477a).getImageUrls().length != 0) {
                RewardVideoAdListener rewardVideoAdListener = this.l;
                T t2 = this.f39477a;
                a aVar = new a(this, this, rewardVideoAdListener, (i) t2);
                this.f = aVar;
                a((i) t2, aVar, (com.kc.dw.core.ad.b) getAdLoader());
                return;
            }
            LogUtil.i("MeishuRewardVideoAdWrap", "资源url为空");
            SsdRewardOwnListener ssdRewardOwnListener = this.g;
            if (ssdRewardOwnListener != null) {
                ssdRewardOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
