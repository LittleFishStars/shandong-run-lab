package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class bhd extends zzed implements zzfp {
    private static final bhd zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        bhd bhdVar = new bhd();
        zza = bhdVar;
        zzed.zzU(bhd.class, bhdVar);
    }

    public static bhd A() {
        return zza;
    }

    public final boolean B() {
        return this.zzk;
    }

    public final int t() {
        return this.zzg;
    }

    public final int u() {
        return this.zzh;
    }

    public final int v() {
        return this.zzi;
    }

    public final int w() {
        return this.zzf;
    }

    public final int x() {
        return this.zzj;
    }

    public final int y() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new bhd();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new bed(a7cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
