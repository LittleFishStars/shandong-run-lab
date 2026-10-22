package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class srd extends zzed implements zzfp {
    private static final srd zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";

    static {
        srd srdVar = new srd();
        zza = srdVar;
        zzed.zzU(srd.class, srdVar);
    }

    public static srd u() {
        return zza;
    }

    public final String A() {
        return this.zze;
    }

    public final String B() {
        return this.zzp;
    }

    public final String C() {
        return this.zzf;
    }

    public final String D() {
        return this.zzi;
    }

    public final String E() {
        return this.zzo;
    }

    public final String F() {
        return this.zzr;
    }

    public final String G() {
        return this.zzh;
    }

    public final String H() {
        return this.zzn;
    }

    public final String I() {
        return this.zzg;
    }

    public final String v() {
        return this.zzk;
    }

    public final String w() {
        return this.zzl;
    }

    public final String x() {
        return this.zzj;
    }

    public final String y() {
        return this.zzm;
    }

    public final String z() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဈ\u000b\rဈ\f\u000eဈ\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new srd();
        }
        a7c a7cVar = null;
        if (i2 == 4) {
            return new kqd(a7cVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
