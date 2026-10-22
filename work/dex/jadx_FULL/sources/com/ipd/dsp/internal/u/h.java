package com.ipd.dsp.internal.u;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.i.v;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h implements k<com.ipd.dsp.internal.e.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38550a;

    public h(com.ipd.dsp.internal.j.e eVar) {
        this.f38550a = eVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull com.ipd.dsp.internal.e.a aVar, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public v<Bitmap> a(@NonNull com.ipd.dsp.internal.e.a aVar, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return com.ipd.dsp.internal.q.g.a(aVar.b(), this.f38550a);
    }
}
