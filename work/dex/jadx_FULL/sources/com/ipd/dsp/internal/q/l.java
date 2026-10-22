package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(api = 28)
public final class l implements com.ipd.dsp.internal.f.k<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f38505a = new f();

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return this.f38505a.a(ImageDecoder.createSource(byteBuffer), i, i2, iVar);
    }
}
