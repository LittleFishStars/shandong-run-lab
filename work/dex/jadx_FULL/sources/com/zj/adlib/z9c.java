package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class z9c extends zzed implements zzfp {
    private static final z9c zza;
    private int zzd;
    private int zzf;
    private boolean zzh;
    private byte zzi = 2;
    private String zze = "";
    private String zzg = "";

    static {
        z9c z9cVar = new z9c();
        zza = z9cVar;
        zzed.zzU(z9c.class, z9cVar);
    }

    public static z9c u() {
        return zza;
    }

    public final String v() {
        return this.zzg;
    }

    public final String w() {
        return this.zze;
    }

    public final int x() {
        int iA = v9c.a(this.zzf);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ᔈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", s9c.f44645a, "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new z9c();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new l9c(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
