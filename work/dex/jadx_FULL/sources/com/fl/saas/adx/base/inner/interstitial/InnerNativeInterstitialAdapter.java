package com.fl.saas.adx.base.inner.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1405e;
import com.fl.saas.AbstractC1418k0;
import com.fl.saas.C1415j;
import com.fl.saas.S0;
import com.fl.saas.a1;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.activity.FLInterstitialActivity;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bidding.C2SBiddingECPM;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.FLAdTempHelper;
import com.fl.saas.adx.base.inner.InnerNativeAdapter;
import com.fl.saas.adx.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.adx.base.innterNative.ActionView;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.innterNative.NativeStyle;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.b1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeInterstitialAdapter extends AbstractC1405e implements InnerNativeAdapter, AdChangeCacheData {
    private AbstractC1418k0 handler;
    private InterstitialViewHelper interstitialHelper;
    private boolean loadCallbackNeedShow = false;
    private NativeAd mNativeAd;
    private InterstitialViewEvent viewEvent;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.interstitial.InnerNativeInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeInterstitialAdapter.this.handler));
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            InnerNativeInterstitialAdapter.this.disposeError(fLError);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeInterstitialAdapter innerNativeInterstitialAdapter = InnerNativeInterstitialAdapter.this;
            innerNativeInterstitialAdapter.setAdSource(innerNativeInterstitialAdapter.handler.getAdSource());
            InnerNativeInterstitialAdapter.this.bindC2SBidECPM(new b1() { // from class: com.fl.saas.adx.base.inner.interstitial.a
                @Override // com.fl.saas.b1
                public final Object a() {
                    return this.f1737a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeInterstitialAdapter.this.mNativeAd = nativeAd;
            InnerNativeInterstitialAdapter.this.render(nativeAd);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x009f  */
    private boolean checkStyle() {
        int i;
        int i2;
        String str = getAdSource().L;
        int i3 = getAdSource().K;
        int i4 = getAdSource().J;
        String[] strArrSplit = str.split(",");
        long jB = S0.a().b("interstitialValue4");
        int iA = S0.a().a("interstitialValue5");
        int iA2 = S0.a().a("interstitialValue6");
        long jB2 = S0.a().b("interstitialValue7");
        long bootTime = DeviceUtil.getBootTime();
        long j = bootTime - jB;
        long j2 = bootTime - jB2;
        int i5 = iA + 1;
        S0.a().b("interstitialValue5", i5);
        if (j > 86400000 || j < 0) {
            S0.a().b("interstitialValue6", 0);
            S0.a().b("interstitialValue4", bootTime);
            S0.a().b("interstitialValue5", 1);
            i = 0;
            i2 = 1;
        } else {
            i = iA2;
            i2 = i5;
        }
        if (TextUtils.isEmpty(str)) {
            if (j2 <= ((long) i3) * 60000) {
                S0.a().b("interstitialValue6", i + 1);
                S0.a().b("interstitialValue7", bootTime);
                return true;
            }
            S0.a().b("interstitialValue6", i + 1);
            S0.a().b("interstitialValue7", bootTime);
            return true;
        }
        if (a1.a(strArrSplit, i2 + "")) {
            if ((j2 <= ((long) i3) * 60000 || j2 < 0) && i < i4) {
                S0.a().b("interstitialValue6", i + 1);
                S0.a().b("interstitialValue7", bootTime);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$render$0() {
        if (canUseEcpm()) {
            return getAdSource().f();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (nativeAd instanceof BaseNativeAd) {
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.zj.adlib.w94
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f45552a.lambda$render$0();
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.adx.base.inner.interstitial.InnerNativeInterstitialAdapter.2
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(InnerNativeInterstitialAdapter.this.getAdSource().p, InnerNativeInterstitialAdapter.this.getAdSource().q, InnerNativeInterstitialAdapter.this.getAdSource().j, InnerNativeInterstitialAdapter.this.getAdSource().k);
                }

                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public C1415j getSource() {
                    return InnerNativeInterstitialAdapter.this.getAdSource();
                }
            });
        }
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        if (DeviceUtil.filling_timing == 0) {
            if (ViewHelper.checkMateria(adMaterial)) {
                onLoadedEvent();
            } else {
                disposeError(FLError.create(20405, "media and imgUrl is empty"));
            }
        }
        boolean zIsFullScreenInterstitial = isFullScreenInterstitial();
        if (this.viewEvent == null) {
            this.viewEvent = new InterstitialViewEvent() { // from class: com.fl.saas.adx.base.inner.interstitial.InnerNativeInterstitialAdapter.3
                @Override // com.fl.saas.adx.base.inner.interstitial.InterstitialViewEvent
                public void onActivityShow(Activity activity) {
                    NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                    nativePrepareInfo.setActivity(activity);
                    nativePrepareInfo.setCtaView(InnerNativeInterstitialAdapter.this.interstitialHelper.getCATView());
                    nativePrepareInfo.setClickView(InnerNativeInterstitialAdapter.this.interstitialHelper.getClicks());
                    InnerNativeInterstitialAdapter.this.mNativeAd.prepare(nativePrepareInfo);
                }

                @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
                public void onAdFailed(FLError fLError) {
                    InnerNativeInterstitialAdapter.this.disposeError(fLError);
                }

                @Override // com.fl.saas.adx.base.inner.interstitial.InterstitialViewEvent
                public void onDismiss() {
                    InnerNativeInterstitialAdapter.this.onClosedEvent();
                    if (InnerNativeInterstitialAdapter.this.mNativeAd != null) {
                        InnerNativeInterstitialAdapter.this.mNativeAd.release();
                    }
                }

                @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
                public void onLoaded(NativeInterstitialView nativeInterstitialView) {
                    if (DeviceUtil.filling_timing != 0) {
                        InnerNativeInterstitialAdapter.this.onLoadedEvent();
                    } else if (InnerNativeInterstitialAdapter.this.loadCallbackNeedShow) {
                        InnerNativeInterstitialAdapter innerNativeInterstitialAdapter = InnerNativeInterstitialAdapter.this;
                        innerNativeInterstitialAdapter.startInterstitialActivity(innerNativeInterstitialAdapter.getContext());
                    }
                }
            };
        }
        InterstitialViewHelper interstitialViewHelper = new InterstitialViewHelper(getContext(), zIsFullScreenInterstitial, adMaterial, getAdSource().h(), this.viewEvent);
        this.interstitialHelper = interstitialViewHelper;
        interstitialViewHelper.setAlpha(getAdSource().n);
        nativeAd.renderAdContainer(this.interstitialHelper.getNativeAdView(), this.interstitialHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.adx.base.inner.interstitial.InnerNativeInterstitialAdapter.4
            private boolean isReportExposure = false;

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                if (!InnerNativeInterstitialAdapter.this.changeReRequestCount()) {
                    if (!InnerNativeInterstitialAdapter.this.getAdSource().l() || InnerNativeInterstitialAdapter.this.getAdSource().k0) {
                        InnerNativeInterstitialAdapter.this.interstitialHelper.click();
                    } else {
                        InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                    }
                    InnerNativeInterstitialAdapter.this.onClickedEvent();
                }
                InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                InnerNativeInterstitialAdapter.this.reRequest();
                InnerNativeInterstitialAdapter.this.interstitialHelper.closeInterstitial();
                InnerNativeInterstitialAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
                InnerNativeInterstitialAdapter.this.onAdFailed(fLError);
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeInterstitialAdapter.this.onShowEvent();
                InnerNativeInterstitialAdapter.this.interstitialHelper.startCountdown();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
            }
        });
        this.interstitialHelper.setClosePos(getAdSource().d()).setCloseViewSize(getAdSource().w).setCountDown(true ^ getAdSource().m(), getAdSource().v).setAutoClose(getAdSource().l()).setClickType(getAdSource().H).setShakeType(getAdSource().p() && getAdSource().C == 2).setSpeed(getAdSource().x).setAnimalTime(getAdSource().O).setAnimalStartTime(getAdSource().N);
        this.interstitialHelper.loadView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInterstitialActivity(Context context) {
        this.loadCallbackNeedShow = false;
        this.interstitialHelper.setViewType(checkStyle(), getAdSource().I);
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof ActionView) {
            this.interstitialHelper.addActionView(((ActionView) nativeAd).bindActionView(ActionView.Type.Interstitial));
        }
        String str = getAdSource().g;
        FLAdTempHelper.getInstance().addInterstitialHelper(str, this.interstitialHelper);
        FLInterstitialActivity.startMe(context, str);
    }

    @Override // com.fl.saas.AbstractC1405e, com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
        this.viewEvent = null;
        InterstitialViewHelper interstitialViewHelper = this.interstitialHelper;
        if (interstitialViewHelper != null) {
            interstitialViewHelper.destroy();
        }
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.AbstractC1423n
    public void handle(Context context) {
        LogcatUtil.d("handle");
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).a(getAppId(), getPosId()).setLinkId(getLinkId()).a(new AdParams.Builder(getKey()).setIsMixNative(false).build()).a(new AnonymousClass1());
        this.handler.a(NativeStyle.NATIVE);
        this.handler.a(isHot());
        this.handler.a(context);
    }

    @Override // com.fl.saas.AbstractC1405e
    public boolean selfCloseInterstitialAd() {
        InterstitialViewHelper interstitialViewHelper = this.interstitialHelper;
        if (interstitialViewHelper == null) {
            return false;
        }
        interstitialViewHelper.closeInterstitial();
        return true;
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, c1415j);
        }
    }

    @Override // com.fl.saas.AbstractC1405e
    public void showInterstitial(Activity activity) {
        if (activity != null) {
            setContext((Context) activity);
        }
        Context context = activity;
        if (this.interstitialHelper == null) {
            this.loadCallbackNeedShow = true;
            return;
        }
        if (activity == null) {
            context = getContext();
        }
        startInterstitialActivity(context);
    }
}
