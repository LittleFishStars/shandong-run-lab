package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class pld extends zzed implements zzfp {
    private static final pld zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private bhd zzj;
    private bhd zzk;

    static {
        pld pldVar = new pld();
        zza = pldVar;
        zzed.zzU(pld.class, pldVar);
    }

    public static pld w() {
        return zza;
    }

    public final String A() {
        return this.zzi;
    }

    public final String B() {
        return this.zze;
    }

    public final bhd t() {
        bhd bhdVar = this.zzk;
        return bhdVar == null ? bhd.A() : bhdVar;
    }

    public final bhd u() {
        bhd bhdVar = this.zzj;
        return bhdVar == null ? bhd.A() : bhdVar;
    }

    public final String x() {
        return this.zzf;
    }

    public final String y() {
        return this.zzg;
    }

    public final String z() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new pld();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new jjd(a7cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
