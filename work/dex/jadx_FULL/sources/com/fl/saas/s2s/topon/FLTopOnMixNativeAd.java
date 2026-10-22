package com.fl.saas.s2s.topon;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeAdView;
import com.fl.saas.api.mixNative.NativeEventListener;
import com.fl.saas.api.mixNative.NativePrepareInfo;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnMixNativeAd extends CustomNativeAd {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnInterstitialAdapter.class);
    private long loadSuccessTime = System.currentTimeMillis();
    private Context mContext;
    private NativeAd mNativeAd;
    private NativeAdView nativeAdView;

    public FLTopOnMixNativeAd(Context context, NativeAd nativeAd) {
        this.mContext = context;
        this.mNativeAd = nativeAd;
        setAdData();
    }

    public void clear(View view) {
        super.clear(view);
    }

    public void destroy() {
        super.destroy();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.release();
            this.mNativeAd = null;
        }
    }

    public Bitmap getAdLogo() {
        NativeAd nativeAd = this.mNativeAd;
        return nativeAd != null ? nativeAd.getAdMaterial().getAdLogo() : super.getAdLogo();
    }

    public View getAdMediaView(Object... objArr) {
        NativeAd nativeAd = this.mNativeAd;
        return nativeAd != null ? nativeAd.getAdMaterial().getAdMediaView() : super.getAdMediaView(objArr);
    }

    public ViewGroup getCustomAdContainer() {
        return this.nativeAdView;
    }

    public boolean isNativeExpress() {
        return this.mNativeAd.isNativeExpress();
    }

    public boolean isValid() {
        if (System.currentTimeMillis() - this.loadSuccessTime > 1800000) {
            return false;
        }
        return super.isValid();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        NativePrepareInfo nativePrepareInfo;
        if (this.mNativeAd != null) {
            if (isNativeExpress()) {
                if (view != null && (view.getContext() instanceof Activity)) {
                    this.mNativeAd.renderAdContainer(this.nativeAdView, null);
                    NativePrepareInfo nativePrepareInfo2 = new NativePrepareInfo();
                    nativePrepareInfo2.setActivity((Activity) view.getContext());
                    this.mNativeAd.prepare(nativePrepareInfo2);
                    return;
                }
                if (!(this.mContext instanceof Activity)) {
                    return;
                }
                this.mNativeAd.renderAdContainer(this.nativeAdView, null);
                nativePrepareInfo = new NativePrepareInfo();
                nativePrepareInfo.setActivity((Activity) this.mContext);
            } else {
                if (view != null && (view.getContext() instanceof Activity)) {
                    this.mNativeAd.renderAdContainer(this.nativeAdView, view);
                    NativePrepareInfo nativePrepareInfo3 = new NativePrepareInfo();
                    nativePrepareInfo3.setActivity((Activity) view.getContext());
                    nativePrepareInfo3.setCloseView(aTNativePrepareInfo.getCloseView());
                    List clickViewList = aTNativePrepareInfo.getClickViewList();
                    nativePrepareInfo3.setCtaView(aTNativePrepareInfo.getCtaView());
                    nativePrepareInfo3.setClickView((View[]) clickViewList.toArray(new View[0]));
                    this.mNativeAd.prepare(nativePrepareInfo3);
                    return;
                }
                if (!(this.mContext instanceof Activity)) {
                    return;
                }
                this.mNativeAd.renderAdContainer(this.nativeAdView, view);
                nativePrepareInfo = new NativePrepareInfo();
                nativePrepareInfo.setActivity((Activity) this.mContext);
                nativePrepareInfo.setCloseView(aTNativePrepareInfo.getCloseView());
                List clickViewList2 = aTNativePrepareInfo.getClickViewList();
                nativePrepareInfo.setCtaView(aTNativePrepareInfo.getCtaView());
                nativePrepareInfo.setClickView((View[]) clickViewList2.toArray(new View[0]));
            }
            this.mNativeAd.prepare(nativePrepareInfo);
        }
    }

    public void registerDownloadConfirmListener() {
        super.registerDownloadConfirmListener();
    }

    public void setAdData() {
        setTitle(this.mNativeAd.getAdMaterial().getTitle());
        setDescriptionText(this.mNativeAd.getAdMaterial().getDescription());
        setIconImageUrl(this.mNativeAd.getAdMaterial().getIconUrl());
        setMainImageUrl(this.mNativeAd.getAdMaterial().getMainImageUrl());
        setImageUrlList(this.mNativeAd.getAdMaterial().getImageUrlList());
        setCallToActionText(this.mNativeAd.getAdMaterial().getCallToAction());
        setVideoUrl(this.mNativeAd.getAdMaterial().getVideoUrl());
        setVideoDuration(this.mNativeAd.getAdMaterial().getVideoDuration());
        this.mNativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.s2s.topon.FLTopOnMixNativeAd.1
            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdClicked");
                FLTopOnMixNativeAd.this.notifyAdClicked();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdClose");
                FLTopOnMixNativeAd.this.notifyAdDislikeClick();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, YdError ydError) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdFailed");
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdImpressed");
                FLTopOnMixNativeAd.this.notifyAdImpression();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdVideoEnd");
                FLTopOnMixNativeAd.this.notifyAdVideoEnd();
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
                LogcatUtil.d(FLTopOnMixNativeAd.TAG, "onAdVideoStart");
                FLTopOnMixNativeAd.this.notifyAdVideoStart();
            }
        });
        if (this.nativeAdView == null) {
            this.nativeAdView = new NativeAdView(this.mContext);
        }
    }
}
