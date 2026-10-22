package com.ipd.dsp.internal.v;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38558a;
    public final e<Bitmap, byte[]> b;
    public final e<com.ipd.dsp.internal.u.c, byte[]> c;

    public c(@NonNull com.ipd.dsp.internal.j.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<com.ipd.dsp.internal.u.c, byte[]> eVar3) {
        this.f38558a = eVar;
        this.b = eVar2;
        this.c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static v<com.ipd.dsp.internal.u.c> a(@NonNull v<Drawable> vVar) {
        return vVar;
    }

    @Override // com.ipd.dsp.internal.v.e
    @Nullable
    public v<byte[]> a(@NonNull v<Drawable> vVar, @NonNull i iVar) {
        Drawable drawable = vVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(com.ipd.dsp.internal.q.g.a(((BitmapDrawable) drawable).getBitmap(), this.f38558a), iVar);
        }
        if (drawable instanceof com.ipd.dsp.internal.u.c) {
            return this.c.a(a(vVar), iVar);
        }
        return null;
    }
}
