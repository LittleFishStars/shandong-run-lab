package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.Dsp;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(api = 28)
public final class f implements com.ipd.dsp.internal.f.k<ImageDecoder.Source, Bitmap> {
    public static final String b = "BitmapImageDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.e f38497a = new com.ipd.dsp.internal.j.f();

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull ImageDecoder.Source source, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new com.ipd.dsp.internal.p.a(i, i2, iVar));
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(b, "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new g(bitmapDecodeBitmap, this.f38497a);
    }
}
