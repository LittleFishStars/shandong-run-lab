package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface l {
    @Nullable
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    int b(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String c(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
