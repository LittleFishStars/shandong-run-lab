package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d0 implements com.ipd.dsp.internal.f.k<ParcelFileDescriptor, Bitmap> {
    public static final int b = 536870912;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f38495a;

    public d0(r rVar) {
        this.f38495a = rVar;
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return a(parcelFileDescriptor) && this.f38495a.a(parcelFileDescriptor);
    }

    public final boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }

    @Override // com.ipd.dsp.internal.f.k
    @Nullable
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        return this.f38495a.a(parcelFileDescriptor, i, i2, iVar);
    }
}
