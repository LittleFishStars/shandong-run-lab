package com.google.mlkit.vision.common;

import androidx.annotation.NonNull;
import com.zj.adlib.y6c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class PointF3D {
    @NonNull
    public static PointF3D a(float f, float f2, float f3) {
        return new y6c(f, f2, f3);
    }

    public abstract float b();

    public abstract float c();

    public abstract float d();
}
