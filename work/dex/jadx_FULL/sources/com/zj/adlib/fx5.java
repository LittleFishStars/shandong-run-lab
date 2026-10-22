package com.zj.adlib;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.common.bean.AdPlatformSwitch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JB\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u0013"}, d2 = {"Lcom/zj/adlib/fx5;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "Landroid/view/ViewGroup;", "container", "", "width", "height", "Lcom/huachenjie/ad/interfaces/NativeAdListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "a", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class fx5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fx5 f41777a = new fx5();

    @JvmStatic
    public static final void a(@NotNull Activity activity, @NotNull AdPlatformSwitch adConfig, @NotNull Lifecycle lifecycle, @NotNull ViewGroup container, int width, int height, @Nullable NativeAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        Intrinsics.checkNotNullParameter(container, "container");
        if (adConfig.getAdType() == 1 && !TextUtils.isEmpty(adConfig.getImgUrl())) {
            ew.i().e(adConfig, container, listener);
        } else if (r90.c()) {
            ew.l().e(r8a.j, activity, container, listener);
        } else {
            ew.j().h(vb8.e, lifecycle, container, width, height, listener);
        }
    }
}
