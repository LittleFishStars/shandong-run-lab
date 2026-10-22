package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i0 implements zzfl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zzfo f5808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f5809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object[] f5810a;

    public i0(zzfo zzfoVar, String str, Object[] objArr) {
        this.f5808a = zzfoVar;
        this.f5809a = str;
        this.f5810a = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f31379a = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.f31379a = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    public final boolean a() {
        return (this.f31379a & 2) == 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    public final zzfo b() {
        return this.f5808a;
    }

    public final String c() {
        return this.f5809a;
    }

    public final Object[] d() {
        return this.f5810a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfl
    public final int zzc() {
        return (this.f31379a & 1) != 0 ? 1 : 2;
    }
}
