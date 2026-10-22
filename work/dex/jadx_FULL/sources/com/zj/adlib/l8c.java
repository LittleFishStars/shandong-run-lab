package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class l8c extends zzed implements zzfp {
    private static final l8c zza;
    private int zzd;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        l8c l8cVar = new l8c();
        zza = l8cVar;
        zzed.zzU(l8c.class, l8cVar);
    }

    public static i8c v() {
        return (i8c) zza.zzF();
    }

    public static /* synthetic */ void x(l8c l8cVar, int i) {
        l8cVar.zzd |= 1;
        l8cVar.zze = i;
    }

    public static /* synthetic */ void y(l8c l8cVar, int i) {
        l8cVar.zzd |= 2;
        l8cVar.zzf = i;
    }

    public final int t() {
        return this.zze;
    }

    public final int u() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔄ\u0000\u0002ᔄ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new l8c();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new i8c(a7cVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
