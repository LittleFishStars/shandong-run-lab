package com.ipd.dsp.internal.q;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o extends h {
    public static final int c = 1;
    public static final String d = "com.ipd.dsp.internal.components.glide.load.resource.bitmap.CircleCrop.1";
    public static final byte[] e = d.getBytes(com.ipd.dsp.internal.f.f.b);

    @Override // com.ipd.dsp.internal.q.h
    public Bitmap a(@NonNull Context context, @NonNull com.ipd.dsp.internal.j.e eVar, @NonNull Bitmap bitmap, int i, int i2) {
        return j0.c(eVar, bitmap, i, i2);
    }

    @Override // com.ipd.dsp.internal.f.f
    public boolean equals(Object obj) {
        return obj instanceof o;
    }

    @Override // com.ipd.dsp.internal.f.f
    public int hashCode() {
        return 1043377007;
    }

    @Override // com.ipd.dsp.internal.f.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(e);
    }
}
