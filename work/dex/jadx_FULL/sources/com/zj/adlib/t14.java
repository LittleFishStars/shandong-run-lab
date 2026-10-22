package com.zj.adlib;

import android.content.Context;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.AlertTip;
import com.huachenjie.common.util.ActivityLifecycleManager;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¨\u0006\u000e"}, d2 = {"Lcom/zj/adlib/t14;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/common/bean/AlertTip;", yj7.a.ALERT_TIP, "", yj7.a.SHOULD_REFRESH_USER_INFO, "", yj7.a.HOME_INDEX, "", "d", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class t14 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t14 f44827a = new t14();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/zj/adlib/t14$a", "Lcom/alibaba/android/arouter/facade/callback/NavCallback;", "Lcom/alibaba/android/arouter/facade/Postcard;", "postcard", "", "onArrival", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends NavCallback {
        @Override // com.alibaba.android.arouter.facade.callback.NavCallback, com.alibaba.android.arouter.facade.callback.NavigationCallback
        public void onArrival(@Nullable Postcard postcard) {
            ActivityLifecycleManager.l().j(zj7.a.HOME);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        e(context, null, false, 0, 14, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void b(@NotNull Context context, @Nullable AlertTip alertTip) {
        Intrinsics.checkNotNullParameter(context, "context");
        e(context, alertTip, false, 0, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@NotNull Context context, @Nullable AlertTip alertTip, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        e(context, alertTip, z, 0, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(@NotNull Context context, @Nullable AlertTip alertTip, boolean shouldRefreshUserInfo, int homeIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        ARouter.getInstance().build(zj7.a.HOME).withParcelable(yj7.a.ALERT_TIP, alertTip).withBoolean(yj7.a.SHOULD_REFRESH_USER_INFO, shouldRefreshUserInfo).withInt(yj7.a.HOME_INDEX, homeIndex).navigation(context, new a());
    }

    public static /* synthetic */ void e(Context context, AlertTip alertTip, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            alertTip = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            i = 0;
        }
        d(context, alertTip, z, i);
    }
}
