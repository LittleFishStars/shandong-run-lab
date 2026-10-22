package com.zj.adlib;

import com.google.mlkit.vision.common.PointF3D;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class y6c extends PointF3D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f45966a;
    public final float b;
    public final float c;

    public y6c(float f, float f2, float f3) {
        this.f45966a = f;
        this.b = f2;
        this.c = f3;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float b() {
        return this.f45966a;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float c() {
        return this.b;
    }

    @Override // com.google.mlkit.vision.common.PointF3D
    public final float d() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PointF3D) {
            PointF3D pointF3D = (PointF3D) obj;
            if (Float.floatToIntBits(this.f45966a) == Float.floatToIntBits(pointF3D.b()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(pointF3D.c()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(pointF3D.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Float.floatToIntBits(this.f45966a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c);
    }

    public final String toString() {
        return "PointF3D{x=" + this.f45966a + ", y=" + this.b + ", z=" + this.c + "}";
    }
}
