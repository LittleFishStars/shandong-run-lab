package com.huachenjie.ad.impl;

import android.app.Activity;
import android.app.Application;
import android.view.ViewGroup;
import androidx.p002lifecycle.DefaultLifecycleObserver;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.LifecycleOwner;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bwt.top.AdSdk;
import com.bwt.top.BannerAdListener;
import com.bwt.top.DeviceParamsController;
import com.bwt.top.ServiceAd;
import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.exception.AdError;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.AdLoader;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.zj.adlib.qo5;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J0\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/ad/impl/MhtAdLoader;", "Lcom/huachenjie/ad/interfaces/AdLoader;", "", "a", "Landroid/app/Application;", "context", "", "c", "", "posId", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroid/view/ViewGroup;", "container", "Lcom/huachenjie/ad/interfaces/FDAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "d", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class MhtAdLoader extends AdLoader {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/ad/impl/MhtAdLoader$a", "Lcom/bwt/top/DeviceParamsController;", "", "isCanUsePhoneState", "isCanUseWifiState", "ad_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DeviceParamsController {
        @Override // com.bwt.top.DeviceParamsController
        public boolean isCanUsePhoneState() {
            return false;
        }

        @Override // com.bwt.top.DeviceParamsController
        public boolean isCanUseWifiState() {
            return false;
        }
    }

    @Override // com.huachenjie.ad.interfaces.AdLoader
    public int a() {
        return 7;
    }

    public final void c(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AdSdk.getInstance().setDebug(false);
        AdSdk.getInstance().setBaseHttp("https://ad.lovefree.cc");
        AdSdk.getInstance().setDeviceParamsController(new a());
        AdSdk.getInstance().init(context, qo5.f44256a);
    }

    public final void d(@NotNull String posId, @NotNull Activity activity, @NotNull Lifecycle lifecycle, @NotNull ViewGroup container, @Nullable final FDAdListener listener) {
        Intrinsics.checkNotNullParameter(posId, "posId");
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        Intrinsics.checkNotNullParameter(container, "container");
        final ServiceAd serviceAd = new ServiceAd(activity, container);
        serviceAd.setAdId(posId);
        serviceAd.showCloseView();
        serviceAd.setAutoRefreshInterval(30);
        serviceAd.setAdListener(new BannerAdListener() { // from class: com.huachenjie.ad.impl.MhtAdLoader$loadServiceAd$1
            @Override // com.bwt.top.ad.AdListener
            public void onAdClick(@Nullable AdInfo ad) {
                FDAdListener fDAdListener = listener;
                if (fDAdListener != null) {
                    fDAdListener.a();
                }
            }

            @Override // com.bwt.top.ad.AdListener
            public void onAdClose(@Nullable AdInfo ad) {
                FDAdListener fDAdListener = listener;
                if (fDAdListener != null) {
                    fDAdListener.b();
                }
            }

            @Override // com.bwt.top.ad.AdListener
            public void onAdExpose(@Nullable AdInfo ad) {
                FDAdListener fDAdListener = listener;
                if (fDAdListener != null) {
                    fDAdListener.e();
                }
            }

            @Override // com.bwt.top.ad.AdListener
            public void onAdFailed(@Nullable AdError adError) {
                FDAdListener fDAdListener = listener;
                if (fDAdListener != null) {
                    String strValueOf = String.valueOf(adError != null ? Integer.valueOf(adError.errorCode()) : null);
                    String strErrorMsg = adError != null ? adError.errorMsg() : null;
                    if (strErrorMsg == null) {
                        strErrorMsg = "";
                    }
                    fDAdListener.c(strValueOf, strErrorMsg);
                }
            }

            @Override // com.bwt.top.ad.AdListener
            public void onAdReceive(@Nullable AdInfo ad) {
                FDAdListener fDAdListener = listener;
                if (fDAdListener != null) {
                    fDAdListener.d();
                }
            }
        });
        addLifecycleObserver(lifecycle, new DefaultLifecycleObserver() { // from class: com.huachenjie.ad.impl.MhtAdLoader$loadServiceAd$2
            @Override // androidx.p002lifecycle.DefaultLifecycleObserver
            public void onDestroy(@NotNull LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                serviceAd.release();
            }
        });
        serviceAd.loadAd();
    }
}
