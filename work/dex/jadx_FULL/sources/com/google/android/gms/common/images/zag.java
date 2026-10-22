package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.base.zam;
import com.zj.adlib.c3c;
import com.zj.adlib.tb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c3c f5651a;

    public zag(Uri uri, int i) {
        this.f31284a = 0;
        this.f5651a = new c3c(uri);
        this.f31284a = i;
    }

    public final void a(Context context, zam zamVar, boolean z) {
        int i = this.f31284a;
        zaa(i != 0 ? context.getResources().getDrawable(i) : null, z, false, false);
    }

    public final void b(Context context, Bitmap bitmap, boolean z) {
        tb0.c(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }

    public abstract void zaa(@Nullable Drawable drawable, boolean z, boolean z2, boolean z3);
}
