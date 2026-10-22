package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k implements com.ipd.dsp.internal.f.k<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f38504a;

    public k(r rVar) {
        this.f38504a = rVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return this.f38504a.a(byteBuffer);
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return this.f38504a.a(byteBuffer, i, i2, iVar);
    }
}
