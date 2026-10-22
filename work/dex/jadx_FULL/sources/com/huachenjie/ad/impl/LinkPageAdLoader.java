package com.huachenjie.ad.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import cj.mobile.CJInterstitial;
import cj.mobile.CJMobileAd;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJInitListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJNativeExpressListener;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.zj.adlib.ey4;
import com.zj.adlib.z50;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class LinkPageAdLoader extends AdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f32709a = "LinkPageAdLoader";

    public class a implements CJInitListener {
        public a() {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public class b implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f32713a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CJInterstitial f6859a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ InterstitialAdListener f6861a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean[] f6862a;

        public b(InterstitialAdListener interstitialAdListener, CJInterstitial cJInterstitial, Activity activity, boolean[] zArr) {
            this.f6861a = interstitialAdListener;
            this.f6859a = cJInterstitial;
            this.f32713a = activity;
            this.f6862a = zArr;
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClick() {
            InterstitialAdListener interstitialAdListener = this.f6861a;
            if (interstitialAdListener != null) {
                interstitialAdListener.a(LinkPageAdLoader.this.a(), this.f6859a.getAdType());
            }
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClose() {
            InterstitialAdListener interstitialAdListener = this.f6861a;
            if (interstitialAdListener != null) {
                interstitialAdListener.b(LinkPageAdLoader.this.a());
            }
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onError(String str, String str2) {
            InterstitialAdListener interstitialAdListener = this.f6861a;
            if (interstitialAdListener != null) {
                interstitialAdListener.c(LinkPageAdLoader.this.a(), str, str2);
            }
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onLoad() {
            InterstitialAdListener interstitialAdListener = this.f6861a;
            if (interstitialAdListener != null) {
                interstitialAdListener.d(LinkPageAdLoader.this.a());
            }
            Activity activity = this.f32713a;
            if (activity == null || !this.f6862a[0]) {
                return;
            }
            this.f6859a.showAd(activity);
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onShow() {
            InterstitialAdListener interstitialAdListener = this.f6861a;
            if (interstitialAdListener != null) {
                interstitialAdListener.e(LinkPageAdLoader.this.a(), this.f6859a.getAdType());
            }
        }
    }

    public class c implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f32714a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CJNativeExpress f6863a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ NativeAdListener f6865a;

        public c(NativeAdListener nativeAdListener, CJNativeExpress cJNativeExpress, ViewGroup viewGroup) {
            this.f6865a = nativeAdListener;
            this.f6863a = cJNativeExpress;
            this.f32714a = viewGroup;
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void loadSuccess(View view) {
            ViewGroup viewGroup = this.f32714a;
            if (viewGroup == null || view == null) {
                return;
            }
            viewGroup.removeAllViews();
            this.f32714a.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClick(View view) {
            NativeAdListener nativeAdListener = this.f6865a;
            if (nativeAdListener != null) {
                nativeAdListener.a(LinkPageAdLoader.this.a(), this.f6863a.getAdType());
            }
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClose(View view) {
            NativeAdListener nativeAdListener = this.f6865a;
            if (nativeAdListener != null) {
                nativeAdListener.b(LinkPageAdLoader.this.a());
            }
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onError(String str, String str2) {
            NativeAdListener nativeAdListener = this.f6865a;
            if (nativeAdListener != null) {
                nativeAdListener.c(LinkPageAdLoader.this.a(), str, str2);
            }
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onShow(View view) {
            NativeAdListener nativeAdListener = this.f6865a;
            if (nativeAdListener != null) {
                nativeAdListener.e(LinkPageAdLoader.this.a(), this.f6863a.getAdType());
            }
        }
    }

    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 2;
    }

    public void c(Application application, boolean z) {
        AdLoader.b(z);
        CJMobileAd.privacyCompliance(application, true);
        CJMobileAd.isCanUseAppList(false);
        CJMobileAd.offPersonal(!z);
        CJMobileAd.setAndroidId(application, z50.a(application));
        CJMobileAd.init(application, ey4.f41548a, new a());
    }

    public void d(String str, Activity activity, Lifecycle lifecycle, @Nullable InterstitialAdListener interstitialAdListener) {
        final CJInterstitial cJInterstitial = new CJInterstitial();
        final boolean[] zArr = {false};
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.LinkPageAdLoader.2
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                cJInterstitial.destroy();
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
        cJInterstitial.loadAd(activity, str, new b(interstitialAdListener, cJInterstitial, activity, zArr));
    }

    public void e(FragmentActivity fragmentActivity, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, String str, @Nullable NativeAdListener nativeAdListener) {
        final CJNativeExpress cJNativeExpress = new CJNativeExpress();
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.LinkPageAdLoader.4
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
                cJNativeExpress.destroy();
            }
        });
        cJNativeExpress.loadAd(fragmentActivity, i, i2, str, new c(nativeAdListener, cJNativeExpress, viewGroup));
    }

    public void f(Context context, String str) {
        CJMobileAd.setOaid(context, str);
    }
}
