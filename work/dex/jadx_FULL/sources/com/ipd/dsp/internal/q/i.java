package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i extends com.ipd.dsp.internal.b.i<i, Bitmap> {
    @NonNull
    public static i b(@NonNull com.ipd.dsp.internal.b0.c cVar) {
        return new i().a(cVar);
    }

    @NonNull
    public static i c(int i) {
        return new i().b(i);
    }

    @NonNull
    public static i d(@NonNull com.ipd.dsp.internal.b0.g<Drawable> gVar) {
        return new i().b(gVar);
    }

    @NonNull
    public static i e() {
        return new i().d();
    }

    @NonNull
    public i a(@NonNull com.ipd.dsp.internal.b0.c cVar) {
        return b((com.ipd.dsp.internal.b0.g<Drawable>) cVar);
    }

    @Override // com.ipd.dsp.internal.b.i
    public boolean equals(Object obj) {
        return (obj instanceof i) && super.equals(obj);
    }

    @Override // com.ipd.dsp.internal.b.i
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public static i b(@NonNull com.ipd.dsp.internal.b0.c.a aVar) {
        return new i().a(aVar);
    }

    @NonNull
    public static i c(@NonNull com.ipd.dsp.internal.b0.g<Bitmap> gVar) {
        return new i().a(gVar);
    }

    @NonNull
    public i a(@NonNull com.ipd.dsp.internal.b0.c.a aVar) {
        return b((com.ipd.dsp.internal.b0.g<Drawable>) aVar.a());
    }

    @NonNull
    public i d() {
        return a(new com.ipd.dsp.internal.b0.c.a());
    }

    @NonNull
    public i b(int i) {
        return a(new com.ipd.dsp.internal.b0.c.a(i));
    }

    @NonNull
    public i b(@NonNull com.ipd.dsp.internal.b0.g<Drawable> gVar) {
        return a(new com.ipd.dsp.internal.b0.b(gVar));
    }
}
