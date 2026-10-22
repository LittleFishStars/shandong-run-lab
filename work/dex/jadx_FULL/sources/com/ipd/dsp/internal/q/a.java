package com.ipd.dsp.internal.q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a<DataType> implements com.ipd.dsp.internal.f.k<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.f.k<DataType, Bitmap> f38487a;
    public final Resources b;

    public a(Context context, com.ipd.dsp.internal.f.k<DataType, Bitmap> kVar) {
        this(context.getResources(), kVar);
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull DataType datatype, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return this.f38487a.a(datatype, iVar);
    }

    @Deprecated
    public a(Resources resources, com.ipd.dsp.internal.j.e eVar, com.ipd.dsp.internal.f.k<DataType, Bitmap> kVar) {
        this(resources, kVar);
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<BitmapDrawable> a(@NonNull DataType datatype, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return c0.a(this.b, this.f38487a.a(datatype, i, i2, iVar));
    }

    public a(@NonNull Resources resources, @NonNull com.ipd.dsp.internal.f.k<DataType, Bitmap> kVar) {
        this.b = (Resources) com.ipd.dsp.internal.d0.m.a(resources);
        this.f38487a = (com.ipd.dsp.internal.f.k) com.ipd.dsp.internal.d0.m.a(kVar);
    }
}
