package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(api = 28)
public final class b0 implements com.ipd.dsp.internal.f.k<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f38494a = new f();

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull InputStream inputStream, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return this.f38494a.a(ImageDecoder.createSource(com.ipd.dsp.internal.d0.a.a(inputStream)), i, i2, iVar);
    }
}
