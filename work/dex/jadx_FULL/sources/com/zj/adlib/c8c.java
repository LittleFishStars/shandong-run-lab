package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c8c extends zzed implements zzfp {
    private static final c8c zza;
    private int zzd;
    private double zze;
    private double zzf;
    private byte zzg = 2;

    static {
        c8c c8cVar = new c8c();
        zza = c8cVar;
        zzed.zzU(c8c.class, c8cVar);
    }

    public static c8c w() {
        return zza;
    }

    public final double t() {
        return this.zze;
    }

    public final double u() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔀ\u0000\u0002ᔀ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new c8c();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new w7c(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
