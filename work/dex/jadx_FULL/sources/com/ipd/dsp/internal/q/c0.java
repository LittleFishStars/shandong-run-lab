package com.ipd.dsp.internal.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c0 implements com.ipd.dsp.internal.i.v<BitmapDrawable>, com.ipd.dsp.internal.i.r {
    public final Resources f;
    public final com.ipd.dsp.internal.i.v<Bitmap> g;

    public c0(@NonNull Resources resources, @NonNull com.ipd.dsp.internal.i.v<Bitmap> vVar) {
        this.f = (Resources) com.ipd.dsp.internal.d0.m.a(resources);
        this.g = (com.ipd.dsp.internal.i.v) com.ipd.dsp.internal.d0.m.a(vVar);
    }

    @Deprecated
    public static c0 a(Context context, Bitmap bitmap) {
        return (c0) a(context.getResources(), g.a(bitmap, com.ipd.dsp.internal.components.glide.a.a(context).e()));
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f, this.g.get());
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return this.g.c();
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
        this.g.e();
    }

    @Deprecated
    public static c0 a(Resources resources, com.ipd.dsp.internal.j.e eVar, Bitmap bitmap) {
        return (c0) a(resources, g.a(bitmap, eVar));
    }

    @Nullable
    public static com.ipd.dsp.internal.i.v<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.ipd.dsp.internal.i.v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new c0(resources, vVar);
    }

    @Override // com.ipd.dsp.internal.i.r
    public void a() {
        com.ipd.dsp.internal.i.v<Bitmap> vVar = this.g;
        if (vVar instanceof com.ipd.dsp.internal.i.r) {
            ((com.ipd.dsp.internal.i.r) vVar).a();
        }
    }
}
