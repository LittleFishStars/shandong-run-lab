package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q0 extends zzhh {
    public q0(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final double a(Object obj, long j) {
        return Double.longBitsToDouble(this.f31403a.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final float b(Object obj, long j) {
        return Float.intBitsToFloat(this.f31403a.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0.o(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0.n(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0.o(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void c(Object obj, long j, boolean z) {
        if (s0.d) {
            s0.n(obj, j, z);
        } else {
            s0.o(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void d(Object obj, long j, byte b) {
        if (s0.d) {
            s0.d(obj, j, b);
        } else {
            s0.e(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void e(Object obj, long j, double d) {
        this.f31403a.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final void f(Object obj, long j, float f) {
        this.f31403a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzhh
    public final boolean g(Object obj, long j) {
        return s0.d ? s0.y(obj, j) : s0.z(obj, j);
    }
}
