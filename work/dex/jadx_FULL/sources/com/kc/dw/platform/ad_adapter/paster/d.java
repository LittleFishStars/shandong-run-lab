package com.kc.dw.platform.ad_adapter.paster;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.paster.PasterAdImpl;
import com.kc.dw.core.ad.paster.PasterAdLoadListener;
import com.kc.dw.core.ad.paster.PasterCommonAdLoader;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.ad_adapter.e;
import com.kc.dw.platform.ad_adapter.g;
import com.kc.dw.platform.ad_adapter.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends h<i, PasterCommonAdLoader, PasterAdLoadListener> {
    public ViewGroup f;
    public boolean g;
    public boolean h;
    public PasterAdImpl i;
    public SsdPasterOwnListener j;
    public g k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public long q;
    public com.kc.dw.ad.nativ.a r;

    @Keep
    public class a implements com.kc.dw.ad.nativ.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NativeAdMediaListener f39484a = new C1070a(this);
        public final d b;

        /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.paster.d$a$a, reason: collision with other inner class name */
        @Keep
        public class C1070a implements NativeAdMediaListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39485a;

            public C1070a(a aVar) {
                this.f39485a = aVar;
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoCompleted() {
                this.f39485a.b.f.setOnClickListener(null);
                SsdPasterOwnListener ssdPasterOwnListener = this.f39485a.b.j;
                if (ssdPasterOwnListener != null) {
                    ssdPasterOwnListener.onVideoComplete();
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoError() {
                this.f39485a.b.f.setOnClickListener(null);
                this.f39485a.onAdRenderFail("download video error1001", 200002);
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoLoaded() {
                d dVar = this.f39485a.b;
                if (dVar.h) {
                    return;
                }
                dVar.h = true;
                SsdPasterOwnListener ssdPasterOwnListener = this.f39485a.b.j;
                if (ssdPasterOwnListener != null) {
                    ssdPasterOwnListener.onVideoLoaded();
                }
                d dVar2 = this.f39485a.b;
                SsdPasterOwnListener ssdPasterOwnListener2 = dVar2.j;
                if (ssdPasterOwnListener2 != null) {
                    ssdPasterOwnListener2.onRenderSuccess(dVar2.i);
                }
                this.f39485a.b.k.a(-1, 8);
                com.kc.dw.core.service.logrecord.a.a(5, "e7", this.f39485a.b);
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

        public a(d dVar) {
            this.b = dVar;
        }

        @Override // com.kc.dw.ad.z
        public void a(List<com.kc.dw.ad.nativ.d> list) {
            String str;
            List<com.kc.dw.ad.nativ.d> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                str = "ad is empty";
            } else {
                com.kc.dw.ad.nativ.d dVar = list2.get(0);
                if (dVar.getMediaView() instanceof NormalMediaView) {
                    T t = this.b.f39477a;
                    if (t != 0 && !TextUtils.isEmpty(((i) t).g)) {
                        com.kc.dw.core.service.logrecord.a.a(5, "e5", this.b, new TypeMsg().setData(this.b.l ? 2 : 1));
                        ((NormalMediaView) dVar.getMediaView()).setAutoStart(false);
                        this.b.i.setAdListener(this);
                        this.b.i.setAdView(dVar.getAdView());
                        this.b.f.setOnClickListener(new com.kc.dw.platform.ad_adapter.paster.a(this, dVar));
                        TouchAdContainer touchAdContainer = new TouchAdContainer(this.b.getContext());
                        touchAdContainer.setTouchPositionListener(new TouchPositionListener(dVar));
                        touchAdContainer.setOnTouchListener(new b(this));
                        this.b.getContext();
                        dVar.a(touchAdContainer, new com.kc.dw.platform.ad_adapter.recycler.d((i) this.b.f39477a, this.f39484a), new com.kc.dw.core.service.logrecord.util.a(this.b, true));
                        touchAdContainer.setOnClickListener(new c(this, dVar));
                        this.b.f.removeAllViews();
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(13);
                        this.b.f.addView(touchAdContainer, layoutParams);
                        return;
                    }
                    str = "videoUrl is null";
                } else {
                    str = "isn`t video ad";
                }
            }
            onAdRenderFail(str, 200002);
        }

        @Override // com.kc.dw.ad.z
        public void onADExposure() {
            d dVar = this.b;
            if (dVar.g) {
                return;
            }
            t0.a(((i) dVar.f39477a).getPosId(), 3);
            String[] monitorUrl = ((i) this.b.f39477a).getMonitorUrl();
            g0.a(monitorUrl, this.b.i.getAdView(), (View) null);
            if (monitorUrl != null) {
                LogUtil.d("MeishuPasterAdWrapper", "send onADExposure");
                for (String str : monitorUrl) {
                    if (!TextUtils.isEmpty(str)) {
                        com.kc.dw.ad.interstitial.c.a(this.b.getContext(), g0.a(g0.a(str, ((i) this.b.f39477a).getAct_type(), AdType.PASTER)));
                    }
                }
            }
            PasterAdImpl pasterAdImpl = this.b.i;
            if (pasterAdImpl != null && pasterAdImpl.getInteractionListener() != null) {
                this.b.i.getInteractionListener().onAdExposure();
            }
            this.b.g = true;
        }

        @Override // com.kc.dw.ad.z
        public void onAdRenderFail(String str, int i) {
            if (this.b.k.f39476a == 6) {
                return;
            }
            if (((i) this.b.f39477a).getErrorUrl() != null) {
                z.a(((i) this.b.f39477a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            this.b.k.a(-1, 6);
            d dVar = this.b;
            SsdPasterOwnListener ssdPasterOwnListener = dVar.j;
            if (ssdPasterOwnListener != null) {
                ssdPasterOwnListener.onAdFail(dVar.i, new AdError(i, str), 0);
            }
        }
    }

    public d(PasterCommonAdLoader pasterCommonAdLoader, i iVar, ViewGroup viewGroup) {
        super(pasterCommonAdLoader, iVar);
        this.g = false;
        this.h = false;
        this.k = new g();
        this.l = false;
        this.r = new a(this);
        this.f = viewGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        if (this.k.f39476a != 0) {
            return;
        }
        this.k.a(-1, 1);
        new e(getContext(), this).a((i) this.f39477a, this.r, false, false, false, DimensionUtils.px2dip(getContext(), ((PasterCommonAdLoader) getAdLoader()).getAccept_ad_width().intValue()), DimensionUtils.px2dip(getContext(), ((PasterCommonAdLoader) getAdLoader()).getAccept_ad_height().intValue()));
    }

    @Override // com.kc.dw.platform.ad_adapter.h, com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
        LogUtil.e("MeishuPasterAdWrapper", "MeishuPasterAdWrapper.destroy");
        this.f.setOnClickListener(null);
        this.f.removeAllViews();
        this.f = null;
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        T t = this.f39477a;
        if (t == 0 || ((i) t).getImageUrls() == null || ((i) this.f39477a).getImageUrls().length == 0) {
            LogUtil.i("MeishuPasterAdWrapper", "资源url为空");
            SsdPasterOwnListener ssdPasterOwnListener = this.j;
            if (ssdPasterOwnListener != null) {
                ssdPasterOwnListener.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
                return;
            }
            return;
        }
        PasterAdImpl pasterAdImpl = new PasterAdImpl(this, (i) this.f39477a);
        this.i = pasterAdImpl;
        SsdPasterOwnListener ssdPasterOwnListener2 = this.j;
        if (ssdPasterOwnListener2 != null) {
            ssdPasterOwnListener2.onLoadSuccess(pasterAdImpl);
        }
        if (isAutoRender()) {
            c();
        }
    }
}
