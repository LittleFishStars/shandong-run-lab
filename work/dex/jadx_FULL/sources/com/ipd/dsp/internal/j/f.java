package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements e {
    @Override // com.ipd.dsp.internal.j.e
    public void a() {
    }

    @Override // com.ipd.dsp.internal.j.e
    public void a(float f) {
    }

    @Override // com.ipd.dsp.internal.j.e
    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.ipd.dsp.internal.j.e
    public long b() {
        return 0L;
    }

    @Override // com.ipd.dsp.internal.j.e
    @NonNull
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        return a(i, i2, config);
    }

    @Override // com.ipd.dsp.internal.j.e
    public void trimMemory(int i) {
    }

    @Override // com.ipd.dsp.internal.j.e
    @NonNull
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
