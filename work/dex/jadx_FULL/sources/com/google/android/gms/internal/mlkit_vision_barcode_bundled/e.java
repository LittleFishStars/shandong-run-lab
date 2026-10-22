package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qdc;
import com.zj.adlib.tdc;
import com.zj.adlib.xec;
import com.zj.adlib.zdc;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e extends zzed implements zzfp {
    private static final e zza;
    private int zzd;
    private int zze;
    private x zzg;
    private byte zzh = 2;
    private zzel zzf = zzed.zzO();

    static {
        e eVar = new e();
        zza = eVar;
        zzed.zzU(e.class, eVar);
    }

    public final List u() {
        return this.zzf;
    }

    public final int v() {
        int iA = xec.a(this.zze);
        if (iA == 0) {
            return 1;
        }
        return iA;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzed.zzR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001᠌\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zzd", "zze", zdc.f46241a, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new e();
        }
        qdc qdcVar = null;
        if (i2 == 4) {
            return new tdc(qdcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
