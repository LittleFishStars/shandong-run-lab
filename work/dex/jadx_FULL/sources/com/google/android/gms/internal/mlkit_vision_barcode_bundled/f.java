package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.dfc;
import com.zj.adlib.qdc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f extends zzed implements zzfp {
    private static final f zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        f fVar = new f();
        zza = fVar;
        zzed.zzU(f.class, fVar);
    }

    public static f u() {
        return zza;
    }

    public final String A() {
        return this.zzf;
    }

    public final String B() {
        return this.zzk;
    }

    public final String v() {
        return this.zzh;
    }

    public final String w() {
        return this.zze;
    }

    public final String x() {
        return this.zzj;
    }

    public final String y() {
        return this.zzi;
    }

    public final String z() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new f();
        }
        qdc qdcVar = null;
        if (i2 == 4) {
            return new dfc(qdcVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
