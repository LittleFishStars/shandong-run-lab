package com.bwt.top.ad.adapter;

import android.text.TextUtils;
import com.bwt.top.AdSdk;
import com.bwt.top.BannerAd;
import com.bwt.top.InterstitialAd;
import com.bwt.top.NativeAd;
import com.bwt.top.SplashAd;
import com.bwt.top.UnifiedAD;
import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.BaseAd;
import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.ad.report.BaseReport;
import com.bwt.top.api.FunctionConfig;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.custom_ad.CustomReport;
import com.bwt.top.custom_ad.http.CustomAdPosInfoManger;
import com.bwt.top.custom_ad.http.CustomAdPosResult;
import com.bwt.top.custom_ad.http.CustomRequestCallback;
import com.bwt.top.exception.AdError;
import com.bwt.top.h5.AdSdkH5Helper;
import com.bwt.top.image.ImageLoaderImp;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterCustomAdLoader<V extends AdInfo, Y extends AdListener<V>, T extends BaseAd<Y>> extends AdapterAdLoaderImp<V, Y, T> {
    protected CustomAdPosResult mAdObject;
    protected ImageLoaderImp mImageLoader;
    private BaseReport mReport;

    public class a extends CustomRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1466a;

        public a(boolean z) {
            this.f1466a = z;
        }

        @Override // com.bwt.top.custom_ad.http.CustomRequestCallback
        public void onFailed(AdError adError) {
            if (adError != null) {
                adError.log();
            }
            AdapterCustomAdLoader.this.callbackFail();
        }

        @Override // com.bwt.top.custom_ad.http.CustomRequestCallback
        public void onSucceed(CustomAdPosResult customAdPosResult) {
            AdapterCustomAdLoader.this.mAdObject = customAdPosResult;
            customAdPosResult.setDownload(this.f1466a);
            AdapterCustomAdLoader.this.callbackSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackFail() {
        handleAdLoaderCallback(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackSuccess() {
        if (this.mAd == null || this.mAdObject == null || getContext() == null || this.mIsReleased) {
            callbackFail();
            return;
        }
        this.mReport = createAdReport();
        readyAdView();
        this.mImageLoader = new ImageLoaderImp(getContext(), this.TAG);
        handleAdLoaderCallback(true);
        onAdReceiveListener();
    }

    private BaseReport createAdReport() {
        return new CustomReport(this.mAdObject);
    }

    private int getAdType() {
        T t = this.mAd;
        if (t == null || (t instanceof BannerAd)) {
            return 3;
        }
        if (t instanceof SplashAd) {
            return 1;
        }
        if (t instanceof InterstitialAd) {
            return 4;
        }
        return ((t instanceof NativeAd) || (t instanceof UnifiedAD)) ? 2 : 3;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void adClick() {
        CustomAdPosResult customAdPosResult;
        BaseReport baseReport;
        super.adClick();
        BaseReport baseReport2 = this.mReport;
        if (baseReport2 != null) {
            baseReport2.clickReport();
        }
        if (this.mIsReleased || (customAdPosResult = this.mAdObject) == null) {
            return;
        }
        String deeplink = customAdPosResult.getDeeplink();
        if (TextUtils.isEmpty(deeplink)) {
            skipAd();
            return;
        }
        BaseReport baseReport3 = this.mReport;
        if (baseReport3 != null) {
            baseReport3.deepLinkReport();
        }
        boolean zSkipDeeplink = AdSdkH5Helper.skipDeeplink(deeplink, (this.mAdObject.getCtype() != 7 || TextUtils.isEmpty(this.mAdObject.getStorePkg())) ? "" : this.mAdObject.getStorePkg());
        if (zSkipDeeplink && (baseReport = this.mReport) != null) {
            baseReport.deepLinkSuccessReport();
        } else {
            if (zSkipDeeplink) {
                return;
            }
            BaseReport baseReport4 = this.mReport;
            if (baseReport4 != null) {
                baseReport4.deepLinkFailReport();
            }
            skipAd();
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public boolean checkRenderView() {
        super.checkRenderView();
        return (this.mAdObject == null || this.mImageLoader == null) ? false : true;
    }

    public void deeplinkSuccess() {
    }

    public void displayReport() {
        BaseReport baseReport = this.mReport;
        if (baseReport != null) {
            baseReport.displayReport();
        }
    }

    public String getJumpUrl() {
        return this.mAdObject.getJumpPage();
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void onAdExposeListener() {
        super.onAdExposeListener();
    }

    public void readyAdView() {
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp, com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        this.mAdObject = null;
        ImageLoaderImp imageLoaderImp = this.mImageLoader;
        if (imageLoaderImp != null) {
            imageLoaderImp.release();
        }
        ALog.i(this.TAG, "release .........");
    }

    public void skipAd() {
        if (this.mAdObject == null) {
            return;
        }
        String jumpUrl = getJumpUrl();
        skipH5Listener(jumpUrl);
        AdSdkH5Helper.skipH5(AdSdk.getInstance().getContext(), jumpUrl, this.mAdObject.isDownload());
    }

    public void skipH5Listener(String str) {
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoaderImp
    public void startRequestAd(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
        ALog.i(this.TAG, "thirdPosId:" + posInfoBean.getThirdPosId());
        CustomAdPosInfoManger.instance().requestAdPosInfo(posInfoBean, getAdType(), this.mAd.getScenes(), new a(FunctionConfig.instance().isWebApkDownload(posInfoBean.getPosPlatform())));
    }
}
