package com.huachenjie.ad.impl;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.interfaces.RewardVideoAdListener;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.zj.adlib.c49;
import com.zj.adlib.i4a;
import com.zj.adlib.r8a;
import com.zj.zjsdk.ZJConfig;
import com.zj.zjsdk.ZjCustomController;
import com.zj.zjsdk.ZjSdk;
import com.zj.zjsdk.api.v2.express.ZJNativeExpressAd;
import com.zj.zjsdk.api.v2.express.ZJNativeExpressAdInteractionListener;
import com.zj.zjsdk.api.v2.express.ZJNativeExpressAdLoadListener;
import com.zj.zjsdk.api.v2.interstitial.ZJInterstitialAd;
import com.zj.zjsdk.api.v2.interstitial.ZJInterstitialAdInteractionListener;
import com.zj.zjsdk.api.v2.interstitial.ZJInterstitialAdLoadListener;
import com.zj.zjsdk.api.v2.rewarded.ZJRewardedAd;
import com.zj.zjsdk.api.v2.rewarded.ZJRewardedAdInteractionListener;
import com.zj.zjsdk.api.v2.rewarded.ZJRewardedAdLoadListener;
import com.zj.zjsdk.api.v2.splash.ZJSplashAd;
import com.zj.zjsdk.api.v2.splash.ZJSplashAdInteractionListener;
import com.zj.zjsdk.api.v2.splash.ZJSplashAdLoadListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ZJAdLoader extends AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f32730a = "ZJAdLoader";

    public class a implements ZJRewardedAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32732a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RewardVideoAdListener f6892a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ZJRewardedAdInteractionListener f6893a;

        public a(RewardVideoAdListener rewardVideoAdListener, ZJRewardedAdInteractionListener zJRewardedAdInteractionListener, Activity activity) {
            this.f6892a = rewardVideoAdListener;
            this.f6893a = zJRewardedAdInteractionListener;
            this.f32732a = activity;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull ZJRewardedAd zJRewardedAd) {
            zJRewardedAd.setAdInteractionListener(this.f6893a);
            zJRewardedAd.show(this.f32732a);
        }

        public void onError(int i, @NonNull String str) {
            RewardVideoAdListener rewardVideoAdListener = this.f6892a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
            }
        }
    }

    public class b extends ZjCustomController.Controller {
        public b() {
        }

        public boolean canReadBootId() {
            return false;
        }

        public boolean canReadInstalledPackages() {
            return false;
        }

        public boolean canReadLocation() {
            return false;
        }

        public boolean canReadNearbyWifiList() {
            return false;
        }

        public boolean canUseAndroidId() {
            return false;
        }

        public boolean canUseMacAddress() {
            return false;
        }

        public boolean canUseNetworkState() {
            return false;
        }

        public boolean canUsePhoneState() {
            return false;
        }

        public boolean canUseSimOperator() {
            return false;
        }

        public boolean canUseStoragePermission() {
            return false;
        }
    }

    public class c implements ZjSdk.OnStartListener {
        public c() {
        }

        public void onStartFailed(int i, @Nullable String str) {
            i4a.b(ZJAdLoader.f32730a, "ZJSDK初始化失败[" + i + c49.f40900a + str + "]");
        }

        public void onStartSuccess() {
            i4a.b(ZJAdLoader.f32730a, "ZJSDK初始化成功");
        }
    }

    public class d implements ZJSplashAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f32735a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SplashAdListener f6895a;

        public class a implements ZJSplashAdInteractionListener {
            public a() {
            }

            public void onSplashAdClick() {
                d dVar = d.this;
                SplashAdListener splashAdListener = dVar.f6895a;
                if (splashAdListener != null) {
                    splashAdListener.a(ZJAdLoader.this.a(), "");
                }
            }

            public void onSplashAdClose() {
                d dVar = d.this;
                SplashAdListener splashAdListener = dVar.f6895a;
                if (splashAdListener != null) {
                    splashAdListener.b(ZJAdLoader.this.a());
                }
            }

            public void onSplashAdShow() {
                d dVar = d.this;
                SplashAdListener splashAdListener = dVar.f6895a;
                if (splashAdListener != null) {
                    splashAdListener.e(ZJAdLoader.this.a(), "");
                }
            }

            public void onSplashAdShowError(int i, @NonNull String str) {
                d dVar = d.this;
                SplashAdListener splashAdListener = dVar.f6895a;
                if (splashAdListener != null) {
                    splashAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
                }
            }
        }

        public d(SplashAdListener splashAdListener, ViewGroup viewGroup) {
            this.f6895a = splashAdListener;
            this.f32735a = viewGroup;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull ZJSplashAd zJSplashAd) {
            zJSplashAd.setAdInteractionListener(new a());
            SplashAdListener splashAdListener = this.f6895a;
            if (splashAdListener != null) {
                splashAdListener.d(ZJAdLoader.this.a());
            }
            zJSplashAd.show(this.f32735a);
        }

        public void onError(int i, @NonNull String str) {
            SplashAdListener splashAdListener = this.f6895a;
            if (splashAdListener != null) {
                splashAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
            }
        }
    }

    public class e implements ZJInterstitialAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ InterstitialAdListener f6896a;

        public e(InterstitialAdListener interstitialAdListener) {
            this.f6896a = interstitialAdListener;
        }

        public void onInterstitialAdClick() {
            InterstitialAdListener interstitialAdListener = this.f6896a;
            if (interstitialAdListener != null) {
                interstitialAdListener.a(ZJAdLoader.this.a(), "");
            }
        }

        public void onInterstitialAdClose() {
            InterstitialAdListener interstitialAdListener = this.f6896a;
            if (interstitialAdListener != null) {
                interstitialAdListener.b(ZJAdLoader.this.a());
            }
        }

        public void onInterstitialAdShow() {
            InterstitialAdListener interstitialAdListener = this.f6896a;
            if (interstitialAdListener != null) {
                interstitialAdListener.e(ZJAdLoader.this.a(), "");
            }
        }

        public void onInterstitialAdShowError(int i, @NonNull String str) {
            InterstitialAdListener interstitialAdListener = this.f6896a;
            if (interstitialAdListener != null) {
                interstitialAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
            }
        }
    }

    public class f implements ZJInterstitialAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32738a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ InterstitialAdListener f6898a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ZJInterstitialAdInteractionListener f6899a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean[] f6900a;

        public f(InterstitialAdListener interstitialAdListener, ZJInterstitialAdInteractionListener zJInterstitialAdInteractionListener, boolean[] zArr, Activity activity) {
            this.f6898a = interstitialAdListener;
            this.f6899a = zJInterstitialAdInteractionListener;
            this.f6900a = zArr;
            this.f32738a = activity;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull ZJInterstitialAd zJInterstitialAd) {
            InterstitialAdListener interstitialAdListener = this.f6898a;
            if (interstitialAdListener != null) {
                interstitialAdListener.d(ZJAdLoader.this.a());
            }
            zJInterstitialAd.setAdInteractionListener(this.f6899a);
            if (this.f6900a[0]) {
                zJInterstitialAd.show(this.f32738a);
            }
        }

        public void onError(int i, @NonNull String str) {
            InterstitialAdListener interstitialAdListener = this.f6898a;
            if (interstitialAdListener != null) {
                interstitialAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
            }
        }
    }

    public class g implements ZJNativeExpressAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdListener f6901a;

        public g(NativeAdListener nativeAdListener) {
            this.f6901a = nativeAdListener;
        }

        public void onNativeExpressAdClick() {
            NativeAdListener nativeAdListener = this.f6901a;
            if (nativeAdListener != null) {
                nativeAdListener.a(ZJAdLoader.this.a(), "");
            }
        }

        public void onNativeExpressAdClose() {
            NativeAdListener nativeAdListener = this.f6901a;
            if (nativeAdListener != null) {
                nativeAdListener.b(ZJAdLoader.this.a());
            }
        }

        public void onNativeExpressAdRenderSuccess(View view) {
        }

        public void onNativeExpressAdShow() {
            NativeAdListener nativeAdListener = this.f6901a;
            if (nativeAdListener != null) {
                nativeAdListener.e(ZJAdLoader.this.a(), "");
            }
        }

        public void onNativeExpressAdShowError(int i, String str) {
            NativeAdListener nativeAdListener = this.f6901a;
            if (nativeAdListener != null) {
                nativeAdListener.c(ZJAdLoader.this.a(), i + "", str);
            }
        }
    }

    public class h implements ZJNativeExpressAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32740a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ViewGroup f6902a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdListener f6904a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ZJNativeExpressAdInteractionListener f6905a;

        public h(NativeAdListener nativeAdListener, ZJNativeExpressAdInteractionListener zJNativeExpressAdInteractionListener, Activity activity, ViewGroup viewGroup) {
            this.f6904a = nativeAdListener;
            this.f6905a = zJNativeExpressAdInteractionListener;
            this.f32740a = activity;
            this.f6902a = viewGroup;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(@NonNull List<ZJNativeExpressAd> list) {
            if (list.isEmpty()) {
                NativeAdListener nativeAdListener = this.f6904a;
                if (nativeAdListener != null) {
                    nativeAdListener.c(ZJAdLoader.this.a(), "", "广告加载失败");
                    return;
                }
                return;
            }
            NativeAdListener nativeAdListener2 = this.f6904a;
            if (nativeAdListener2 != null) {
                nativeAdListener2.d(ZJAdLoader.this.a());
            }
            ZJNativeExpressAd zJNativeExpressAd = list.get(0);
            zJNativeExpressAd.setInteractionListener(this.f6905a);
            zJNativeExpressAd.showAd(this.f32740a, this.f6902a);
        }

        public void onError(int i, @NonNull String str) {
            NativeAdListener nativeAdListener = this.f6904a;
            if (nativeAdListener != null) {
                nativeAdListener.c(ZJAdLoader.this.a(), i + "", str);
            }
        }
    }

    public class i implements ZJRewardedAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RewardVideoAdListener f6906a;

        public i(RewardVideoAdListener rewardVideoAdListener) {
            this.f6906a = rewardVideoAdListener;
        }

        public void onRewardVerify(@NonNull String str) {
            RewardVideoAdListener rewardVideoAdListener = this.f6906a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.d(ZJAdLoader.this.a(), str);
            }
        }

        public void onRewardedAdClick() {
            RewardVideoAdListener rewardVideoAdListener = this.f6906a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.a(ZJAdLoader.this.a(), "");
            }
        }

        public void onRewardedAdClose() {
            RewardVideoAdListener rewardVideoAdListener = this.f6906a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.b(ZJAdLoader.this.a());
            }
        }

        public void onRewardedAdShow() {
            RewardVideoAdListener rewardVideoAdListener = this.f6906a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.e(ZJAdLoader.this.a(), "");
            }
        }

        public void onRewardedAdShowError(int i, @NonNull String str) {
            RewardVideoAdListener rewardVideoAdListener = this.f6906a;
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.c(ZJAdLoader.this.a(), String.valueOf(i), str);
            }
        }
    }

    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 6;
    }

    public void c(Application application, boolean z) {
        AdLoader.b(z);
        ZjSdk.setPersonalizedState(z ? 2 : 1);
        ZjCustomController.getInstance().setCustomController(new b());
        ZjSdk.initWithoutStart(application, new ZJConfig.Builder(r8a.f44398a).isDebug(false).build());
        ZjSdk.start(new c());
    }

    public void d(String str, Activity activity, Lifecycle lifecycle, @Nullable InterstitialAdListener interstitialAdListener) {
        final boolean[] zArr = {false};
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.ZJAdLoader.4
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onPause(@NonNull LifecycleOwner lifecycleOwner) {
                zArr[0] = false;
            }

            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
                zArr[0] = true;
            }
        });
        ZJInterstitialAd.loadAd(activity, str, new f(interstitialAdListener, new e(interstitialAdListener), zArr, activity));
    }

    public void e(String str, Activity activity, @NonNull ViewGroup viewGroup, NativeAdListener nativeAdListener) {
        ZJNativeExpressAd.loadAd(activity, str, 1, new h(nativeAdListener, new g(nativeAdListener), activity, viewGroup));
    }

    public void f(String str, String str2, Activity activity, RewardVideoAdListener rewardVideoAdListener) {
        ZJRewardedAd.loadAd(activity, str, str2, new a(rewardVideoAdListener, new i(rewardVideoAdListener), activity));
    }

    public void g(String str, FragmentActivity fragmentActivity, ViewGroup viewGroup, int i2, int i3, SplashAdListener splashAdListener) {
        ZJSplashAd.loadAd(fragmentActivity, str, SizeUtils.g(i2), SizeUtils.g(i3), new d(splashAdListener, viewGroup));
    }
}
