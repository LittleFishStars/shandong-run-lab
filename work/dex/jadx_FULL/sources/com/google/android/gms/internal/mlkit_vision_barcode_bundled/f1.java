package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.d3d;
import com.zj.adlib.h3d;
import com.zj.adlib.jyc;
import com.zj.adlib.t2d;
import com.zj.adlib.x2d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f1 extends zzed implements zzfp {
    private static final f1 zza;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzg = true;
    private String zzl = "";
    private String zzm = "";

    static {
        f1 f1Var = new f1();
        zza = f1Var;
        zzed.zzU(f1.class, f1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzeh zzehVar = d3d.f41102a;
            return zzed.zzR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\bဈ\u0007\tဈ\b", new Object[]{"zzd", "zze", "zzf", h3d.f42044a, "zzg", "zzh", t2d.f44837a, "zzi", zzehVar, "zzj", zzehVar, "zzk", zzehVar, "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new f1();
        }
        jyc jycVar = null;
        if (i2 == 4) {
            return new x2d(jycVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
