package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f0 implements com.ipd.dsp.internal.f.k<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.s.g f38498a;
    public final com.ipd.dsp.internal.j.e b;

    public f0(com.ipd.dsp.internal.s.g gVar, com.ipd.dsp.internal.j.e eVar) {
        this.f38498a = gVar;
        this.b = eVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull Uri uri, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return com.google.android.exoplayer2.upstream.c.h.equals(uri.getScheme());
    }

    @Override // com.ipd.dsp.internal.f.k
    @Nullable
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull Uri uri, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        com.ipd.dsp.internal.i.v<Drawable> vVarA = this.f38498a.a(uri, i, i2, iVar);
        if (vVarA == null) {
            return null;
        }
        return s.a(this.b, vVarA.get(), i, i2);
    }
}
