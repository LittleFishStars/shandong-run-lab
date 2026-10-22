package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.b6d;
import com.zj.adlib.i6d;
import com.zj.adlib.jyc;
import com.zj.adlib.m6d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class o1 extends zzed implements zzfp {
    private static final o1 zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private int zzh;
    private int zzi;
    private e1 zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private long zzp;

    static {
        o1 o1Var = new o1();
        zza = o1Var;
        zzed.zzU(o1.class, o1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004᠌\u0003\u0005င\u0004\u0006ဉ\u0005\u0007ဇ\u0006\b᠌\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဂ\u000b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", i6d.f42293a, "zzi", "zzj", "zzk", "zzl", m6d.f43238a, "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new o1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new b6d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
