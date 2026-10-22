package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.hv.TTDownloadField;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J/\u0010\u000f\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¨\u0006\u001a"}, d2 = {"Lcom/zj/adlib/fo6;", "", "Landroid/content/Context;", "ctx", "", AttributionReporter.SYSTEM_PERMISSION, "", "a", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", RequestPermission.PERMISSIONS, "", "code", "", "requestPermissions", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "context", "d", "c", "e", "Landroid/content/Intent;", "intent", "b", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class fo6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fo6 f41719a = new fo6();

    public final boolean a(@NotNull Context ctx, @Nullable String permission) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Context applicationContext = ctx.getApplicationContext();
        Intrinsics.checkNotNull(permission);
        return ContextCompat.checkSelfPermission(applicationContext, permission) == 0;
    }

    public final boolean b(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public final boolean c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(context)");
        return notificationManagerCompatFrom.areNotificationsEnabled();
    }

    public final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (b(context, intent)) {
            applicationContext.startActivity(intent.addFlags(268435456));
        }
    }

    public final void e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        context.startActivity(intent);
    }

    public final void requestPermissions(@Nullable Activity activity, @NotNull String[] permissions, int code) {
        Intrinsics.checkNotNullParameter(permissions, RequestPermission.PERMISSIONS);
        Intrinsics.checkNotNull(activity);
        ActivityCompat.requestPermissions(activity, permissions, code);
    }
}
