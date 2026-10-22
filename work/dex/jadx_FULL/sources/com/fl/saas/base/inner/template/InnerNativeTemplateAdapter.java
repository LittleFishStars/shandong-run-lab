package com.fl.saas.base.inner.template;

import android.app.Activity;
import android.view.View;
import androidx.annotation.Nullable;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.base.adapter.AdViewTemplateAdapter;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.bidding.C2SBiddingECPM;
import com.fl.saas.base.inner.InnerNativeAdapter;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.interfaces.AdChangeCacheData;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Supplier;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeTemplateAdapter extends AdViewTemplateAdapter implements InnerNativeAdapter, AdChangeCacheData {
    private final String TAG = CommConstant.getObjTag(this);
    private MixNativeHandler handler;
    private NativeAd mNativeAd;

    /* JADX INFO: renamed from: com.fl.saas.base.inner.template.InnerNativeTemplateAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeTemplateAdapter.this.handler));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            InnerNativeTemplateAdapter.this.disposeError(ydError);
        }

        @Override // com.fl.saas.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeTemplateAdapter.this.bindC2SBidECPM(new Supplier() { // from class: com.fl.saas.base.inner.template.a
                @Override // com.fl.saas.common.util.feature.Supplier
                public final Object get() {
                    return this.f1752a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeTemplateAdapter.this.mNativeAd = nativeAd;
            InnerNativeTemplateAdapter.this.render(nativeAd);
        }
    }

    private void bindEvent(NativeAd nativeAd) {
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.base.inner.template.InnerNativeTemplateAdapter.2
            private boolean isReportExposure = false;

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeTemplateAdapter.this.onClickedEvent(0);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeTemplateAdapter.this.onClosedEvent(nativeAdView);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                InnerNativeTemplateAdapter.this.onAdFailed(ydError);
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                InnerNativeTemplateAdapter.this.onShowEvent(0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (!nativeAd.isNativeExpress()) {
            LogcatUtil.d(this.TAG, "is not express ad");
            disposeError(YdError.create(20405, "is not express ad"));
            return;
        }
        bindEvent(nativeAd);
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        NativeAdView nativeAdView = new NativeAdView(getContext());
        nativeAd.renderAdContainer(nativeAdView, null);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(getActivityOrNull());
        nativeAd.prepare(nativePrepareInfo);
        ArrayList arrayList = new ArrayList();
        View adMediaView = adMaterial.getAdMediaView();
        if (adMediaView == null) {
            LogcatUtil.d(this.TAG, "MediaView is empty");
            disposeError(YdError.create(20405, "MediaView is empty"));
        } else {
            ViewHelper.removeParent(adMediaView);
            nativeAdView.addView(adMediaView, ViewHelper.getMatchParent());
            arrayList.add(nativeAdView);
            onLoadedEvent(arrayList);
        }
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
        this.handler.setContext(getContext()).setAdId(getAppId(), getPosId()).setAdSource(getAdSource()).setAdParams(new AdParams.Builder(getKey()).setExpressHeight(getHeight()).setExpressWidth(getWidth()).setExpressFullWidth().setExpressAutoHeight().build()).setLoadListener(new AnonymousClass1());
        this.handler.setAdStyle(NativeStyle.EXPRESS);
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
