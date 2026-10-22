package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bvd extends zzed implements zzfp {
    private static final bvd zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        bvd bvdVar = new bvd();
        zza = bvdVar;
        zzed.zzU(bvd.class, bvdVar);
    }

    public static bvd u() {
        return zza;
    }

    public final String v() {
        return this.zzf;
    }

    public final String w() {
        return this.zzh;
    }

    public final String x() {
        return this.zzg;
    }

    public final int y() {
        int iA = vud.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", kud.f42916a, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new bvd();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new usd(a7cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
