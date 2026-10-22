package com.kc.dw.ad;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.gson.Gson;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.splash.SplashSkipView;
import com.kc.dw.ad.splash.SsdSplashRootView;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.splash.SplashAdListener;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.PackageBean;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.f1;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.g1;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.h1;
import com.kc.dw.core.utils.j1;
import com.kc.dw.core.utils.k1;
import com.kc.dw.core.utils.l1;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.DownloadView;
import com.kc.dw.core.view.SwipeView;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.core.view.gif.GifImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k {
    public static Handler E = new Handler();
    public com.kc.dw.ad.splash.c A;
    public SsdSplashRootView B;
    public NormalMediaView C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39105a;
    public int b;
    public String[] d;
    public int f;
    public boolean g;
    public boolean h;
    public volatile boolean i;
    public volatile boolean j;
    public volatile byte[] k;
    public CountDownLatch l;
    public volatile Boolean m;
    public volatile Boolean n;
    public long o;
    public int p;
    public long q;
    public long r;
    public long s;
    public final com.kc.dw.platform.ad_adapter.state.a t;
    public com.kc.dw.ad.splash.d u;
    public com.kc.dw.platform.ad_adapter.splash.e v;
    public com.kc.dw.platform.ad_adapter.splash.j w;
    public View x;
    public boolean y;
    public boolean z;
    public int c = 1;
    public List<Animator> e = new ArrayList();
    public final boolean[] D = {false};

    @Keep
    public class a implements com.kc.dw.core.utils.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39106a;
        public final k b;

        public a(k kVar, com.kc.dw.ad.splash.d dVar) {
            this.b = kVar;
            this.f39106a = dVar;
        }

        @Override // com.kc.dw.core.utils.i.b
        public void a(String str) {
            if (TextUtils.isEmpty(this.f39106a.getDefImage()) || (!TextUtils.isEmpty(str) && str.equals(this.f39106a.getDefImage()))) {
                this.b.n = Boolean.FALSE;
                k.a(this.b);
                com.kc.dw.core.utils.i.b(this);
            }
        }

        @Override // com.kc.dw.core.utils.i.b
        public void b(String str) {
            if (TextUtils.isEmpty(this.f39106a.getDefImage()) || (!TextUtils.isEmpty(str) && str.equals(this.f39106a.getDefImage()))) {
                this.b.n = Boolean.TRUE;
                k.a(this.b);
                com.kc.dw.core.utils.i.b(this);
            }
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39107a;
        public final com.kc.dw.ad.splash.a b;
        public final com.kc.dw.ad.splash.c c;
        public final SsdSplashRootView d;
        public final com.kc.dw.core.bquery.d e;
        public final boolean f;
        public final View g;
        public final int h;
        public final int i;
        public final k j;

        @Keep
        public class a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f39108a;

            public a(b bVar) {
                this.f39108a = bVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    if (!this.f39108a.j.i) {
                        this.f39108a.j.r = System.currentTimeMillis();
                        if (this.f39108a.j.k != null && this.f39108a.j.k.length > 0) {
                            this.f39108a.f39107a.getImageUrls()[0] = this.f39108a.f39107a.getVideo_cover();
                            g0.b(this.f39108a.f39107a.getMonitorUrl());
                            b bVar = this.f39108a;
                            k kVar = bVar.j;
                            kVar.a(bVar.b, bVar.f39107a, bVar.c, bVar.d, bVar.g, bVar.h, bVar.i, kVar.k);
                        } else if (TextUtils.isEmpty(this.f39108a.f39107a.getDefImage())) {
                            com.kc.dw.core.service.logrecord.a.a(5, "f4", this.f39108a.j.w, new LoadResState().setFail(4));
                            b bVar2 = this.f39108a;
                            k kVar2 = bVar2.j;
                            com.kc.dw.ad.splash.a aVar = bVar2.b;
                            Integer num = com.kc.dw.core.exception.b.c;
                            kVar2.a(aVar, "video load error1", num);
                            s1.a(this.f39108a.f39107a.getEventUrl(), 13, num.intValue(), "video timeout，image error cid:" + this.f39108a.f39107a.getCid());
                        } else {
                            s1.a(this.f39108a.f39107a.getEventUrl(), 13, 200, "底图加载成功");
                            this.f39108a.f39107a.getImageUrls()[0] = this.f39108a.f39107a.getDefImage();
                            g0.b(this.f39108a.f39107a.getMonitorUrl());
                            b bVar3 = this.f39108a;
                            bVar3.j.a(bVar3.b, bVar3.f39107a, bVar3.c, bVar3.d, bVar3.g, bVar3.h, bVar3.i, (byte[]) null);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public b(k kVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.core.bquery.d dVar2, boolean z, View view, int i, int i2) {
            this.j = kVar;
            this.f39107a = dVar;
            this.b = aVar;
            this.c = cVar;
            this.d = ssdSplashRootView;
            this.e = dVar2;
            this.f = z;
            this.g = view;
            this.h = i;
            this.i = i2;
        }

        @Override // com.kc.dw.core.safe.l
        public void a() {
            this.j.j = true;
            cancel();
            SdkHandler.getInstance().runOnUiThread(new a(this));
        }
    }

    @Keep
    public class c implements com.kc.dw.ad.nativ.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39109a;
        public final com.kc.dw.ad.splash.c b;
        public final SsdSplashRootView c;
        public final com.kc.dw.ad.splash.a d;
        public final View e;
        public final int f;
        public final int g;
        public final boolean h;
        public final AtomicBoolean i;
        public final ImageView j;
        public final Boolean[] k;
        public final CountDownLatch l;
        public final com.kc.dw.core.bquery.d m;
        public final boolean n;
        public final k o;

        @Keep
        public class a implements com.kc.dw.ad.nativ.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f39110a;

            public a(c cVar) {
                this.f39110a = cVar;
            }

            @Override // com.kc.dw.ad.z
            public /* bridge */ /* synthetic */ void a(List<com.kc.dw.ad.nativ.d> list) {
            }

            @Override // com.kc.dw.ad.z
            public void onADExposure() {
            }

            @Override // com.kc.dw.ad.z
            public void onAdRenderFail(String str, int i) {
                c cVar = this.f39110a;
                cVar.o.a(cVar.d, str, Integer.valueOf(i));
            }
        }

        @Keep
        public class b implements NativeAdMediaListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f39111a;

            @Keep
            public class a extends com.kc.dw.core.safe.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final b f39112a;

                public a(b bVar) {
                    this.f39112a = bVar;
                }

                @Override // com.kc.dw.core.safe.j
                public void safeRun() {
                    this.f39112a.f39111a.o.C.c();
                    View adView = this.f39112a.f39111a.b.getAdView();
                    if (adView != null) {
                        ViewParent parent = adView.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(adView);
                        }
                    }
                }
            }

            public b(c cVar) {
                this.f39111a = cVar;
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoCompleted() {
                c cVar = this.f39111a;
                com.kc.dw.ad.splash.c cVar2 = cVar.b;
                cVar2.g = true;
                if (cVar.f39109a.I == 1 && cVar2.h) {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(this), ExoPlayerImplInternal.f);
                }
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoError() {
            }

            @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
            public void onVideoLoaded() {
                this.f39111a.i.get();
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

        public c(k kVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.ad.splash.a aVar, View view, int i, int i2, boolean z, AtomicBoolean atomicBoolean, ImageView imageView, Boolean[] boolArr, CountDownLatch countDownLatch, com.kc.dw.core.bquery.d dVar2, boolean z2) {
            this.o = kVar;
            this.f39109a = dVar;
            this.b = cVar;
            this.c = ssdSplashRootView;
            this.d = aVar;
            this.e = view;
            this.f = i;
            this.g = i2;
            this.h = z;
            this.i = atomicBoolean;
            this.j = imageView;
            this.k = boolArr;
            this.l = countDownLatch;
            this.m = dVar2;
            this.n = z2;
        }

        @Override // com.kc.dw.ad.nativ.b
        public void a() {
            if (this.o.m == null || (!this.o.m.booleanValue() && this.o.n == null)) {
                LogUtil.dev("AdNative", this.o.m == null ? "wait video cover2" : "wait defImage2");
                this.o.a(2000L);
            }
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onPrepareError(int i, String str) {
            String[] eventUrl = this.f39109a.getEventUrl();
            StringBuilder sbA = com.kc.dw.activity.a.a(" video cid:");
            sbA.append(this.f39109a.getCid());
            s1.a(eventUrl, 13, i, sbA.toString());
            if (this.o.j) {
                return;
            }
            this.o.i = true;
            this.o.r = System.currentTimeMillis();
            try {
                if (this.o.k != null && this.o.k.length > 0) {
                    this.f39109a.getImageUrls()[0] = this.f39109a.getVideo_cover();
                    g0.b(this.f39109a.getMonitorUrl());
                    k kVar = this.o;
                    kVar.a(this.d, this.f39109a, this.b, this.c, this.e, this.f, this.g, kVar.k);
                } else if (TextUtils.isEmpty(this.f39109a.getDefImage())) {
                    com.kc.dw.core.service.logrecord.a.a(5, "f4", this.o.w, new LoadResState().setFail(i));
                    this.o.a(this.d, "splash video and img load error", Integer.valueOf(i));
                } else {
                    this.f39109a.getImageUrls()[0] = this.f39109a.getDefImage();
                    g0.b(this.f39109a.getMonitorUrl());
                    this.o.a(this.d, this.f39109a, this.b, this.c, this.e, this.f, this.g, (byte[]) null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.o.w, new LoadResState().setFail(i));
                this.o.a(this.d, "download video error01", Integer.valueOf(i));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.ad.nativ.c
        public void onPreparedStartPlay(int i, int i2, boolean z) {
            try {
                s1.a(this.f39109a.getEventUrl(), 13, 200, "视频加载成功");
                if (this.o.j) {
                    return;
                }
                this.o.s = System.currentTimeMillis();
                this.o.i = true;
                com.kc.dw.core.service.logrecord.a.a(5, "s4", this.o.w, new LoadResState().setSuccess(2, com.kc.dw.core.service.logrecord.b.a(this.f39109a), z ? 1 : 0));
                if (z) {
                    this.o.b(2);
                }
                SplashSkipView splashSkipViewA = k.a(this.o, this.b, this.c, this.d, this.e);
                this.o.C.setConfigWidth(this.f39109a.f39132a);
                this.o.C.setConfigHeight(this.f39109a.b);
                this.o.C.setContainerWidth(this.f);
                this.o.C.setContainerHeight(this.g);
                this.o.C.setPlayOnce(true);
                this.o.C.f();
                if (!this.h) {
                    this.o.C.i();
                }
                this.o.C.setIsEyes(this.f39109a.I);
                this.o.C.setUseTransform(false);
                if (com.kc.dw.base.a.adConfig().showLogo()) {
                    this.o.C.setFromLogo(this.f39109a.getFromLogo());
                    this.o.C.setFromLogoVisibility(0);
                } else {
                    this.o.C.setFromLogoVisibility(8);
                    this.o.C.setFromLogo(null);
                }
                this.o.C.setAdListener(new a(this));
                RelativeLayout relativeLayout = (RelativeLayout) this.c.findViewById(R.id.ms_splash_video);
                relativeLayout.setVisibility(0);
                int scale_type = this.f39109a.getScale_type();
                if (scale_type == -1) {
                    scale_type = 2;
                }
                if (scale_type == 9) {
                    this.o.C.setDisplayMode(2);
                    relativeLayout.addView(this.o.C, -1, -1);
                } else {
                    this.o.C.setDisplayMode(1);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13, -1);
                    relativeLayout.addView(this.o.C, layoutParams);
                }
                com.kc.dw.ad.splash.c cVar = this.b;
                NormalMediaView normalMediaView = this.o.C;
                cVar.d = normalMediaView;
                long jMin = Math.min(normalMediaView.getDuration(), ((SplashCommonAdLoader) this.o.w.getAdLoader()).getAdSlot().getSplashShowTime());
                if (this.f39109a.I != 1) {
                    splashSkipViewA.setTotalTime((int) jMin);
                }
                this.o.C.setNativeAdMediaListener(new com.kc.dw.platform.ad_adapter.recycler.d(this.f39109a, new b(this)));
                try {
                    Gson gson = new Gson();
                    HashMap map = new HashMap();
                    map.put("stepNum", 3);
                    map.put("msg", "video succ");
                    map.put("creativeType", Integer.valueOf(this.f39109a.getAdPatternType()));
                    s1.a(this.b.b.getErrorUrl(), gson.toJson(map));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.j.setVisibility(0);
                if (!Boolean.TRUE.equals(this.k[0])) {
                    try {
                        this.l.await(400L, TimeUnit.MILLISECONDS);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                this.o.t.b(2);
                k.b(this.o);
            } catch (Exception e2) {
                e2.printStackTrace();
                onPrepareError(com.kc.dw.core.exception.b.c.intValue(), "splash video player init error." + e2);
            }
        }

        @Override // com.kc.dw.ad.nativ.c
        public void onStartDownload() {
            this.o.b(2);
        }
    }

    @Keep
    public class d implements com.kc.dw.ad.splash.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39113a;
        public final k b;

        public d(k kVar, com.kc.dw.ad.splash.d dVar) {
            this.b = kVar;
            this.f39113a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            k kVar = this.b;
            kVar.getClass();
            try {
                if (kVar.h && kVar.t.b == 5 && kVar.t.c == 0) {
                    kVar.t.c(7);
                    com.kc.dw.core.service.logrecord.a.a(5, "e7", kVar.w);
                    try {
                        new Timer().schedule(new v(kVar), 5000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    kVar.A.c();
                    kVar.v.onADExposure();
                    kVar.t.c(8);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0038 A[Catch: all -> 0x0060, TRY_ENTER, TryCatch #0 {all -> 0x0060, blocks: (B:3:0x0001, B:5:0x000f, B:6:0x0014, B:8:0x001c, B:10:0x0024, B:12:0x002a, B:17:0x003d, B:19:0x004e, B:20:0x0052, B:22:0x005a, B:16:0x0038), top: B:36:0x0001 }] */
        @Override // com.kc.dw.ad.splash.c.b
        public void a(ViewGroup viewGroup) {
            int ic;
            try {
                this.b.h = true;
                if (this.b.t.f39562a == 0) {
                    this.b.a(viewGroup);
                }
                if (this.b.t.f39562a != 2) {
                    try {
                        PackageBean.AdBean adBeanA = com.kc.dw.core.utils.b.a();
                        com.kc.dw.core.utils.b.b = adBeanA;
                        ic = (adBeanA == null || adBeanA.getSplash() == null) ? 0 : com.kc.dw.core.utils.b.b.getSplash().getIc();
                    } catch (Exception unused) {
                    }
                    if (ic == 1) {
                        this.b.b();
                    }
                } else {
                    this.b.b();
                }
                com.kc.dw.platform.ad_adapter.state.a aVar = this.b.t;
                com.kc.dw.platform.ad_adapter.state.a.InterfaceC1076a interfaceC1076a = new com.kc.dw.platform.ad_adapter.state.a.InterfaceC1076a(this) { // from class: com.kc.dw.ad.k$d$$ExternalSyntheticLambda0
                    public final k.d f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.kc.dw.platform.ad_adapter.state.a.InterfaceC1076a
                    public final void onRenderSuccess() {
                        this.f$0.a();
                    }
                };
                aVar.getClass();
                if (aVar.b == 5) {
                    interfaceC1076a.onRenderSuccess();
                } else if (!aVar.d.contains(interfaceC1076a)) {
                    aVar.d.add(interfaceC1076a);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            k kVar = this.b;
            com.kc.dw.ad.splash.d dVar = this.f39113a;
            kVar.getClass();
            try {
                if (kVar.A.b.getAdPatternType() == 2) {
                    return;
                }
                new Timer().schedule(new t(kVar, dVar), 5000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class e extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39114a;
        public final com.kc.dw.core.bquery.d b;
        public final Boolean[] c;
        public final CountDownLatch d;
        public final ImageView e;
        public final k f;

        public e(k kVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.core.bquery.d dVar2, Boolean[] boolArr, CountDownLatch countDownLatch, ImageView imageView) {
            this.f = kVar;
            this.f39114a = dVar;
            this.b = dVar2;
            this.c = boolArr;
            this.d = countDownLatch;
            this.e = imageView;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            Bitmap videoThumb = this.f.C.getVideoThumb();
            if (videoThumb == null && !TextUtils.isEmpty(this.f39114a.getVideo_cover())) {
                this.b.b(R.id.ms_splash_image_bg).a(this.f39114a.getVideo_cover(), true);
                LogUtil.d("AdNative", "splash image bg. use video cover");
                this.c[0] = Boolean.TRUE;
                this.d.countDown();
                return;
            }
            k kVar = this.f;
            ImageView imageView = this.e;
            CountDownLatch countDownLatch = this.d;
            Boolean[] boolArr = this.c;
            kVar.getClass();
            if (videoThumb != null) {
                try {
                    Bitmap.Config config = videoThumb.getConfig();
                    Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                    if (config != config2) {
                        videoThumb = videoThumb.copy(config2, true);
                    }
                    if (videoThumb != null) {
                        kVar.f39105a.getApplicationContext();
                        Bitmap bitmapA = d0.a(videoThumb, 25);
                        if (bitmapA != null) {
                            SdkHandler.getInstance().runOnUiThread(new u(kVar, imageView, bitmapA));
                        }
                    }
                    boolArr[0] = Boolean.TRUE;
                } catch (Throwable th) {
                    try {
                        th.printStackTrace();
                        boolArr[0] = Boolean.TRUE;
                    } finally {
                        boolArr[0] = Boolean.TRUE;
                        countDownLatch.countDown();
                    }
                }
            } else {
                boolArr[0] = Boolean.TRUE;
            }
        }
    }

    @Keep
    public class f implements com.kc.dw.cache.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39115a;
        public final k b;

        public f(k kVar, com.kc.dw.ad.splash.d dVar) {
            this.b = kVar;
            this.f39115a = dVar;
        }

        @Override // com.kc.dw.cache.d
        public void a() {
        }

        @Override // com.kc.dw.cache.d
        public void a(Bitmap bitmap, byte[] bArr, boolean z) {
            if (bArr == null || bArr.length <= 0) {
                this.b.m = Boolean.FALSE;
                k.a(this.b);
                String[] eventUrl = this.f39115a.getEventUrl();
                int iIntValue = com.kc.dw.core.exception.b.c.intValue();
                StringBuilder sbA = com.kc.dw.activity.a.a("video cover load error1 cid:");
                sbA.append(this.f39115a.getCid());
                s1.a(eventUrl, 13, iIntValue, sbA.toString());
                return;
            }
            this.b.k = bArr;
            this.b.m = Boolean.TRUE;
            k.a(this.b);
            LogUtil.d("AdNative", "download cover success");
            String[] eventUrl2 = this.f39115a.getEventUrl();
            StringBuilder sbA2 = com.kc.dw.activity.a.a("video cover load success cid:");
            sbA2.append(this.f39115a.getCid());
            s1.a(eventUrl2, 13, 200, sbA2.toString());
        }

        @Override // com.kc.dw.cache.d
        public void b(int i) {
            LogUtil.d("AdNative", "download cover fail");
            this.b.m = Boolean.FALSE;
            k.a(this.b);
            String[] eventUrl = this.f39115a.getEventUrl();
            int iIntValue = com.kc.dw.core.exception.b.c.intValue();
            StringBuilder sbA = com.kc.dw.activity.a.a("video cover load error2 cid:");
            sbA.append(this.f39115a.getCid());
            s1.a(eventUrl, 13, iIntValue, sbA.toString());
        }
    }

    @Keep
    public class g extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.core.bquery.d f39116a;
        public final k b;

        public g(k kVar, com.kc.dw.core.bquery.d dVar) {
            this.b = kVar;
            this.f39116a = dVar;
        }

        /* JADX WARN: Code duplicated, block: B:102:0x03d6  */
        /* JADX WARN: Code duplicated, block: B:105:0x03e5  */
        /* JADX WARN: Code duplicated, block: B:108:0x03f8  */
        /* JADX WARN: Code duplicated, block: B:110:0x0402  */
        /* JADX WARN: Code duplicated, block: B:111:0x0415  */
        /* JADX WARN: Code duplicated, block: B:29:0x0151  */
        /* JADX WARN: Code duplicated, block: B:31:0x0157  */
        /* JADX WARN: Code duplicated, block: B:32:0x015b  */
        /* JADX WARN: Code duplicated, block: B:36:0x01be  */
        /* JADX WARN: Code duplicated, block: B:71:0x0291  */
        /* JADX WARN: Code duplicated, block: B:83:0x02ec  */
        /* JADX WARN: Code duplicated, block: B:85:0x0317  */
        /* JADX WARN: Code duplicated, block: B:90:0x0362  */
        /* JADX WARN: Code duplicated, block: B:93:0x0374  */
        /* JADX WARN: Code duplicated, block: B:95:0x03a1  */
        /* JADX WARN: Code duplicated, block: B:96:0x03aa  */
        /* JADX WARN: Code duplicated, block: B:99:0x03c6  */
        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            String str;
            TextView textView;
            ImageView imageView;
            com.kc.dw.ad.splash.d dVar;
            ImageView imageView2;
            com.kc.dw.core.bquery.d dVar2;
            com.kc.dw.platform.ad_adapter.splash.e eVar;
            RelativeLayout relativeLayout;
            ImageView imageView3;
            com.kc.dw.ad.splash.d dVar3;
            SplashSkipView splashSkipView;
            com.kc.dw.platform.ad_adapter.splash.e eVar2;
            com.kc.dw.ad.splash.c cVar;
            RelativeLayout relativeLayout2;
            TextView textView2;
            String str2;
            String str3;
            AdType adType = AdType.SPLASH;
            adType.value();
            com.kc.dw.core.utils.h.a();
            this.b.A.b.setAct_type(com.kc.dw.core.utils.h.a(this.b.A.b.getAct_type(), adType.value()));
            k kVar = this.b;
            com.kc.dw.core.bquery.d dVar4 = this.f39116a;
            SsdSplashRootView ssdSplashRootView = kVar.B;
            com.kc.dw.ad.splash.d dVar5 = kVar.u;
            com.kc.dw.ad.splash.c cVar2 = kVar.A;
            com.kc.dw.platform.ad_adapter.splash.e eVar3 = kVar.v;
            dVar5.getAct_type();
            SplashSkipView splashSkipView2 = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
            RelativeLayout relativeLayout3 = (RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_shake_img_container);
            ImageView imageView4 = (ImageView) ssdSplashRootView.findViewById(R.id.ms_shake_img);
            TextView textView3 = (TextView) ssdSplashRootView.findViewById(R.id.ms_shake_text);
            TextView textView4 = (TextView) ssdSplashRootView.findViewById(R.id.ms_shake_text_bottom);
            LinearLayout linearLayout = (LinearLayout) ssdSplashRootView.findViewById(R.id.ms_shakeRoot);
            int i = R.id.ssd_jump_btn;
            TextView textView5 = (TextView) ssdSplashRootView.findViewById(i);
            SwipeView swipeView = (SwipeView) ssdSplashRootView.findViewById(R.id.ms_SwipeViewParent);
            RelativeLayout relativeLayout4 = (RelativeLayout) ssdSplashRootView.findViewById(R.id.ms_up_move_container);
            ImageView imageView5 = (ImageView) ssdSplashRootView.findViewById(R.id.ms_up_move_iv);
            ImageView imageView6 = (ImageView) ssdSplashRootView.findViewById(R.id.ms_any_move_iv);
            int i2 = R.id.ssd_img_ad_tag;
            ssdSplashRootView.post(new j(kVar, relativeLayout3, imageView6, imageView4, relativeLayout4, imageView5, textView3, textView4, textView5, splashSkipView2, (ImageView) ssdSplashRootView.findViewById(i2)));
            String strA = ((dVar5.getAct_type() & 4) == 4 || (dVar5.getAct_type() & 64) == 64) ? w.a("", "摇动手机") : "";
            if (com.kc.dw.core.utils.h.e(dVar5.getAct_type())) {
                strA = w.a(strA, TextUtils.isEmpty(strA) ? "转动手机" : "或转动手机");
            }
            if ((dVar5.getAct_type() & 128) != 128) {
                if ((dVar5.getAct_type() & 32) == 32) {
                    str = TextUtils.isEmpty(strA) ? "上滑屏幕" : "或上滑屏幕";
                }
                if ((dVar5.getAct_type() & 2) == 2) {
                    if (TextUtils.isEmpty(strA)) {
                        str3 = "点击图标";
                    } else {
                        str3 = "或点击图标";
                    }
                    strA = w.a(strA, str3);
                }
                textView3.setText(strA);
                textView4.setText("跳转详情页或第三方应用");
                int splashDesignHeight = DimensionUtils.getSplashDesignHeight(kVar.f39105a);
                DisplayMetrics displayMetrics = kVar.f39105a.getResources().getDisplayMetrics();
                double d = splashDesignHeight;
                textView3.setTextSize(((float) (0.02d * d)) / displayMetrics.scaledDensity);
                textView4.setTextSize(((float) (0.018d * d)) / displayMetrics.scaledDensity);
                textView5.setTextSize(((float) (d * 0.019d)) / displayMetrics.scaledDensity);
                dVar4.b(i).d(8);
                if (swipeView.getVisibility() != 8) {
                    swipeView.setVisibility(8);
                }
                imageView4.addOnAttachStateChangeListener(new com.kc.dw.ad.b(kVar));
                if (!com.kc.dw.core.utils.h.d(dVar5.getAct_type()) || com.kc.dw.core.utils.h.e(dVar5.getAct_type())) {
                    textView3.setVisibility(0);
                    textView4.setVisibility(0);
                    linearLayout.post(new com.kc.dw.ad.c(kVar, ssdSplashRootView, linearLayout, dVar4));
                    textView = textView4;
                    if ((dVar5.getAct_type() & 32) == 32 || (dVar5.getAct_type() & 128) == 128) {
                        imageView = imageView6;
                        dVar = dVar5;
                        imageView2 = imageView4;
                        dVar2 = dVar4;
                        eVar = eVar3;
                    } else {
                        imageView = imageView6;
                        dVar2 = dVar4;
                        imageView2 = imageView4;
                        k.E.postDelayed(new n(kVar, imageView5, relativeLayout4, relativeLayout3, imageView4), 100L);
                        swipeView.setVisibility(0);
                        dVar = dVar5;
                        swipeView.setMoveDistance(dVar5.getAct_type(), dVar.G);
                        eVar = eVar3;
                        swipeView.setOnSwipeListener(new com.kc.dw.ad.d(kVar, eVar, cVar2, splashSkipView2));
                        if ((dVar.getAct_type() & 2) == 2) {
                            relativeLayout4.setOnClickListener(new com.kc.dw.ad.e(kVar, eVar, cVar2, splashSkipView2));
                        }
                    }
                    if ((dVar.getAct_type() & 128) == 128) {
                        relativeLayout = relativeLayout3;
                        imageView3 = imageView;
                        k.E.postDelayed(new m(kVar, imageView3, imageView2, relativeLayout), 100L);
                        swipeView.setVisibility(0);
                        swipeView.setMoveDistance(dVar.getAct_type(), dVar.G);
                        swipeView.setOnSwipeListener(new com.kc.dw.ad.f(kVar, eVar, cVar2, splashSkipView2));
                        if ((dVar.getAct_type() & 2) == 2) {
                            imageView3.setOnClickListener(new com.kc.dw.ad.g(kVar, eVar, cVar2, splashSkipView2));
                        }
                    } else {
                        ImageView imageView7 = imageView2;
                        relativeLayout = relativeLayout3;
                        relativeLayout.setVisibility(0);
                        imageView7.setVisibility(0);
                        imageView7.post(new o(kVar, imageView7, -1));
                    }
                    if ((dVar.getAct_type() & 2) == 2) {
                        relativeLayout.setOnClickListener(new com.kc.dw.ad.h(kVar, eVar, cVar2, splashSkipView2));
                    }
                } else {
                    if ((dVar5.getAct_type() & 32) == 32 || (dVar5.getAct_type() & 128) == 128) {
                        dVar3 = dVar5;
                        textView3.setVisibility(0);
                        textView4.setVisibility(0);
                        if ((dVar3.getAct_type() & 32) != 32) {
                            splashSkipView = splashSkipView2;
                            eVar2 = eVar3;
                            cVar = cVar2;
                        } else {
                            if ((dVar3.getAct_type() & 128) != 128) {
                                relativeLayout2 = relativeLayout4;
                                relativeLayout2.setVisibility(0);
                                imageView5.setVisibility(0);
                                imageView5.post(new q(kVar, relativeLayout2, imageView5, -1));
                            } else {
                                relativeLayout2 = relativeLayout4;
                            }
                            if ((dVar3.getAct_type() & 2) == 2) {
                                splashSkipView = splashSkipView2;
                                eVar2 = eVar3;
                                cVar = cVar2;
                                relativeLayout2.setOnClickListener(new l(kVar, eVar2, cVar, splashSkipView));
                            } else {
                                splashSkipView = splashSkipView2;
                                eVar2 = eVar3;
                                cVar = cVar2;
                            }
                        }
                        if ((dVar3.getAct_type() & 128) == 128) {
                            imageView6.setVisibility(0);
                            imageView6.post(new p(kVar, imageView6, -1));
                            if ((dVar3.getAct_type() & 2) == 2) {
                                imageView6.setOnClickListener(new l(kVar, eVar2, cVar, splashSkipView));
                            }
                        }
                        dVar3.getAct_type();
                        if ((dVar3.getAct_type() & 32) == 32 || (dVar3.getAct_type() & 128) == 128) {
                            swipeView.setVisibility(0);
                            swipeView.setMoveDistance(dVar3.getAct_type(), dVar3.G);
                            swipeView.setOnSwipeListener(new com.kc.dw.ad.i(kVar, eVar2, dVar3, cVar, splashSkipView));
                        }
                    } else if ((dVar5.getAct_type() & 2) == 2) {
                        dVar4.b(i).d(0);
                        dVar3 = dVar5;
                        if (!TextUtils.isEmpty(dVar3.F)) {
                            dVar4.b(i).a((CharSequence) dVar3.F);
                        } else if (dVar3.getInteractionType() == 1) {
                            View view = dVar4.b(i).d;
                            if (view instanceof TextView) {
                                textView2 = (TextView) view;
                                str2 = "点击按钮下载或跳转第三方应用";
                                textView2.setText(str2);
                            }
                        } else {
                            View view2 = dVar4.b(i).d;
                            if (view2 instanceof TextView) {
                                textView2 = (TextView) view2;
                                str2 = "点击按钮查看详情或跳转第三方应用";
                                textView2.setText(str2);
                            }
                        }
                    } else {
                        textView = textView4;
                        dVar2 = dVar4;
                        dVar = dVar5;
                    }
                    textView = textView4;
                    dVar2 = dVar4;
                    dVar = dVar3;
                }
                if (!TextUtils.isEmpty(dVar.F)) {
                    textView3.setText(dVar.F);
                }
                if (!TextUtils.isEmpty(dVar.getAction_desc())) {
                    textView.setText(dVar.getAction_desc());
                }
                if (com.kc.dw.base.a.adConfig().showLogo()) {
                    dVar2.b(i2).d(8);
                } else if (!TextUtils.isEmpty(dVar.getFromLogo())) {
                    dVar2.b(i2).a(dVar.getFromLogo(), false);
                }
                k kVar2 = this.b;
                k.a(kVar2, kVar2.A, kVar2.B, kVar2.v, kVar2.x);
                DownloadView downloadView = new DownloadView();
                k kVar3 = this.b;
                downloadView.handleDownloadView(kVar3.B, kVar3.u);
            }
            str = TextUtils.isEmpty(strA) ? "滑动屏幕" : "或滑动屏幕";
            strA = w.a(strA, str);
            if ((dVar5.getAct_type() & 2) == 2) {
                if (TextUtils.isEmpty(strA)) {
                    str3 = "点击图标";
                } else {
                    str3 = "或点击图标";
                }
                strA = w.a(strA, str3);
            }
            textView3.setText(strA);
            textView4.setText("跳转详情页或第三方应用");
            int splashDesignHeight2 = DimensionUtils.getSplashDesignHeight(kVar.f39105a);
            DisplayMetrics displayMetrics2 = kVar.f39105a.getResources().getDisplayMetrics();
            double d2 = splashDesignHeight2;
            textView3.setTextSize(((float) (0.02d * d2)) / displayMetrics2.scaledDensity);
            textView4.setTextSize(((float) (0.018d * d2)) / displayMetrics2.scaledDensity);
            textView5.setTextSize(((float) (d2 * 0.019d)) / displayMetrics2.scaledDensity);
            dVar4.b(i).d(8);
            if (swipeView.getVisibility() != 8) {
                swipeView.setVisibility(8);
            }
            imageView4.addOnAttachStateChangeListener(new com.kc.dw.ad.b(kVar));
            if (com.kc.dw.core.utils.h.d(dVar5.getAct_type())) {
                textView3.setVisibility(0);
                textView4.setVisibility(0);
                linearLayout.post(new com.kc.dw.ad.c(kVar, ssdSplashRootView, linearLayout, dVar4));
                textView = textView4;
                if ((dVar5.getAct_type() & 32) == 32) {
                    imageView = imageView6;
                    dVar = dVar5;
                    imageView2 = imageView4;
                    dVar2 = dVar4;
                    eVar = eVar3;
                } else {
                    imageView = imageView6;
                    dVar = dVar5;
                    imageView2 = imageView4;
                    dVar2 = dVar4;
                    eVar = eVar3;
                }
                if ((dVar.getAct_type() & 128) == 128) {
                    relativeLayout = relativeLayout3;
                    imageView3 = imageView;
                    k.E.postDelayed(new m(kVar, imageView3, imageView2, relativeLayout), 100L);
                    swipeView.setVisibility(0);
                    swipeView.setMoveDistance(dVar.getAct_type(), dVar.G);
                    swipeView.setOnSwipeListener(new com.kc.dw.ad.f(kVar, eVar, cVar2, splashSkipView2));
                    if ((dVar.getAct_type() & 2) == 2) {
                        imageView3.setOnClickListener(new com.kc.dw.ad.g(kVar, eVar, cVar2, splashSkipView2));
                    }
                } else {
                    ImageView imageView8 = imageView2;
                    relativeLayout = relativeLayout3;
                    relativeLayout.setVisibility(0);
                    imageView8.setVisibility(0);
                    imageView8.post(new o(kVar, imageView8, -1));
                }
                if ((dVar.getAct_type() & 2) == 2) {
                    relativeLayout.setOnClickListener(new com.kc.dw.ad.h(kVar, eVar, cVar2, splashSkipView2));
                }
            } else {
                textView3.setVisibility(0);
                textView4.setVisibility(0);
                linearLayout.post(new com.kc.dw.ad.c(kVar, ssdSplashRootView, linearLayout, dVar4));
                textView = textView4;
                if ((dVar5.getAct_type() & 32) == 32) {
                    imageView = imageView6;
                    dVar = dVar5;
                    imageView2 = imageView4;
                    dVar2 = dVar4;
                    eVar = eVar3;
                } else {
                    imageView = imageView6;
                    dVar = dVar5;
                    imageView2 = imageView4;
                    dVar2 = dVar4;
                    eVar = eVar3;
                }
                if ((dVar.getAct_type() & 128) == 128) {
                    relativeLayout = relativeLayout3;
                    imageView3 = imageView;
                    k.E.postDelayed(new m(kVar, imageView3, imageView2, relativeLayout), 100L);
                    swipeView.setVisibility(0);
                    swipeView.setMoveDistance(dVar.getAct_type(), dVar.G);
                    swipeView.setOnSwipeListener(new com.kc.dw.ad.f(kVar, eVar, cVar2, splashSkipView2));
                    if ((dVar.getAct_type() & 2) == 2) {
                        imageView3.setOnClickListener(new com.kc.dw.ad.g(kVar, eVar, cVar2, splashSkipView2));
                    }
                } else {
                    ImageView imageView9 = imageView2;
                    relativeLayout = relativeLayout3;
                    relativeLayout.setVisibility(0);
                    imageView9.setVisibility(0);
                    imageView9.post(new o(kVar, imageView9, -1));
                }
                if ((dVar.getAct_type() & 2) == 2) {
                    relativeLayout.setOnClickListener(new com.kc.dw.ad.h(kVar, eVar, cVar2, splashSkipView2));
                }
            }
            if (!TextUtils.isEmpty(dVar.F)) {
                textView3.setText(dVar.F);
            }
            if (!TextUtils.isEmpty(dVar.getAction_desc())) {
                textView.setText(dVar.getAction_desc());
            }
            if (com.kc.dw.base.a.adConfig().showLogo()) {
                dVar2.b(i2).d(8);
            } else if (!TextUtils.isEmpty(dVar.getFromLogo())) {
                dVar2.b(i2).a(dVar.getFromLogo(), false);
            }
            k kVar4 = this.b;
            k.a(kVar4, kVar4.A, kVar4.B, kVar4.v, kVar4.x);
            DownloadView downloadView2 = new DownloadView();
            k kVar5 = this.b;
            downloadView2.handleDownloadView(kVar5.B, kVar5.u);
        }
    }

    @Keep
    public class h extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f39117a;

        public h(k kVar) {
            this.f39117a = kVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            k kVar = this.f39117a;
            SsdSplashRootView ssdSplashRootView = kVar.B;
            com.kc.dw.ad.splash.d dVar = kVar.u;
            try {
                com.kc.dw.core.bquery.d dVar2 = new com.kc.dw.core.bquery.d(ssdSplashRootView);
                LinearLayout linearLayout = (LinearLayout) ssdSplashRootView.findViewById(R.id.ssd_layout_native_splash_logo_ll);
                ImageView imageView = (ImageView) ssdSplashRootView.findViewById(R.id.ssd_layout_native_splash_logo);
                TextView textView = (TextView) ssdSplashRootView.findViewById(R.id.ssd_layout_native_splash_cid);
                linearLayout.setBackground(kVar.f39105a.getResources().getDrawable(R.drawable.ssd_black_oval_gray));
                if (!TextUtils.isEmpty(dVar.getCid())) {
                    textView.setText(dVar.getCid());
                }
                if (!TextUtils.isEmpty(dVar.getFromLogo())) {
                    dVar2.d = imageView;
                    dVar2.a(dVar.getFromLogo(), false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            k kVar2 = this.f39117a;
            k.a(kVar2, kVar2.A, kVar2.B, kVar2.v, kVar2.x);
        }
    }

    @Keep
    public class i implements com.kc.dw.cache.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.ad.splash.d f39118a;
        public final byte[] b;
        public final com.kc.dw.ad.splash.c c;
        public final SsdSplashRootView d;
        public final com.kc.dw.ad.splash.a e;
        public final View f;
        public final int g;
        public final long h;
        public final k i;

        public i(k kVar, com.kc.dw.ad.splash.d dVar, byte[] bArr, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.ad.splash.a aVar, View view, int i, long j) {
            this.i = kVar;
            this.f39118a = dVar;
            this.b = bArr;
            this.c = cVar;
            this.d = ssdSplashRootView;
            this.e = aVar;
            this.f = view;
            this.g = i;
            this.h = j;
        }

        @Override // com.kc.dw.cache.d
        public void a() {
            this.i.b(2);
        }

        @Override // com.kc.dw.cache.c
        public void a(int i) {
            if (k.a(this.i, this.f39118a, this.b) || this.i.n != null) {
                return;
            }
            LogUtil.dev("AdNative", "wait defImage1");
            this.i.a(((long) this.g) - (System.currentTimeMillis() - this.h));
        }

        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        @Override // com.kc.dw.cache.d
        public void a(Bitmap bitmap, byte[] bArr, boolean z) {
            int i;
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        if (bArr.length >= h0.a()) {
                            b(9);
                            return;
                        }
                        if (!k.a(this.i, this.f39118a, this.b)) {
                            s1.a(this.c.b.getEventUrl(), 13, 200, "图片资源加载成功");
                        }
                        if (z) {
                            this.i.b(2);
                        }
                        com.kc.dw.platform.ad_adapter.splash.j jVar = this.i.w;
                        LoadResState loadResState = new LoadResState();
                        com.kc.dw.ad.splash.d dVar = this.f39118a;
                        if (dVar != null) {
                            try {
                                if (dVar.getAdPatternType() == 2) {
                                    i = 2;
                                } else {
                                    i = 1;
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            i = 1;
                        }
                        com.kc.dw.core.service.logrecord.a.a(5, "s4", jVar, loadResState.setSuccess(i, com.kc.dw.core.service.logrecord.b.a(this.f39118a), z ? 1 : 0));
                        if (d0.b(bArr)) {
                            k.a(this.i, this.c, this.d, this.e, this.f);
                            k.a(this.i, bArr, this.d, true, (BaseAdSlot) this.f39118a, this.c, this.e, (NormalMediaView) null);
                        } else {
                            k.a(this.i, this.c, this.d, this.e, this.f);
                            k.a(this.i, bArr, this.d, false, (BaseAdSlot) this.f39118a, this.c, this.e, (NormalMediaView) null);
                        }
                        this.i.t.b(2);
                        k.b(this.i);
                        return;
                    }
                } catch (Throwable th) {
                    b(9);
                    th.printStackTrace();
                    return;
                }
            }
            b(4);
        }

        @Override // com.kc.dw.cache.d
        public void b(int i) {
            com.kc.dw.platform.ad_adapter.splash.j jVar;
            LoadResState fail;
            try {
                if (!k.a(this.i, this.f39118a, this.b)) {
                    s1.a(this.c.b.getEventUrl(), 13, com.kc.dw.core.exception.b.c.intValue(), "图片资源加载错误12 cid:" + this.f39118a.getCid());
                }
                if (this.i.a((BaseAdSlot) this.f39118a)) {
                    this.i.a(this.e, "图片资源加载错误13", com.kc.dw.core.exception.b.c);
                    jVar = this.i.w;
                    fail = new LoadResState().setFail(i);
                } else {
                    byte[] bArrC = com.kc.dw.core.utils.i.c(this.f39118a.getDefImage());
                    if (bArrC != null && bArrC.length > 0 && com.kc.dw.core.utils.i.a(bArrC, this.f39118a.getDefImage())) {
                        LogUtil.d("AdNative", "native image fail. use defImage");
                        this.f39118a.getImageUrls()[0] = this.f39118a.getDefImage();
                        a(null, bArrC, true);
                        return;
                    } else {
                        LogUtil.d("AdNative", "native image fail. invalid defImage");
                        this.i.a(this.e, "图片资源加载错误14", com.kc.dw.core.exception.b.c);
                        jVar = this.i.w;
                        fail = new LoadResState().setFail(i);
                    }
                }
                com.kc.dw.core.service.logrecord.a.a(5, "f4", jVar, fail);
            } catch (Exception e) {
                this.i.a(this.e, "图片资源加载错误15:" + e, com.kc.dw.core.exception.b.c);
                com.kc.dw.core.service.logrecord.a.a(5, "f4", this.i.w, new LoadResState().setFail(i));
            }
        }
    }

    public k(Context context, com.kc.dw.platform.ad_adapter.state.a aVar) {
        this.f39105a = context;
        this.t = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static SplashSkipView a(k kVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.ad.splash.a aVar, View view) {
        kVar.getClass();
        SplashSkipView splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
        try {
            splashSkipView.setSplashClickPause(((SplashCommonAdLoader) kVar.w.getAdLoader()).getAdSlot().isSplashClickPause());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ssdSplashRootView.post(new s(kVar, splashSkipView, cVar, aVar, view, ssdSplashRootView));
        cVar.c = splashSkipView;
        return splashSkipView;
    }

    public static void a(k kVar) {
        kVar.getClass();
        try {
            CountDownLatch countDownLatch = kVar.l;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(k kVar, int i2, Bitmap bitmap, GifImageView gifImageView, ImageView imageView, Bitmap bitmap2) {
        kVar.getClass();
        try {
            gifImageView.setScaleType(bitmap2 != null ? ImageView.ScaleType.CENTER : ImageView.ScaleType.MATRIX);
            if (i2 == 9) {
                gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            gifImageView.setImageBitmap(bitmap);
        } catch (Throwable th) {
            th.printStackTrace();
            gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (bitmap2 != null) {
            try {
                imageView.setVisibility(0);
                imageView.setImageBitmap(bitmap2);
                imageView.setImageAlpha(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(k kVar, SplashSkipView splashSkipView) {
        kVar.getClass();
        try {
            if (!((SplashCommonAdLoader) kVar.w.getAdLoader()).getAdSlot().getIsClickToClose() || splashSkipView == null) {
                return;
            }
            splashSkipView.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x009d  */
    /* JADX WARN: Code duplicated, block: B:15:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:18:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:19:0x010b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x010d  */
    /* JADX WARN: Code duplicated, block: B:21:0x012a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x012c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0133  */
    /* JADX WARN: Code duplicated, block: B:25:0x0136  */
    /* JADX WARN: Code duplicated, block: B:28:0x0140  */
    /* JADX WARN: Code duplicated, block: B:31:0x0165  */
    /* JADX WARN: Code duplicated, block: B:35:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:37:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:43:0x020e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0233  */
    /* JADX WARN: Code duplicated, block: B:47:0x023e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0250  */
    /* JADX WARN: Code duplicated, block: B:51:0x025b  */
    /* JADX WARN: Code duplicated, block: B:54:0x0269  */
    /* JADX WARN: Code duplicated, block: B:55:0x0274  */
    /* JADX WARN: Code duplicated, block: B:58:0x027d  */
    /* JADX WARN: Code duplicated, block: B:60:0x028f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0293  */
    /* JADX WARN: Code duplicated, block: B:63:0x029f  */
    /* JADX WARN: Code duplicated, block: B:64:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:66:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x02c8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static void a(k kVar, byte[] bArr, SsdSplashRootView ssdSplashRootView, boolean z, BaseAdSlot baseAdSlot, com.kc.dw.ad.splash.c cVar, com.kc.dw.ad.splash.a aVar, NormalMediaView normalMediaView) {
        int height;
        Bitmap bitmapDecodeByteArray;
        int videoWidth;
        int i2;
        boolean z2;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        GifImageView gifImageView;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        TextView textView2;
        TextView textView3;
        int i3;
        Bitmap bitmapDecodeByteArray2;
        com.kc.dw.core.bquery.d dVar;
        com.kc.dw.ad.splash.c cVar2;
        ?? r5;
        com.kc.dw.ad.nativ.i iVar;
        int i4;
        String str;
        DisplayMetrics displayMetrics = kVar.f39105a.getResources().getDisplayMetrics();
        ImageView imageView3 = (ImageView) ssdSplashRootView.findViewById(R.id.ssd_layout_native_splash_bg);
        SplashSkipView splashSkipView = (SplashSkipView) ssdSplashRootView.findViewById(R.id.ssd_skipView);
        RelativeLayout relativeLayout2 = (RelativeLayout) ssdSplashRootView.findViewById(R.id.ssd_native_splash_ad_container);
        View viewInflate = View.inflate(kVar.f39105a, R.layout.ssd_layout_native_splash_1, null);
        if (normalMediaView == null) {
            if (z) {
                GifImageView gifImageView2 = new GifImageView(kVar.f39105a);
                gifImageView2.setBytes(bArr);
                int gifWidth = gifImageView2.getGifWidth();
                height = gifImageView2.getGifHeight();
                videoWidth = gifWidth;
            } else {
                Bitmap bitmapDecodeByteArray3 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray3 != null) {
                    int width = bitmapDecodeByteArray3.getWidth();
                    height = bitmapDecodeByteArray3.getHeight();
                    bitmapDecodeByteArray = bitmapDecodeByteArray3;
                    videoWidth = width;
                } else {
                    height = 0;
                    bitmapDecodeByteArray = bitmapDecodeByteArray3;
                    videoWidth = 0;
                }
            }
            i2 = videoWidth;
            if ((videoWidth * 1.0f) / height < 0.67d) {
                viewInflate = View.inflate(kVar.f39105a, R.layout.ssd_layout_native_splash_2, null);
                z2 = true;
            } else {
                z2 = false;
            }
            relativeLayout2.addView(viewInflate, -1, -1);
            relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
            linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
            gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
            textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
            imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
            imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
            textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
            textView3 = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
            if (normalMediaView != null) {
                relativeLayout.removeAllViews();
                relativeLayout.addView(normalMediaView, -1, -1);
                ExecutorService executorService = f0.f39362a;
                f0.b.f39363a.a(new x(kVar, normalMediaView, imageView3));
            } else if (z) {
                gifImageView.setBytes(bArr);
                cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
                cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
                gifImageView.startAnimation();
            } else {
                if (bitmapDecodeByteArray == null) {
                    i3 = 0;
                    bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                } else {
                    i3 = 0;
                }
                if (bitmapDecodeByteArray != null) {
                    gifImageView.setImageBitmap(bitmapDecodeByteArray);
                }
                bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr, i3, bArr.length);
                if (bitmapDecodeByteArray2 != null) {
                    kVar.f39105a.getApplicationContext();
                    imageView3.setImageBitmap(d0.a(bitmapDecodeByteArray2, 25));
                }
            }
            dVar = new com.kc.dw.core.bquery.d(ssdSplashRootView);
            if (z2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d2 = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams.width = (int) d2;
                layoutParams.height = (int) ((d2 * ((double) height)) / ((double) i2));
                int i5 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams.topMargin = i5;
                layoutParams.bottomMargin = i5;
                linearLayout.setLayoutParams(layoutParams);
                if (com.kc.dw.core.utils.h.d(cVar.b.getAct_type()) || com.kc.dw.core.utils.h.e(cVar.b.getAct_type())) {
                    Drawable drawable = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                    drawable.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable, null, null, null);
                }
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView2.setVisibility(8);
                imageView.setVisibility(8);
                cVar2 = cVar;
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams2.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams2.height = -2;
                int i6 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams2.topMargin = i6;
                layoutParams2.bottomMargin = i6;
                linearLayout.setLayoutParams(layoutParams2);
                cVar2 = cVar;
                if (!com.kc.dw.core.utils.h.d(cVar2.b.getAct_type()) || com.kc.dw.core.utils.h.e(cVar2.b.getAct_type())) {
                    Drawable drawable2 = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                    r5 = 0;
                    drawable2.setBounds(0, 0, 100, 100);
                    textView3.setPadding(60, 0, 60, 0);
                    textView3.setCompoundDrawables(drawable2, null, null, null);
                } else {
                    r5 = 0;
                }
                iVar = (com.kc.dw.ad.nativ.i) baseAdSlot;
                if (TextUtils.isEmpty(iVar.desc)) {
                    i4 = 8;
                    textView2.setVisibility(8);
                    imageView2.setVisibility(r5);
                } else {
                    textView2.setVisibility(r5);
                    textView2.setText(iVar.title);
                    i4 = 8;
                }
                if (TextUtils.isEmpty(baseAdSlot.getAppName())) {
                    textView.setVisibility(i4);
                    imageView2.setVisibility(i4);
                } else {
                    textView.setVisibility(r5);
                    textView.setText(baseAdSlot.getAppName());
                }
                if (TextUtils.isEmpty(iVar.iconUrl)) {
                    imageView.setVisibility(i4);
                } else {
                    imageView.setVisibility(r5);
                    dVar.d = imageView;
                    dVar.a(iVar.iconUrl, r5);
                }
            }
            if (baseAdSlot.getInteractionType() == 0) {
                textView3.setText("点击跳转详情页或第三方应用");
                if (com.kc.dw.core.utils.h.d(cVar2.b.getAct_type())) {
                    str = "点击/摇一摇跳转详情页";
                } else if (com.kc.dw.core.utils.h.e(cVar2.b.getAct_type())) {
                    str = "点击/扭动手机跳转详情页";
                }
                textView3.setText(str);
            } else {
                textView3.setText("点击下载第三方应用");
                if (com.kc.dw.core.utils.h.d(cVar2.b.getAct_type())) {
                    str = "点击/摇一摇下载第三方应用";
                } else if (com.kc.dw.core.utils.h.e(cVar2.b.getAct_type())) {
                    str = "点击/扭动手机下载第三方应用";
                }
                textView3.setText(str);
            }
            textView3.setOnClickListener(new y(kVar, aVar, cVar2, splashSkipView));
        }
        videoWidth = normalMediaView.getOwnVideoView().getMediaPlayer().getVideoWidth();
        height = normalMediaView.getOwnVideoView().getMediaPlayer().getVideoHeight();
        bitmapDecodeByteArray = null;
        i2 = videoWidth;
        if ((videoWidth * 1.0f) / height < 0.67d) {
            viewInflate = View.inflate(kVar.f39105a, R.layout.ssd_layout_native_splash_2, null);
            z2 = true;
        } else {
            z2 = false;
        }
        relativeLayout2.addView(viewInflate, -1, -1);
        relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ssd_layout_native_splash_ll);
        gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        imageView = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        textView3 = (TextView) viewInflate.findViewById(R.id.ssd_jump_btn);
        if (normalMediaView != null) {
            relativeLayout.removeAllViews();
            relativeLayout.addView(normalMediaView, -1, -1);
            ExecutorService executorService2 = f0.f39362a;
            f0.b.f39363a.a(new x(kVar, normalMediaView, imageView3));
        } else if (z) {
            gifImageView.setBytes(bArr);
            cVar.setWidth(Integer.valueOf(gifImageView.getGifWidth()));
            cVar.setHeight(Integer.valueOf(gifImageView.getGifHeight()));
            gifImageView.startAnimation();
        } else {
            if (bitmapDecodeByteArray == null) {
                i3 = 0;
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            } else {
                i3 = 0;
            }
            if (bitmapDecodeByteArray != null) {
                gifImageView.setImageBitmap(bitmapDecodeByteArray);
            }
            bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(bArr, i3, bArr.length);
            if (bitmapDecodeByteArray2 != null) {
                kVar.f39105a.getApplicationContext();
                imageView3.setImageBitmap(d0.a(bitmapDecodeByteArray2, 25));
            }
        }
        dVar = new com.kc.dw.core.bquery.d(ssdSplashRootView);
        if (z2) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            double d3 = ((double) displayMetrics.widthPixels) * 0.86d;
            layoutParams3.width = (int) d3;
            layoutParams3.height = (int) ((d3 * ((double) height)) / ((double) i2));
            int i7 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams3.topMargin = i7;
            layoutParams3.bottomMargin = i7;
            linearLayout.setLayoutParams(layoutParams3);
            if (com.kc.dw.core.utils.h.d(cVar.b.getAct_type())) {
                Drawable drawable3 = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                drawable3.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable3, null, null, null);
            } else {
                Drawable drawable4 = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                drawable4.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable4, null, null, null);
            }
            textView.setVisibility(8);
            textView2.setVisibility(8);
            imageView2.setVisibility(8);
            imageView.setVisibility(8);
            cVar2 = cVar;
        } else {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams4.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
            layoutParams4.height = -2;
            int i8 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams4.topMargin = i8;
            layoutParams4.bottomMargin = i8;
            linearLayout.setLayoutParams(layoutParams4);
            cVar2 = cVar;
            if (com.kc.dw.core.utils.h.d(cVar2.b.getAct_type())) {
                Drawable drawable5 = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                r5 = 0;
                drawable5.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable5, null, null, null);
            } else {
                Drawable drawable6 = kVar.f39105a.getResources().getDrawable(R.drawable.ssd_shake_angle);
                r5 = 0;
                drawable6.setBounds(0, 0, 100, 100);
                textView3.setPadding(60, 0, 60, 0);
                textView3.setCompoundDrawables(drawable6, null, null, null);
            }
            iVar = (com.kc.dw.ad.nativ.i) baseAdSlot;
            if (TextUtils.isEmpty(iVar.desc)) {
                textView2.setVisibility(r5);
                textView2.setText(iVar.title);
                i4 = 8;
            } else {
                i4 = 8;
                textView2.setVisibility(8);
                imageView2.setVisibility(r5);
            }
            if (TextUtils.isEmpty(baseAdSlot.getAppName())) {
                textView.setVisibility(r5);
                textView.setText(baseAdSlot.getAppName());
            } else {
                textView.setVisibility(i4);
                imageView2.setVisibility(i4);
            }
            if (TextUtils.isEmpty(iVar.iconUrl)) {
                imageView.setVisibility(r5);
                dVar.d = imageView;
                dVar.a(iVar.iconUrl, r5);
            } else {
                imageView.setVisibility(i4);
            }
        }
        if (baseAdSlot.getInteractionType() == 0) {
            textView3.setText("点击跳转详情页或第三方应用");
            if (com.kc.dw.core.utils.h.d(cVar2.b.getAct_type())) {
                str = "点击/摇一摇跳转详情页";
            } else if (com.kc.dw.core.utils.h.e(cVar2.b.getAct_type())) {
                str = "点击/扭动手机跳转详情页";
            }
            textView3.setText(str);
        } else {
            textView3.setText("点击下载第三方应用");
            if (com.kc.dw.core.utils.h.d(cVar2.b.getAct_type())) {
                str = "点击/摇一摇下载第三方应用";
            } else if (com.kc.dw.core.utils.h.e(cVar2.b.getAct_type())) {
                str = "点击/扭动手机下载第三方应用";
            }
            textView3.setText(str);
        }
        textView3.setOnClickListener(new y(kVar, aVar, cVar2, splashSkipView));
    }

    public static boolean a(k kVar, BaseAdSlot baseAdSlot, byte[] bArr) {
        kVar.getClass();
        return bArr != null || kVar.a(baseAdSlot);
    }

    public static Bitmap[] a(int i2, Bitmap bitmap, int i3, int i4) {
        try {
            switch (i2) {
                case 1:
                    return (((float) bitmap.getHeight()) * 1.0f) / ((float) i4) > (((float) bitmap.getWidth()) * 1.0f) / ((float) i3) ? b(bitmap, i3, i4, i2) : a(bitmap, i3, i4, i2);
                case 2:
                default:
                    return (((float) bitmap.getWidth()) * 1.0f) / ((float) i3) > (((float) bitmap.getHeight()) * 1.0f) / ((float) i4) ? b(bitmap, i3, i4, i2) : a(bitmap, i3, i4, i2);
                case 3:
                case 4:
                case 5:
                    return b(bitmap, i3, i4, i2);
                case 6:
                case 7:
                case 8:
                    return a(bitmap, i3, i4, i2);
                case 9:
                    return new Bitmap[]{bitmap, null};
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return new Bitmap[]{bitmap, null};
        }
    }

    public static Bitmap[] a(Bitmap bitmap, int i2, int i3, int i4) {
        int i5;
        int i6;
        Bitmap[] bitmapArr = new Bitmap[2];
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = (i3 * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmapCreateBitmap.getHeight();
        int width2 = bitmapCreateBitmap.getWidth();
        if (width2 < i2) {
            try {
                com.kc.dw.base.a.getContext();
                bitmapArr[1] = d0.a(bitmapCreateBitmap, 25);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (i4 == 6 || i4 == 2 || i4 == 1) {
                i5 = (width2 - i2) / 2;
            } else {
                if (i4 != 7 && i4 == 8) {
                    i5 = width2 - i2;
                } else {
                    i6 = 0;
                }
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i6, 0, i2, i3, (Matrix) null, false);
            }
            i6 = i5;
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i6, 0, i2, i3, (Matrix) null, false);
        }
        bitmapArr[0] = bitmapCreateBitmap;
        return bitmapArr;
    }

    public static void b(k kVar) {
        if (kVar.z || kVar.g || kVar.h) {
            kVar.b();
        }
    }

    public static Bitmap[] b(Bitmap bitmap, int i2, int i3, int i4) {
        int i5;
        Bitmap[] bitmapArr = new Bitmap[2];
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = (i2 * 1.0f) / width;
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        int height2 = bitmapCreateBitmap.getHeight();
        bitmapCreateBitmap.getWidth();
        if (height2 < i3) {
            try {
                com.kc.dw.base.a.getContext();
                bitmapArr[1] = d0.a(bitmapCreateBitmap, 10);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            if (i4 == 3 || i4 == 2 || i4 == 1) {
                i5 = (height2 - i3) / 2;
            } else {
                i5 = (i4 != 4 && i4 == 5) ? height2 - i3 : 0;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, i5, i2, i3, (Matrix) null, false);
        }
        bitmapArr[0] = bitmapCreateBitmap;
        return bitmapArr;
    }

    public static void c(k kVar) {
        kVar.getClass();
        try {
            List<Animator> list = kVar.e;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < kVar.e.size(); i2++) {
                Animator animator = kVar.e.get(i2);
                if (animator != null) {
                    animator.cancel();
                }
            }
            kVar.e.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final int a(int i2) {
        try {
            if (this.p > 0 && this.o > 0) {
                return Math.max(Math.min(this.p - ((int) (System.currentTimeMillis() - this.o)), Math.max(i2, 0)), 0);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Math.max(i2, 0);
    }

    public String a() {
        return this.q + Consts.DOT + this.r + Consts.DOT + this.s;
    }

    public final void a(long j) {
        try {
            CountDownLatch countDownLatch = this.l;
            if (countDownLatch != null && countDownLatch.getCount() != 0) {
                this.l.countDown();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (j <= 0) {
            return;
        }
        try {
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            this.l = countDownLatch2;
            countDownLatch2.await(Math.min(j, 2000L), TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ViewGroup viewGroup) {
        try {
            if (this.t.f39562a != 0) {
                return;
            }
            this.t.b(1);
            Gson gson = new Gson();
            HashMap map = new HashMap();
            map.put("stepNum", 2);
            map.put("msg", "start create layout");
            map.put("creativeType", Integer.valueOf(this.u.getAdPatternType()));
            s1.a(this.A.b.getErrorUrl(), gson.toJson(map));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (viewGroup != null) {
            try {
                this.f39105a = viewGroup.getContext();
            } catch (Throwable th) {
                try {
                    s1.a(this.A.b.getErrorUrl(), 12, 9000001, th.getMessage());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                th.printStackTrace();
                return;
            }
        }
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f39105a);
        int ad_type = this.u.getAd_type() != 0 ? this.u.getAd_type() : AdType.SPLASH.value();
        if (ad_type != AdType.SPLASH.value()) {
            if (ad_type != AdType.FEED.value()) {
                a(this.v, "unsupported type", com.kc.dw.core.exception.b.e);
                return;
            }
            SsdSplashRootView ssdSplashRootView = (SsdSplashRootView) layoutInflaterFrom.inflate(R.layout.ssd_layout_native_splash, (ViewGroup) null);
            this.B = ssdSplashRootView;
            com.kc.dw.ad.splash.c cVar = this.A;
            cVar.e = ssdSplashRootView;
            cVar.adView = ssdSplashRootView;
            ssdSplashRootView.post(new h(this));
            a(this.v, this.u, this.A, this.B, this.x);
            return;
        }
        SsdSplashRootView ssdSplashRootView2 = (SsdSplashRootView) layoutInflaterFrom.inflate(R.layout.ssd_splash_ad_layout, (ViewGroup) null);
        this.B = ssdSplashRootView2;
        com.kc.dw.ad.splash.c cVar2 = this.A;
        cVar2.e = ssdSplashRootView2;
        cVar2.adView = ssdSplashRootView2;
        SsdSplashRootView ssdSplashRootView3 = this.B;
        com.kc.dw.core.bquery.d dVar = new com.kc.dw.core.bquery.d(ssdSplashRootView3);
        ssdSplashRootView3.post(new g(this, dVar));
        int iIntValue = ((SplashCommonAdLoader) this.w.getAdLoader()).getAccept_ad_width().intValue();
        int iIntValue2 = ((SplashCommonAdLoader) this.w.getAdLoader()).getAccept_ad_height().intValue();
        if (viewGroup != null) {
            if (iIntValue <= 0) {
                iIntValue = viewGroup.getWidth();
            }
            if (iIntValue2 <= 0) {
                iIntValue2 = viewGroup.getHeight();
            }
        }
        DisplayMetrics displayMetrics = this.f39105a.getResources().getDisplayMetrics();
        if (iIntValue <= 0 || iIntValue > displayMetrics.widthPixels) {
            iIntValue = displayMetrics.widthPixels;
        }
        if (iIntValue2 <= 0 || iIntValue2 > displayMetrics.heightPixels) {
            iIntValue2 = displayMetrics.heightPixels;
        }
        int i2 = iIntValue2;
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this.w);
        if (this.u.getAdPatternType() == 2) {
            a(this.v, this.u, this.A, this.B, dVar, this.y, this.x, ((SplashCommonAdLoader) this.w.getAdLoader()).getVideoIsMute(), iIntValue, i2);
        } else {
            a(this.v, this.u, this.A, this.B, this.x, iIntValue, i2, (byte[]) null);
        }
    }

    public final void a(com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, View view) {
        new DownloadView().handleDownloadView(ssdSplashRootView, dVar);
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this.w);
        if (dVar.getAdPatternType() != 2) {
            a(aVar, dVar, cVar, ssdSplashRootView, view, (byte[]) null);
            return;
        }
        a(dVar);
        this.C = new NormalMediaView(this.f39105a);
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA = a(dVar.getMaterialTimeout(2500));
        this.C.setPreparedStartPlayListener(new com.kc.dw.ad.a(this, cVar, ssdSplashRootView, aVar, view, dVar, iA, jCurrentTimeMillis));
        this.C.a(dVar.g, com.kc.dw.core.utils.b.c(), iA);
    }

    public final void a(com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, View view, int i2, int i3, byte[] bArr) {
        ImageView imageView = (ImageView) ssdSplashRootView.findViewById(R.id.ms_splash_image_bg);
        GifImageView gifImageView = (GifImageView) ssdSplashRootView.findViewById(R.id.ms_splash_image);
        int scale_type = dVar.getScale_type();
        if (scale_type == -1) {
            scale_type = 2;
        }
        int i4 = scale_type;
        DisplayMetrics displayMetrics = this.f39105a.getResources().getDisplayMetrics();
        int i5 = i2 <= 0 ? displayMetrics.widthPixels : i2;
        int i6 = i3 <= 0 ? displayMetrics.heightPixels : i3;
        gifImageView.setVisibility(0);
        ssdSplashRootView.findViewById(R.id.ms_splash_video).setVisibility(8);
        if (this.q == 0) {
            this.q = System.currentTimeMillis();
        }
        int iA = a(dVar.getMaterialTimeout(2000));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = dVar.getImageUrls()[0];
        boolean zA = a((BaseAdSlot) dVar);
        int i7 = i6;
        int i8 = i5;
        com.kc.dw.core.timeout.a aVar2 = new com.kc.dw.core.timeout.a(iA, new r(this, dVar, bArr, iA, jCurrentTimeMillis, aVar, i4, i5, i7, gifImageView, cVar, ssdSplashRootView, view, i4, imageView));
        if (bArr != null && bArr.length > 0) {
            SdkHandler.runOnMainThread(new f1(d0.a(bArr), bArr, i4, i8, i7, aVar2));
            return;
        }
        if (!zA) {
            com.kc.dw.cache.b.a(str, new h1(aVar2, i4, i8, i7));
            return;
        }
        byte[] bArrC = com.kc.dw.core.utils.i.c(str);
        Bitmap bitmapA = d0.a(bArrC);
        if (bArrC != null && bArrC.length > 0 && bitmapA == null) {
            com.kc.dw.core.utils.i.a(str);
        }
        SdkHandler.runOnMainThread(new g1(bitmapA, bArrC, i4, i8, i7, aVar2));
    }

    public final void a(com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, View view, byte[] bArr) {
        Runnable k1Var;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iA = a(dVar.getMaterialTimeout(2000));
        String str = dVar.getImageUrls()[0];
        boolean zA = a((BaseAdSlot) dVar);
        com.kc.dw.core.timeout.b bVar = new com.kc.dw.core.timeout.b(iA, new i(this, dVar, bArr, cVar, ssdSplashRootView, aVar, view, iA, jCurrentTimeMillis));
        if (bArr != null && bArr.length > 0) {
            k1Var = new j1(bVar, bArr);
        } else {
            if (!zA) {
                com.kc.dw.cache.b.a(str, new l1(bVar));
                return;
            }
            k1Var = new k1(com.kc.dw.core.utils.i.c(str), str, bVar);
        }
        SdkHandler.runOnMainThread(k1Var);
    }

    public final void a(com.kc.dw.ad.splash.a aVar, com.kc.dw.ad.splash.d dVar, com.kc.dw.ad.splash.c cVar, SsdSplashRootView ssdSplashRootView, com.kc.dw.core.bquery.d dVar2, boolean z, View view, boolean z2, int i2, int i3) {
        ImageView imageView;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ssdSplashRootView.setVisibility(4);
        ssdSplashRootView.findViewById(R.id.ms_splash_image).setVisibility(8);
        ImageView imageView2 = (ImageView) ssdSplashRootView.findViewById(R.id.ms_splash_image_bg);
        imageView2.setVisibility(0);
        try {
            imageView = imageView2;
            try {
                new Timer().schedule(new b(this, dVar, aVar, cVar, ssdSplashRootView, dVar2, z, view, i2, i3), a(dVar.getMaterialTimeout(2500)));
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th = th2;
            imageView = imageView2;
        }
        a(dVar);
        this.q = System.currentTimeMillis();
        this.C = new NormalMediaView(this.f39105a);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Boolean[] boolArr = new Boolean[1];
        this.C.setPreparedStartPlayListener(new c(this, dVar, cVar, ssdSplashRootView, aVar, view, i2, i3, z2, atomicBoolean, imageView, boolArr, countDownLatch, dVar2, z));
        this.C.a(dVar.g, com.kc.dw.core.utils.b.c(), 5000L);
        ExecutorService executorService = f0.f39362a;
        f0.b.f39363a.a(new e(this, dVar, dVar2, boolArr, countDownLatch, imageView));
    }

    public final void a(com.kc.dw.ad.splash.d dVar) {
        if (dVar != null && !TextUtils.isEmpty(dVar.getVideo_cover())) {
            dVar.getAd_type();
            AdType.FEED.value();
            com.kc.dw.cache.b.a(dVar.getVideo_cover(), new f(this, dVar));
            return;
        }
        LogUtil.d("AdNative", "cover is null");
        this.m = Boolean.FALSE;
        try {
            CountDownLatch countDownLatch = this.l;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.kc.dw.ad.splash.d dVar, com.kc.dw.platform.ad_adapter.splash.e eVar, com.kc.dw.platform.ad_adapter.splash.j jVar, View view, boolean z, boolean z2) {
        long t1;
        this.u = dVar;
        this.v = eVar;
        this.w = jVar;
        this.x = view;
        this.y = z;
        this.z = z2;
        try {
            this.d = dVar.getErrorUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (((SplashCommonAdLoader) jVar.getAdLoader()).getAdSlot().getIsClickToClose()) {
                dVar.setAdClosed(true);
            }
        } catch (Throwable unused) {
        }
        int fetchDelay = 0;
        com.kc.dw.core.utils.i.a(dVar.getDefImage(), false, new a(this, dVar));
        this.A = new com.kc.dw.ad.splash.c(dVar, jVar, z);
        this.f = 0;
        PackageBean.AdBean adBean = com.kc.dw.core.utils.b.b;
        if (adBean != null && adBean.getSplash() != null) {
            this.f = com.kc.dw.core.utils.b.b.getSplash().getAr();
        }
        try {
            t1 = ((SplashCommonAdLoader) jVar.getAdLoader()).getT1();
        } catch (Exception unused2) {
            t1 = 0;
        }
        this.o = t1;
        try {
            fetchDelay = ((SplashCommonAdLoader) jVar.getAdLoader()).getFetchDelay();
        } catch (Exception unused3) {
        }
        this.p = fetchDelay;
        com.kc.dw.ad.splash.c cVar = this.A;
        cVar.i.add(new d(this, dVar));
        if (eVar != null) {
            com.kc.dw.ad.splash.c cVar2 = this.A;
            com.kc.dw.platform.ad_adapter.splash.j jVar2 = eVar.c;
            if (jVar2 != null) {
                com.kc.dw.platform.ad_adapter.splash.k kVar = new com.kc.dw.platform.ad_adapter.splash.k(cVar2, jVar2, eVar, eVar.f);
                eVar.d = kVar;
                SplashAdListener splashAdListener = eVar.b;
                if (splashAdListener != null) {
                    splashAdListener.onAdLoaded(kVar);
                }
            }
        }
        if (this.f == 1 || z2) {
            a((ViewGroup) null);
        }
        if (z2 && a(dVar, 1)) {
            LogUtil.i("AdNative", "rs renderSuccess1");
            b();
        }
    }

    public final void a(z zVar, String str, Integer num) {
        boolean zContainsKey;
        if ((zVar instanceof com.kc.dw.platform.ad_adapter.splash.e) && ((com.kc.dw.platform.ad_adapter.splash.e) zVar).e) {
            return;
        }
        this.t.a(6);
        if (this.r == 0) {
            this.r = System.currentTimeMillis();
        }
        try {
            zContainsKey = this.w.getSdkAdInfo().getAppendInfo().getEventTimes(com.kc.dw.core.service.logrecord.b.a(this.w.getSdkAdInfo())).containsKey("e5");
        } catch (Exception unused) {
            zContainsKey = false;
        }
        if (!zContainsKey) {
            com.kc.dw.core.service.logrecord.a.a(5, "e5", this.w, new TypeMsg().setData(this.g ? 2 : 1));
        }
        if (zVar != null) {
            zVar.onAdRenderFail(str, num.intValue());
        }
        if (p0.k > 0) {
            s1.a(this.d, 12, num.intValue(), str);
        }
    }

    public final boolean a(com.kc.dw.ad.splash.d dVar, int i2) {
        if (dVar == null || dVar.getRs() == null) {
            return com.kc.dw.core.utils.b.d() == i2;
        }
        return dVar.getRs().intValue() == i2;
    }

    public final boolean a(BaseAdSlot baseAdSlot) {
        if (baseAdSlot == null) {
            return false;
        }
        try {
            return !TextUtils.isEmpty(baseAdSlot.getDefImage()) && baseAdSlot.getDefImage().equals(baseAdSlot.getImageUrls()[0]);
        } catch (Exception unused) {
            return false;
        }
    }

    public final void b() {
        NormalMediaView normalMediaView;
        if (this.t.f39562a == 2) {
            try {
                if (this.u.getAdPatternType() == 2 && (normalMediaView = this.A.d) != null) {
                    normalMediaView.start();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (this.v == null || this.t.b != 0) {
            return;
        }
        this.t.a(4);
        if (this.z && !this.g) {
            com.kc.dw.core.service.logrecord.a.a(5, "e5", this.w, new TypeMsg().setData(1));
        }
        com.kc.dw.platform.ad_adapter.splash.e eVar = this.v;
        com.kc.dw.ad.splash.c cVar = this.A;
        eVar.getClass();
        try {
            eVar.i = cVar.getAdView();
            int nie = 0;
            try {
                Gson gson = new Gson();
                HashMap map = new HashMap();
                map.put("stepNum", 4);
                map.put("msg", "onAdReady add View");
                Integer numA = eVar.a();
                if (numA != null) {
                    map.put("creativeType", numA);
                }
                map.put("adView", eVar.i != null ? 1 : 0);
                s1.a(eVar.f39548a, gson.toJson(map));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            View view = eVar.i;
            if (view != null) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(eVar.i);
                }
                TouchAdContainer touchAdContainer = new TouchAdContainer(eVar.i.getContext());
                try {
                    PackageBean.AdBean adBean = com.kc.dw.core.utils.b.b;
                    if (adBean != null && adBean.getSplash() != null) {
                        nie = com.kc.dw.core.utils.b.b.getSplash().getNie();
                    }
                } catch (Exception unused) {
                }
                if (nie != 1) {
                    touchAdContainer.setInterceptDownEvent();
                }
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(cVar));
                touchAdContainer.addView(eVar.i);
                if (viewGroup != null) {
                    viewGroup.addView(touchAdContainer);
                }
                eVar.i = touchAdContainer;
                cVar.adView = touchAdContainer;
                com.kc.dw.platform.ad_adapter.splash.k kVar = eVar.d;
                if (kVar != null) {
                    kVar.setAdView(touchAdContainer);
                }
            } else {
                try {
                    s1.a(cVar.b.getErrorUrl(), 12, 9000002, "adView 为null");
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            SplashAdListener splashAdListener = eVar.b;
            if (splashAdListener != null) {
                splashAdListener.onAdReady(eVar.d);
            }
        } catch (Throwable th) {
            try {
                s1.a(cVar.b.getErrorUrl(), 12, 9000002, "广告加载成功，加载到容器时发生异常");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    public final void b(int i2) {
        if (this.g && a(this.u, i2)) {
            LogUtil.i("AdNative", "rs renderSuccess " + i2);
            b();
        }
    }
}
