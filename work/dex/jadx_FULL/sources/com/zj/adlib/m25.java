package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import com.huachenjie.base.app_widget.a;
import com.huachenjie.compat.service.LogoutService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/zj/adlib/m25;", "", "Landroid/content/Context;", "context", "", "b", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class m25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m25 f43205a = new m25();

    @JvmStatic
    public static final void b(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LogoutService.INSTANCE.a(context, new Intent());
        ai9.b();
        r57.g();
        p44.y();
        p59.a().execute(new Runnable() { // from class: com.zj.adlib.l25
            @Override // java.lang.Runnable
            public final void run() {
                m25.c(context);
            }
        });
        a.d(true);
        dq1.c();
        e0a.c();
    }

    public static final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        ba1.j(context.getFilesDir().getAbsolutePath());
    }
}
