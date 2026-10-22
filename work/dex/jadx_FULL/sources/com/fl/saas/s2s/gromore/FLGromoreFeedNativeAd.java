package com.fl.saas.s2s.gromore;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdAppInfo;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativeMaterial;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreFeedNativeAd extends MediationCustomNativeAd {
    private static final String TAG = CommConstant.getClassTag("FLGromoreFeedNativeAd", FLGromoreFullVideoLoader.class);
    private NativeAdView expressView;
    private boolean hasBackDisplay = false;
    private Context mContext;
    private NativeAd mNativeAd;
    private FrameLayout mediaView;

    public FLGromoreFeedNativeAd(NativeAd nativeAd, Context context) {
        int i = -1;
        if (nativeAd == null || !(context instanceof Activity)) {
            callRenderFail(null, -1, "context fail,need activity");
            return;
        }
        this.mNativeAd = nativeAd;
        this.mContext = context;
        if (nativeAd.isNativeExpress()) {
            setExpressAd(true);
        } else {
            setExpressAd(false);
            NativeMaterial adMaterial = nativeAd.getAdMaterial();
            if (adMaterial != null) {
                View adMediaView = adMaterial.getAdMediaView();
                if (adMediaView != null) {
                    FrameLayout frameLayout = new FrameLayout(context);
                    this.mediaView = frameLayout;
                    frameLayout.addView(adMediaView);
                }
                setTitle(adMaterial.getTitle());
                setDescription(adMaterial.getDescription());
                setImageUrl(adMaterial.getMainImageUrl());
                setImageWidth(adMaterial.getSize().getWidth());
                setImageHeight(adMaterial.getSize().getHeight());
                setActionText(adMaterial.getCallToAction());
                setImageList(adMaterial.getImageUrlList());
                setInteractionType(adMaterial.isNativeAppAd() ? 4 : 2);
                int adType = adMaterial.getAdType();
                if (adType == 3) {
                    i = 5;
                } else if (adType == 1) {
                    i = 2;
                } else if (adType == 2) {
                    i = 4;
                }
                setAdImageMode(i);
                NativeAdAppInfo adAppInfo = adMaterial.getAdAppInfo();
                if (adAppInfo != null) {
                    setNativeAdAppInfo(getMediationNativeAdAppInfo(adAppInfo));
                }
            }
        }
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreFeedNativeAd.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdClicked");
                FLGromoreFeedNativeAd.this.callAdClick();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdClose");
                FLGromoreFeedNativeAd.this.callDislikeSelected(-1, "点击关闭");
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdFailed");
                FLGromoreFeedNativeAd.this.callRenderFail(null, ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdImpressed");
                if (FLGromoreFeedNativeAd.this.hasBackDisplay) {
                    return;
                }
                FLGromoreFeedNativeAd.this.hasBackDisplay = true;
                FLGromoreFeedNativeAd.this.callAdShow();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdVideoEnd");
                FLGromoreFeedNativeAd.this.callVideoCompleted();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                LogcatUtil.d(FLGromoreFeedNativeAd.TAG, "onAdVideoStart");
                FLGromoreFeedNativeAd.this.callVideoStart();
            }
        });
    }

    private void checkExpressView() {
        NativeAd nativeAd;
        if (this.expressView != null || (nativeAd = this.mNativeAd) == null || nativeAd.getAdMaterial() == null) {
            return;
        }
        NativeAdView nativeAdView = new NativeAdView(this.mContext);
        this.expressView = nativeAdView;
        nativeAdView.addView(this.mNativeAd.getAdMaterial().getAdMediaView());
    }

    private static MediationNativeAdAppInfo getMediationNativeAdAppInfo(NativeAdAppInfo nativeAdAppInfo) {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = new MediationNativeAdAppInfo();
        mediationNativeAdAppInfo.setAppName(nativeAdAppInfo.getAppName());
        mediationNativeAdAppInfo.setAuthorName(nativeAdAppInfo.getPublisher());
        mediationNativeAdAppInfo.setFunctionDescUrl(nativeAdAppInfo.getFunctionUrl());
        mediationNativeAdAppInfo.setPermissionsUrl(nativeAdAppInfo.getAppPermissionUrl());
        mediationNativeAdAppInfo.setPrivacyAgreement(nativeAdAppInfo.getAppPrivacyUrl());
        mediationNativeAdAppInfo.setVersionName(nativeAdAppInfo.getAppVersion());
        return mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        checkExpressView();
        return this.expressView;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd
    public View getVideoView() {
        return this.mediaView;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
        super.onDestroy();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.release();
            this.mNativeAd = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        super.registerView(activity, viewGroup, list, list2, list3, mediationViewBinder);
        if (this.expressView == null) {
            this.expressView = new NativeAdView(activity);
        }
        if (this.mNativeAd == null) {
            callRenderFail(null, 111, "render fail");
            return;
        }
        ViewHelper.removeParent(this.expressView);
        ViewParent parent = viewGroup.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) parent;
            viewGroup2.removeView(viewGroup);
            this.expressView.addView(viewGroup);
            viewGroup2.addView(this.expressView);
        }
        this.mNativeAd.renderAdContainer(this.expressView, viewGroup);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity(activity);
        if (list != null) {
            nativePrepareInfo.setClickView((View[]) list.toArray(new View[0]));
        }
        if (list2 != null) {
            nativePrepareInfo.setCtaView((View[]) list2.toArray(new View[0]));
        }
        this.mNativeAd.prepare(nativePrepareInfo);
        callRenderSuccess(-1.0f, -2.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        NativeAdView nativeAdView;
        super.render();
        checkExpressView();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd == null || (nativeAdView = this.expressView) == null) {
            callRenderFail(null, 111, "render fail");
            return;
        }
        nativeAd.renderAdContainer(nativeAdView, null);
        NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
        nativePrepareInfo.setActivity((Activity) this.mContext);
        this.mNativeAd.prepare(nativePrepareInfo);
        callRenderSuccess(-1.0f, -2.0f);
    }
}
