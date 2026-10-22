package com.huachenjie.base.util;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.common.util.ActivityLifecycleManagerV2;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.zj.adlib.ai9;
import com.zj.adlib.ew;
import com.zj.adlib.i4a;
import com.zj.adlib.r90;
import com.zj.adlib.t47;
import com.zj.adlib.v41;
import com.zj.adlib.x75;
import com.zj.adlib.xh9;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/huachenjie/base/util/ThirdUtil;", "", "Landroid/app/Application;", "context", "", y6b.g, "Landroid/content/Context;", "i", "f", y6b.f, "e", "application", "d", "", "a", "J", "KILL_PROGRESS_TIME", "", "Z", "c", "()Z", "k", "(Z)V", "hasInit", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", xh9.WEBSITE_PARAMS_CHANNEL, "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class ThirdUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final long KILL_PROGRESS_TIME = 30000;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static boolean hasInit;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final ThirdUtil f7255a = new ThirdUtil();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static String channel = "";

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"com/huachenjie/base/util/ThirdUtil$a", "Lcom/huachenjie/common/util/ActivityLifecycleManagerV2$ActivityLifecycleInterface;", "", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements ActivityLifecycleManagerV2.ActivityLifecycleInterface {
        public static final void d() {
            if (ActivityLifecycleManagerV2.f33902a.d() > 0) {
                return;
            }
            i4a.f("超时退出app");
            Process.killProcess(Process.myPid());
        }

        @Override // com.huachenjie.common.util.ActivityLifecycleManagerV2.ActivityLifecycleInterface
        public void a() {
            i4a.f("移除倒计时退出app");
            ThirdUtil.mainHandler.removeCallbacksAndMessages(null);
        }

        @Override // com.huachenjie.common.util.ActivityLifecycleManagerV2.ActivityLifecycleInterface
        public void b() {
            i4a.f("开始倒计时退出app");
            ThirdUtil.mainHandler.removeCallbacksAndMessages(null);
            ThirdUtil.mainHandler.postDelayed(new Runnable() { // from class: com.zj.adlib.b59
                @Override // java.lang.Runnable
                public final void run() {
                    ThirdUtil.a.d();
                }
            }, 30000L);
        }
    }

    @NotNull
    public final String b() {
        return channel;
    }

    public final boolean c() {
        return hasInit;
    }

    public final void d(Application application) {
        LocationClient.setAgreePrivacy(true);
        SDKInitializer.setAgreePrivacy(application, true);
        try {
            SDKInitializer.initialize(application);
            SDKInitializer.setCoordType(CoordType.GCJ02);
        } catch (BaiduMapSDKException unused) {
        }
    }

    public final void e() {
        ActivityLifecycleManagerV2.f33902a.e(new a());
    }

    public final void f(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        t47.b(context);
    }

    public final void g(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        x75.c(context);
        x75.a(context);
        x75.b(context);
        d(context);
    }

    public final synchronized void h(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasInit) {
            return;
        }
        if (r90.G()) {
            hasInit = true;
            OAIDUtil.f(context, null, 2, null);
            v41.g((CoroutineContext) null, new ThirdUtil$initThirdSdk$1(context, null), 1, (Object) null);
            ew.m(context, ai9.k(), channel);
            e();
        }
    }

    public final void i(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UMConfigure.setLogEnabled(false);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        UMConfigure.init(context, "5f84366480455950e4a80d9a", Build.MANUFACTURER, 1, (String) null);
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        channel = str;
    }

    public final void k(boolean z) {
        hasInit = z;
    }
}
