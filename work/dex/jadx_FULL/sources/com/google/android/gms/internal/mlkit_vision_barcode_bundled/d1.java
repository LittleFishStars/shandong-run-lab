package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.b2d;
import com.zj.adlib.jyc;
import com.zj.adlib.q1d;
import com.zj.adlib.u1d;
import com.zj.adlib.y1d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d1 extends zzed implements zzfp {
    private static final d1 zza;
    private int zzd;
    private int zze;
    private b1 zzh;
    private int zzj;
    private int zzk;
    private zzel zzf = zzed.zzO();
    private int zzg = -1;
    private String zzi = "";
    private zzej zzl = zzed.zzN();
    private String zzm = "";

    static {
        d1 d1Var = new d1();
        zza = d1Var;
        zzed.zzU(d1.class, d1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006", new Object[]{"zzd", "zze", q1d.f44107a, "zzf", c1.class, "zzg", "zzh", "zzi", "zzj", y1d.f45939a, "zzk", b2d.f40666a, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new d1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new u1d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
