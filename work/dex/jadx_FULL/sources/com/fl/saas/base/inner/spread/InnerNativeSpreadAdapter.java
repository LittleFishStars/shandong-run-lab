package com.fl.saas.base.inner.spread;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.base.interfaces.AdMaterialJson;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.StringUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.SPUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeSpreadAdapter extends AdViewSpreadAdapter implements InnerNativeAdapter, AdMaterialJson, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeSpreadAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeSpreadAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeSpreadAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.spread.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1750a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeSpreadAdapter.this.mNativeAd = nativeAd;
            InnerNativeSpreadAdapter.this.render(nativeAd);
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter$2, reason: invalid class name */
    public class AnonymousClass2 implements SpreadViewEvent {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onLoaded$0(NativeSpreadView nativeSpreadView, ViewGroup viewGroup) {
            View viewBindActionView;
            if (InnerNativeSpreadAdapter.this.getContext() == null) {
                onAdFailed(YdError.create(20405, "Spread show Failed"));
                return;
            }
            nativeSpreadView.setContext(InnerNativeSpreadAdapter.this.getContext());
            if (InnerNativeSpreadAdapter.this.mNativeAd instanceof ActionView) {
                viewBindActionView = ((ActionView) InnerNativeSpreadAdapter.this.mNativeAd).bindActionView(ActionView.Type.Spread);
                if (viewBindActionView != null) {
                    nativeSpreadView.getSelfView().addView(viewBindActionView);
                }
            } else {
                viewBindActionView = null;
            }
            nativeSpreadView.setViewType(InnerNativeSpreadAdapter.this.getAdSource().display_countdown == 1, InnerNativeSpreadAdapter.this.checkStyle(), InnerNativeSpreadAdapter.this.getAdSource().resp_area_ratio);
            nativeSpreadView.setClickAreaVisibility(InnerNativeSpreadAdapter.this.getAdSource().isHotSpot(), viewBindActionView);
            nativeSpreadView.setRainView(InnerNativeSpreadAdapter.this.getAdSource().isRedPackageRain());
            nativeSpreadView.show();
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            nativePrepareInfo.setActivity(InnerNativeSpreadAdapter.this.getActivityOrNull());
            nativePrepareInfo.setCtaView(nativeSpreadView.getCATView());
            nativePrepareInfo.setClickView(nativeSpreadView.getClicks());
            InnerNativeSpreadAdapter.this.mNativeAd.prepare(nativePrepareInfo);
            viewGroup.addView(nativeSpreadView.getNativeAdView(), ViewHelper.getMatchParent());
        }

        @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
        public void onAdFailed(YdError ydError) {
            InnerNativeSpreadAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.base.inner.spread.SpreadViewEvent
        public void onDismiss() {
            InnerNativeSpreadAdapter.this.onClosedEvent();
        }

        @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
        public void onLoaded(final NativeSpreadView nativeSpreadView) {
            InnerNativeSpreadAdapter.this.onSpreadLoadedEvent(null, new AdViewSpreadAdapter.AdViewLoadListener() { // from class: com.fl.saas.base.inner.spread.b
                @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter.AdViewLoadListener
                public final void AdViewLoad(ViewGroup viewGroup) {
                    this.f30132a.lambda$onLoaded$0(nativeSpreadView, viewGroup);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x009f  */
    public boolean checkStyle() {
        int i;
        int i2;
        String str = getAdSource().display_effective_count;
        int i3 = getAdSource().close_button_interval;
        int i4 = getAdSource().close_button_freq;
        String[] strArrSplit = str.split(",");
        long j = SPUtil.getInstance().getLong("value4");
        int i5 = SPUtil.getInstance().getInt("value5");
        int i6 = SPUtil.getInstance().getInt("value6");
        long j2 = SPUtil.getInstance().getLong("value7");
        long bootTime = DeviceUtil.getBootTime();
        long j3 = bootTime - j;
        long j4 = bootTime - j2;
        int i7 = i5 + 1;
        SPUtil.getInstance().putInt("value5", i7);
        if (j3 > 86400000 || j3 < 0) {
            SPUtil.getInstance().putInt("value6", 0);
            SPUtil.getInstance().putLong("value4", bootTime);
            SPUtil.getInstance().putInt("value5", 1);
            i = 0;
            i2 = 1;
        } else {
            i = i6;
            i2 = i7;
        }
        if (TextUtils.isEmpty(str)) {
            if (j4 <= ((long) i3) * 60000) {
                SPUtil.getInstance().putInt("value6", i + 1);
                SPUtil.getInstance().putLong("value7", bootTime);
                return true;
            }
            SPUtil.getInstance().putInt("value6", i + 1);
            SPUtil.getInstance().putLong("value7", bootTime);
            return true;
        }
        if (StringUtils.containsField(strArrSplit, i2 + "")) {
            if ((j4 <= ((long) i3) * 60000 || j4 < 0) && i < i4) {
                SPUtil.getInstance().putInt("value6", i + 1);
                SPUtil.getInstance().putLong("value7", bootTime);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (getContext() == null) {
            onAdFailed(YdError.create(20405, "Spread show Failed"));
            return;
        }
        final SpreadViewHelper spreadViewHelper = new SpreadViewHelper(getContext(), nativeAd.getAdMaterial(), new AnonymousClass2());
        nativeAd.renderAdContainer(spreadViewHelper.getNativeAdView(), spreadViewHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter.3
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClickedEvent();
                spreadViewHelper.onClicked();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeSpreadAdapter.this.onAdFailed(ydError);
                spreadViewHelper.cancelCountdown();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                spreadViewHelper.startCountdown();
                InnerNativeSpreadAdapter.this.onShowEvent();
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
        nativeAd.setClickCallBackListener(new NativeClickCallbackListener() { // from class: com.fl.saas.base.inner.spread.InnerNativeSpreadAdapter.4
            @Override // com.fl.saas.api.mixNative.NativeClickCallbackListener
            public void onAdClicked(String str) {
                InnerNativeSpreadAdapter.this.onClickedEvent(str);
            }
        });
        spreadViewHelper.initView();
    }

    @Override // com.fl.saas.base.adapter.AdViewSpreadAdapter, com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.interfaces.AdMaterialJson
    @Nullable
    public String getMaterialJson() {
        NativeAd nativeAd = this.mNativeAd;
        return nativeAd != null ? nativeAd.getMaterialJson() : "";
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedHeight(getHeightPX()).setImageAcceptedWidth(getWidthPX()).build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.NATIVE);
        this.handler.init();
        this.handler.load(activity);
    }

    @Override // com.fl.saas.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, AdSource adSource) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, adSource);
        }
    }
}
