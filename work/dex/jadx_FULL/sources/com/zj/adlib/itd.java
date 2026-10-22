package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzuu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class itd extends zzuu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f42441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f17274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f17275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17276a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f17277b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f17278b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f17279b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public /* synthetic */ itd(int i, int i2, float f, float f2, boolean z, float f3, float f4, long j, long j2, boolean z2, float f5, float f6, htd htdVar) {
        this.f17274a = i;
        this.f17277b = i2;
        this.f42441a = f;
        this.b = f2;
        this.f17276a = z;
        this.c = f3;
        this.d = f4;
        this.f17275a = j;
        this.f17278b = j2;
        this.f17279b = z2;
        this.e = f5;
        this.f = f6;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float a() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float c() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float d() {
        return this.f42441a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzuu) {
            zzuu zzuuVar = (zzuu) obj;
            if (this.f17274a == zzuuVar.h() && this.f17277b == zzuuVar.g() && Float.floatToIntBits(this.f42441a) == Float.floatToIntBits(zzuuVar.d()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(zzuuVar.c()) && this.f17276a == zzuuVar.l() && Float.floatToIntBits(this.c) == Float.floatToIntBits(zzuuVar.b()) && Float.floatToIntBits(this.d) == Float.floatToIntBits(zzuuVar.a()) && this.f17275a == zzuuVar.j() && this.f17278b == zzuuVar.i() && this.f17279b == zzuuVar.k() && Float.floatToIntBits(this.e) == Float.floatToIntBits(zzuuVar.e()) && Float.floatToIntBits(this.f) == Float.floatToIntBits(zzuuVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final float f() {
        return this.f;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final int g() {
        return this.f17277b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final int h() {
        return this.f17274a;
    }

    public final int hashCode() {
        int iFloatToIntBits = ((((((((((((this.f17274a ^ 1000003) * 1000003) ^ this.f17277b) * 1000003) ^ Float.floatToIntBits(this.f42441a)) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ (true != this.f17276a ? 1237 : 1231)) * 1000003) ^ Float.floatToIntBits(this.c)) * 1000003) ^ Float.floatToIntBits(this.d);
        int i = (int) this.f17275a;
        return (((((((((iFloatToIntBits * 1000003) ^ i) * 1000003) ^ ((int) this.f17278b)) * 1000003) ^ (true == this.f17279b ? 1231 : 1237)) * 1000003) ^ Float.floatToIntBits(this.e)) * 1000003) ^ Float.floatToIntBits(this.f);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final long i() {
        return this.f17278b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final long j() {
        return this.f17275a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final boolean k() {
        return this.f17279b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzuu
    public final boolean l() {
        return this.f17276a;
    }

    public final String toString() {
        return "AutoZoomOptions{recentFramesToCheck=" + this.f17274a + ", recentFramesContainingPredictedArea=" + this.f17277b + ", recentFramesIou=" + this.f42441a + ", maxCoverage=" + this.b + ", useConfidenceScore=" + this.f17276a + ", lowerConfidenceScore=" + this.c + ", higherConfidenceScore=" + this.d + ", zoomIntervalInMillis=" + this.f17275a + ", resetIntervalInMillis=" + this.f17278b + ", enableZoomThreshold=" + this.f17279b + ", zoomInThreshold=" + this.e + ", zoomOutThreshold=" + this.f + "}";
    }
}
