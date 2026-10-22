package cn.hzjizhun.admin.ad.adapter;

import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZFuctionService;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.impl.JZServiceAd;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.impl.JZUnifiedAD;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.custom_ad.CustomReport;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosInfoManger;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.custom_ad.http.CustomRequestCallback;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.h5.AdSdkH5Helper;
import cn.hzjizhun.admin.image.ImageLoaderImp;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DialogUtils;
import cn.hzjizhun.admin.util.SRUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterCustomAdLoader<V extends JZAdInfo, Y extends AdListener<V>, T extends BaseAd<Y>> extends AdapterAdLoaderImp<V, Y, T> {
    private static long preTime;
    private CustomRequestCallback callback = new d();
    private boolean isDownload;
    private boolean isShowSecondarySureDialog;
    protected CustomAdPosResult mAdObject;
    protected ImageLoaderImp mImageLoader;
    protected CustomReport mReport;
    private boolean mWxErrorReport;

    public class a implements AdSdkH5Helper.DialogCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f272a;
        public final /* synthetic */ String b;

        public a(String str, String str2) {
            this.f272a = str;
            this.b = str2;
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void cancel() {
            CustomReport customReport = AdapterCustomAdLoader.this.mReport;
            if (customReport != null) {
                customReport.deepLinkFailReport();
            }
            AdapterCustomAdLoader.this.skipAd();
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void sure() {
            AdapterCustomAdLoader.this.openWxMiniProgram(this.f272a, this.b);
        }
    }

    public class b implements AdSdkH5Helper.DialogCallback {
        public b() {
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void cancel() {
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void sure() {
            AdapterCustomAdLoader.this.adClickJump();
        }
    }

    public class c implements AdSdkH5Helper.DialogCallback {
        public c() {
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void cancel() {
            ALog.d("deeplink fail ....");
            CustomReport customReport = AdapterCustomAdLoader.this.mReport;
            if (customReport != null) {
                customReport.deepLinkFailReport();
            }
            AdapterCustomAdLoader.this.skipAd();
        }

        @Override // cn.hzjizhun.admin.h5.AdSdkH5Helper.DialogCallback
        public void sure() {
            ALog.d("deeplink success ....");
            CustomReport customReport = AdapterCustomAdLoader.this.mReport;
            if (customReport != null) {
                customReport.deepLinkSuccessReport();
            }
        }
    }

    public class d extends CustomRequestCallback {
        public d() {
        }

        @Override // cn.hzjizhun.admin.custom_ad.http.CustomRequestCallback
        public void onFailed(JZAdError jZAdError) {
            if (jZAdError != null) {
                jZAdError.log();
            }
            AdapterCustomAdLoader.this.callbackFail();
        }

        @Override // cn.hzjizhun.admin.custom_ad.http.CustomRequestCallback
        public void onSucceed(CustomAdPosResult customAdPosResult) {
            try {
                AdapterCustomAdLoader adapterCustomAdLoader = AdapterCustomAdLoader.this;
                adapterCustomAdLoader.mAdObject = customAdPosResult;
                adapterCustomAdLoader.setBindPrice();
                AdapterCustomAdLoader adapterCustomAdLoader2 = AdapterCustomAdLoader.this;
                adapterCustomAdLoader2.mAdObject.setDownload(adapterCustomAdLoader2.isDownload);
                AdapterCustomAdLoader adapterCustomAdLoader3 = AdapterCustomAdLoader.this;
                adapterCustomAdLoader3.mAdObject.setShowSecondarySureDialog(adapterCustomAdLoader3.isShowSecondarySureDialog);
                AdapterCustomAdLoader adapterCustomAdLoader4 = AdapterCustomAdLoader.this;
                adapterCustomAdLoader4.mAdObject.setChannelName(adapterCustomAdLoader4.mPosInfo.getPosPlatform());
                AdapterCustomAdLoader adapterCustomAdLoader5 = AdapterCustomAdLoader.this;
                adapterCustomAdLoader5.mAdObject.setPostId(adapterCustomAdLoader5.mPosInfo.getPosId());
                AdapterCustomAdLoader adapterCustomAdLoader6 = AdapterCustomAdLoader.this;
                adapterCustomAdLoader6.mAdObject.setOutFunction(adapterCustomAdLoader6.mAd instanceof JZFuctionService);
                AdapterCustomAdLoader.this.callbackSuccess();
            } catch (Throwable unused) {
            }
        }
    }

    private void adClick() {
        try {
            if (!this.mIsReleased && this.mAdObject != null) {
                if (System.currentTimeMillis() - preTime < 300) {
                    preTime = System.currentTimeMillis();
                } else if (isShowAdClickSureDialog()) {
                    DialogUtils.show(getContext(), JZAdSdk.getInstance().getPopUpDesc(), new b());
                } else {
                    adClickJump();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adClickJump() {
        CustomReport customReport;
        boolean z = true;
        try {
            this.mIsClick = true;
            onAdClickListener();
            T t = this.mAd;
            if (t != null && (customReport = this.mReport) != null) {
                customReport.clickReport(t.getPosId());
            }
            if (!this.mAdObject.isShowSecondarySureDialog() || this.mIsAccelerationClick || isShowAdClickSureDialog()) {
                z = false;
            }
            this.mIsAccelerationClick = false;
            if (this.mAdObject.getCtype() == 11) {
                startOpenWxMiniProgram(this.mAdObject.getWechatId(), this.mAdObject.getWechatPath(), z);
                return;
            }
            String deeplink = this.mAdObject.getDeeplink();
            if (TextUtils.isEmpty(deeplink)) {
                skipAd();
                return;
            }
            CustomReport customReport2 = this.mReport;
            if (customReport2 != null) {
                customReport2.deepLinkReport();
            }
            String storePkg = "";
            if (this.mAdObject.getCtype() == 7 && !TextUtils.isEmpty(this.mAdObject.getStorePkg())) {
                storePkg = this.mAdObject.getStorePkg();
            }
            AdSdkH5Helper.skipDeeplink(getContext(), deeplink, storePkg, z, new c());
        } catch (Throwable unused) {
        }
    }

    private CustomReport createAdReport() {
        return new CustomReport(this.mAdObject);
    }

    private int getAdType() {
        T t = this.mAd;
        if (t == null || (t instanceof JZBannerAd)) {
            return 3;
        }
        if (t instanceof JZSplashAd) {
            return 1;
        }
        if (t instanceof JZInterstitialAd) {
            return 4;
        }
        return ((t instanceof JZNativeAd) || (t instanceof JZUnifiedAD)) ? 2 : 3;
    }

    private boolean isShowAdClickSureDialog() {
        try {
            T t = this.mAd;
            return ((t instanceof JZServiceAd) || ((t instanceof JZNativeAd) && !this.mAdObject.isNativePop)) && !this.mAdObject.isKeen() && this.mAdObject.getAcceleration() <= 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void noWxAppIdReport() {
        try {
            if (!TextUtils.isEmpty(JZAdSdk.getInstance().getWxAppId()) || this.mWxErrorReport) {
                return;
            }
            this.mWxErrorReport = true;
            ApiManager.reportError("10002", this.mPosInfo.getThirdPosId());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWxMiniProgram(String str, String str2) {
        try {
            String wxAppId = JZAdSdk.getInstance().getWxAppId();
            if (!TextUtils.isEmpty(wxAppId) && !TextUtils.isEmpty(str)) {
                ALog.d("wxAppid = " + wxAppId + "---wechatId = " + str);
                IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(JZAdSdk.getInstance().getContext(), wxAppId);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                if (!TextUtils.isEmpty(str2)) {
                    req.path = str2;
                }
                if (iwxapiCreateWXAPI.sendReq(req)) {
                    CustomReport customReport = this.mReport;
                    if (customReport != null) {
                        customReport.deepLinkSuccessReport();
                        return;
                    }
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        skipAd();
        CustomReport customReport2 = this.mReport;
        if (customReport2 != null) {
            customReport2.deepLinkFailReport();
        }
        noWxAppIdReport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBindPrice() {
        try {
            int price = this.mPosInfo.getPrice();
            int bidPrice = this.mAdObject.getBidPrice();
            this.mAd.setBidPrice(Math.max(bidPrice, price));
            ALog.innerD("竞价价格", price + "---" + bidPrice);
        } catch (Throwable unused) {
        }
    }

    private void startOpenWxMiniProgram(String str, String str2, boolean z) {
        CustomReport customReport = this.mReport;
        if (customReport != null) {
            customReport.deepLinkReport();
        }
        if (z) {
            AdSdkH5Helper.showDeeplinkSureDialog(getContext(), new a(str, str2));
        } else {
            openWxMiniProgram(str, str2);
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void adClickSource(Cs cs) {
        boolean zIsStart = SRUtils.isStart();
        boolean z = cs == Cs.SC && ((this.mAd instanceof JZSplashAd) || !zIsStart);
        boolean z2 = cs == Cs.KC && !zIsStart;
        if (cs == Cs.MC || z || z2) {
            adClick();
        }
    }

    public void callbackFail() {
        handleAdLoaderCallback(false);
    }

    public void callbackSuccess() {
        if (this.mAd == null || this.mAdObject == null || getContext() == null || this.mIsReleased) {
            callbackFail();
            return;
        }
        this.mReport = createAdReport();
        readyAdView();
        this.mImageLoader = new ImageLoaderImp(getContext().getApplicationContext(), this.TAG);
        handleAdLoaderCallback(true);
        onAdReceiveListener();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public boolean checkRenderView() {
        super.checkRenderView();
        return (this.mAdObject == null || this.mImageLoader == null) ? false : true;
    }

    public void deeplinkSuccess() {
    }

    public void displayReport() {
        CustomReport customReport = this.mReport;
        if (customReport != null) {
            customReport.displayReport();
        }
    }

    public String getJumpUrl() {
        return this.mAdObject.getJumpPage();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void onAdExposeListener() {
        displayReport();
        super.onAdExposeListener();
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || !customAdPosResult.getMoment().equals("on")) {
            return;
        }
        accelerationClick(this.mAdObject.getAcceleration());
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void onAdReceiveListener() {
        T t;
        super.onAdReceiveListener();
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult != null && customAdPosResult.getMoment().equals("before")) {
            accelerationClick(this.mAdObject.getAcceleration());
        }
        CustomAdPosResult customAdPosResult2 = this.mAdObject;
        if (customAdPosResult2 == null || !customAdPosResult2.getMoment().equals("on") || (t = this.mAd) == null || !(t instanceof JZSplashAd)) {
            return;
        }
        accelerationDisplayBefore(this.mAdObject.getAcceleration());
    }

    public void readyAdView() {
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
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
        if (this.mAdObject == null || this.mAd == null) {
            return;
        }
        skipH5Listener(getJumpUrl());
        AdSdkH5Helper.skipH5(new AdSdkH5Helper.SkipH5Params(JZAdSdk.getInstance().getContext(), this.mAdObject, this.mReport, this.mAd.getToggleFullLandingPage(), this.mAd.getLandingPageAlpha(), this.mAd.isLandingPageFlowSystem(), this.mAd.isLandingVertical()));
    }

    public void skipH5Listener(String str) {
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void startRequestAd(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
        ALog.i(this.TAG, "thirdPosId:" + posInfoBean.getThirdPosId());
        try {
            this.isDownload = FunctionConfig.instance().isWebApkDownload(posInfoBean.getPosPlatform());
            this.isShowSecondarySureDialog = FunctionConfig.instance().isShowSecondarySureDialog(posInfoBean.getPosPlatform()) && this.mAd.hasContainsProduct();
            T t = this.mAd;
            if ((t instanceof JZNativeAd) && ((JZNativeAd) t).isInFunctionAd()) {
                CustomAdPosInfoManger.instance().requestInFunctionAdPosInfo(posInfoBean.getPosPlatform(), this.callback);
            } else if (this.mAd instanceof JZFuctionService) {
                CustomAdPosInfoManger.instance().requestOutFunctionAdPosInfo(posInfoBean, this.mAd.getScenes(), this.callback);
            } else {
                CustomAdPosInfoManger.instance().requestAdPosInfo(posInfoBean, getAdType(), this.mAd.getScenes(), this.callback);
            }
        } catch (Throwable unused) {
        }
    }
}
