package com.kc.dw.platform.ad_adapter.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.MsCustomVideo;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecyclerAdUtils;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.router.log.bean.ClickAdState;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.d1;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.view.PositionView;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.ad_adapter.splash.ShakeResult;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class q extends MsCustomRecyclerFeedAd {
    public static int t = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.ad.nativ.d f39516a;
    public com.kc.dw.platform.ad_adapter.recycler.e b;
    public RecylcerAdInteractionListener c;
    public boolean d;
    public NativeAdMediaListener e;
    public int f;
    public boolean g;
    public int h;
    public float i;
    public float j;
    public float k;
    public float l;
    public boolean m;
    public int n;
    public FrameLayout o;
    public long p;
    public MsCustomVideo q;
    public boolean r = false;
    public ViewTreeObserver.OnScrollChangedListener s = new a(this);

    @Keep
    public class a implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f39517a;

        public a(q qVar) {
            this.f39517a = qVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                q qVar = this.f39517a;
                if (qVar.i <= 0.0f || qVar.j <= 0.0f || !s1.a(((RecyclerMixCommonAdLoader) qVar.b.getAdLoader()).getPosId(), this.f39517a.f39516a.a().getAdp(), this.f39517a.f39516a.a().getAdg())) {
                    return;
                }
                int[] iArr = new int[2];
                this.f39517a.o.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (i > 0) {
                    q qVar2 = this.f39517a;
                    if (qVar2.h == 0) {
                        qVar2.h = i;
                    }
                }
                q qVar3 = this.f39517a;
                qVar3.n = Math.abs(qVar3.h - i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class b extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f39518a;

        public b(q qVar) {
            this.f39518a = qVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.nativ.d dVar = this.f39518a.f39516a;
            if (dVar == null || dVar.getMediaView() == null) {
                return;
            }
            this.f39518a.f39516a.getMediaView().start();
        }
    }

    @Keep
    public class c extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f39519a;

        public c(q qVar) {
            this.f39519a = qVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.ad.nativ.d dVar = this.f39519a.f39516a;
            if (dVar == null || dVar.getMediaView() == null) {
                return;
            }
            this.f39519a.f39516a.getMediaView().replay();
        }
    }

    @Keep
    public class d implements com.kc.dw.core.adinner.recycler.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FeedInteractionListener f39520a;
        public final q b;

        public d(q qVar, FeedInteractionListener feedInteractionListener) {
            this.b = qVar;
            this.f39520a = feedInteractionListener;
        }

        @Override // com.kc.dw.core.adinner.recycler.a
        public List<View> a() {
            return this.b.a(this.f39520a);
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
            FeedInteractionListener feedInteractionListener = this.f39520a;
            if (feedInteractionListener != null) {
                feedInteractionListener.onAdClicked();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
            FeedInteractionListener feedInteractionListener = this.f39520a;
            if (feedInteractionListener != null) {
                feedInteractionListener.onAdClosed();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
            FeedInteractionListener feedInteractionListener = this.f39520a;
            if (feedInteractionListener != null) {
                feedInteractionListener.onAdExposure();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener
        public void onAdRenderFailed() {
        }
    }

    @Keep
    public class e implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f39521a;
        public final Rect b;
        public final RecylcerAdInteractionListener c;
        public final q d;

        @Keep
        public class a implements ShakeUtil.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f39522a;
            public final e b;

            public a(e eVar, long j) {
                this.b = eVar;
                this.f39522a = j;
            }

            @Override // com.kc.dw.platform.ad_adapter.splash.ShakeUtil.c
            public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
                RecylcerAdInteractionListener recylcerAdInteractionListener;
                ShakeUtil.getInstance().a(this.b.d.f);
                if (shakeResult != null) {
                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - this.f39522a);
                }
                this.b.d.f39516a.a().setClkActType(i);
                this.b.d.f39516a.a().setClkPower(i2);
                this.b.d.f39516a.a().setShakeResult(shakeResult);
                com.kc.dw.core.service.logrecord.a.a(5, "e8", this.b.d.b, new ClickAdState().setData(this.b.d.d() != null ? this.b.d.d().getClkActType() : -1, this.b.d.d() != null ? this.b.d.d().getClkPower() : -1));
                if (this.b.d.f39516a.a().getCbc() == 0 && (recylcerAdInteractionListener = this.b.c) != null) {
                    recylcerAdInteractionListener.onAdClicked();
                }
                com.kc.dw.core.utils.f.a(this.b.d.f39516a, i2 >= 50);
            }
        }

        public e(q qVar, ViewGroup viewGroup, Rect rect, RecylcerAdInteractionListener recylcerAdInteractionListener) {
            this.d = qVar;
            this.f39521a = viewGroup;
            this.b = rect;
            this.c = recylcerAdInteractionListener;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!this.f39521a.getGlobalVisibleRect(this.b)) {
                return true;
            }
            if (((long) this.b.height()) * ((long) this.b.width()) >= ((long) this.f39521a.getHeight()) * ((long) this.f39521a.getWidth()) * 0.3d) {
                q qVar = this.d;
                if (!qVar.d) {
                    qVar.d = true;
                    this.d.f39516a.a().setMonitorUrl(g0.a(this.d.f39516a.a().getMonitorUrl(), this.f39521a, (View) null));
                    com.kc.dw.platform.ad_adapter.recycler.c cVar = this.d.b.f;
                    if (cVar != null) {
                        cVar.onADExposure();
                        com.kc.dw.core.service.logrecord.util.c.d(this.d.b);
                        com.kc.dw.core.service.logrecord.a.a(5, "s7", this.d.b, new ShowAdState().setSuccess(com.kc.dw.core.service.logrecord.b.a(this.d.f39516a.a(), null, AdType.FEED_MIX.value()), 1));
                        RecylcerAdInteractionListener recylcerAdInteractionListener = this.c;
                        if (recylcerAdInteractionListener != null) {
                            recylcerAdInteractionListener.onAdExposure();
                        }
                    }
                    this.d.f39516a.a().B = true;
                    if (com.kc.dw.core.utils.h.c(this.d.f39516a.a().getAct_type())) {
                        int iB = com.kc.dw.core.utils.h.b(this.d.f39516a.a().getAct_type());
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ShakeUtil.getInstance().a(this.d.f39516a.a().getPosId(), this.d.f39516a.a().getLoadedTime(), this.d.f39516a.a().getDclk());
                        ShakeUtil shakeUtil = ShakeUtil.getInstance();
                        int power_index = this.d.f39516a.a().getPower_index();
                        int power_index2 = this.d.f39516a.a().getPower_index();
                        long power_delay = this.d.f39516a.a().getPower_delay();
                        int power_count = this.d.f39516a.a().getPower_count();
                        q qVar2 = this.d;
                        shakeUtil.a(power_index, power_index2, iB, power_delay, power_count, qVar2.f, qVar2.f39516a.a().getEcpm(), new a(this, jCurrentTimeMillis));
                        ShakeUtil.getInstance().a(true);
                    }
                    this.f39521a.getViewTreeObserver().removeOnPreDrawListener(this);
                }
            }
            return true;
        }
    }

    @Keep
    public class f implements TouchAdContainer.OnWindownEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f39523a;

        public f(q qVar) {
            this.f39523a = qVar;
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onAttachedToWindow() {
            ShakeUtil.getInstance().a(this.f39523a.f, true);
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onDetachedFromWindow() {
            ShakeUtil.getInstance().a(this.f39523a.f, false);
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onWindowFocusChanged(boolean z) {
            ShakeUtil shakeUtil;
            int i;
            boolean z2;
            if (z) {
                shakeUtil = ShakeUtil.getInstance();
                i = this.f39523a.f;
                z2 = true;
            } else {
                shakeUtil = ShakeUtil.getInstance();
                i = this.f39523a.f;
                z2 = false;
            }
            shakeUtil.a(i, z2);
        }
    }

    @Keep
    public class g extends com.kc.dw.platform.ad_adapter.recycler.f {
        public final q c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(q qVar, com.kc.dw.ad.nativ.d dVar, RecylcerAdInteractionListener recylcerAdInteractionListener) {
            super(dVar, recylcerAdInteractionListener);
            this.c = qVar;
        }

        @Override // com.kc.dw.platform.ad_adapter.recycler.f
        public void a() {
            com.kc.dw.core.service.logrecord.a.a(5, "e8", this.c.b, new ClickAdState().setData(this.c.d() != null ? this.c.d().getClkActType() : -1, this.c.d() != null ? this.c.d().getClkPower() : -1));
            super.a();
        }
    }

    @Keep
    public class h implements NativeAdMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f39524a;

        public h(q qVar) {
            this.f39524a = qVar;
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoCompleted() {
            NativeAdMediaListener nativeAdMediaListener = this.f39524a.e;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoCompleted();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoError() {
            NativeAdMediaListener nativeAdMediaListener = this.f39524a.e;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoError();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoPause() {
            NativeAdMediaListener nativeAdMediaListener = this.f39524a.e;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoPause();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoResume() {
            NativeAdMediaListener nativeAdMediaListener = this.f39524a.e;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoResume();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoStart() {
            NativeAdMediaListener nativeAdMediaListener = this.f39524a.e;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onVideoStart();
            }
        }
    }

    @Keep
    public class i implements RecylcerAdInteractionListener {
        public i(q qVar) {
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener
        public void onAdRenderFailed() {
        }
    }

    @Keep
    public class j implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f39525a;
        public final q b;

        public j(q qVar, List list) {
            this.b = qVar;
            this.f39525a = list;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() == 0) {
                    for (int i = 0; i < this.f39525a.size(); i++) {
                        if (q.a(this.b, (View) this.f39525a.get(i), motionEvent.getRawX(), motionEvent.getRawY())) {
                            this.b.i = motionEvent.getX();
                            this.b.j = motionEvent.getY();
                            this.b.k = motionEvent.getRawX();
                            this.b.l = motionEvent.getRawY();
                            q qVar = this.b;
                            qVar.h = 0;
                            qVar.p = System.currentTimeMillis();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    @Keep
    public class k extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f39526a;
        public final boolean b;
        public final List c;
        public final q d;

        @Keep
        public class a extends com.kc.dw.platform.ad_adapter.recycler.a {
            public final k k;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k kVar, View view, int i, List list) {
                super(view, i, list);
                this.k = kVar;
            }

            @Override // com.kc.dw.platform.ad_adapter.recycler.a
            public void a(float f, float f2, long j, float f3, float f4, int i) {
                k kVar = this.k;
                q.a(kVar.d, kVar.f39526a, f, f2, j, f3, f4, i);
            }
        }

        @Keep
        public class b implements View.OnTouchListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final k f39527a;

            public b(k kVar) {
                this.f39527a = kVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    if (motionEvent.getAction() == 0) {
                        this.f39527a.d.c();
                        return false;
                    }
                    if (motionEvent.getAction() != 1) {
                        return false;
                    }
                    this.f39527a.d.getClass();
                    float f = this.f39527a.d.o.getContext().getResources().getDisplayMetrics().density;
                    float fMax = Math.max(Math.abs(this.f39527a.d.k - motionEvent.getRawX()), Math.abs(this.f39527a.d.l - motionEvent.getRawY()));
                    if (fMax > this.f39527a.d.n) {
                        LogUtil.dev("MeishuRecyclerAdDataAda", "use rawXY");
                    }
                    q qVar = this.f39527a.d;
                    qVar.n = (int) Math.max(qVar.n, fMax);
                    k kVar = this.f39527a;
                    q qVar2 = kVar.d;
                    if (qVar2.n / f <= q.t) {
                        return false;
                    }
                    float f2 = qVar2.i;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float f3 = qVar2.j;
                    if (f3 <= 0.0f) {
                        return false;
                    }
                    q.a(qVar2, kVar.f39526a, f2, f3, qVar2.p, motionEvent.getX(), motionEvent.getY(), this.f39527a.d.n);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        public k(q qVar, ViewGroup viewGroup, boolean z, List list) {
            this.d = qVar;
            this.f39526a = viewGroup;
            this.b = z;
            this.c = list;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            View view;
            try {
                ViewGroup viewGroup = this.f39526a;
                List list = null;
                if (viewGroup == null) {
                    view = null;
                    break;
                }
                try {
                    view = (View) viewGroup.getParent();
                    int i = 0;
                    while (true) {
                        if (view != null && i < 10) {
                            if ((view instanceof RecyclerView) || (view instanceof ListView) || (view instanceof ScrollView) || (view instanceof NestedScrollView)) {
                                break;
                            } else if (view.getParent() instanceof View) {
                                view = (View) view.getParent();
                                i++;
                            }
                            e.printStackTrace();
                        }
                        view = null;
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (view != null) {
                    view.setOnTouchListener(new b(this));
                    return;
                }
                try {
                    FrameLayout frameLayout = this.d.o;
                    View childAt = this.f39526a.getChildAt(0);
                    int i2 = q.t;
                    if (this.b && this.d.r) {
                        list = this.c;
                    }
                    frameLayout.setOnTouchListener(new a(this, childAt, i2, list));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public q(com.kc.dw.platform.ad_adapter.recycler.e eVar, com.kc.dw.ad.nativ.d dVar) {
        this.b = eVar;
        this.f39516a = dVar;
        if (this.f == 0) {
            this.f = ShakeUtil.getInstance().b();
        }
        this.q = new MsCustomVideo(dVar.a());
        try {
            AdType adType = AdType.FEED_MIX;
            adType.value();
            com.kc.dw.core.utils.h.a();
            dVar.a().setAct_type(com.kc.dw.core.utils.h.a(dVar.a().getAct_type(), adType.value()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (dVar.a().getPower_index() > 0) {
            t = dVar.a().getPower_index() * 5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(q qVar, ViewGroup viewGroup, float f2, float f3, long j2, float f4, float f5, int i2) {
        boolean z;
        AdSlot adSlotA;
        qVar.getClass();
        try {
            if (qVar.m) {
                return;
            }
            FrameLayout frameLayout = qVar.o;
            if (frameLayout == null || frameLayout.getVisibility() != 0 || frameLayout.getParent() == null || !frameLayout.hasWindowFocus()) {
                z = false;
            } else {
                Rect rect = new Rect();
                if (frameLayout.getGlobalVisibleRect(rect)) {
                    int iWidth = rect.width();
                    int iHeight = rect.height();
                    int width = (int) (((double) (frameLayout.getWidth() * frameLayout.getHeight())) * 0.8d);
                    if (width > 0 && iHeight * iWidth >= width) {
                        z = true;
                    }
                }
                z = false;
            }
            if (z && qVar.d) {
                qVar.m = true;
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.kc.dw.core.utils.r.a().b(((RecyclerMixCommonAdLoader) qVar.b.getAdLoader()).getPosId() + "_adp", jCurrentTimeMillis);
                com.kc.dw.core.utils.r.a().b("adg_time", jCurrentTimeMillis);
                qVar.f39516a.a().setClkActType(512);
                qVar.f39516a.a().setClkPower(i2);
                com.kc.dw.platform.ad_adapter.recycler.b.a(qVar.f39516a, f2, f3, j2, f4, f5);
                qVar.c();
                com.kc.dw.ad.nativ.d dVar = qVar.f39516a;
                try {
                    int width2 = viewGroup.getWidth();
                    int height = viewGroup.getHeight();
                    if (width2 > 0 && height > 0 && (adSlotA = dVar.a()) != null && adSlotA.getClickUrl() != null) {
                        for (int i3 = 0; i3 < adSlotA.getClickUrl().length; i3++) {
                            adSlotA.getClickUrl()[i3] = g0.a(adSlotA.getClickUrl()[i3], width2, height);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) qVar.f39516a, false);
                try {
                    qVar.o.getViewTreeObserver().removeOnScrollChangedListener(qVar.s);
                } catch (Exception unused) {
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean a(q qVar, View view, float f2, float f3) {
        qVar.getClass();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return f2 >= ((float) i2) && f2 <= ((float) (view.getWidth() + i2)) && f3 >= ((float) i3) && f3 <= ((float) (view.getHeight() + i3));
    }

    public final List<View> a(InteractionListener interactionListener) {
        Method declaredMethod;
        try {
            if (interactionListener instanceof com.kc.dw.core.adinner.recycler.a) {
                return ((com.kc.dw.core.adinner.recycler.a) interactionListener).a();
            }
            Charset charset = d1.f39359a;
            String str = new String(Base64.decode("Z3N3", 0));
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                declaredMethod = interactionListener.getClass().getDeclaredMethod(str, new Class[0]);
            } catch (Throwable unused) {
                declaredMethod = null;
            }
            if (declaredMethod == null) {
                return null;
            }
            this.r = true;
            declaredMethod.setAccessible(true);
            return (List) declaredMethod.invoke(interactionListener, new Object[0]);
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final void a(Activity activity, ViewGroup viewGroup, List<View> list) {
        try {
            if (activity != null) {
                try {
                    if ((this.f39516a.a().getAct_type() & 512) != 512) {
                        return;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                boolean z = true;
                if (this.f39516a.a().getNativeSE() == 1) {
                    z = false;
                }
                List<View> listA = z ? a(this.c) : null;
                if (z && this.r) {
                    list = listA;
                }
                if (list != null && !list.isEmpty()) {
                    if (this.o == null) {
                        FrameLayout frameLayout = new FrameLayout(activity);
                        int height = -1;
                        int width = viewGroup.getWidth() <= 0 ? -1 : viewGroup.getWidth();
                        if (viewGroup.getHeight() > 0) {
                            height = viewGroup.getHeight();
                        }
                        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                        viewGroup.addView(frameLayout);
                        this.o = frameLayout;
                    }
                    this.o.setOnTouchListener(new j(this, list));
                    viewGroup.post(new k(this, viewGroup, z, listA));
                    this.o.getViewTreeObserver().addOnScrollChangedListener(this.s);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(ViewGroup viewGroup, NativeAdMediaListener nativeAdMediaListener) {
        try {
            if (this.f39516a.getAdPatternType() != 2) {
                return;
            }
            com.kc.dw.ad.nativ.d dVar = this.f39516a;
            if (dVar instanceof com.kc.dw.ad.nativ.g) {
                com.kc.dw.ad.nativ.g gVar = (com.kc.dw.ad.nativ.g) dVar;
                i iVar = new i(this);
                if (gVar.g.getVideoView() instanceof NormalMediaView) {
                    ((NormalMediaView) gVar.g.getVideoView()).setOnExposureListener(iVar);
                }
            }
            com.kc.dw.ad.nativ.d dVar2 = this.f39516a;
            this.b.getContext();
            dVar2.a(null, new com.kc.dw.platform.ad_adapter.recycler.d((com.kc.dw.ad.nativ.i) this.b.f39477a, nativeAdMediaListener), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        bindAdToView(context, viewGroup, list, (FeedInteractionListener) null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0089  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a8 A[Catch: all -> 0x0194, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0194, blocks: (B:4:0x0011, B:5:0x001a, B:7:0x003d, B:25:0x0070, B:29:0x008b, B:33:0x00a8, B:44:0x012e, B:43:0x012b, B:37:0x00e8, B:48:0x0144, B:50:0x015f, B:52:0x0165, B:54:0x016d, B:58:0x0177, B:57:0x0174, B:45:0x0133, B:47:0x0137, B:24:0x006d, B:8:0x0041, B:10:0x0049, B:34:0x00d6, B:40:0x00ee, B:16:0x0056, B:19:0x005b, B:21:0x0061), top: B:64:0x000f, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0133 A[Catch: all -> 0x0194, TryCatch #1 {all -> 0x0194, blocks: (B:4:0x0011, B:5:0x001a, B:7:0x003d, B:25:0x0070, B:29:0x008b, B:33:0x00a8, B:44:0x012e, B:43:0x012b, B:37:0x00e8, B:48:0x0144, B:50:0x015f, B:52:0x0165, B:54:0x016d, B:58:0x0177, B:57:0x0174, B:45:0x0133, B:47:0x0137, B:24:0x006d, B:8:0x0041, B:10:0x0049, B:34:0x00d6, B:40:0x00ee, B:16:0x0056, B:19:0x005b, B:21:0x0061), top: B:64:0x000f, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0137 A[Catch: all -> 0x0194, TryCatch #1 {all -> 0x0194, blocks: (B:4:0x0011, B:5:0x001a, B:7:0x003d, B:25:0x0070, B:29:0x008b, B:33:0x00a8, B:44:0x012e, B:43:0x012b, B:37:0x00e8, B:48:0x0144, B:50:0x015f, B:52:0x0165, B:54:0x016d, B:58:0x0177, B:57:0x0174, B:45:0x0133, B:47:0x0137, B:24:0x006d, B:8:0x0041, B:10:0x0049, B:34:0x00d6, B:40:0x00ee, B:16:0x0056, B:19:0x005b, B:21:0x0061), top: B:64:0x000f, inners: #2, #3, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0165 A[Catch: Exception -> 0x0173, all -> 0x0194, TryCatch #5 {Exception -> 0x0173, blocks: (B:50:0x015f, B:52:0x0165, B:54:0x016d), top: B:71:0x015f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x016d A[Catch: Exception -> 0x0173, all -> 0x0194, TRY_LEAVE, TryCatch #5 {Exception -> 0x0173, blocks: (B:50:0x015f, B:52:0x0165, B:54:0x016d), top: B:71:0x015f, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x0170 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, FeedInteractionListener feedInteractionListener) {
        Activity activity;
        Activity activity2;
        ViewGroup[] info;
        ViewGroup viewGroup2;
        int i2;
        View childAt;
        ViewGroup viewGroup3;
        TouchAdContainer touchAdContainer;
        boolean zShowFeedAdLogo;
        d dVar = new d(this, feedInteractionListener);
        try {
            if (viewGroup == null) {
                LogUtil.e("MeishuRecyclerAdDataAda", "adContainer is null");
                return;
            }
            s1.b(this.f39516a.a().getEventUrl());
            com.kc.dw.core.service.logrecord.util.c.c(this.b);
            com.kc.dw.core.service.logrecord.util.c.d(this.b);
            this.c = dVar;
            Rect rect = new Rect();
            if (!(context instanceof Activity)) {
                if (viewGroup.getContext() instanceof Activity) {
                    activity2 = (Activity) viewGroup.getContext();
                } else {
                    activity = null;
                }
                if (activity != null) {
                    try {
                        if (!this.g && Build.VERSION.SDK_INT >= 29) {
                            this.g = true;
                            activity.registerActivityLifecycleCallbacks(new r(this));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                viewGroup.getViewTreeObserver().addOnPreDrawListener(new e(this, viewGroup, rect, dVar));
                info = RecyclerAdUtils.getInfo(viewGroup, q.class, TouchAdContainer.class);
                viewGroup2 = info[1];
                if (viewGroup2 == null) {
                    viewGroup2 = info[0];
                    viewGroup3 = (ViewGroup) viewGroup2.getParent();
                    if (viewGroup3 == null) {
                        try {
                            Charset charset = d1.f39359a;
                            LogUtil.e("", new String(Base64.decode("c2VsZiByZW5kZXIgYmluZEFkVG9WaWV3LCBUaGUgYWRDb250YWluZXIgbXVzdCBiZSBpbnNlcnRlZCBpbnRvIHRoZSBwYWdlIGxheW91dC4=", 0)));
                        } catch (Throwable unused) {
                        }
                    } else {
                        int iIndexOfChild = viewGroup3.indexOfChild(viewGroup2);
                        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                        viewGroup3.removeView(viewGroup2);
                        touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                        touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f39516a));
                        touchAdContainer.addView(viewGroup2, layoutParams2);
                        touchAdContainer.setId(viewGroup2.getId());
                        try {
                            zShowFeedAdLogo = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().showFeedAdLogo();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            zShowFeedAdLogo = false;
                        }
                        if (zShowFeedAdLogo) {
                            try {
                                ImageView imageView = new ImageView(viewGroup2.getContext());
                                imageView.setAdjustViewBounds(true);
                                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup2.getContext().getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                                layoutParams3.gravity = 85;
                                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ssd_ad));
                                touchAdContainer.addView(imageView, layoutParams3);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        viewGroup3.addView(touchAdContainer, iIndexOfChild, layoutParams);
                        viewGroup2 = touchAdContainer;
                    }
                } else if (viewGroup2 instanceof TouchAdContainer) {
                    ((TouchAdContainer) viewGroup2).setTouchPositionListener(new TouchPositionListener(this.f39516a));
                }
                PositionView positionView = new PositionView(viewGroup.getContext());
                positionView.setTag(Integer.valueOf(this.f));
                positionView.setOnWindownEventListener(new f(this));
                for (i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    try {
                        childAt = viewGroup2.getChildAt(i2);
                        if (childAt instanceof PositionView) {
                            viewGroup2.removeView(childAt);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                viewGroup2.addView(positionView, 1, 1);
                a(activity, viewGroup2, list);
                com.kc.dw.ad.nativ.d dVar2 = this.f39516a;
                dVar2.a(context, viewGroup2, list, new g(this, dVar2, dVar));
                this.f39516a.setInteractionListener(dVar);
                a((ViewGroup) null, new h(this));
            }
            activity2 = (Activity) context;
            activity = activity2;
            if (activity != null) {
                if (!this.g) {
                    this.g = true;
                    activity.registerActivityLifecycleCallbacks(new r(this));
                }
            }
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new e(this, viewGroup, rect, dVar));
            info = RecyclerAdUtils.getInfo(viewGroup, q.class, TouchAdContainer.class);
            viewGroup2 = info[1];
            if (viewGroup2 == null) {
                viewGroup2 = info[0];
                viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 == null) {
                    Charset charset2 = d1.f39359a;
                    LogUtil.e("", new String(Base64.decode("c2VsZiByZW5kZXIgYmluZEFkVG9WaWV3LCBUaGUgYWRDb250YWluZXIgbXVzdCBiZSBpbnNlcnRlZCBpbnRvIHRoZSBwYWdlIGxheW91dC4=", 0)));
                } else {
                    int iIndexOfChild2 = viewGroup3.indexOfChild(viewGroup2);
                    ViewGroup.LayoutParams layoutParams4 = viewGroup2.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams5 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup3.removeView(viewGroup2);
                    touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f39516a));
                    touchAdContainer.addView(viewGroup2, layoutParams5);
                    touchAdContainer.setId(viewGroup2.getId());
                    zShowFeedAdLogo = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().showFeedAdLogo();
                    if (zShowFeedAdLogo) {
                        ImageView imageView2 = new ImageView(viewGroup2.getContext());
                        imageView2.setAdjustViewBounds(true);
                        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup2.getContext().getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                        layoutParams6.gravity = 85;
                        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.ssd_ad));
                        touchAdContainer.addView(imageView2, layoutParams6);
                    }
                    viewGroup3.addView(touchAdContainer, iIndexOfChild2, layoutParams4);
                    viewGroup2 = touchAdContainer;
                }
            } else if (viewGroup2 instanceof TouchAdContainer) {
                ((TouchAdContainer) viewGroup2).setTouchPositionListener(new TouchPositionListener(this.f39516a));
            }
            PositionView positionView2 = new PositionView(viewGroup.getContext());
            positionView2.setTag(Integer.valueOf(this.f));
            positionView2.setOnWindownEventListener(new f(this));
            while (i2 < viewGroup2.getChildCount()) {
                childAt = viewGroup2.getChildAt(i2);
                if (childAt instanceof PositionView) {
                    viewGroup2.removeView(childAt);
                }
            }
            viewGroup2.addView(positionView2, 1, 1);
            a(activity, viewGroup2, list);
            com.kc.dw.ad.nativ.d dVar3 = this.f39516a;
            dVar3.a(context, viewGroup2, list, new g(this, dVar3, dVar));
            this.f39516a.setInteractionListener(dVar);
            a((ViewGroup) null, new h(this));
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0083  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a2 A[Catch: all -> 0x018f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x018f, blocks: (B:4:0x000c, B:6:0x0014, B:8:0x0037, B:26:0x006a, B:30:0x0085, B:34:0x00a2, B:45:0x0128, B:44:0x0125, B:38:0x00e2, B:49:0x013e, B:51:0x0159, B:53:0x015f, B:55:0x0167, B:59:0x0171, B:58:0x016e, B:46:0x012d, B:48:0x0131, B:25:0x0067, B:9:0x003b, B:11:0x0043, B:35:0x00d0, B:41:0x00e8, B:17:0x0050, B:20:0x0055, B:22:0x005b), top: B:75:0x000a, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x012d A[Catch: all -> 0x018f, TryCatch #5 {all -> 0x018f, blocks: (B:4:0x000c, B:6:0x0014, B:8:0x0037, B:26:0x006a, B:30:0x0085, B:34:0x00a2, B:45:0x0128, B:44:0x0125, B:38:0x00e2, B:49:0x013e, B:51:0x0159, B:53:0x015f, B:55:0x0167, B:59:0x0171, B:58:0x016e, B:46:0x012d, B:48:0x0131, B:25:0x0067, B:9:0x003b, B:11:0x0043, B:35:0x00d0, B:41:0x00e8, B:17:0x0050, B:20:0x0055, B:22:0x005b), top: B:75:0x000a, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0131 A[Catch: all -> 0x018f, TryCatch #5 {all -> 0x018f, blocks: (B:4:0x000c, B:6:0x0014, B:8:0x0037, B:26:0x006a, B:30:0x0085, B:34:0x00a2, B:45:0x0128, B:44:0x0125, B:38:0x00e2, B:49:0x013e, B:51:0x0159, B:53:0x015f, B:55:0x0167, B:59:0x0171, B:58:0x016e, B:46:0x012d, B:48:0x0131, B:25:0x0067, B:9:0x003b, B:11:0x0043, B:35:0x00d0, B:41:0x00e8, B:17:0x0050, B:20:0x0055, B:22:0x005b), top: B:75:0x000a, inners: #0, #1, #2, #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x015f A[Catch: Exception -> 0x016d, all -> 0x018f, TryCatch #1 {Exception -> 0x016d, blocks: (B:51:0x0159, B:53:0x015f, B:55:0x0167), top: B:67:0x0159, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0167 A[Catch: Exception -> 0x016d, all -> 0x018f, TRY_LEAVE, TryCatch #1 {Exception -> 0x016d, blocks: (B:51:0x0159, B:53:0x015f, B:55:0x0167), top: B:67:0x0159, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x016a A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        Activity activity;
        Activity activity2;
        ViewGroup[] info;
        ViewGroup viewGroup2;
        int i2;
        View childAt;
        ViewGroup viewGroup3;
        TouchAdContainer touchAdContainer;
        boolean zShowFeedAdLogo;
        try {
            if (viewGroup == null) {
                LogUtil.e("MeishuRecyclerAdDataAda", "adContainer is null");
                return;
            }
            s1.b(this.f39516a.a().getEventUrl());
            com.kc.dw.core.service.logrecord.util.c.c(this.b);
            com.kc.dw.core.service.logrecord.util.c.d(this.b);
            this.c = recylcerAdInteractionListener;
            Rect rect = new Rect();
            if (!(context instanceof Activity)) {
                if (viewGroup.getContext() instanceof Activity) {
                    activity2 = (Activity) viewGroup.getContext();
                } else {
                    activity = null;
                }
                if (activity != null) {
                    try {
                        if (!this.g && Build.VERSION.SDK_INT >= 29) {
                            this.g = true;
                            activity.registerActivityLifecycleCallbacks(new r(this));
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                viewGroup.getViewTreeObserver().addOnPreDrawListener(new e(this, viewGroup, rect, recylcerAdInteractionListener));
                info = RecyclerAdUtils.getInfo(viewGroup, q.class, TouchAdContainer.class);
                viewGroup2 = info[1];
                if (viewGroup2 == null) {
                    viewGroup2 = info[0];
                    viewGroup3 = (ViewGroup) viewGroup2.getParent();
                    if (viewGroup3 == null) {
                        try {
                            Charset charset = d1.f39359a;
                            LogUtil.e("", new String(Base64.decode("c2VsZiByZW5kZXIgYmluZEFkVG9WaWV3LCBUaGUgYWRDb250YWluZXIgbXVzdCBiZSBpbnNlcnRlZCBpbnRvIHRoZSBwYWdlIGxheW91dC4=", 0)));
                        } catch (Throwable unused) {
                        }
                    } else {
                        int iIndexOfChild = viewGroup3.indexOfChild(viewGroup2);
                        ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                        viewGroup3.removeView(viewGroup2);
                        touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                        touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f39516a));
                        touchAdContainer.addView(viewGroup2, layoutParams2);
                        touchAdContainer.setId(viewGroup2.getId());
                        try {
                            zShowFeedAdLogo = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().showFeedAdLogo();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                            zShowFeedAdLogo = false;
                        }
                        if (zShowFeedAdLogo) {
                            try {
                                ImageView imageView = new ImageView(viewGroup2.getContext());
                                imageView.setAdjustViewBounds(true);
                                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup2.getContext().getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                                layoutParams3.gravity = 85;
                                imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ssd_ad));
                                touchAdContainer.addView(imageView, layoutParams3);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        viewGroup3.addView(touchAdContainer, iIndexOfChild, layoutParams);
                        viewGroup2 = touchAdContainer;
                    }
                } else if (viewGroup2 instanceof TouchAdContainer) {
                    ((TouchAdContainer) viewGroup2).setTouchPositionListener(new TouchPositionListener(this.f39516a));
                }
                PositionView positionView = new PositionView(viewGroup.getContext());
                positionView.setTag(Integer.valueOf(this.f));
                positionView.setOnWindownEventListener(new f(this));
                for (i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    try {
                        childAt = viewGroup2.getChildAt(i2);
                        if (childAt instanceof PositionView) {
                            viewGroup2.removeView(childAt);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                viewGroup2.addView(positionView, 1, 1);
                a(activity, viewGroup2, list);
                com.kc.dw.ad.nativ.d dVar = this.f39516a;
                dVar.a(context, viewGroup2, list, new g(this, dVar, recylcerAdInteractionListener));
                this.f39516a.setInteractionListener(recylcerAdInteractionListener);
                a((ViewGroup) null, new h(this));
            }
            activity2 = (Activity) context;
            activity = activity2;
            if (activity != null) {
                if (!this.g) {
                    this.g = true;
                    activity.registerActivityLifecycleCallbacks(new r(this));
                }
            }
            viewGroup.getViewTreeObserver().addOnPreDrawListener(new e(this, viewGroup, rect, recylcerAdInteractionListener));
            info = RecyclerAdUtils.getInfo(viewGroup, q.class, TouchAdContainer.class);
            viewGroup2 = info[1];
            if (viewGroup2 == null) {
                viewGroup2 = info[0];
                viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 == null) {
                    Charset charset2 = d1.f39359a;
                    LogUtil.e("", new String(Base64.decode("c2VsZiByZW5kZXIgYmluZEFkVG9WaWV3LCBUaGUgYWRDb250YWluZXIgbXVzdCBiZSBpbnNlcnRlZCBpbnRvIHRoZSBwYWdlIGxheW91dC4=", 0)));
                } else {
                    int iIndexOfChild2 = viewGroup3.indexOfChild(viewGroup2);
                    ViewGroup.LayoutParams layoutParams4 = viewGroup2.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams5 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup3.removeView(viewGroup2);
                    touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f39516a));
                    touchAdContainer.addView(viewGroup2, layoutParams5);
                    touchAdContainer.setId(viewGroup2.getId());
                    zShowFeedAdLogo = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().showFeedAdLogo();
                    if (zShowFeedAdLogo) {
                        ImageView imageView2 = new ImageView(viewGroup2.getContext());
                        imageView2.setAdjustViewBounds(true);
                        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup2.getContext().getResources().getDisplayMetrics().density * 13.0f) + 0.5f));
                        layoutParams6.gravity = 85;
                        imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.ssd_ad));
                        touchAdContainer.addView(imageView2, layoutParams6);
                    }
                    viewGroup3.addView(touchAdContainer, iIndexOfChild2, layoutParams4);
                    viewGroup2 = touchAdContainer;
                }
            } else if (viewGroup2 instanceof TouchAdContainer) {
                ((TouchAdContainer) viewGroup2).setTouchPositionListener(new TouchPositionListener(this.f39516a));
            }
            PositionView positionView2 = new PositionView(viewGroup.getContext());
            positionView2.setTag(Integer.valueOf(this.f));
            positionView2.setOnWindownEventListener(new f(this));
            while (i2 < viewGroup2.getChildCount()) {
                childAt = viewGroup2.getChildAt(i2);
                if (childAt instanceof PositionView) {
                    viewGroup2.removeView(childAt);
                }
            }
            viewGroup2.addView(positionView2, 1, 1);
            a(activity, viewGroup2, list);
            com.kc.dw.ad.nativ.d dVar2 = this.f39516a;
            dVar2.a(context, viewGroup2, list, new g(this, dVar2, recylcerAdInteractionListener));
            this.f39516a.setInteractionListener(recylcerAdInteractionListener);
            a((ViewGroup) null, new h(this));
        } catch (Throwable unused2) {
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdRenderFailed();
            }
        }
    }

    public final void c() {
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.h = 0;
        this.n = 0;
    }

    public BaseAdSlot d() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void destroy() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null) {
            return;
        }
        if (dVar.getMediaView() != null && (this.f39516a.getMediaView() instanceof NormalMediaView)) {
            ((NormalMediaView) this.f39516a.getMediaView()).c();
        }
        ShakeUtil.getInstance().a(this.f);
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().d;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null) {
            return 12;
        }
        if (dVar.a().getAdPatternType() == 2) {
            return 2;
        }
        switch (this.f39516a.a().x) {
            case 1:
            case 2:
            case 6:
                return 12;
            case 3:
            case 4:
                return 11;
            case 5:
                return 13;
            default:
                return this.f39516a.getAdPatternType();
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public View getAdView() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar != null) {
            return dVar.getAdView();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getApp_intro();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getApp_intor_url();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getAppName();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public List<SsdAdInfo.PermissionBean> getAppPermissionList() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null || dVar.a() == null) {
            return null;
        }
        return this.f39516a.a().getApp_permission();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getApp_permission_url();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getApp_size();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getApp_ver();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getContent() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().c;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return this.q;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.kc.dw.ad.nativ.i) this.b.f39477a).getCid());
            resultBean.setCat(((com.kc.dw.ad.nativ.i) this.b.f39477a).getCat());
            resultBean.setAderId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getAder_id());
            resultBean.setFromId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getFromId());
            resultBean.setDrawing(((com.kc.dw.ad.nativ.i) this.b.f39477a).getDrawing());
            resultBean.setPid(((com.kc.dw.ad.nativ.i) this.b.f39477a).getPosId());
            resultBean.setReqId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getReq_id());
            resultBean.setPrice(((com.kc.dw.ad.nativ.i) this.b.f39477a).getEcpm());
            resultBean.setEcpm(((com.kc.dw.ad.nativ.i) this.b.f39477a).getEcpm() + "");
            resultBean.setS_ext(((com.kc.dw.ad.nativ.i) this.b.f39477a).getS_ext());
            resultBean.setS_code(((com.kc.dw.ad.nativ.i) this.b.f39477a).getS_code());
            resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.b.f39477a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("SSD");
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return dVar != null ? dVar.getDesc() : "";
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getDeveloper();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar != null && dVar.getMediaView() != null && (this.f39516a.getMediaView() instanceof NormalMediaView)) {
            return ((NormalMediaView) this.f39516a.getMediaView()).getDuration();
        }
        com.kc.dw.ad.nativ.d dVar2 = this.f39516a;
        if (dVar2 == null || dVar2.a() == null) {
            return 0L;
        }
        return this.f39516a.a().y * 1000;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public FeedExpressAdInteractionListener getExpressAdInteractionListener() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().f;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getFromId();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getFromLogo();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null || dVar.a() == null) {
            return 0;
        }
        return this.f39516a.a().b;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().e;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return dVar != null ? dVar.getIconUrl() : "";
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar != null) {
            return dVar.getImgUrls();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar != null) {
            return dVar.getInteractionType();
        }
        return 0;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null || dVar.getMediaView() == null || !(this.f39516a.getMediaView() instanceof NormalMediaView)) {
            return null;
        }
        return (ViewGroup) this.f39516a.getMediaView();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public FeedInteractionListener getNativeAdInteractionListener() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getPackageName();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "SSD";
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return (dVar == null || dVar.a() == null) ? "" : this.f39516a.a().getPrivacy_agreement();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        return dVar != null ? dVar.getTitle() : "";
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        try {
            return this.f39516a.a().getVideo_cover();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        try {
            if (getAdPatternType() == 2) {
                return getImgUrls()[0];
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null || dVar.a() == null) {
            return 0;
        }
        return this.f39516a.a().f39132a;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.kc.dw.ad.nativ.i) this.b.f39477a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.kc.dw.ad.nativ.i) this.b.f39477a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void mute() {
        com.kc.dw.ad.nativ.d dVar;
        if (getAdPatternType() != 2 || (dVar = this.f39516a) == null || dVar.getMediaView() == null) {
            return;
        }
        this.f39516a.getMediaView().mute();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
        com.kc.dw.ad.nativ.d dVar;
        if (getAdPatternType() != 2 || (dVar = this.f39516a) == null || dVar.getMediaView() == null) {
            return;
        }
        this.f39516a.getMediaView().pause();
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void replay() {
        if (getAdPatternType() == 2) {
            new Handler().postDelayed(new c(this), 300L);
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
        com.kc.dw.ad.nativ.d dVar;
        if (getAdPatternType() != 2 || (dVar = this.f39516a) == null || dVar.getMediaView() == null) {
            return;
        }
        this.f39516a.getMediaView().resume();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(this.b.getContext(), ((com.kc.dw.ad.nativ.i) this.b.f39477a).getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(this.b.getContext(), ((com.kc.dw.ad.nativ.i) this.b.f39477a).getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setExpressAdInteractionListener(FeedExpressAdInteractionListener feedExpressAdInteractionListener) {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setNativeMediaListener(NativeAdMediaListener nativeAdMediaListener) {
        this.e = nativeAdMediaListener;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void startVideo() {
        if (getAdPatternType() == 2) {
            new Handler().postDelayed(new b(this), 300L);
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
        com.kc.dw.ad.nativ.d dVar = this.f39516a;
        if (dVar == null || dVar.getMediaView() == null || !(this.f39516a.getMediaView() instanceof NormalMediaView)) {
            return;
        }
        ((NormalMediaView) this.f39516a.getMediaView()).j();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void unmute() {
        com.kc.dw.ad.nativ.d dVar;
        if (getAdPatternType() != 2 || (dVar = this.f39516a) == null || dVar.getMediaView() == null) {
            return;
        }
        this.f39516a.getMediaView().unmute();
    }
}
