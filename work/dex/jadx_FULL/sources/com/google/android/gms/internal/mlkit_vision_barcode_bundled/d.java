package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.j9c;
import com.zj.adlib.n9c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends zzed implements zzfp {
    private static final d zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        d dVar = new d();
        zza = dVar;
        zzed.zzU(d.class, dVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new d();
        }
        j9c j9cVar = null;
        if (i2 == 4) {
            return new n9c(j9cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
