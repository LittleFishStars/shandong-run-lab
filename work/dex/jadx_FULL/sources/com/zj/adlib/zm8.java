package com.zj.adlib;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.common.bean.AdPlatformSwitch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JL\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/zm8;", "", "", "coldStart", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroid/view/ViewGroup;", "container", "", "width", "height", "Lcom/huachenjie/ad/interfaces/SplashAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "a", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class zm8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final zm8 f46296a = new zm8();

    @JvmStatic
    public static final void a(boolean coldStart, @Nullable AdPlatformSwitch adConfig, @NotNull FragmentActivity activity, @NotNull Lifecycle lifecycle, @NotNull ViewGroup container, int width, int height, @Nullable SplashAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        Intrinsics.checkNotNullParameter(container, "container");
        if (adConfig != null && adConfig.getAdType() == 1 && !TextUtils.isEmpty(adConfig.getImgUrl())) {
            ew.i().f(activity, adConfig, container, listener);
            return;
        }
        if (r90.c()) {
            ew.l().g("J2591425374", activity, container, width, height, listener);
            return;
        }
        AdPlatformSwitch adPlatformSwitchE = r90.e("sigmob");
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            ew.j().j(activity, lifecycle, container, width, height, listener);
            return;
        }
        AdPlatformSwitch adPlatformSwitchE2 = r90.e("chuangjian");
        if (adPlatformSwitchE2 == null || !adPlatformSwitchE2.getOpenFlag()) {
            return;
        }
        ew.l().g("J2591425374", activity, container, width, height, listener);
    }
}
