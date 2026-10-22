package com.zj.adlib;

import android.app.Activity;
import androidx.p002lifecycle.Lifecycle;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.bean.AdPlatformSwitch;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\n"}, d2 = {"Lcom/zj/adlib/nd4;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Landroidx/lifecycle/Lifecycle;", RequestParameters.SUBRESOURCE_LIFECYCLE, "", "a", "<init>", "()V", "ad_release"}, k = 1, mv = {1, 8, 0})
public final class nd4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final nd4 f43499a = new nd4();

    @JvmStatic
    public static final void a(@NotNull Activity activity, @NotNull Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        AdPlatformSwitch adPlatformSwitchE = r90.e("ct");
        boolean z = false;
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            z = true;
        }
        if (z) {
            if (r90.c()) {
                ew.l().d(r8a.i, activity, lifecycle, null);
            } else {
                ew.g().d(ey4.b, activity, lifecycle, null);
            }
        }
    }
}
