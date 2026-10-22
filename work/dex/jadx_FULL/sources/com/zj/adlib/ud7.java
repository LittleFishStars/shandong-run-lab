package com.zj.adlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.blankj.utilcode.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0014\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/zj/adlib/ud7;", "", "Landroid/content/Context;", "context", "Landroid/content/BroadcastReceiver;", "receiver", "", "a", "i", "c", y6b.f, "", "refreshInspiration", "e", "", "Ljava/lang/String;", "ACTION", "b", "EXTRA_REFRESH_INSPIRATION", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ud7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ud7 f45122a = new ud7();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ACTION = "com.huachenjie.run.action.REFRESH_RUN_INDEX";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String EXTRA_REFRESH_INSPIRATION = "extra_refresh_inspiration";

    @JvmStatic
    public static final void a(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(receiver, new IntentFilter(ACTION));
    }

    @JvmStatic
    @JvmOverloads
    public static final void b() {
        d(null, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(@Nullable Context context) {
        f45122a.e(context, false);
    }

    public static /* synthetic */ void d(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        c(context);
    }

    @JvmStatic
    @JvmOverloads
    public static final void f() {
        h(null, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(@Nullable Context context) {
        f45122a.e(context, true);
    }

    public static /* synthetic */ void h(Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        g(context);
    }

    @JvmStatic
    public static final void i(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(receiver);
    }

    public final void e(Context context, boolean refreshInspiration) {
        Context contextA;
        if (context == null || (contextA = context.getApplicationContext()) == null) {
            contextA = Utils.a();
        }
        Intent intentPutExtra = new Intent(ACTION).putExtra(EXTRA_REFRESH_INSPIRATION, refreshInspiration);
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(ACTION).putExtra(…TION, refreshInspiration)");
        LocalBroadcastManager.getInstance(contextA).sendBroadcast(intentPutExtra);
    }
}
