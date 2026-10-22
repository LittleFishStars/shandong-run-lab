package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class h implements com.ipd.dsp.internal.f.m<Bitmap> {
    public abstract Bitmap a(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2);

    @Override // com.ipd.dsp.internal.f.m
    @NonNull
    public final com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull Context context, @NonNull com.ipd.dsp.internal.i.v<Bitmap> vVar, int i, int i2) {
        if (!com.ipd.dsp.internal.d0.o.b(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.ipd.dsp.internal.j.e eVarE = com.ipd.dsp.internal.components.glide.a.a(context).e();
        Bitmap bitmap = vVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        int i3 = i;
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapA = a(context, eVarE, bitmap, i3, i2);
        return bitmap.equals(bitmapA) ? vVar : g.a(bitmapA, eVarE);
    }
}
