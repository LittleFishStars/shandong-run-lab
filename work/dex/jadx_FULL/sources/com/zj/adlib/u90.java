package com.zj.adlib;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.alibaba.android.arouter.launcher.ARouter;
import com.aliyun.svideosdk.AlivcSdkCore;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.base.util.ThirdUtil;
import com.imuxuan.floatingview.FloatingMagnetView;
import com.imuxuan.floatingview.MagnetViewListener;
import com.tencent.tauth.Tencent;
import com.umeng.commonsdk.UMConfigure;
import com.vanniktech.emoji.EmojiManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nJ\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\u0013"}, d2 = {"Lcom/zj/adlib/u90;", "", "Landroid/app/Application;", "context", "", "b", y6b.g, "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "f", "Landroid/content/Context;", "k", "e", "c", "d", "j", "i", "<init>", "()V", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
public final class u90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u90 f45091a = new u90();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/zj/adlib/u90$a", "Lcom/imuxuan/floatingview/MagnetViewListener;", "Lcom/imuxuan/floatingview/FloatingMagnetView;", "magnetView", "", "a", "b", "app_otherRelease"}, k = 1, mv = {1, 8, 0})
    public static final class a implements MagnetViewListener {
        @Override // com.imuxuan.floatingview.MagnetViewListener
        public void a(@NotNull FloatingMagnetView magnetView) {
            Intrinsics.checkNotNullParameter(magnetView, "magnetView");
        }

        @Override // com.imuxuan.floatingview.MagnetViewListener
        public void b(@NotNull FloatingMagnetView magnetView) {
            Intrinsics.checkNotNullParameter(magnetView, "magnetView");
            ARouter.getInstance().build(zj7.d.INSIDE).navigation();
        }
    }

    public static final void g(Application application, Function0 function0) {
        Intrinsics.checkNotNullParameter(application, "$context");
        u90 u90Var = f45091a;
        u90Var.e(application);
        u90Var.c(application);
        ThirdUtil thirdUtil = ThirdUtil.f7255a;
        thirdUtil.f(application);
        u90Var.i(application);
        EmojiManager.h(new jh4());
        thirdUtil.g(application);
        il0.f42382a.c(application);
        thirdUtil.i(application);
        r57.f();
        AlivcSdkCore.register(application);
        if (function0 != null) {
            function0.invoke();
        }
        thirdUtil.k(true);
    }

    public final void b(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Utils.b(context);
        c(context);
        e(context);
        i(context);
        d();
        j();
        ThirdUtil.f7255a.j("other");
    }

    public final void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ARouter.init((Application) applicationContext);
    }

    public final void d() {
    }

    public final void e(Context context) {
        r24 r24Var = r24.f44348a;
        Intrinsics.checkNotNull(context);
        r24Var.c(context, "8.7.7", "26101017", "2", c31.e, false, "other");
    }

    public final void f(@NotNull final Application context, @Nullable final Function0<? extends Object> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        p59.c().execute(new Runnable() { // from class: com.zj.adlib.t90
            @Override // java.lang.Runnable
            public final void run() {
                u90.g(context, listener);
            }
        });
    }

    public final void h(@NotNull Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Utils.b(context);
        OAIDUtil.f(context, null, 2, null);
        ew.m(context, ai9.k(), "other");
        d();
        j();
        ThirdUtil.f7255a.e();
    }

    public final void i(Application context) {
        Tencent.setIsPermissionGranted(true, Build.MODEL);
        y88.g(context, "wx15d677743c454371");
        y88.d(context, "1111310146", b.l(), b.j());
        y88.e(context, "1320560779");
    }

    public final void j() {
        tq8.p(2131559403);
        tq8.q(2131559420);
        tq8.w(2131362324);
    }

    public final void k(@Nullable Context context) {
        UMConfigure.preInit(context, "5f84366480455950e4a80d9a", Build.MANUFACTURER);
    }
}
