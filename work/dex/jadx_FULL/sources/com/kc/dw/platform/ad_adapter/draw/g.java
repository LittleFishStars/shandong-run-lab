package com.kc.dw.platform.ad_adapter.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.ad.draw.SsdDrawRootView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.draw.DrawAdListener;
import com.kc.dw.core.ad.draw.DrawAdLoadListener;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.ad.draw.IDrawAd;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.safe.m;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.dw.platform.ad_adapter.h;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends h<i, DrawCommonAdLoader, DrawAdLoadListener> {
    public boolean f;
    public boolean g;
    public com.kc.dw.platform.ad_adapter.draw.a h;
    public SsdDrawOwnListener i;
    public long j;
    public long k;
    public com.kc.dw.platform.ad_adapter.g l;
    public NativeAdMediaListener m;

    @Keep
    public class a implements DrawAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SsdDrawRootView f39464a;
        public final g b;

        /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.draw.g$a$a, reason: collision with other inner class name */
        @Keep
        public class C1068a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39465a;

            public C1068a(a aVar) {
                this.f39465a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                t0.a(((i) this.f39465a.b.f39477a).getPosId(), 3);
                String[] strArrB = g0.b(((i) this.f39465a.b.f39477a).getMonitorUrl(), this.f39465a.b.b());
                g0.a(strArrB, this.f39465a.b.h.getAdView(), (View) null);
                if (strArrB != null) {
                    LogUtil.d("MeishuDrawAdWrapper", "send onAdExposure");
                    for (String str : strArrB) {
                        if (!TextUtils.isEmpty(str)) {
                            com.kc.dw.ad.interstitial.c.a(this.f39465a.b.getContext(), g0.a(g0.a(str, ((i) this.f39465a.b.f39477a).getAct_type(), AdType.DRAW)));
                        }
                    }
                }
                com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39465a.b.h;
                if (aVar != null && aVar.getInteractionListener() != null) {
                    this.f39465a.b.h.getInteractionListener().onAdExposure();
                }
                this.f39465a.b.f = true;
            }
        }

        public a(g gVar, SsdDrawRootView ssdDrawRootView) {
            this.b = gVar;
            this.f39464a = ssdDrawRootView;
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdError() {
            if (((i) this.b.f39477a).getErrorUrl() != null) {
                z.a(((i) this.b.f39477a).getErrorUrl()[0], (Integer) (-1), "图片加载失败");
            }
            this.b.a(new AdError(com.kc.dw.core.exception.b.i.intValue(), "图片加载失败"));
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdExposure() {
            SsdDrawRootView ssdDrawRootView;
            if (this.b.f || (ssdDrawRootView = this.f39464a) == null) {
                return;
            }
            ssdDrawRootView.post(new C1068a(this));
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public /* bridge */ /* synthetic */ void onAdLoaded(IDrawAd iDrawAd) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdPlatformError(AdPlatformError adPlatformError) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public /* bridge */ /* synthetic */ void onAdReady(IDrawAd iDrawAd) {
        }

        @Override // com.kc.dw.core.loader.IAdLoadListener
        public void onAdRenderFail(String str, int i) {
            if (((i) this.b.f39477a).getErrorUrl() != null) {
                z.a(((i) this.b.f39477a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            this.b.a(new AdError(i, str));
        }
    }

    @Keep
    public class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f39466a;

        public b(g gVar) {
            this.f39466a = gVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            if (this.f39466a.h.getInteractionListener() != null) {
                this.f39466a.h.getInteractionListener().onAdClosed();
            }
        }
    }

    @Keep
    public class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GifImageView f39467a;
        public final SsdDrawRootView b;
        public final g c;

        public c(g gVar, GifImageView gifImageView, SsdDrawRootView ssdDrawRootView) {
            this.c = gVar;
            this.f39467a = gifImageView;
            this.b = ssdDrawRootView;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c, new LoadResState().setFail(2));
            this.c.a(new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误"));
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            g gVar;
            AdError adError;
            try {
                if (httpResponse.isSuccessful()) {
                    byte[] responseBody = httpResponse.getResponseBody();
                    if (responseBody != null && responseBody.length > 0) {
                        com.kc.dw.core.service.logrecord.a.a(5, "s4", this.c, new LoadResState().setSuccess(1, 1, 0));
                        this.c.getClass();
                        byte[] bArr = new byte[4];
                        System.arraycopy(responseBody, 0, bArr, 0, 4);
                        if (new BigInteger(1, bArr).toString(16).startsWith("47494638")) {
                            GifImageView gifImageView = this.f39467a;
                            if (gifImageView != null) {
                                gifImageView.setBytes(responseBody);
                                this.f39467a.startAnimation();
                            }
                        } else {
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                            if (bitmapDecodeByteArray == null) {
                                if (((i) this.c.f39477a).getErrorUrl() != null) {
                                    String str = ((i) this.c.f39477a).getErrorUrl()[0];
                                    Integer num = com.kc.dw.core.exception.b.c;
                                    z.a(str, num, "图片资源加载错误");
                                    s1.a(((i) this.c.f39477a).getErrorUrl(), 12, num.intValue(), "图片资源加载错误");
                                }
                                this.c.a(new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误"));
                                return;
                            }
                            this.f39467a.setImageBitmap(bitmapDecodeByteArray);
                        }
                        this.c.k = System.currentTimeMillis();
                        if (this.c.i != null) {
                            TouchAdContainer touchAdContainer = new TouchAdContainer(this.c.context);
                            touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.c.h));
                            touchAdContainer.addView(this.b);
                            this.c.h.setAdView(touchAdContainer);
                            this.c.l.a(-1, 5);
                            g gVar2 = this.c;
                            gVar2.i.onRenderSuccess(gVar2.h);
                            return;
                        }
                        return;
                    }
                    if (((i) this.c.f39477a).getErrorUrl() != null) {
                        String str2 = ((i) this.c.f39477a).getErrorUrl()[0];
                        Integer num2 = com.kc.dw.core.exception.b.c;
                        z.a(str2, num2, "图片资源加载错误");
                        s1.a(((i) this.c.f39477a).getErrorUrl(), 12, num2.intValue(), "图片资源加载错误");
                    }
                    com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c, new LoadResState().setFail(4));
                    gVar = this.c;
                    adError = new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误");
                } else {
                    if (((i) this.c.f39477a).getErrorUrl() != null) {
                        String str3 = ((i) this.c.f39477a).getErrorUrl()[0];
                        Integer num3 = com.kc.dw.core.exception.b.c;
                        z.a(str3, num3, "图片资源加载错误");
                        s1.a(((i) this.c.f39477a).getErrorUrl(), 12, num3.intValue(), "图片资源加载错误");
                    }
                    com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c, new LoadResState().setFail(3));
                    gVar = this.c;
                    adError = new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误");
                }
                gVar.a(adError);
            } catch (Throwable th) {
                if (((i) this.c.f39477a).getErrorUrl() != null) {
                    String str4 = ((i) this.c.f39477a).getErrorUrl()[0];
                    Integer num4 = com.kc.dw.core.exception.b.c;
                    z.a(str4, num4, "图片资源加载错误");
                    s1.a(((i) this.c.f39477a).getErrorUrl(), 12, num4.intValue(), "图片资源加载错误");
                }
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.c, new LoadResState().setFail(9));
                this.c.a(new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误"));
                th.printStackTrace();
            }
        }
    }

    @Keep
    public class d extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f39468a;

        public d(g gVar) {
            this.f39468a = gVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            g gVar = this.f39468a;
            if (gVar.f) {
                AdSlot adSlot = gVar.h.f39457a;
                if (adSlot instanceof BaseAdSlot) {
                    ((BaseAdSlot) adSlot).setClkActType(2);
                }
                T t = this.f39468a.f39477a;
                if (t != 0 && ((i) t).getCbc() == 0 && this.f39468a.h.getInteractionListener() != null) {
                    this.f39468a.h.getInteractionListener().onAdClicked();
                }
                com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.f39468a.h, true);
            }
        }
    }

    @Keep
    public class e extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f39469a;

        public e(g gVar) {
            this.f39469a = gVar;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            g gVar = this.f39469a;
            if (gVar.f) {
                AdSlot adSlot = gVar.h.f39457a;
                if (adSlot instanceof BaseAdSlot) {
                    ((BaseAdSlot) adSlot).setClkActType(1);
                }
                T t = this.f39469a.f39477a;
                if (t != 0 && ((i) t).getCbc() == 0 && this.f39469a.h.getInteractionListener() != null) {
                    this.f39469a.h.getInteractionListener().onAdClicked();
                }
                com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) this.f39469a.h, true);
            }
        }
    }

    @Keep
    public class f implements NativeAdMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f39470a;

        public f(g gVar) {
            this.f39470a = gVar;
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onProgressUpdate(long j, long j2) {
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().onProgressUpdate(j, j2);
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoCompleted() {
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().playCompletion();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoError() {
            this.f39470a.a(new AdError(-1, "视频加载失败"));
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().onVideoError(-1, "视频加载失败");
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoLoaded() {
            g gVar = this.f39470a;
            if (gVar.g) {
                return;
            }
            gVar.g = true;
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().onVideoLoad();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoPause() {
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().playPause();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoResume() {
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().playResume();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoStart() {
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39470a.h;
            if (aVar == null || aVar.getDrawVideoListener() == null) {
                return;
            }
            this.f39470a.h.getDrawVideoListener().playRenderingStart();
        }
    }

    public g(DrawCommonAdLoader drawCommonAdLoader, i iVar) {
        super(drawCommonAdLoader, iVar);
        this.f = false;
        this.g = false;
        this.m = new f(this);
    }

    public final void a(AdError adError) {
        SsdDrawOwnListener ssdDrawOwnListener;
        com.kc.dw.platform.ad_adapter.draw.a aVar;
        int i;
        this.l.a(-1, 6);
        if (this.l.f39476a >= 5) {
            ssdDrawOwnListener = this.i;
            aVar = this.h;
            i = 1;
        } else {
            ssdDrawOwnListener = this.i;
            aVar = this.h;
            i = 0;
        }
        ssdDrawOwnListener.onAdFail(aVar, adError, i);
    }

    @Override // com.kc.dw.platform.ad_adapter.h
    public String b() {
        return this.j + Consts.DOT + 0L + Consts.DOT + this.k;
    }

    public final void c() {
        try {
            if (this.l.f39476a != 0) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.j = jCurrentTimeMillis;
            ((i) this.f39477a).C = jCurrentTimeMillis;
            this.l.a(-1, 1);
            int act_type = ((i) this.f39477a).getAct_type();
            if ((act_type & 1) != 1 && (act_type & 2) != 2) {
                ((i) this.f39477a).setAct_type(act_type | 1);
            }
            if (((i) this.f39477a).getAdPatternType() != 2) {
                d();
            } else {
                com.kc.dw.core.service.logrecord.a.a(5, "e4", this);
                z.a(((i) this.f39477a).getImageUrls()[0], new com.kc.dw.platform.ad_adapter.draw.f(this));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        SsdDrawRootView ssdDrawRootView = (SsdDrawRootView) LayoutInflater.from(this.context).inflate(R.layout.ssd_draw_ad_layout, (ViewGroup) null).findViewById(R.id.ms_draw_rootView);
        ssdDrawRootView.setAdListener(new a(this, ssdDrawRootView));
        com.kc.dw.core.bquery.d dVar = new com.kc.dw.core.bquery.d(ssdDrawRootView);
        com.kc.dw.platform.ad_adapter.draw.a aVar = this.h;
        aVar.f39457a = this.f39477a;
        aVar.b = null;
        GifImageView gifImageView = (GifImageView) ssdDrawRootView.findViewById(R.id.ms_draw_ad_image);
        TextView textView = (TextView) ssdDrawRootView.findViewById(R.id.draw_ad_detail_title);
        TextView textView2 = (TextView) ssdDrawRootView.findViewById(R.id.ms_draw_ad_detail_desc);
        ImageView imageView = (ImageView) ssdDrawRootView.findViewById(R.id.ms_draw_close_button);
        textView.setText(((i) this.f39477a).title);
        textView2.setText(((i) this.f39477a).c);
        imageView.setOnClickListener(new b(this));
        if (((i) this.f39477a).getAdPatternType() != 1 && ((i) this.f39477a).getAdPatternType() != 12) {
            StringBuilder sbA = com.kc.dw.activity.a.a("unsupported type: ");
            sbA.append(((i) this.f39477a).getAdPatternType());
            LogUtil.i("MeishuDrawAdWrapper", sbA.toString());
            if (((i) this.f39477a).getErrorUrl() != null) {
                String str = ((i) this.f39477a).getErrorUrl()[0];
                Integer num = com.kc.dw.core.exception.b.c;
                z.a(str, num, "图片资源加载错误");
                s1.a(((i) this.f39477a).getErrorUrl(), 12, num.intValue(), "图片资源加载错误");
            }
            a(new AdError(com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误"));
            return;
        }
        if (!com.kc.dw.base.a.adConfig().showLogo()) {
            dVar.b(R.id.ssd_img_ad_tag).d(8);
        } else if (!TextUtils.isEmpty(((i) this.f39477a).getFromLogo())) {
            dVar.b(R.id.ssd_img_ad_tag).a(((i) this.f39477a).getFromLogo(), false);
        }
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this);
        c0.a(((i) this.f39477a).getImageUrls()[0], new c(this, gifImageView, ssdDrawRootView));
        TextView textView3 = (TextView) ssdDrawRootView.findViewById(R.id.ms_draw_ad_detail_btn);
        boolean z = (((i) this.f39477a).getAct_type() & 1) == 1;
        if (!z && (((i) this.f39477a).getAct_type() & 2) == 2) {
            textView3.setOnClickListener(new d(this));
        }
        if (z) {
            ssdDrawRootView.setOnClickListener(new e(this));
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        try {
            T t = this.f39477a;
            if (t != 0 && ((i) t).getImageUrls() != null && ((i) this.f39477a).getImageUrls().length != 0) {
                com.kc.dw.platform.ad_adapter.draw.a aVar = new com.kc.dw.platform.ad_adapter.draw.a(this.f39477a, null);
                this.h = aVar;
                SsdDrawOwnListener ssdDrawOwnListener = this.i;
                if (ssdDrawOwnListener != null) {
                    ssdDrawOwnListener.onLoadSuccess(aVar);
                }
                if (!isAutoRender()) {
                    LogUtil.w("MeishuDrawAdWrapper", "please call render() when loadSuccess()");
                    return;
                } else {
                    com.kc.dw.core.service.logrecord.a.a(5, "e5", this, new TypeMsg().setData(1));
                    c();
                    return;
                }
            }
            LogUtil.i("MeishuDrawAdWrapper", "资源url为空");
            SsdDrawOwnListener ssdDrawOwnListener2 = this.i;
            if (ssdDrawOwnListener2 != null) {
                ssdDrawOwnListener2.onLoadFail(new AdError(com.kc.dw.core.exception.b.d.intValue(), "资源url为空"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
