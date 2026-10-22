package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements com.ipd.dsp.internal.f.l<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38493a;
    public final com.ipd.dsp.internal.f.l<Bitmap> b;

    public b(com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.f.l<Bitmap> lVar) {
        this.f38493a = eVar;
        this.b = lVar;
    }

    @Override // com.ipd.dsp.internal.f.d
    public boolean a(@NonNull com.ipd.dsp.internal.i.v<BitmapDrawable> vVar, @NonNull File file, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return this.b.a((Bitmap) new g(vVar.get().getBitmap(), this.f38493a), file, iVar);
    }

    @Override // com.ipd.dsp.internal.f.l
    @NonNull
    public com.ipd.dsp.internal.f.c a(@NonNull com.ipd.dsp.internal.f.i iVar) {
        return this.b.a(iVar);
    }
}
