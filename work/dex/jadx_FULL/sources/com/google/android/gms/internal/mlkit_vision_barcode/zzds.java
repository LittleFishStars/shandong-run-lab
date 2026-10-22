package com.google.android.gms.internal.mlkit_vision_barcode;

import com.zj.adlib.afc;
import com.zj.adlib.ehc;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zzds extends zzcx {
    static final zzcx zza = new zzds(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    private zzds(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public static zzds zzg(int i, Object[] objArr, ehc ehcVar) {
        Object obj = objArr[0];
        obj.getClass();
        Object obj2 = objArr[1];
        obj2.getClass();
        afc.b(obj, obj2);
        return new zzds(null, objArr, 1);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0007  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcx, java.util.Map
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

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcx
    public final zzcq zza() {
        return new zzdr(this.zzb, 1, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcx
    public final zzcy zzd() {
        return new zzdp(this, this.zzb, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcx
    public final zzcy zze() {
        return new zzdq(this, new zzdr(this.zzb, 0, this.zzc));
    }
}
