package com.fl.saas.adx.base.inner.banner;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1403d;
import com.fl.saas.AbstractC1418k0;
import com.fl.saas.C1415j;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bidding.C2SBiddingECPM;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.InnerNativeAdapter;
import com.fl.saas.adx.base.inner.InnerNativeView;
import com.fl.saas.adx.base.innterNative.ActionView;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.innterNative.NativeStyle;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.b1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeBannerAdapter extends AbstractC1403d implements InnerNativeAdapter, AdChangeCacheData {
    private BannerViewHelper bannerViewHelper;
    private AbstractC1418k0 handler;
    private int height;
    private NativeAd mNativeAd;
    private int width;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.banner.InnerNativeBannerAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeBannerAdapter.this.handler));
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            InnerNativeBannerAdapter.this.disposeError(fLError);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeBannerAdapter innerNativeBannerAdapter = InnerNativeBannerAdapter.this;
            innerNativeBannerAdapter.setAdSource(innerNativeBannerAdapter.handler.getAdSource());
            InnerNativeBannerAdapter.this.bindC2SBidECPM(new b1() { // from class: com.fl.saas.adx.base.inner.banner.a
                @Override // com.fl.saas.b1
                public final Object a() {
                    return this.f1736a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeBannerAdapter.this.mNativeAd = nativeAd;
            InnerNativeBannerAdapter.this.render(nativeAd);
        }
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
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.zj.adlib.u94
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f45095a.lambda$render$0();
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.adx.base.inner.banner.InnerNativeBannerAdapter.2
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(InnerNativeBannerAdapter.this.getAdSource().p, InnerNativeBannerAdapter.this.getAdSource().q, InnerNativeBannerAdapter.this.getAdSource().j, InnerNativeBannerAdapter.this.getAdSource().k);
                }

                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public C1415j getSource() {
                    return InnerNativeBannerAdapter.this.getAdSource();
                }
            });
        }
        this.bannerViewHelper = new BannerViewHelper(getContext(), nativeAd.getAdMaterial(), this.width, this.height, new BannerViewEvent() { // from class: com.fl.saas.adx.base.inner.banner.InnerNativeBannerAdapter.3
            @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
            public void onAdFailed(FLError fLError) {
                InnerNativeBannerAdapter.this.disposeError(fLError);
            }

            @Override // com.fl.saas.adx.base.inner.banner.BannerViewEvent
            public void onDismiss() {
                InnerNativeBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
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
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.adx.base.inner.banner.InnerNativeBannerAdapter.4
            private boolean isReportExposure = false;

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeBannerAdapter.this.onClickedEvent();
                if (InnerNativeBannerAdapter.this.bannerViewHelper != null) {
                    InnerNativeBannerAdapter.this.bannerViewHelper.onClicked();
                }
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeBannerAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
                InnerNativeBannerAdapter.this.onAdFailed(fLError);
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeBannerAdapter.this.onShowEvent();
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
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.AbstractC1423n
    public void handle(Context context) {
        this.handler = loadNativeHandler();
        this.width = DeviceUtil.dip2px(getWidth());
        this.height = DeviceUtil.dip2px(getHeight());
        this.handler.setContext(getContext()).a(getAppId(), getPosId()).setLinkId(getLinkId()).a(new AdParams.Builder(getKey()).setIsMixNative(false).build()).a(new AnonymousClass1());
        this.handler.a(isHot());
        this.handler.a(NativeStyle.NATIVE);
        this.handler.a(context);
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, c1415j);
        }
    }
}
