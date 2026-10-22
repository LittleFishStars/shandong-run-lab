package com.zj.adlib;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.huachenjie.common.R;
import com.huachenjie.common.service.LocationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J0\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0012\u001a\u00020\u0011\"\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0016\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/zj/adlib/t26;", "", "Landroid/content/Context;", "context", "Landroid/app/Notification;", "d", "", LocationService.f, "", "title", "content", "Landroid/app/PendingIntent;", BaseGmsClient.i, "", "e", "id", "b", "", "ids", "c", "a", "Ljava/lang/String;", "NOTIFICATION_FOREGROUND_CHANNEL_ID", "NOTIFICATION_RUN_CHANNEL_ID", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class t26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t26 f44833a = new t26();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String NOTIFICATION_FOREGROUND_CHANNEL_ID = "com.huachenjie.common_foreground";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String NOTIFICATION_RUN_CHANNEL_ID = "com.huachenjie.common_running";

    public final void a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
    }

    public final void b(@NotNull Context context, int id) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (id > 0) {
            notificationManager.cancel(id);
        } else {
            notificationManager.cancelAll();
        }
    }

    public final void c(@NotNull Context context, @NotNull int... ids) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ids, "ids");
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        for (int i : ids) {
            notificationManager.cancel(i);
        }
    }

    @Nullable
    public final Notification d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        String string = applicationContext.getString(R.string.foreground_notification_title);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…round_notification_title)");
        String string2 = applicationContext.getString(R.string.foreground_notification_content);
        Intrinsics.checkNotNullExpressionValue(string2, "applicationContext.getSt…und_notification_content)");
        String string3 = applicationContext.getString(R.string.channelname_foreground_notification);
        Intrinsics.checkNotNullExpressionValue(string3, "applicationContext.getSt…_foreground_notification)");
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_FOREGROUND_CHANNEL_ID, string3, 3);
        notificationChannel.setSound(null, null);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        Object systemService = applicationContext.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(applicationContext, NOTIFICATION_FOREGROUND_CHANNEL_ID);
        if (!TextUtils.isEmpty(string)) {
            builder.setContentTitle(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setContentText(string2);
        }
        builder.setColor(ResourcesCompat.getColor(applicationContext.getResources(), R.color.colorAccent, null));
        builder.setSmallIcon(R.mipmap.ic_white_launcher);
        return builder.build();
    }

    public final void e(@NotNull Context context, int notificationId, @NotNull String title, @NotNull String content, @Nullable PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(content)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        String string = applicationContext.getString(R.string.channelname_run_notification);
        Intrinsics.checkNotNullExpressionValue(string, "applicationContext.getSt…nelname_run_notification)");
        Object systemService = applicationContext.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (notificationId == 0) {
            notificationId = -1677205656;
        }
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_RUN_CHANNEL_ID, string, 3);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-65536);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(applicationContext, NOTIFICATION_RUN_CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_white_launcher);
        builder.setColor(ContextCompat.getColor(applicationContext, R.color.colorAccent));
        builder.setVisibility(1);
        NotificationCompat.Builder contentTitle = builder.setContentTitle(TextUtils.isEmpty(title) ? "" : title);
        if (TextUtils.isEmpty(content)) {
            content = "";
        }
        NotificationCompat.Builder contentText = contentTitle.setContentText(content);
        if (TextUtils.isEmpty(title)) {
            title = "";
        }
        contentText.setTicker(title).setDefaults(2).setPriority(2).setAutoCancel(true);
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        notificationManager.notify(notificationId, builder.build());
    }
}
