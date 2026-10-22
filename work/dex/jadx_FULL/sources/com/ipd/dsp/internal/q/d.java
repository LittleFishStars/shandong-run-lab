package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public class d implements com.ipd.dsp.internal.f.m<BitmapDrawable> {
    public final com.ipd.dsp.internal.f.m<Drawable> c;

    public d(com.ipd.dsp.internal.f.m<Bitmap> mVar) {
        this.c = (com.ipd.dsp.internal.f.m) com.ipd.dsp.internal.d0.m.a(new t(mVar, false));
    }

    public static com.ipd.dsp.internal.i.v<Drawable> b(com.ipd.dsp.internal.i.v<BitmapDrawable> vVar) {
        return vVar;
    }

    @Override // com.ipd.dsp.internal.f.m
    @NonNull
    public com.ipd.dsp.internal.i.v<BitmapDrawable> a(@NonNull Context context, @NonNull com.ipd.dsp.internal.i.v<BitmapDrawable> vVar, int i, int i2) {
        return a(this.c.a(context, b(vVar), i, i2));
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.c.equals(((d) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.ipd.dsp.internal.i.v<BitmapDrawable> a(com.ipd.dsp.internal.i.v<Drawable> vVar) {
        if (vVar.get() instanceof BitmapDrawable) {
            return vVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + vVar.get());
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.c.a(messageDigest);
    }
}
