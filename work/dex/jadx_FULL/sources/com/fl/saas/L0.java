package com.fl.saas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.fl.saas.K0;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.ActionView;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class L0 extends BaseNativeAd implements BiddingResult, AdChangeCacheData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativeAdView f30073a;
    private final C1415j b;
    private final Q0 c;
    private int d;
    private Q0.b e;
    private boolean f;

    public class a implements Q0.b {
        public a() {
        }

        @Override // com.fl.saas.Q0.b
        public void a() {
        }

        @Override // com.fl.saas.Q0.b
        public void onClose() {
            L0.this.onAdCloseEvent();
        }
    }

    public class b implements NativeEventListener {
        public b() {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdClicked(NativeAdView nativeAdView) {
            L0.this.onAdClickedEvent();
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdClose(NativeAdView nativeAdView) {
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
            L0.this.onAdFailedEvent(fLError);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdImpressed(NativeAdView nativeAdView) {
            L0.this.onAdImpressedEvent();
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdVideoEnd(NativeAdView nativeAdView) {
            L0.this.onAdVideoEndEvent();
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            L0.this.onAdVideoProgress(j);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
        public void onAdVideoStart(NativeAdView nativeAdView) {
            L0.this.onAdVideoStartEvent();
        }
    }

    public L0(Context context, K0 k0, int i, int i2) {
        super(context, k0);
        this.f = false;
        C1415j c1415j = (C1415j) k0.getNativeAdOpt().b();
        this.b = c1415j;
        int iDip2px = DeviceUtil.dip2px(c1415j.u0);
        int iDip2px2 = DeviceUtil.dip2px(c1415j.v0);
        NativeAdView nativeAdView = new NativeAdView(getContext());
        this.f30073a = nativeAdView;
        nativeAdView.setLayoutParams(ViewHelper.getWrapParent());
        Q0 q0 = new Q0(context, Q0.c.a(c1415j.t0));
        this.c = q0;
        NativeMaterial adMaterial = k0.getAdMaterial();
        if (this.e == null) {
            this.e = new a();
        }
        q0.e(adMaterial.getTitle()).c(adMaterial.getDescription()).b(adMaterial.getCallToAction()).b(i, i2).b(c1415j).a(iDip2px, iDip2px2).a(adMaterial.getAdLogo()).d(adMaterial.getIconUrl()).a().a(this.e);
    }

    @Override // com.fl.saas.adx.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, final int i3) {
        getNativeAdOpt().a(new B() { // from class: com.zj.adlib.ws4
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((K0) obj).biddingResult(z, i, i2, i3);
            }
        });
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public NativeMaterial createNativeMaterial(K0 k0) {
        return J0.a(this.b, this.f30073a);
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public void destroy() {
        super.destroy();
        if (this.f) {
            return;
        }
        this.f = true;
        if (getNativeAd() != null) {
            ((K0) getNativeAd()).destroy();
        }
        Q0 q0 = this.c;
        if (q0 != null) {
            q0.b();
        }
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public void init(K0 k0) {
        k0.setNativeEventListener(new b());
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeAd
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd, com.fl.saas.adx.api.mixNative.NativeAd
    public void release() {
        super.release();
        if (this.f) {
            return;
        }
        this.f = true;
        if (getNativeAd() != null) {
            ((K0) getNativeAd()).destroy();
        }
        Q0 q0 = this.c;
        if (q0 != null) {
            q0.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:9:0x0020  */
    @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd
    public void lambda$prepare$0(K0 k0, NativePrepareInfo nativePrepareInfo) {
        View viewC = this.c.c();
        if (viewC != null) {
            ViewParent parent = viewC.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(viewC);
            } else if (this.b.g() == 8) {
                this.c.b(k0.bindActionView(ActionView.Type.Template));
            } else {
                this.c.a(k0.bindActionView(ActionView.Type.Template));
            }
        } else if (this.b.g() == 8) {
            this.c.b(k0.bindActionView(ActionView.Type.Template));
        } else {
            this.c.a(k0.bindActionView(ActionView.Type.Template));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f30073a.addView(viewC, layoutParams);
        k0.renderAdContainer(this.f30073a, viewC);
        NativePrepareInfo nativePrepareInfo2 = new NativePrepareInfo();
        nativePrepareInfo2.setActivity(nativePrepareInfo.getActivity());
        if (this.d != 0 || nativePrepareInfo.getCtaViewList() == null || nativePrepareInfo.getCtaViewList().isEmpty()) {
            nativePrepareInfo2.setClickView(viewC);
        }
        nativePrepareInfo2.setCtaView((View[]) nativePrepareInfo.getCtaViewList().toArray(new View[0]));
        k0.prepare(nativePrepareInfo2);
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        C1415j c1415j2 = this.b;
        if (c1415j2 != null) {
            c1415j2.r = str;
            c1415j2.i = c1415j.i;
            c1415j2.b0 = c1415j.h;
            c1415j2.a0 = c1415j.i;
            c1415j2.c0 = c1415j.j;
        }
    }

    public L0 a(int i) {
        this.d = i;
        return this;
    }
}
