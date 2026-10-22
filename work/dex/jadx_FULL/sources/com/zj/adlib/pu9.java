package com.zj.adlib;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/pu9;", "", "Landroid/content/Context;", "context", "Landroid/content/BroadcastReceiver;", "receiver", "", "registerReceiver", "unregisterReceiver", "a", "", "Ljava/lang/String;", "ACTION_RELOAD", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class pu9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final pu9 f44062a = new pu9();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String ACTION_RELOAD = "com.huachenjie.shandong_school.receiver.web_page_reload";

    @JvmStatic
    public static final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(ACTION_RELOAD));
    }

    @JvmStatic
    public static final void registerReceiver(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter(ACTION_RELOAD));
    }

    @JvmStatic
    public static final void unregisterReceiver(@NotNull Context context, @NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receiver);
    }
}
