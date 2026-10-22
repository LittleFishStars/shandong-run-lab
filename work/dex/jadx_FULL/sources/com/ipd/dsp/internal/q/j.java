package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j extends h {
    public static final String e = "com.ipd.dsp.internal.components.glide.load.resource.bitmap.BlurTransformation";
    public static final byte[] f = e.getBytes(com.ipd.dsp.internal.f.f.b);

    @IntRange(from = 1, to = 25)
    public final int c;
    public final boolean d;

    public j(@IntRange(from = 1, to = 25) int i) {
        this(i, true);
    }

    @Override // com.ipd.dsp.internal.q.h
    public Bitmap a(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return com.ipd.dsp.internal.c2.c.a(context, bitmap, this.c, this.d);
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.c == ((j) obj).c;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return com.ipd.dsp.internal.d0.o.a(com.ipd.dsp.internal.d0.o.b(-1051197316), this.c);
    }

    public j(@IntRange(from = 1, to = 25) int i, boolean z) {
        this.c = i;
        this.d = z;
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
    }
}
