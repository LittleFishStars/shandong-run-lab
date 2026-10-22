package com.ipd.dsp.internal.a0;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l extends e<Bitmap> {
    public final RemoteViews i;
    public final Context j;
    public final int k;
    public final String l;
    public final Notification m;
    public final int n;

    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    public l(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, null);
    }

    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    private void a() {
        ((NotificationManager) com.ipd.dsp.internal.d0.m.a((NotificationManager) this.j.getSystemService("notification"))).notify(this.l, this.k, this.m);
    }

    @Override // com.ipd.dsp.internal.a0.p
    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    public void onLoadCleared(@Nullable Drawable drawable) {
        a(null);
    }

    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    public l(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }

    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    public l(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.j = (Context) com.ipd.dsp.internal.d0.m.a(context, "Context must not be null!");
        this.m = (Notification) com.ipd.dsp.internal.d0.m.a(notification, "Notification object can not be null!");
        this.i = (RemoteViews) com.ipd.dsp.internal.d0.m.a(remoteViews, "RemoteViews object can not be null!");
        this.n = i3;
        this.k = i4;
        this.l = str;
    }

    @Override // com.ipd.dsp.internal.a0.p
    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable com.ipd.dsp.internal.b0.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    @RequiresPermission(Permission.POST_NOTIFICATIONS)
    @SuppressLint({"InlinedApi"})
    private void a(@Nullable Bitmap bitmap) {
        this.i.setImageViewBitmap(this.n, bitmap);
        a();
    }
}
