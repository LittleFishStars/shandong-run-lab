package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g implements com.ipd.dsp.internal.i.v<Bitmap>, com.ipd.dsp.internal.i.r {
    public final Bitmap f;
    public final com.ipd.dsp.internal.j.e g;

    public g(@NonNull Bitmap bitmap, @NonNull com.ipd.dsp.internal.j.e eVar) {
        this.f = (Bitmap) com.ipd.dsp.internal.d0.m.a(bitmap, "Bitmap must not be null");
        this.g = (com.ipd.dsp.internal.j.e) com.ipd.dsp.internal.d0.m.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static g a(@Nullable Bitmap bitmap, @NonNull com.ipd.dsp.internal.j.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f;
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return com.ipd.dsp.internal.d0.o.a(this.f);
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override // com.ipd.dsp.internal.i.v
    public void e() {
        this.g.a(this.f);
    }

    @Override // com.ipd.dsp.internal.i.r
    public void a() {
        this.f.prepareToDraw();
    }
}
