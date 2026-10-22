package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzuv;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jtd extends zzuv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42673a;
    public final float b;
    public final float c;
    public final float d;

    public jtd(float f, float f2, float f3, float f4, float f5) {
        this.f42673a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuv
    public final float a() {
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuv
    public final float b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuv
    public final float c() {
        return this.f42673a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuv
    public final float d() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuv
    public final float e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzuv) {
            zzuv zzuvVar = (zzuv) obj;
            if (Float.floatToIntBits(this.f42673a) == Float.floatToIntBits(zzuvVar.c()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(zzuvVar.e()) && Float.floatToIntBits(this.c) == Float.floatToIntBits(zzuvVar.b()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(zzuvVar.d())) {
                int iFloatToIntBits = Float.floatToIntBits(0.0f);
                zzuvVar.a();
                if (iFloatToIntBits == Float.floatToIntBits(0.0f)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((Float.floatToIntBits(this.f42673a) ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d)) * 1000003) ^ Float.floatToIntBits(0.0f);
    }

    public final String toString() {
        return "PredictedArea{xMin=" + this.f42673a + ", yMin=" + this.b + ", xMax=" + this.c + ", yMax=" + this.d + ", confidenceScore=0.0}";
    }
}
