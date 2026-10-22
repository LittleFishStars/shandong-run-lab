package com.ipd.dsp.internal.s;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.b.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends i<e, Drawable> {
    @NonNull
    public static e b(@NonNull com.ipd.dsp.internal.b0.c cVar) {
        return new e().a(cVar);
    }

    @NonNull
    public static e c(int i) {
        return new e().b(i);
    }

    @NonNull
    public static e e() {
        return new e().d();
    }

    @NonNull
    public e a(@NonNull com.ipd.dsp.internal.b0.c cVar) {
        return a((com.ipd.dsp.internal.b0.g) cVar);
    }

    @NonNull
    public e d() {
        return a(new com.ipd.dsp.internal.b0.c.a());
    }

    @Override // com.ipd.dsp.internal.b.i
    public boolean equals(Object obj) {
        return (obj instanceof e) && super.equals(obj);
    }

    @Override // com.ipd.dsp.internal.b.i
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public static e b(@NonNull com.ipd.dsp.internal.b0.c.a aVar) {
        return new e().a(aVar);
    }

    @NonNull
    public e a(@NonNull com.ipd.dsp.internal.b0.c.a aVar) {
        return a(aVar.a());
    }

    @NonNull
    public static e b(@NonNull com.ipd.dsp.internal.b0.g<Drawable> gVar) {
        return new e().a(gVar);
    }

    @NonNull
    public e b(int i) {
        return a(new com.ipd.dsp.internal.b0.c.a(i));
    }
}
