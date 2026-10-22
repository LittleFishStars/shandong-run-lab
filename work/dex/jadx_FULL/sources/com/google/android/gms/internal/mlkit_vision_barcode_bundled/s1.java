package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.b8d;
import com.zj.adlib.x7d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class s1 extends zzdz implements zzfp {
    private static final s1 zzd;
    private byte zze = 2;

    static {
        s1 s1Var = new s1();
        zzd = s1Var;
        zzed.zzU(s1.class, s1Var);
    }

    public static s1 v() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        x7d x7dVar = null;
        if (i2 == 2) {
            return zzed.zzR(zzd, "\u0003\u0000", null);
        }
        if (i2 == 3) {
            return new s1();
        }
        if (i2 == 4) {
            return new b8d(x7dVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
