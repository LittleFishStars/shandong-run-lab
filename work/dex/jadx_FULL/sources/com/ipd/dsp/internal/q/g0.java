package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g0 extends h {
    public static final String d = "com.ipd.dsp.internal.components.glide.load.resource.bitmap.Rotate";
    public static final byte[] e = d.getBytes(com.ipd.dsp.internal.f.f.b);
    public final int c;

    public g0(int i) {
        this.c = i;
    }

    @Override // com.ipd.dsp.internal.q.h
    public Bitmap a(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return j0.a(bitmap, this.c);
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        return (obj instanceof g0) && this.c == ((g0) obj).c;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return com.ipd.dsp.internal.d0.o.a(1357148295, com.ipd.dsp.internal.d0.o.b(this.c));
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.c).array());
    }
}
