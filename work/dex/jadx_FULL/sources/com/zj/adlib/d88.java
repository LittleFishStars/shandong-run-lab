package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.ad.interfaces.InterstitialAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.ad.widget.BannerAdView;
import com.huachenjie.ad.widget.InterstitialAdView;
import com.huachenjie.ad.widget.NativeAdView;
import com.huachenjie.ad.widget.SplashAdView;
import com.huachenjie.common.bean.AdPlatformSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u000eJ \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0013¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/d88;", "Lcom/huachenjie/ad/interfaces/AdLoader;", "", "a", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "Landroid/view/ViewGroup;", "container", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "f", "Lcom/huachenjie/ad/interfaces/NativeAdListener;", "e", "Lcom/huachenjie/ad/interfaces/BannerAdListener;", "c", "Landroid/app/Activity;", "Lcom/huachenjie/ad/interfaces/InterstitialAdListener;", "d", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class d88 extends AdLoader {
    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 4;
    }

    public final void c(@NotNull AdPlatformSwitch adConfig, @NotNull ViewGroup container, @Nullable BannerAdListener listener) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(container, "container");
        if (listener != null) {
            listener.b(a());
        }
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        BannerAdView bannerAdView = new BannerAdView(context, null, 0, 6, null);
        container.addView(bannerAdView, new ViewGroup.LayoutParams(-1, -2));
        bannerAdView.showAd(adConfig, a(), listener);
    }

    public final void d(@NotNull Activity activity, @NotNull AdPlatformSwitch adConfig, @Nullable InterstitialAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        if (listener != null) {
            listener.d(a());
        }
        new InterstitialAdView(activity, adConfig, a(), listener).m();
    }

    public final void e(@NotNull AdPlatformSwitch adConfig, @NotNull ViewGroup container, @Nullable NativeAdListener listener) {
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(container, "container");
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        NativeAdView nativeAdView = new NativeAdView(context, null, 0, 6, null);
        container.addView(nativeAdView, new ViewGroup.LayoutParams(-1, -2));
        nativeAdView.showAd(adConfig, a(), listener);
    }

    public final void f(@NotNull FragmentActivity activity, @NotNull AdPlatformSwitch adConfig, @NotNull ViewGroup container, @Nullable SplashAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(container, "container");
        if (listener != null) {
            listener.f(a());
        }
        SplashAdView splashAdView = new SplashAdView(activity, null, 0, 6, null);
        container.addView(splashAdView, new ViewGroup.LayoutParams(-1, -1));
        splashAdView.showAd(activity, adConfig, a(), listener);
    }
}
