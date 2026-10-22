package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface e {
    @NonNull
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a();

    void a(float f);

    void a(Bitmap bitmap);

    long b();

    @NonNull
    Bitmap b(int i, int i2, Bitmap.Config config);

    void trimMemory(int i);
}
