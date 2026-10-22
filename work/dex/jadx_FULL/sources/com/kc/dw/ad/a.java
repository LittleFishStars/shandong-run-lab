package com.kc.dw.ad;

import android.text.TextUtils;
import android.view.View;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.dw.ad.nativ.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.kc.dw.ad.splash.c f39079a;
    public final SsdSplashRootView b;
    public final com.kc.dw.ad.splash.a c;
    public final View d;
    public final com.kc.dw.ad.splash.d e;
    public final int f;
    public final long g;
    public final k h;

    /* JADX INFO: renamed from: com.kc.dw.ad.a$a, reason: collision with other inner class name */
    @Keep
    public class C1017a implements com.kc.dw.ad.nativ.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39080a;

        public C1017a(a aVar) {
            this.f39080a = aVar;
        }

        @Override // com.kc.dw.ad.z
        public /* bridge */ /* synthetic */ void a(List<com.kc.dw.ad.nativ.d> list) {
        }

        @Override // com.kc.dw.ad.z
        public void onADExposure() {
        }

        @Override // com.kc.dw.ad.z
        public void onAdRenderFail(String str, int i) {
            this.f39080a.onPrepareError(com.kc.dw.core.exception.b.h.intValue(), "player error." + i + str);
        }
    }

    @Keep
    public class b implements NativeAdMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SplashSkipView f39081a;
        public final a b;

        public b(a aVar, SplashSkipView splashSkipView) {
            this.b = aVar;
            this.f39081a = splashSkipView;
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoCompleted() {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoError() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoLoaded() {
            a aVar = this.b;
            k kVar = aVar.h;
            k.a(kVar, (byte[]) null, aVar.b, false, (BaseAdSlot) aVar.e, aVar.f39079a, aVar.c, kVar.C);
            a aVar2 = this.b;
            com.kc.dw.ad.splash.c cVar = aVar2.f39079a;
            NormalMediaView normalMediaView = aVar2.h.C;
            cVar.d = normalMediaView;
            if (aVar2.c != null) {
                cVar.setWidth(Integer.valueOf(normalMediaView.getOwnVideoView().getMediaPlayer().getVideoWidth()));
                a aVar3 = this.b;
                aVar3.f39079a.setHeight(Integer.valueOf(aVar3.h.C.getOwnVideoView().getMediaPlayer().getVideoHeight()));
            }
            long jMin = Math.min(this.b.h.C.getDuration(), ((SplashCommonAdLoader) this.b.h.w.getAdLoader()).getAdSlot().getSplashShowTime());
            if (this.b.e.I != 1) {
                this.f39081a.setTotalTime((int) jMin);
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoPause() {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoResume() {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoStart() {
        }
    }

    public a(k kVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.ad.splash.a aVar, View view, com.kc.dw.ad.splash.d dVar, int i, long j) {
        this.h = kVar;
        this.f39079a = cVar;
        this.b = ssdSplashRootView;
        this.c = aVar;
        this.d = view;
        this.e = dVar;
        this.f = i;
        this.g = j;
    }

    @Override // com.kc.dw.ad.nativ.b
    public void a() {
        if (this.h.m == null || (!this.h.m.booleanValue() && this.h.n == null)) {
            LogUtil.dev("AdNative", this.h.m == null ? "wait video cover3" : "wait defImage3");
            this.h.a(((long) this.f) - (System.currentTimeMillis() - this.g));
        }
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onPrepareError(int i, String str) {
        s1.a(this.f39079a.b.getEventUrl(), 13, i, str + " cid:" + this.e.getCid());
        try {
            if (this.h.k != null && this.h.k.length > 0) {
                LogUtil.d("AdNative", "native video fail. use cover");
                this.e.getImageUrls()[0] = this.e.getVideo_cover();
                g0.b(this.e.getMonitorUrl());
                k kVar = this.h;
                kVar.a(this.c, this.e, this.f39079a, this.b, this.d, kVar.k);
            } else if (TextUtils.isEmpty(this.e.getDefImage())) {
                LogUtil.d("AdNative", "native video fail. invalid defImage");
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.h.w, new LoadResState().setFail(i));
                this.h.a(this.c, str, Integer.valueOf(i));
            } else {
                LogUtil.d("AdNative", "native video fail. use defImage");
                this.e.getImageUrls()[0] = this.e.getDefImage();
                g0.b(this.e.getMonitorUrl());
                this.h.a(this.c, this.e, this.f39079a, this.b, this.d, (byte[]) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.h.a(this.c, str, Integer.valueOf(i));
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.h.w, new LoadResState().setFail(i));
        }
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onPreparedStartPlay(int i, int i2, boolean z) {
        try {
            s1.a(this.f39079a.b.getEventUrl(), 13, 200, "splash video load success");
            com.kc.dw.core.service.logrecord.a.a(5, "s4", this.h.w, new LoadResState().setSuccess(2, 1, z ? 1 : 0));
            if (z) {
                this.h.b(2);
            }
            SplashSkipView splashSkipViewA = k.a(this.h, this.f39079a, this.b, this.c, this.d);
            this.h.C.setConfigWidth(this.e.f39132a);
            this.h.C.setConfigHeight(this.e.b);
            this.h.C.setPlayOnce(true);
            this.h.C.f();
            this.h.C.setIsEyes(this.e.I);
            this.h.C.setUseTransform(false);
            this.h.C.setDisplayMode(2);
            this.h.C.setFromLogoVisibility(8);
            this.h.C.setFromLogo(null);
            this.h.C.setAdListener(new C1017a(this));
            this.h.C.setNativeAdMediaListener(new com.kc.dw.platform.ad_adapter.recycler.d(this.e, new b(this, splashSkipViewA)));
            this.h.C.setVideoCover(this.e.getVideo_cover());
            this.h.C.setVideoEndCover(this.e.h);
            this.h.t.b(2);
            k kVar = this.h;
            if (kVar.z || kVar.g || kVar.h) {
                kVar.C.start();
                k.b(this.h);
            }
        } catch (Exception unused) {
            onPrepareError(9000001, "splash video player init error");
        }
    }

    @Override // com.kc.dw.ad.nativ.c
    public void onStartDownload() {
        this.h.b(2);
    }
}
