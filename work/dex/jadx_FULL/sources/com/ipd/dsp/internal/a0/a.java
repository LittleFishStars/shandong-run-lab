package com.ipd.dsp.internal.a0;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends e<Bitmap> {
    public final int[] i;
    public final ComponentName j;
    public final RemoteViews k;
    public final Context l;
    public final int m;

    public a(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        this.l = (Context) com.ipd.dsp.internal.d0.m.a(context, "Context can not be null!");
        this.k = (RemoteViews) com.ipd.dsp.internal.d0.m.a(remoteViews, "RemoteViews object can not be null!");
        this.i = (int[]) com.ipd.dsp.internal.d0.m.a(iArr, "WidgetIds can not be null!");
        this.m = i3;
        this.j = null;
    }

    public final void a() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.l);
        ComponentName componentName = this.j;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.k);
        } else {
            appWidgetManager.updateAppWidget(this.i, this.k);
        }
    }

    @Override // com.ipd.dsp.internal.a0.p
    public void onLoadCleared(@Nullable Drawable drawable) {
        a(null);
    }

    @Override // com.ipd.dsp.internal.a0.p
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable com.ipd.dsp.internal.b0.f<? super Bitmap> fVar) {
        a(bitmap);
    }

    public final void a(@Nullable Bitmap bitmap) {
        this.k.setImageViewBitmap(this.m, bitmap);
        a();
    }

    public a(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    public a(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.l = (Context) com.ipd.dsp.internal.d0.m.a(context, "Context can not be null!");
        this.k = (RemoteViews) com.ipd.dsp.internal.d0.m.a(remoteViews, "RemoteViews object can not be null!");
        this.j = (ComponentName) com.ipd.dsp.internal.d0.m.a(componentName, "ComponentName can not be null!");
        this.m = i3;
        this.i = null;
    }

    public a(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }
}
