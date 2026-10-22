package com.google.android.gms.internal.mlkit_vision_common;

import com.zj.adlib.lnd;
import com.zj.adlib.rzc;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzz extends zzr {
    static final zzr zza = new zzz(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzz(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public static zzz zzg(int i, Object[] objArr, lnd lndVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        rzc.a(obj, obj2);
        return new zzz(null, objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object[] objArr = this.zzb;
        int i = this.zzc;
        if (obj != null && i == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            if (obj3.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzl zza() {
        return new zzy(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs zzd() {
        return new zzw(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzr
    public final zzs zze() {
        return new zzx(this, new zzy(this.zzb, 0, this.zzc));
    }
}
