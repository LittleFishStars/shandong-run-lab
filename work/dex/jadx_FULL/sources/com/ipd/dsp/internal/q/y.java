package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class y extends h {
    public static final String g = "com.ipd.dsp.internal.components.glide.load.resource.bitmap.GranularRoundedCorners";
    public static final byte[] h = g.getBytes(com.ipd.dsp.internal.f.f.b);
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public y(float f, float f2, float f3, float f4) {
        this.c = f;
        this.d = f2;
        this.e = f3;
        this.f = f4;
    }

    @Override // com.ipd.dsp.internal.q.h
    public Bitmap a(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return j0.a(eVar, bitmap, this.c, this.d, this.e, this.f);
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        if (obj instanceof y) {
            y yVar = (y) obj;
            if (this.c == yVar.c && this.d == yVar.d && this.e == yVar.e && this.f == yVar.f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return com.ipd.dsp.internal.d0.o.a(this.f, com.ipd.dsp.internal.d0.o.a(this.e, com.ipd.dsp.internal.d0.o.a(this.d, com.ipd.dsp.internal.d0.o.a(1435795453, com.ipd.dsp.internal.d0.o.a(this.c)))));
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.c).putFloat(this.d).putFloat(this.e).putFloat(this.f).array());
    }
}
