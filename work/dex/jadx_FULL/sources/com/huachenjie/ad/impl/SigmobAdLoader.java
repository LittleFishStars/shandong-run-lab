package com.huachenjie.ad.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import com.blankj.utilcode.util.SizeUtils;
import com.fl.saas.ydsdk.manager.YdConfig;
import com.fl.saas.ydsdk.manager.YdParamConfig;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.sigmob.windad.WindAds;
import com.windmill.sdk.WMAdConfig;
import com.windmill.sdk.WMAdnInitConfig;
import com.windmill.sdk.WMCustomController;
import com.windmill.sdk.WMNetworkConfig;
import com.windmill.sdk.WindMillAd;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.banner.WMBannerAdListener;
import com.windmill.sdk.banner.WMBannerAdRequest;
import com.windmill.sdk.banner.WMBannerView;
import com.windmill.sdk.interstitial.WMInterstitialAd;
import com.windmill.sdk.interstitial.WMInterstitialAdListener;
import com.windmill.sdk.interstitial.WMInterstitialAdRequest;
import com.windmill.sdk.models.AdInfo;
import com.windmill.sdk.natives.WMNativeAd;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRequest;
import com.windmill.sdk.reward.WMRewardAd;
import com.windmill.sdk.reward.WMRewardAdListener;
import com.windmill.sdk.reward.WMRewardAdRequest;
import com.windmill.sdk.reward.WMRewardInfo;
import com.windmill.sdk.splash.IWMSplashEyeAd;
import com.windmill.sdk.splash.WMSplashAd;
import com.windmill.sdk.splash.WMSplashAdListener;
import com.windmill.sdk.splash.WMSplashAdRequest;
import com.zj.adlib.i4a;
import com.zj.adlib.u15;
import com.zj.adlib.vb8;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SigmobAdLoader extends AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f32716a = "SigmobAdLoader";

    public class a implements WMInterstitialAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32723a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ InterstitialAdListener f6879a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WMInterstitialAd f6880a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean[] f6881a;

        public a(InterstitialAdListener interstitialAdListener, WMInterstitialAd wMInterstitialAd, boolean[] zArr, Activity activity) {
            this.f6879a = interstitialAdListener;
            this.f6880a = wMInterstitialAd;
            this.f6881a = zArr;
            this.f32723a = activity;
        }

        public void onInterstitialAdClicked(AdInfo adInfo) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.a(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }

        public void onInterstitialAdClosed(AdInfo adInfo) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.b(SigmobAdLoader.this.a());
            }
        }

        public void onInterstitialAdLoadError(WindMillError windMillError, String str) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.c(SigmobAdLoader.this.a(), windMillError.getErrorCode() + "", windMillError.getMessage());
            }
        }

        public void onInterstitialAdLoadSuccess(String str) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.d(SigmobAdLoader.this.a());
            }
            if (this.f6880a.isReady() && this.f6881a[0]) {
                this.f6880a.show(this.f32723a, (HashMap) null);
            }
        }

        public void onInterstitialAdPlayEnd(AdInfo adInfo) {
        }

        public void onInterstitialAdPlayError(WindMillError windMillError, String str) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.c(SigmobAdLoader.this.a(), windMillError.getErrorCode() + "", windMillError.getMessage());
            }
        }

        public void onInterstitialAdPlayStart(AdInfo adInfo) {
            InterstitialAdListener interstitialAdListener = this.f6879a;
            if (interstitialAdListener != null) {
                interstitialAdListener.e(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }
    }

    public class b implements WMRewardAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32724a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RewardVideoAdListener f6883a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WMRewardAd f6884a;

        public b(WMRewardAd wMRewardAd, Activity activity, RewardVideoAdListener rewardVideoAdListener) {
            this.f6884a = wMRewardAd;
            this.f32724a = activity;
            this.f6883a = rewardVideoAdListener;
        }

        public void onVideoAdClicked(AdInfo adInfo) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.a(SigmobAdLoader.this.a(), adInfo.getNetworkPlacementId());
            }
        }

        public void onVideoAdClosed(AdInfo adInfo) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.b(SigmobAdLoader.this.a());
            }
        }

        public void onVideoAdLoadError(WindMillError windMillError, String str) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.c(SigmobAdLoader.this.a(), windMillError.getErrorCode() + "", windMillError.getMessage());
            }
        }

        public void onVideoAdLoadSuccess(String str) {
            if (this.f6884a.isReady()) {
                this.f6884a.show(this.f32724a, (HashMap) null);
            }
        }

        public void onVideoAdPlayEnd(AdInfo adInfo) {
        }

        public void onVideoAdPlayError(WindMillError windMillError, String str) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.c(SigmobAdLoader.this.a(), windMillError.getErrorCode() + "", windMillError.getMessage());
            }
        }

        public void onVideoAdPlayStart(AdInfo adInfo) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.e(SigmobAdLoader.this.a(), adInfo.getNetworkPlacementId());
            }
        }

        public void onVideoRewarded(AdInfo adInfo, WMRewardInfo wMRewardInfo) {
            RewardVideoAdListener rewardVideoAdListener = this.f6883a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.d(SigmobAdLoader.this.a(), adInfo.getNetworkPlacementId());
            }
        }
    }

    public class c extends WMCustomController {
        public c() {
        }

        public boolean isCanUseAndroidId() {
            return false;
        }

        public boolean isCanUseAppList() {
            return false;
        }

        public boolean isCanUseLocation() {
            return false;
        }

        public boolean isCanUseMacAddress() {
            return false;
        }

        public boolean isCanUsePhoneState() {
            return false;
        }

        public boolean isCanUseWifiState() {
            return false;
        }

        public boolean isCanUseWriteExternal() {
            return false;
        }
    }

    public class d implements WMSplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SplashAdListener f6885a;

        public d(SplashAdListener splashAdListener) {
            this.f6885a = splashAdListener;
        }

        public void onSplashAdClicked(AdInfo adInfo) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.a(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }

        public void onSplashAdFailToLoad(WindMillError windMillError, String str) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.c(SigmobAdLoader.this.a(), "404", windMillError.toString() + u15.f19942b + str);
            }
        }

        public void onSplashAdFailToPresent(WindMillError windMillError, String str) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.c(SigmobAdLoader.this.a(), windMillError.getErrorCode() + "", windMillError.getMessage() + u15.f19942b + str);
            }
        }

        public void onSplashAdSuccessLoad(String str) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.d(SigmobAdLoader.this.a());
            }
        }

        public void onSplashAdSuccessPresent(AdInfo adInfo) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.e(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }

        public void onSplashClosed(AdInfo adInfo, IWMSplashEyeAd iWMSplashEyeAd) {
            SplashAdListener splashAdListener = this.f6885a;
            if (splashAdListener != null) {
                splashAdListener.b(SigmobAdLoader.this.a());
            }
        }
    }

    public class e implements WMBannerAdListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BannerAdListener f6886a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ WMBannerView f6887a;

        public e(BannerAdListener bannerAdListener, WMBannerView wMBannerView) {
            this.f6886a = bannerAdListener;
            this.f6887a = wMBannerView;
        }

        public void onAdAutoRefreshFail(WindMillError windMillError, String str) {
        }

        public void onAdAutoRefreshed(AdInfo adInfo) {
        }

        public void onAdClicked(AdInfo adInfo) {
            BannerAdListener bannerAdListener = this.f6886a;
            if (bannerAdListener != null) {
                bannerAdListener.c(SigmobAdLoader.this.a());
            }
        }

        public void onAdClosed(AdInfo adInfo) {
            if (this.f6887a.getParent() != null) {
                ((ViewGroup) this.f6887a.getParent()).removeView(this.f6887a);
            }
            this.f6887a.destroy();
            BannerAdListener bannerAdListener = this.f6886a;
            if (bannerAdListener != null) {
                bannerAdListener.a(SigmobAdLoader.this.a());
            }
        }

        public void onAdLoadError(WindMillError windMillError, String str) {
            BannerAdListener bannerAdListener = this.f6886a;
            if (bannerAdListener != null) {
                bannerAdListener.d(SigmobAdLoader.this.a(), String.valueOf(windMillError.getErrorCode()), windMillError.getMessage());
            }
        }

        public void onAdLoadSuccess(String str) {
            BannerAdListener bannerAdListener = this.f6886a;
            if (bannerAdListener != null) {
                bannerAdListener.b(SigmobAdLoader.this.a());
            }
        }

        public void onAdShown(AdInfo adInfo) {
            BannerAdListener bannerAdListener = this.f6886a;
            if (bannerAdListener != null) {
                bannerAdListener.e(SigmobAdLoader.this.a(), adInfo.getNetworkPlacementId());
            }
        }
    }

    public class f implements WMNativeAdData.NativeAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdListener f6888a;

        public f(NativeAdListener nativeAdListener) {
            this.f6888a = nativeAdListener;
        }

        public void onADClicked(AdInfo adInfo) {
            NativeAdListener nativeAdListener = this.f6888a;
            if (nativeAdListener != null) {
                nativeAdListener.a(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }

        public void onADError(AdInfo adInfo, WindMillError windMillError) {
            if (this.f6888a != null) {
                i4a.b("SigmobAdLoader,loadNative,onError:", windMillError != null ? windMillError.toString() : "none");
                this.f6888a.c(SigmobAdLoader.this.a(), "", windMillError != null ? windMillError.toString() : "none");
            }
        }

        public void onADExposed(AdInfo adInfo) {
        }

        public void onADRenderSuccess(AdInfo adInfo, View view, float f, float f2) {
            NativeAdListener nativeAdListener = this.f6888a;
            if (nativeAdListener != null) {
                nativeAdListener.e(SigmobAdLoader.this.a(), adInfo.getNetworkId() + "");
            }
        }
    }

    public class g implements WMNativeAdData.DislikeInteractionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f32729a;

        public g(ViewGroup viewGroup) {
            this.f32729a = viewGroup;
        }

        public void onCancel() {
        }

        public void onSelected(int i, String str, boolean z) {
            this.f32729a.removeAllViews();
        }

        public void onShow() {
        }
    }

    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 5;
    }

    public final void d(Context context) {
        KsAdSDK.init(context, new SdkConfig.Builder().appId("1367900003").build());
    }

    public void e(Application application, boolean z) {
        AdLoader.b(z);
        YdConfig.getInstance().setPersonalizedState(z);
        YdConfig.getInstance().setEnableCollectAppInstallStatus(false);
        YdConfig.getInstance().init((Context) application, "4aafa5fcb0d5e41f", "", new YdParamConfig.Builder().setCanUseAndroid(false).setCanUseOaid(true).setCanUseSensor(true).setCanUseMac(false).setCanUseIMEI(false).setCanUseIMSI(false).setCanUseBootID(false).setCanUseLocation(false).setCanUseSSID(false).build(), true);
        WindAds.sharedAds().setSensorStatus(true);
        WindMillAd windMillAdSharedAds = WindMillAd.sharedAds();
        windMillAdSharedAds.setAdult(true);
        windMillAdSharedAds.setPersonalizedAdvertisingOn(z);
        windMillAdSharedAds.setDebugEnable(false);
        windMillAdSharedAds.setInitNetworkConfig(new WMNetworkConfig.Builder().addInitConfig(new WMAdnInitConfig(22, "5317787")).build());
        windMillAdSharedAds.startWithAppId(application, vb8.f45324a, new WMAdConfig.Builder().customController(new c()).build());
    }

    public void f(String str, FragmentActivity fragmentActivity, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, @Nullable BannerAdListener bannerAdListener) {
        final WMBannerView wMBannerView = new WMBannerView(fragmentActivity);
        wMBannerView.setAutoAnimation(true);
        wMBannerView.setAdListener(new e(bannerAdListener, wMBannerView));
        wMBannerView.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        viewGroup.removeAllViews();
        viewGroup.addView(wMBannerView);
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.5
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                wMBannerView.destroy();
            }
        });
        HashMap map = new HashMap();
        map.put("ad_key_width", Integer.valueOf(SizeUtils.g(i)));
        map.put("ad_key_height", Integer.valueOf(SizeUtils.g(i2)));
        wMBannerView.loadAd(new WMBannerAdRequest(str, "", map));
    }

    public void g(String str, Activity activity, Lifecycle lifecycle, @Nullable InterstitialAdListener interstitialAdListener) {
        final WMInterstitialAd wMInterstitialAd = new WMInterstitialAd(activity, new WMInterstitialAdRequest(str, "", (Map) null));
        final boolean[] zArr = {false};
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.9
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                wMInterstitialAd.destroy();
            }

            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
                zArr[0] = false;
            }

            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                zArr[0] = true;
            }
        });
        wMInterstitialAd.setInterstitialAdListener(new a(interstitialAdListener, wMInterstitialAd, zArr, activity));
        wMInterstitialAd.loadAd();
    }

    public void h(String str, final Lifecycle lifecycle, @NonNull final ViewGroup viewGroup, int i, int i2, final NativeAdListener nativeAdListener) {
        d(viewGroup.getContext());
        final f fVar = new f(nativeAdListener);
        final g gVar = new g(viewGroup);
        HashMap map = new HashMap();
        map.put("ad_key_width", Integer.valueOf(SizeUtils.g(i)));
        map.put("ad_key_height", 0);
        final WMNativeAd wMNativeAd = new WMNativeAd(viewGroup.getContext(), new WMNativeAdRequest(str, "", 1, map));
        wMNativeAd.loadAd(new WMNativeAd.NativeAdLoadListener() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.8
            public void onError(WindMillError windMillError, String str2) {
                String string;
                if (windMillError != null) {
                    string = windMillError.toString();
                } else {
                    string = "none:" + str2;
                }
                i4a.b("SigmobAdLoader,loadNative,onError:", string);
                NativeAdListener nativeAdListener2 = nativeAdListener;
                if (nativeAdListener2 != null) {
                    nativeAdListener2.c(SigmobAdLoader.this.a(), "", string);
                }
            }

            public void onFeedAdLoad(String str2) {
                List nativeADDataList = wMNativeAd.getNativeADDataList();
                if (nativeADDataList == null || nativeADDataList.isEmpty()) {
                    NativeAdListener nativeAdListener2 = nativeAdListener;
                    if (nativeAdListener2 != null) {
                        nativeAdListener2.c(SigmobAdLoader.this.a(), "", "nativeAdDataList is empty");
                        return;
                    }
                    return;
                }
                final WMNativeAdData wMNativeAdData = (WMNativeAdData) nativeADDataList.get(0);
                i4a.a("SigmobAdLoader,loadNative,onFeedAdLoad:" + wMNativeAdData);
                wMNativeAdData.setInteractionListener(fVar);
                wMNativeAdData.setDislikeInteractionCallback(com.blankj.utilcode.util.a.x(viewGroup.getContext()), gVar);
                if (wMNativeAdData.isExpressAd()) {
                    wMNativeAdData.render();
                    View expressAdView = wMNativeAdData.getExpressAdView();
                    viewGroup.removeAllViews();
                    viewGroup.addView(expressAdView);
                }
                Lifecycle lifecycle2 = lifecycle;
                if (lifecycle2 != null) {
                    SigmobAdLoader.this.addLifecycleObserver(lifecycle2, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.8.1
                        @Override // androidx.p002lifecycle.DefaultLifecycleObserver
                        public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                            wMNativeAdData.destroy();
                        }
                    });
                }
            }
        });
    }

    public void i(String str, Activity activity, Lifecycle lifecycle, RewardVideoAdListener rewardVideoAdListener) {
        final WMRewardAd wMRewardAd = new WMRewardAd(activity, new WMRewardAdRequest(str, (String) null, (Map) null));
        wMRewardAd.setRewardedAdListener(new b(wMRewardAd, activity, rewardVideoAdListener));
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.12
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                wMRewardAd.destroy();
            }
        });
        if (wMRewardAd.isReady()) {
            wMRewardAd.show(activity, (HashMap) null);
        } else {
            Toast.makeText(activity, "正在拉取广告，请稍等...", 0).show();
            wMRewardAd.loadAd();
        }
    }

    public void j(FragmentActivity fragmentActivity, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, SplashAdListener splashAdListener) {
        d(fragmentActivity);
        HashMap map = new HashMap();
        map.put("ad_key_width", Integer.valueOf(i));
        map.put("ad_key_height", Integer.valueOf(i2));
        WMSplashAdRequest wMSplashAdRequest = new WMSplashAdRequest(vb8.b, "", map);
        wMSplashAdRequest.setDisableAutoHideAd(true);
        final WMSplashAd wMSplashAd = new WMSplashAd(fragmentActivity, wMSplashAdRequest, new d(splashAdListener));
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.SigmobAdLoader.3
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                wMSplashAd.destroy();
            }
        });
        if (splashAdListener != null) {
            splashAdListener.f(a());
        }
        wMSplashAd.loadAdAndShow(viewGroup);
    }
}
