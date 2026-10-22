package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.d9c;
import com.zj.adlib.llc;
import com.zj.adlib.o8c;
import com.zj.adlib.u8c;
import com.zj.adlib.y8c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends zzed implements zzfp {
    public static final llc zza;
    private static final zzek zzd = new u8c();
    private static final c zze;
    private int zzf;
    private w1 zzl;
    private s1 zzm;
    private byte zzn = 2;
    private String zzg = "";
    private String zzh = "";
    private zzej zzi = zzed.zzN();
    private String zzj = "";
    private String zzk = "";

    static {
        c cVar = new c();
        zze = cVar;
        zzed.zzU(c.class, cVar);
        zza = zzed.g(s1.v(), cVar, cVar, null, 308676116, zzho.zzk, c.class);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzed
    public final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return zzed.zzR(zze, "\u0001\u0007\u0000\u0001\u0001Ǵ\u0007\u0000\u0001\u0002\u0001ᔈ\u0000\u0002ဈ\u0001\u0003ࠞ\u0005ဈ\u0002\u0006ဈ\u0003\u000fᐉ\u0005Ǵဉ\u0004", new Object[]{"zzf", "zzg", "zzh", "zzi", d9c.f41134a, "zzj", "zzk", "zzm", "zzl"});
        }
        if (i2 == 3) {
            return new c();
        }
        o8c o8cVar = null;
        if (i2 == 4) {
            return new y8c(o8cVar);
        }
        if (i2 == 5) {
            return zze;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
