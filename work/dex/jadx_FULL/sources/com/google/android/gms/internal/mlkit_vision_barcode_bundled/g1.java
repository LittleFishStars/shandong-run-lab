package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qzc;
import com.zj.adlib.xrc;
import com.zj.adlib.xvc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g1 extends zzed implements zzfp {
    private static final g1 zza;
    private int zzd;
    private int zzg;
    private v1 zzh;
    private u1 zzi;
    private s1 zzj;
    private int zzk;
    private byte zzm = 2;
    private int zze = 17;
    private zzel zzf = zzed.zzO();
    private zzel zzl = zzed.zzO();

    static {
        g1 g1Var = new g1();
        zza = g1Var;
        zzed.zzU(g1.class, g1Var);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzm);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\b\u0000\u0001\u0001\u000f\b\u0000\u0002\u0004\u0001᠌\u0000\u0003Л\u0004င\u0001\u0005ᐉ\u0002\u0006ᐉ\u0003\u0007င\u0005\b\u001b\u000fᐉ\u0004", new Object[]{"zzd", "zze", qzc.f44332a, "zzf", c.class, "zzg", "zzh", "zzi", "zzk", "zzl", d.class, "zzj"});
        }
        if (i2 == 3) {
            return new g1();
        }
        xrc xrcVar = null;
        if (i2 == 4) {
            return new xvc(xrcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzm = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
