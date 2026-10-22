package com.fl.saas.base.inner.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.YdAdTempHelper;
import com.fl.saas.base.inner.interstitial.coustomView.NativeInterstitialView;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.StringUtils;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.SPUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeInterstitialAdapter extends AdViewInterstitialAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private MixNativeHandler handler;
    private InterstitialViewHelper interstitialHelper;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeInterstitialAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeInterstitialAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeInterstitialAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.interstitial.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1744a.lambda$onNativeAdLoaded$0(nativeAd);
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
        String str = getAdSource().display_effective_count;
        int i3 = getAdSource().close_button_interval;
        int i4 = getAdSource().close_button_freq;
        String[] strArrSplit = str.split(",");
        long j = SPUtil.getInstance().getLong("interstitialValue4");
        int i5 = SPUtil.getInstance().getInt("interstitialValue5");
        int i6 = SPUtil.getInstance().getInt("interstitialValue6");
        long j2 = SPUtil.getInstance().getLong("interstitialValue7");
        long bootTime = DeviceUtil.getBootTime();
        long j3 = bootTime - j;
        long j4 = bootTime - j2;
        int i7 = i5 + 1;
        SPUtil.getInstance().putInt("interstitialValue5", i7);
        if (j3 > 86400000 || j3 < 0) {
            SPUtil.getInstance().putInt("interstitialValue6", 0);
            SPUtil.getInstance().putLong("interstitialValue4", bootTime);
            SPUtil.getInstance().putInt("interstitialValue5", 1);
            i = 0;
            i2 = 1;
        } else {
            i = i6;
            i2 = i7;
        }
        if (TextUtils.isEmpty(str)) {
            if (j4 <= ((long) i3) * 60000) {
                SPUtil.getInstance().putInt("interstitialValue6", i + 1);
                SPUtil.getInstance().putLong("interstitialValue7", bootTime);
                return true;
            }
            SPUtil.getInstance().putInt("interstitialValue6", i + 1);
            SPUtil.getInstance().putLong("interstitialValue7", bootTime);
            return true;
        }
        if (StringUtils.containsField(strArrSplit, i2 + "")) {
            if ((j4 <= ((long) i3) * 60000 || j4 < 0) && i < i4) {
                SPUtil.getInstance().putInt("interstitialValue6", i + 1);
                SPUtil.getInstance().putLong("interstitialValue7", bootTime);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInterstitial$0(Activity activity) {
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(activity);
        nativePrepareInfo.setCtaView(this.interstitialHelper.getCATView());
        nativePrepareInfo.setClickView(this.interstitialHelper.getClicks());
        this.mNativeAd.prepare(nativePrepareInfo);
        if (this.interstitialHelper.showDialog(activity)) {
            return;
        }
        onAdFailed(YdError.create(20405, "Interstitial show Failed"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        InterstitialViewHelper interstitialViewHelper = new InterstitialViewHelper(getContext(), isFullScreenInterstitial(), nativeAd.getAdMaterial(), getAdSource().getInterstitialStyle(), new InterstitialViewEvent() { // from class: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter.2
            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onAdFailed(YdError ydError) {
                InnerNativeInterstitialAdapter.this.disposeError(ydError);
            }

            @Override // com.fl.saas.base.inner.interstitial.InterstitialViewEvent
            public void onDismiss() {
                InnerNativeInterstitialAdapter.this.onClosedEvent();
                if (InnerNativeInterstitialAdapter.this.mNativeAd != null) {
                    InnerNativeInterstitialAdapter.this.mNativeAd.destroy();
                }
            }

            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onLoaded(NativeInterstitialView nativeInterstitialView) {
                InnerNativeInterstitialAdapter.this.onLoadedEvent();
            }
        });
        this.interstitialHelper = interstitialViewHelper;
        nativeAd.renderAdContainer(interstitialViewHelper.getNativeAdView(), this.interstitialHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.interstitial.InnerNativeInterstitialAdapter.3
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                if (!InnerNativeInterstitialAdapter.this.changeReRequestCount()) {
                    if (!InnerNativeInterstitialAdapter.this.getAdSource().isAutoClose() || InnerNativeInterstitialAdapter.this.getAdSource().isDownLoad) {
                        InnerNativeInterstitialAdapter.this.interstitialHelper.click();
                    } else {
                        InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                    }
                    InnerNativeInterstitialAdapter.this.onClickedEvent();
                }
                InnerNativeInterstitialAdapter.this.closeTopCountDownView();
                InnerNativeInterstitialAdapter.this.reRequest();
                InnerNativeInterstitialAdapter.this.interstitialHelper.closeDialog();
                InnerNativeInterstitialAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeInterstitialAdapter.this.onAdFailed(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeInterstitialAdapter.this.onShowEvent();
                InnerNativeInterstitialAdapter.this.interstitialHelper.startCountdown();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
            }
        });
        this.interstitialHelper.setRainView(getAdSource().isRedPackageRain()).setClosePos(getAdSource().getCloseButtonPos()).setCloseViewSize(getAdSource().button_size).setCountDown(true ^ getAdSource().isCloseButtonShow(), getAdSource().count_down).setAutoClose(getAdSource().isAutoClose()).setClickType(getAdSource().only_button).setShakeType(getAdSource().isHotSpot() && getAdSource().hotspot_type == 2).setSpeed(getAdSource().sensitivity).setAnimalTime(getAdSource().animate_time).setAnimalStartTime(getAdSource().animate_start_time).setAdType(getClass().getName().contains("S2SInterstitialAdapter"));
        this.interstitialHelper.loadView();
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
        InterstitialViewHelper interstitialViewHelper = this.interstitialHelper;
        if (interstitialViewHelper != null) {
            interstitialViewHelper.destroy();
        }
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        Pair<Integer, Integer> interstitialSize = InterstitialViewHelper.getInterstitialSize();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedHeight(interstitialSize.second.intValue()).setImageAcceptedWidth(interstitialSize.first.intValue()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public boolean selfCloseInterstitialAd() {
        InterstitialViewHelper interstitialViewHelper = this.interstitialHelper;
        if (interstitialViewHelper == null) {
            return false;
        }
        interstitialViewHelper.closeDialog();
        return true;
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }

    @Override // com.fl.saas.base.adapter.AdViewInterstitialAdapter
    public void showInterstitial(Activity activity) {
        String str;
        if (isHasDestroy()) {
            str = "已经调用过销毁方法，无法展示";
        } else {
            if (getContext() != null || (activity != null && !activity.isFinishing())) {
                if (this.interstitialHelper != null) {
                    if (activity == null || activity.isFinishing()) {
                        this.interstitialHelper.setContext(getContext());
                    } else {
                        this.interstitialHelper.setContext(activity);
                    }
                    this.interstitialHelper.setViewType(checkStyle(), getAdSource().resp_area_ratio);
                    NativeAd nativeAd = this.mNativeAd;
                    if (nativeAd instanceof ActionView) {
                        this.interstitialHelper.addActionView(((ActionView) nativeAd).bindActionView(ActionView.Type.Interstitial));
                    }
                    String str2 = getAdSource().req_id;
                    YdAdTempHelper.getInstance().addListener(str2, new YdAdTempHelper.InterstitialActivityLoadListener() { // from class: com.zj.adlib.v94
                        @Override // com.fl.saas.base.inner.YdAdTempHelper.InterstitialActivityLoadListener
                        public final void onActivityCreate(Activity activity2) {
                            this.f45312a.lambda$showInterstitial$0(activity2);
                        }
                    });
                    Context context = activity;
                    if (getContext() == null) {
                        context = getContext();
                    }
                    YdInterstitialActivity.startMe(context, str2);
                    return;
                }
                return;
            }
            str = "Interstitial show Failed";
        }
        onAdFailed(YdError.create(20405, str));
    }
}
