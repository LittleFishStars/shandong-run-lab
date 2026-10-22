package com.huachenjie.base.app_widget;

import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Intent;
import com.blankj.utilcode.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007J\u0018\u0010\n\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/huachenjie/base/app_widget/a;", "", "", "isLogout", "", "d", "Ljava/lang/Class;", "Landroid/appwidget/AppWidgetProvider;", "cls", "b", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f32791a = new a();

    @JvmStatic
    public static final boolean a(@NotNull Class<? extends AppWidgetProvider> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Utils.a());
        if (!appWidgetManager.isRequestPinAppWidgetSupported()) {
            return false;
        }
        ComponentName componentName = new ComponentName(Utils.a(), cls);
        return appWidgetManager.requestPinAppWidget(componentName, null, PendingIntent.getBroadcast(Utils.a(), 0, new Intent().setComponent(componentName), 201326592));
    }

    @JvmStatic
    public static final boolean b(@NotNull Class<? extends AppWidgetProvider> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        int[] appWidgetIds = AppWidgetManager.getInstance(Utils.a()).getAppWidgetIds(new ComponentName(Utils.a(), cls));
        Intrinsics.checkNotNullExpressionValue(appWidgetIds, "appWidgetIds");
        return !(appWidgetIds.length == 0);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c() {
        e(false, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void d(boolean isLogout) {
        int[] appWidgetIds = AppWidgetManager.getInstance(Utils.a()).getAppWidgetIds(new ComponentName(Utils.a(), (Class<?>) InspirationWidget.class));
        Intrinsics.checkNotNullExpressionValue(appWidgetIds, "appWidgetIds");
        if (!(appWidgetIds.length == 0)) {
            Intent intent = new Intent();
            intent.putExtra(InspirationWidgetJobService.f, isLogout);
            InspirationWidgetJobService.Companion companion = InspirationWidgetJobService.INSTANCE;
            Application applicationA = Utils.a();
            Intrinsics.checkNotNullExpressionValue(applicationA, "getApp()");
            companion.a(applicationA, intent);
        }
    }

    public static /* synthetic */ void e(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        d(z);
    }
}
