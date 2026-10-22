package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.fl.saas.C1415j;
import com.fl.saas.K0;
import com.fl.saas.adx.api.mixNative.NativeCustomizeVideo;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.activity.h5.FLH5Activity;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.ActionView;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.base.interfaces.DeepLinkOpenListener;
import com.fl.saas.adx.base.interfaces.S2SVideoPlayListener;
import com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView;
import com.fl.saas.adx.base.widget.FingerSlidingView;
import com.fl.saas.adx.base.widget.InclineView;
import com.fl.saas.adx.base.widget.NativeSlidingView;
import com.fl.saas.adx.base.widget.S2SVideoView;
import com.fl.saas.adx.base.widget.ShakeView;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class K0 extends BaseNativeAd implements BiddingResult, ActionView, AdChangeCacheData, DeepLinkOpenListener {
    private static final String j = CommConstant.getClassTag("S2S", K0.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private S2SVideoView f30066a;
    private final boolean b;
    private final G0 c;
    private ActionView.Type d;
    private boolean e;
    private boolean f;
    private List g;
    private View h;
    private boolean i;

    public class a implements NativeSlidingView.SlidingListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C1415j f30067a;
        final /* synthetic */ NativeSlidingView b;

        public a(C1415j c1415j, NativeSlidingView nativeSlidingView) {
            this.f30067a = c1415j;
            this.b = nativeSlidingView;
        }

        @Override // com.fl.saas.adx.base.widget.NativeSlidingView.SlidingListener
        public void onDown(int i, int i2) {
            C1415j c1415j = this.f30067a;
            if (c1415j == null) {
                return;
            }
            c1415j.E1 = i;
            c1415j.F1 = i2;
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            C1415j c1415j2 = this.f30067a;
            c1415j2.I1 = c1415j2.E1 + iArr[0];
            c1415j2.J1 = c1415j2.F1 + iArr[1];
            c1415j2.R1 = System.currentTimeMillis();
        }

        @Override // com.fl.saas.adx.base.widget.NativeSlidingView.SlidingListener
        public void onSliding() {
            if (this.f30067a == null) {
                return;
            }
            if (K0.this.g != null && !K0.this.g.isEmpty()) {
                for (View view : K0.this.g) {
                    if (view != null) {
                        this.f30067a.k2 = C1415j.b.SLIDE;
                        view.performClick();
                        break;
                    }
                }
            }
            ViewHelper.removeParent(this.b);
        }

        @Override // com.fl.saas.adx.base.widget.NativeSlidingView.SlidingListener
        public void onUp(int i, int i2) {
            C1415j c1415j = this.f30067a;
            if (c1415j == null) {
                return;
            }
            c1415j.G1 = i;
            c1415j.H1 = i2;
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            C1415j c1415j2 = this.f30067a;
            c1415j2.K1 = c1415j2.G1 + iArr[0];
            c1415j2.L1 = c1415j2.H1 + iArr[1];
            c1415j2.S1 = System.currentTimeMillis();
        }
    }

    public class b implements S2SVideoPlayListener {
        public b() {
        }

        @Override // com.fl.saas.adx.base.interfaces.S2SVideoPlayListener
        public void onVideoPlayComplete() {
            K0.this.onAdVideoEndEvent();
        }

        @Override // com.fl.saas.adx.base.interfaces.S2SVideoPlayListener
        public void onVideoPlayError(int i, int i2) {
        }

        @Override // com.fl.saas.adx.base.interfaces.S2SVideoPlayListener
        public void onVideoPlayStart() {
            K0.this.onAdVideoStartEvent();
        }

        @Override // com.fl.saas.adx.base.interfaces.S2SVideoPlayListener
        public void onVideoPrepare() {
            if (DeviceUtil.filling_timing != 1 || K0.this.c == null) {
                return;
            }
            K0.this.c.a();
        }
    }

    public class c implements FingerSlidingView.SlidingListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C1415j f30069a;

        public c(C1415j c1415j) {
            this.f30069a = c1415j;
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingView.SlidingListener
        public void onDown(int i, int i2, View view) {
            C1415j c1415j = (C1415j) K0.this.getNativeAd();
            if (c1415j == null) {
                return;
            }
            c1415j.E1 = i;
            c1415j.F1 = i2;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            c1415j.I1 = c1415j.E1 + iArr[0];
            c1415j.J1 = c1415j.F1 + iArr[1];
            c1415j.R1 = System.currentTimeMillis();
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingView.SlidingListener
        public void onSliding() {
            if (K0.this.g == null || K0.this.g.isEmpty()) {
                return;
            }
            for (View view : K0.this.g) {
                if (view != null) {
                    this.f30069a.k2 = C1415j.b.SLIDE;
                    view.performClick();
                    return;
                }
            }
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingView.SlidingListener
        public void onUp(int i, int i2, View view) {
            C1415j c1415j = (C1415j) K0.this.getNativeAd();
            if (c1415j == null) {
                return;
            }
            c1415j.G1 = i;
            c1415j.H1 = i2;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            c1415j.K1 = c1415j.G1 + iArr[0];
            c1415j.L1 = c1415j.H1 + iArr[1];
            c1415j.S1 = System.currentTimeMillis();
        }
    }

    public class d implements FingerSlidingAndTwistingView.SlidingListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C1415j f30070a;

        public d(C1415j c1415j) {
            this.f30070a = c1415j;
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView.SlidingListener
        public void onDown(int i, int i2, View view) {
            C1415j c1415j = (C1415j) K0.this.getNativeAd();
            if (c1415j == null) {
                return;
            }
            c1415j.E1 = i;
            c1415j.F1 = i2;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            c1415j.I1 = c1415j.E1 + iArr[0];
            c1415j.J1 = c1415j.F1 + iArr[1];
            c1415j.R1 = System.currentTimeMillis();
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView.SlidingListener
        public void onShake(int i, int i2, int i3) {
            C1415j c1415j = this.f30070a;
            c1415j.M1 = i;
            c1415j.N1 = i2;
            c1415j.O1 = i3;
            if (K0.this.g == null || K0.this.g.isEmpty()) {
                return;
            }
            for (View view : K0.this.g) {
                if (view != null) {
                    this.f30070a.k2 = C1415j.b.SHAKE;
                    view.performClick();
                    return;
                }
            }
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView.SlidingListener
        public void onSliding() {
            if (K0.this.g == null || K0.this.g.isEmpty()) {
                return;
            }
            for (View view : K0.this.g) {
                if (view != null) {
                    this.f30070a.k2 = C1415j.b.SLIDE;
                    view.performClick();
                    return;
                }
            }
        }

        @Override // com.fl.saas.adx.base.widget.FingerSlidingAndTwistingView.SlidingListener
        public void onUp(int i, int i2, View view) {
            C1415j c1415j = (C1415j) K0.this.getNativeAd();
            if (c1415j == null) {
                return;
            }
            c1415j.G1 = i;
            c1415j.H1 = i2;
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            c1415j.K1 = c1415j.G1 + iArr[0];
            c1415j.L1 = c1415j.H1 + iArr[1];
            c1415j.S1 = System.currentTimeMillis();
        }
    }

    public class e implements NativeCustomizeVideo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ C1415j f30071a;

        public e(C1415j c1415j) {
            this.f30071a = c1415j;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public String getVideoUrl() {
            return this.f30071a.t1;
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoAutoStart() {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoBreak(long j) {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoContinue(long j) {
            C1443x.a().h(this.f30071a);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoError(long j, int i, int i2) {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoFinish() {
            C1443x.a().b(this.f30071a, 0);
            K0.this.onAdVideoEndEvent();
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo
        public void reportVideoFirst() {
            C1443x.a().i(this.f30071a);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoPause(long j) {
            C1443x.a().l(this.f30071a);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoStart() {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo
        public void reportVideoStart(long j) {
            long j2 = j / 1000;
            this.f30071a.X1 = Math.toIntExact(j2);
            C1443x.a().d(this.f30071a, (int) j2);
            K0.this.onAdVideoStartEvent();
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo, com.fl.saas.adx.base.interfaces.CustomizeVideo
        public void reportVideoStartError(int i, int i2) {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo
        public void reportVideoThird() {
            C1443x.a().m(this.f30071a);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeCustomizeVideo
        public void reportVideomMidpoint() {
            C1443x.a().n(this.f30071a);
        }
    }

    public K0(Context context, C1415j c1415j, G0 g0) {
        super(context, c1415j);
        this.b = false;
        this.e = true;
        this.f = false;
        this.i = false;
        this.c = g0;
    }

    @Override // com.fl.saas.adx.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        getNativeAdOpt().a(new B() { // from class: com.zj.adlib.rp4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                K0.a(i2, z, i, (C1415j) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0157 A[PHI: r3
      0x0157: PHI (r3v38 android.view.View) = (r3v18 android.view.View), (r3v47 android.view.View) binds: [B:79:0x0155, B:29:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010b, code lost:
    
        if (r18 != com.fl.saas.adx.base.innterNative.ActionView.Type.Banner) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0181, code lost:
    
        if (r2.g() == 8) goto L90;
     */
    @Override // com.fl.saas.adx.base.innterNative.ActionView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View bindActionView(ActionView.Type type) {
        View spreadSlidingTwistingView;
        double d2;
        View view;
        double d3;
        View templateShakesView;
        this.d = type;
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j == null || !c1415j.o()) {
            return null;
        }
        if (c1415j.g() == 2 && DeviceUtil.deviceHasAccelerometerSensor) {
            if (type == ActionView.Type.Spread) {
                View spreadShakesView = getSpreadShakesView();
                this.h = spreadShakesView;
                if (spreadShakesView != null) {
                    int iDip2px = DeviceUtil.dip2px(280.0f);
                    int iDip2px2 = DeviceUtil.dip2px(80.0f);
                    if (c1415j.D != 0) {
                        iDip2px = DeviceUtil.dip2px(320.0f);
                        iDip2px2 = DeviceUtil.dip2px(100.0f);
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
                    layoutParams.gravity = 81;
                    layoutParams.setMargins(0, 0, 0, DeviceUtil.dip2px(10.0f) * 3);
                    this.h.setLayoutParams(layoutParams);
                }
            } else {
                if (type == ActionView.Type.Interstitial) {
                    templateShakesView = getInterstitalShakesView();
                } else if (type == ActionView.Type.Template || type == ActionView.Type.Banner) {
                    templateShakesView = getTemplateShakesView();
                }
                this.h = templateShakesView;
            }
            view = this.h;
            if (view != null) {
                b(view, type, c1415j);
            }
        } else {
            if (c1415j.g() == 1 && type == ActionView.Type.Spread) {
                spreadSlidingTwistingView = getTipsView(c1415j.D);
            } else if (c1415j.g() == 4 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                this.h = getSpreadInlineView();
                int mobileHeight = DeviceUtil.getMobileHeight();
                if (mobileHeight <= 0) {
                    mobileHeight = DeviceUtil.dip2px(900.0f);
                }
                double d4 = mobileHeight;
                int i = (int) (d4 * 0.2d);
                int i2 = c1415j.D;
                if (i2 == 1) {
                    d3 = d4 * 0.3d;
                } else {
                    if (i2 == 2) {
                        d3 = d4 * 0.4d;
                    }
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
                    layoutParams2.gravity = 81;
                    this.h.setLayoutParams(layoutParams2);
                    a(this.h, type, c1415j);
                }
                i = (int) d3;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i);
                layoutParams3.gravity = 81;
                this.h.setLayoutParams(layoutParams3);
                a(this.h, type, c1415j);
            } else if (c1415j.g() == 5) {
                if (type == ActionView.Type.Spread) {
                    spreadSlidingTwistingView = getSpreadSlidingView(c1415j.D, c1415j.j(), new c(c1415j));
                } else {
                    if (type != ActionView.Type.Template) {
                    }
                    spreadSlidingTwistingView = c(c1415j);
                }
            } else if (c1415j.g() == 6 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                this.h = getAreaShakesView();
                int mobileHeight2 = DeviceUtil.getMobileHeight();
                if (mobileHeight2 <= 0) {
                    mobileHeight2 = DeviceUtil.dip2px(900.0f);
                }
                double d5 = mobileHeight2;
                int i3 = (int) (d5 * 0.2d);
                int i4 = c1415j.D;
                if (i4 == 1) {
                    d2 = d5 * 0.3d;
                } else if (i4 == 2) {
                    d2 = d5 * 0.4d;
                } else {
                    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, i3);
                    layoutParams4.gravity = 80;
                    layoutParams4.setMargins(0, 0, 0, 0);
                    this.h.setLayoutParams(layoutParams4);
                    view = this.h;
                    if (view != null) {
                        b(view, type, c1415j);
                    }
                }
                i3 = (int) d2;
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, i3);
                layoutParams5.gravity = 80;
                layoutParams5.setMargins(0, 0, 0, 0);
                this.h.setLayoutParams(layoutParams5);
                view = this.h;
                if (view != null) {
                    b(view, type, c1415j);
                }
            } else if (c1415j.g() == 7 && type == ActionView.Type.Spread && DeviceUtil.deviceHasAccelerometerSensor) {
                spreadSlidingTwistingView = getSpreadSlidingTwistingView(c1415j.D, true, c1415j.j(), new d(c1415j));
            }
            this.h = spreadSlidingTwistingView;
        }
        return this.h;
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(C1415j c1415j) {
        return J0.a(c1415j, this.f30066a);
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        if (this.i) {
            return;
        }
        this.i = true;
        D.a().b();
        S2SVideoView s2SVideoView = this.f30066a;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
        C1439v.b().a();
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public NativeCustomizeVideo getCustomizeVideo() {
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j == null || TextUtils.isEmpty(c1415j.t1) || c1415j.P0.b != 2) {
            return null;
        }
        return new e(c1415j);
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public void init(C1415j c1415j) {
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return false;
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isReady() {
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j != null) {
            return this.isNativeReady && ((((System.currentTimeMillis() - this.responseTime) / 1000) > ((long) c1415j.D1) ? 1 : (((System.currentTimeMillis() - this.responseTime) / 1000) == ((long) c1415j.D1) ? 0 : -1)) < 0);
        }
        return false;
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isShakeType() {
        return getNativeAd() != null && ((C1415j) getNativeAd()).t() && this.d == null && DeviceUtil.deviceHasAccelerometerSensor;
    }

    @Override // com.fl.saas.adx.base.interfaces.DeepLinkOpenListener
    public void onDeepLinkOpenFailed(Activity activity) {
        try {
            C1415j c1415j = (C1415j) getNativeAd();
            if (c1415j == null || TextUtils.isEmpty(c1415j.x0)) {
                return;
            }
            c1415j.h2 = 1;
            c1415j.i2 = 1;
            C1443x.a().f(c1415j);
            FLH5Activity.launchWithEnableQuickApp(activity, C1443x.a().a(c1415j.x0, c1415j), QuickAppHelper.getInstance().enableQuickApp(c1415j.i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public void release() {
        super.release();
        D.a().b();
        S2SVideoView s2SVideoView = this.f30066a;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
        C1439v.b().a();
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public void lambda$prepare$0(C1415j c1415j, NativePrepareInfo nativePrepareInfo) {
        final C1415j c1415j2 = (C1415j) getNativeAd();
        if (c1415j2 == null) {
            onAdFailedEvent(FLError.create(20401, "S2SMixNative render but AdSource is null"));
            return;
        }
        this.g = nativePrepareInfo.getAllClickViews();
        if (this.e && getNativeAd() != null && ((C1415j) getNativeAd()).t() && this.d == null && DeviceUtil.deviceHasAccelerometerSensor) {
            this.h = getShakeTipsView();
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(this.h);
            ShakeView shakeView = (ShakeView) this.h.findViewById(R.id.yd_shake_view);
            shakeView.setCallback(false);
            shakeView.setShakeListener(c1415j2.j(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.pp4
                @Override // com.fl.saas.adx.base.widget.ShakeView.ShakeListener
                public final void onShake(int i, int i2, int i3) {
                    this.f44035a.a(c1415j2, i, i2, i3);
                }
            });
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            if (nativePrepareInfo.isSelfRenderShake()) {
                layoutParams.gravity = 80;
                this.h.setAlpha(0.0f);
            }
            getNativeAdView().addView(this.h, layoutParams);
        }
        if (getNativeAd() != null && ((C1415j) getNativeAd()).q() && this.d == null) {
            NativeSlidingView nativeSlidingViewC = c(c1415j2);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            getNativeAdView().addView(nativeSlidingViewC, layoutParams2);
        }
        a();
        if (nativePrepareInfo.getCloseView() != null) {
            nativePrepareInfo.getCloseView().bringToFront();
            nativePrepareInfo.getCloseView().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.qp4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f44268a.a(view);
                }
            });
        }
        a(c1415j2);
        a(c1415j2, nativePrepareInfo.getCtaViewList());
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        if (getNativeAd() != null) {
            ((C1415j) getNativeAd()).r = str;
            ((C1415j) getNativeAd()).i = c1415j.i;
            ((C1415j) getNativeAd()).b0 = c1415j.h;
            ((C1415j) getNativeAd()).a0 = c1415j.i;
            ((C1415j) getNativeAd()).c0 = c1415j.j;
        }
    }

    private void a(Context context, C1415j c1415j) {
        if (c1415j == null || context == null) {
            return;
        }
        View view = this.h;
        if (view != null) {
            ViewHelper.removeParent(view);
            this.e = false;
            this.h = null;
        }
        D.a().a(this);
        c1415j.p2 = "2";
        b();
        int iA = AbstractC1399b.a(c1415j);
        c1415j.q1 = iA;
        C1443x.a().c(c1415j);
        C1415j.c cVar = c1415j.P0;
        if (cVar != null && !TextUtils.isEmpty(cVar.f30178a)) {
            ((C1415j) getNativeAd()).z = c1415j.P0.f30178a;
        }
        if (TextUtils.isEmpty(c1415j.x0) || !c1415j.x0.startsWith("ECHARGINGCUSTOM")) {
            C1439v.b().b(context, c1415j);
            onAdClickedEvent(iA);
        } else {
            onAdClickedCallBackEvent(c1415j.x0.replace("ECHARGINGCUSTOM", ""));
        }
        c1415j.k2 = C1415j.b.NORMAL;
        c1415j.E1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.F1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.I1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.J1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.G1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.H1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.K1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.L1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.M1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.N1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
        c1415j.O1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
    }

    private void b() {
        if (this.f) {
            return;
        }
        getNativeAdView().unOnVisibilityChanged();
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j != null) {
            c1415j.d0 = isReady() ? 1 : 0;
            c1415j.m2 = System.currentTimeMillis();
            c1415j.P1 = getNativeAdView().getWidth();
            c1415j.Q1 = getNativeAdView().getHeight();
            C1443x.a().a(c1415j, false);
            C1415j.c cVar = c1415j.P0;
            if (cVar != null && !TextUtils.isEmpty(cVar.f30178a)) {
                ((C1415j) getNativeAd()).z = c1415j.P0.f30178a;
            }
        }
        onAdImpressedEvent();
        this.f = true;
    }

    private NativeSlidingView c(C1415j c1415j) {
        NativeSlidingView nativeSlidingView = new NativeSlidingView(getContext());
        nativeSlidingView.setSlidingListener(c1415j.x, new a(c1415j, nativeSlidingView));
        nativeSlidingView.createView(c1415j.Y == 1);
        return nativeSlidingView;
    }

    private void a(C1415j c1415j, final List list) {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        LogcatUtil.d(j, "bindClickViews" + this.g.size());
        for (View view : this.g) {
            view.setClickable(true);
            view.setEnabled(true);
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.jp4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f42639a.a(view2, motionEvent);
                }
            });
            ViewHelper.onSingleClickListener(view, new View.OnClickListener() { // from class: com.zj.adlib.kp4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f42878a.a(list, view2);
                }
            });
        }
    }

    private void b(C1415j c1415j) {
        G0 g0;
        if (c1415j == null || this.f30066a != null || TextUtils.isEmpty(c1415j.t1) || c1415j.P0.b != 2) {
            G0 g1 = this.c;
            if (g1 != null) {
                g1.a();
                return;
            }
            return;
        }
        this.f30066a = new S2SVideoView(getContext());
        if (DeviceUtil.filling_timing == 0 && (g0 = this.c) != null) {
            g0.a();
        }
        this.f30066a.setVideo(c1415j);
        this.f30066a.setVideoPlayListener(new b());
    }

    public void c() {
        b((C1415j) getNativeAd());
    }

    private void a(final C1415j c1415j) {
        S2SVideoView s2SVideoView = this.f30066a;
        if (s2SVideoView == null || c1415j.H == 0) {
            return;
        }
        s2SVideoView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.op4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43800a.a(c1415j, view);
            }
        });
    }

    private void b(final View view, final ActionView.Type type, final C1415j c1415j) {
        listenShakeView(view, false, type, c1415j.j(), new ShakeView.ShakeListener() { // from class: com.zj.adlib.sp4
            @Override // com.fl.saas.adx.base.widget.ShakeView.ShakeListener
            public final void onShake(int i, int i2, int i3) {
                this.f19617a.b(c1415j, type, view, i, i2, i3);
            }
        });
    }

    private void a() {
        LogcatUtil.d(j, "bindNativeView" + this.f);
        if (this.f) {
            return;
        }
        getNativeAdView().setOnVisibilityChanged(new B() { // from class: com.zj.adlib.lp4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f43121a.a((Boolean) obj);
            }
        });
        getNativeAdView().setVisibilityRatioChanged(new B() { // from class: com.zj.adlib.mp4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f43356a.a((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(C1415j c1415j, ActionView.Type type, View view, int i, int i2, int i3) {
        c1415j.M1 = i;
        c1415j.N1 = i2;
        c1415j.O1 = i3;
        List list = this.g;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.g) {
                if (view2 != null) {
                    c1415j.k2 = C1415j.b.SHAKE;
                    view2.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    private void a(final View view, final ActionView.Type type, final C1415j c1415j) {
        listenInclineView(view, false, type, c1415j.j(), new InclineView.InclineListener() { // from class: com.zj.adlib.np4
            @Override // com.fl.saas.adx.base.widget.InclineView.InclineListener
            public final void onIncline(int i, int i2, int i3) {
                this.f18476a.a(c1415j, type, view, i, i2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, boolean z, int i2, C1415j c1415j) {
        c1415j.e = i;
        if (!z) {
            if (i2 > 0) {
                c1415j.d = i2;
            }
            C1443x.a().a(c1415j);
        } else {
            if (i2 > 0 && i2 <= c1415j.d) {
                c1415j.d = i2;
            }
            C1443x.a().b(c1415j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            LogcatUtil.d(j, "ACTION_DOWN");
            C1415j c1415j = (C1415j) getNativeAd();
            if (c1415j != null) {
                c1415j.E1 = (int) motionEvent.getX();
                c1415j.F1 = (int) motionEvent.getY();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                c1415j.I1 = c1415j.E1 + iArr[0];
                c1415j.J1 = c1415j.F1 + iArr[1];
                c1415j.R1 = System.currentTimeMillis();
            }
        }
        if (motionEvent.getAction() == 1) {
            LogcatUtil.d(j, "ACTION_UP");
            C1415j c1415j2 = (C1415j) getNativeAd();
            if (c1415j2 != null) {
                c1415j2.G1 = (int) motionEvent.getX();
                c1415j2.H1 = (int) motionEvent.getY();
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                c1415j2.K1 = c1415j2.G1 + iArr2[0];
                c1415j2.L1 = c1415j2.H1 + iArr2[1];
                c1415j2.S1 = System.currentTimeMillis();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, View view) {
        LogcatUtil.d(j, "viewClick");
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j != null) {
            c1415j.o2 = "1";
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((View) it.next()) == view) {
                        c1415j.o2 = "2";
                        break;
                    }
                }
            }
        }
        a(getContext(), c1415j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C1415j c1415j, View view) {
        c1415j.o2 = "1";
        c1415j.U1 = this.f30066a.getProgress();
        c1415j.V1 = this.f30066a.getProgress() / 1000;
        a(getContext(), c1415j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Integer num) {
        C1415j c1415j = (C1415j) getNativeAd();
        if (c1415j == null || num == null) {
            return;
        }
        c1415j.n2 = num.intValue();
        if (num.intValue() >= 100) {
            getNativeAdView().unOnVisibilityRatioChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C1415j c1415j, ActionView.Type type, View view, int i, int i2, int i3) {
        c1415j.M1 = i;
        c1415j.N1 = i2;
        c1415j.O1 = i3;
        List list = this.g;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.g) {
                if (view2 != null) {
                    c1415j.k2 = C1415j.b.SHAKE;
                    view2.performClick();
                    break;
                }
            }
        }
        if (type != ActionView.Type.Spread) {
            ViewHelper.removeParent(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(C1415j c1415j, int i, int i2, int i3) {
        c1415j.M1 = i;
        c1415j.N1 = i2;
        c1415j.O1 = i3;
        List list = this.g;
        if (list != null && !list.isEmpty()) {
            for (View view : this.g) {
                if (view != null) {
                    c1415j.k2 = C1415j.b.SHAKE;
                    view.performClick();
                    break;
                }
            }
        }
        ViewHelper.removeParent(this.h);
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        LogcatUtil.d(j, "onAdClose");
        onAdCloseEvent();
        ViewHelper.removeParent(getNativeAdView());
    }
}
