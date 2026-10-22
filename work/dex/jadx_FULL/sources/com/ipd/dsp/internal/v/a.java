package com.ipd.dsp.internal.v;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.i.v;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f38556a;
    public final int b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.ipd.dsp.internal.v.e
    @Nullable
    public v<byte[]> a(@NonNull v<Bitmap> vVar, @NonNull i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f38556a, this.b, byteArrayOutputStream);
        vVar.e();
        return new com.ipd.dsp.internal.r.b(byteArrayOutputStream.toByteArray());
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.f38556a = compressFormat;
        this.b = i;
    }
}
