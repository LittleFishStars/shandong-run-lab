package com.fl.saas.base.inner.banner;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewBannerAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.base.innterNative.ActionView;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeBannerAdapter extends AdViewBannerAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private BannerViewHelper bannerViewHelper;
    private MixNativeHandler handler;
    private int height;
    private NativeAd mNativeAd;
    private int width;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.banner.InnerNativeBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeBannerAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeBannerAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeBannerAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.banner.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1743a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeBannerAdapter.this.mNativeAd = nativeAd;
            InnerNativeBannerAdapter.this.render(nativeAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        this.bannerViewHelper = new BannerViewHelper(getContext(), nativeAd.getAdMaterial(), this.width, this.height, new BannerViewEvent() { // from class: com.fl.saas.base.inner.banner.InnerNativeBannerAdapter.2
            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onAdFailed(YdError ydError) {
                InnerNativeBannerAdapter.this.disposeError(ydError);
            }

            @Override // com.fl.saas.base.inner.banner.BannerViewEvent
            public void onDismiss() {
                InnerNativeBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.base.inner.InnerViewLoaderEvent
            public void onLoaded(InnerNativeView innerNativeView) {
                View viewBindActionView;
                try {
                    NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
                    nativePrepareInfo.setActivity(InnerNativeBannerAdapter.this.getActivityOrNull());
                    nativePrepareInfo.setClickView(innerNativeView.getClicks());
                    if ((InnerNativeBannerAdapter.this.mNativeAd instanceof ActionView) && (viewBindActionView = ((ActionView) InnerNativeBannerAdapter.this.mNativeAd).bindActionView(ActionView.Type.Banner)) != null && innerNativeView.getSelfView() != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams.gravity = 17;
                        innerNativeView.getSelfView().addView(viewBindActionView, layoutParams);
                    }
                    if (InnerNativeBannerAdapter.this.mNativeAd != null) {
                        InnerNativeBannerAdapter.this.mNativeAd.renderAdContainer(innerNativeView.getNativeAdView(), innerNativeView.getSelfView());
                        InnerNativeBannerAdapter.this.mNativeAd.prepare(nativePrepareInfo);
                    }
                    InnerNativeBannerAdapter.this.onLoadedEvent(innerNativeView.getNativeAdView());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.banner.InnerNativeBannerAdapter.3
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeBannerAdapter.this.onClickedEvent();
                if (InnerNativeBannerAdapter.this.bannerViewHelper != null) {
                    InnerNativeBannerAdapter.this.bannerViewHelper.onClicked();
                }
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeBannerAdapter.this.onAdFailed(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeBannerAdapter.this.onShowEvent();
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
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        this.handler = loadNativeHandler();
        this.width = DeviceUtil.dip2px(getWidth());
        this.height = DeviceUtil.dip2px(getHeight());
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setImageAcceptedHeight(this.height).setImageAcceptedWidth(Math.round(this.width * 0.3f)).build()).setLoadListener(new AnonymousClass1());
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
