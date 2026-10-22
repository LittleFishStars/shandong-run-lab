package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzel;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class zad extends zzed implements zzfp {
    private static final zad zza;
    private int zzd;
    private String zze = "";
    private zzel zzf = zzed.zzO();

    static {
        zad zadVar = new zad();
        zza = zadVar;
        zzed.zzU(zad.class, zadVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", q7c.class});
        }
        if (i2 == 3) {
            return new zad();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new r7d(a7cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
