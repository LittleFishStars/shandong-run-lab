package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class t implements com.ipd.dsp.internal.f.m<Drawable> {
    public final com.ipd.dsp.internal.f.m<Bitmap> c;
    public final boolean d;

    public t(com.ipd.dsp.internal.f.m<Bitmap> mVar, boolean z) {
        this.c = mVar;
        this.d = z;
    }

    public com.ipd.dsp.internal.f.m<BitmapDrawable> a() {
        return this;
    }

    @Override // com.ipd.dsp.internal.f.m
    @NonNull
    public com.ipd.dsp.internal.i.v<Drawable> a(@NonNull Context context, @NonNull com.ipd.dsp.internal.i.v<Drawable> vVar, int i, int i2) {
        com.ipd.dsp.internal.j.e eVarE = com.ipd.dsp.internal.components.glide.a.a(context).e();
        Drawable drawable = vVar.get();
        com.ipd.dsp.internal.i.v<Bitmap> vVarA = s.a(eVarE, drawable, i, i2);
        if (vVarA != null) {
            com.ipd.dsp.internal.i.v<Bitmap> vVarA2 = this.c.a(context, vVarA, i, i2);
            if (!vVarA2.equals(vVarA)) {
                return a(context, vVarA2);
            }
            vVarA2.e();
            return vVar;
        }
        if (!this.d) {
            return vVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof t) {
            return this.c.equals(((t) obj).c);
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return this.c.hashCode();
    }

    public final com.ipd.dsp.internal.i.v<Drawable> a(Context context, com.ipd.dsp.internal.i.v<Bitmap> vVar) {
        return c0.a(context.getResources(), vVar);
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.c.a(messageDigest);
    }
}
