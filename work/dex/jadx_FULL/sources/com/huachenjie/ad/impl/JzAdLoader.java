package com.huachenjie.ad.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.impl.JZServiceAd;
import cn.hzjizhun.admin.ad.impl.JZUnifiedAD;
import cn.hzjizhun.admin.ad.listener.DeviceParamsController;
import cn.hzjizhun.admin.ad.listener.JZBannerAdListener;
import cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener;
import cn.hzjizhun.admin.ad.listener.JZUnifiedADListener;
import cn.hzjizhun.admin.ad.utils.JZAdUtil;
import cn.hzjizhun.admin.exception.JZAdError;
import com.huachenjie.ad.impl.JzAdLoader;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.zj.adlib.hp4;
import com.zj.adlib.p59;
import com.zj.adlib.pi4;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class JzAdLoader extends AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32704a = "JzAdLoader";

    public class a extends DeviceParamsController {
        public a() {
        }

        @Override // cn.hzjizhun.admin.ad.listener.DeviceParamsController
        public boolean isCanUsePhoneState() {
            return false;
        }

        @Override // cn.hzjizhun.admin.ad.listener.DeviceParamsController
        public boolean isCanUseWifiState() {
            return false;
        }
    }

    public static /* synthetic */ void e(Application application) {
        JZAdSdk.getInstance().initJZ(application, hp4.f42174a);
    }

    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 3;
    }

    public void d(final Application application, boolean z) {
        AdLoader.b(z);
        JZAdSdk.getInstance().setJZWxAppId("wx15d677743c454371");
        JZAdSdk.getInstance().setJZBaseHttp("https://admin.hzjizhun.cn");
        JZAdSdk.getInstance().setIsInitLoadLocation(false);
        JZAdSdk.getInstance().noNeedLatLng();
        JZAdSdk.getInstance().setDeviceParamsController(new a());
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.gp4
            @Override // java.lang.Runnable
            public final void run() {
                JzAdLoader.e(application);
            }
        });
    }

    public void f(FragmentActivity fragmentActivity, Lifecycle lifecycle, ViewGroup viewGroup, String str) {
        final JZBannerAd jZBannerAd = new JZBannerAd(fragmentActivity, viewGroup);
        jZBannerAd.setJZAdId(str);
        jZBannerAd.setJZChannel(Build.BRAND);
        jZBannerAd.showCloseView();
        jZBannerAd.setJZAdListener(new JZBannerAdListener() { // from class: com.huachenjie.ad.impl.JzAdLoader.6
            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClick(JZAdInfo jZAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告点击");
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClose(JZAdInfo jZAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告关闭");
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdExpose(JZAdInfo jZAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告曝光");
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdFailed(JZAdError jZAdError) {
                Log.d(JzAdLoader.f32704a, "⼴告获取失败");
                Log.e(JzAdLoader.f32704a, "onAdFailed----->" + jZAdError.errorCode());
                Log.e(JzAdLoader.f32704a, "onAdFailed----->" + jZAdError.errorMsg());
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdReceive(JZAdInfo jZAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告获取成功");
            }
        });
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.JzAdLoader.7
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                jZBannerAd.release();
            }
        });
        jZBannerAd.loadJZAd();
    }

    public void g(String str, Activity activity, Lifecycle lifecycle, ViewGroup viewGroup, final FDAdListener fDAdListener) {
        final JZServiceAd jZServiceAd = new JZServiceAd(activity, viewGroup);
        jZServiceAd.setJZAdId(str);
        jZServiceAd.showCloseView();
        jZServiceAd.setAutoRefreshInterval(0);
        jZServiceAd.setJZChannel(Build.BRAND);
        jZServiceAd.setJZAdListener(new JZBannerAdListener() { // from class: com.huachenjie.ad.impl.JzAdLoader.2
            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClick(JZAdInfo jZAdInfo) {
                FDAdListener fDAdListener2 = fDAdListener;
                if (fDAdListener2 != null) {
                    fDAdListener2.a();
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClose(JZAdInfo jZAdInfo) {
                FDAdListener fDAdListener2 = fDAdListener;
                if (fDAdListener2 != null) {
                    fDAdListener2.b();
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdExpose(JZAdInfo jZAdInfo) {
                FDAdListener fDAdListener2 = fDAdListener;
                if (fDAdListener2 != null) {
                    fDAdListener2.e();
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdFailed(JZAdError jZAdError) {
                Log.d(JzAdLoader.f32704a, "⼴告获取失败：" + jZAdError.errorCode() + "-->" + jZAdError.errorMsg());
                FDAdListener fDAdListener2 = fDAdListener;
                if (fDAdListener2 != null) {
                    fDAdListener2.c(jZAdError.errorCode() + "", jZAdError.errorMsg());
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdReceive(JZAdInfo jZAdInfo) {
                FDAdListener fDAdListener2 = fDAdListener;
                if (fDAdListener2 != null) {
                    fDAdListener2.d();
                }
            }
        });
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.JzAdLoader.3
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                jZServiceAd.release();
            }
        });
        jZServiceAd.loadJZAd();
    }

    public void h(String str, final FragmentActivity fragmentActivity, Lifecycle lifecycle, final InterstitialAdListener interstitialAdListener) {
        final JZInterstitialAd jZInterstitialAd = new JZInterstitialAd(fragmentActivity);
        jZInterstitialAd.setJZAdId(str);
        jZInterstitialAd.setJZChannel(Build.BRAND);
        final boolean[] zArr = {false};
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.JzAdLoader.4
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                jZInterstitialAd.release();
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
        jZInterstitialAd.setJZAdListener(new JZInterstitialAdListener() { // from class: com.huachenjie.ad.impl.JzAdLoader.5
            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdFailed(JZAdError jZAdError) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.c(JzAdLoader.this.a(), jZAdError.errorCode() + "", jZAdError.errorMsg());
                }
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener
            public void onAdClick(JZInterstitialAdInfo jZInterstitialAdInfo, String str2) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.a(JzAdLoader.this.a(), "");
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClose(JZInterstitialAdInfo jZInterstitialAdInfo) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.b(JzAdLoader.this.a());
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdExpose(JZInterstitialAdInfo jZInterstitialAdInfo) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.e(JzAdLoader.this.a(), jZInterstitialAdInfo.getPlatformPosId());
                }
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener, cn.hzjizhun.admin.ad.AdListener
            public void onAdReady(JZInterstitialAdInfo jZInterstitialAdInfo) {
                if (zArr[0]) {
                    JZAdUtil.showInterstitialAd(fragmentActivity, jZInterstitialAdInfo);
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdReceive(JZInterstitialAdInfo jZInterstitialAdInfo) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.d(JzAdLoader.this.a());
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClick(JZInterstitialAdInfo jZInterstitialAdInfo) {
                InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.a(JzAdLoader.this.a(), "");
                }
            }
        });
        jZInterstitialAd.loadJZAd();
    }

    public void i(FragmentActivity fragmentActivity, String str, final pi4 pi4Var) {
        Log.d(f32704a, "loadUnifiedAD");
        JZUnifiedAD jZUnifiedAD = new JZUnifiedAD(fragmentActivity, false);
        jZUnifiedAD.setJZAdId(str);
        jZUnifiedAD.setJZChannel(Build.BRAND);
        jZUnifiedAD.setJZAdListener(new JZUnifiedADListener() { // from class: com.huachenjie.ad.impl.JzAdLoader.8
            @Override // cn.hzjizhun.admin.ad.listener.JZUnifiedADListener
            public void onADLoaded(JZUnifiedAdInfo jZUnifiedAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告数据获取成功时回调:" + jZUnifiedAdInfo);
                Log.d(JzAdLoader.f32704a, "desc:" + jZUnifiedAdInfo.getJZDesc());
                Log.d(JzAdLoader.f32704a, "IconUrl:" + jZUnifiedAdInfo.getJZIconUrl());
                Log.d(JzAdLoader.f32704a, "imgUrl:" + jZUnifiedAdInfo.getJZImgUrl());
                Log.d(JzAdLoader.f32704a, "title:" + jZUnifiedAdInfo.getJZTitle());
                Log.d(JzAdLoader.f32704a, "PatternType:" + jZUnifiedAdInfo.getJZAdPatternType());
                pi4 pi4Var2 = pi4Var;
                if (pi4Var2 != null) {
                    pi4Var2.c(jZUnifiedAdInfo);
                }
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZUnifiedADListener
            public void onAdClick(JZUnifiedAdInfo jZUnifiedAdInfo, String str2) {
                Log.d(JzAdLoader.f32704a, "⼴告被点击回调");
            }

            @Override // cn.hzjizhun.admin.ad.listener.JZUnifiedADListener, cn.hzjizhun.admin.ad.AdListener
            public void onAdFailed(JZAdError jZAdError) {
                pi4 pi4Var2 = pi4Var;
                if (pi4Var2 != null) {
                    pi4Var2.b();
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdClose(JZUnifiedAdInfo jZUnifiedAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告被关闭");
                pi4 pi4Var2 = pi4Var;
                if (pi4Var2 != null) {
                    pi4Var2.a(jZUnifiedAdInfo);
                }
            }

            @Override // cn.hzjizhun.admin.ad.AdListener
            public void onAdExpose(JZUnifiedAdInfo jZUnifiedAdInfo) {
                Log.d(JzAdLoader.f32704a, "⼴告被曝光回调");
            }
        });
        jZUnifiedAD.loadJZAd();
    }
}
